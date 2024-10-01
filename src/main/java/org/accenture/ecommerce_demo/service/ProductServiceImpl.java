package org.accenture.ecommerce_demo.service;

import jakarta.transaction.Transactional;
import org.accenture.ecommerce_demo.entity.Product;
import org.accenture.ecommerce_demo.exception.BadRequestException;
import org.accenture.ecommerce_demo.exception.ProductAlreadyExistsException;
import org.accenture.ecommerce_demo.model.ProductRequest;
import org.accenture.ecommerce_demo.model.ProductResponse;
import org.accenture.ecommerce_demo.repository.IProductCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class ProductServiceImpl implements IProductService{

    @Autowired
    private IProductCommand productCommand;

    public ProductResponse createProduct(ProductRequest request) throws ProductAlreadyExistsException, BadRequestException {
        // Validar si el producto ya existe
//        productServiceExtensions.validateProductDoesNotExistByName(request);
//        productServiceExtensions.validateProductRequest(request);

        // Crear el producto
        Product product = new Product();
        product.setProductId(UUID.randomUUID());
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setCategory(request.getCategory());
        product.setDiscount(request.getDiscount());
        product.setImageUrl(request.getImageUrl());

        // Agregar el producto
        productCommand.addProduct(product);

        // Construir y devolver la respuesta
        return buildProductResponse(product);
    }
    private ProductResponse buildProductResponse(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getProductId());
        productResponse.setName(product.getName());
        productResponse.setDescription(product.getDescription());
        productResponse.setPrice(product.getPrice());
        productResponse.setDiscount(product.getDiscount());
        productResponse.setImageUrl(product.getImageUrl());

//        // Obtener la categoría del producto y asignarla a la respuesta
//        String category = categoryService.getProductCategory(product.getCategory());
//        productResponse.setCategory(category);

        return productResponse;
    }



    @Override
    public ProductResponse getProductById(UUID id) {
        return null;
    }

    @Override
    public ProductResponse updateProduct(UUID id, ProductRequest request) {
        return null;
    }

    @Override
    public ProductResponse deleteProduct(UUID id) {
        return null;
    }
}
