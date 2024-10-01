package org.accenture.service;

import org.accenture.model.ProductRequest;
import org.accenture.model.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductServiceImpl implements IProductService{

    @Override
    public ProductResponse createProduct(ProductRequest request) {
        return null;
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
