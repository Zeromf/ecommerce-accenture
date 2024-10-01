package org.accenture.ecommerce_demo.repository;

import jakarta.transaction.Transactional;
import org.accenture.ecommerce_demo.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ProductCommand implements IProductCommand {

    private final StoreDbContext context;

    public ProductCommand(StoreDbContext context) {
        this.context = context;
    }

    @Override
    public void addProduct(Product product) {
        if (product.getProductId() != null) {
            // Usar merge para actualizar una entidad existente (detached)
            context.getEntityManager().merge(product);
        } else {
            // Usar persist para una nueva entidad
            context.getEntityManager().persist(product);
        }
    }
    @Override
    public void updateProduct(Product product) {
        context.getEntityManager().merge(product);
    }

    @Override
    public void deleteProduct(Product product) {
        context.getEntityManager().remove(context.getEntityManager().contains(product) ? product : context.getEntityManager().merge(product));
    }
}