package org.accenture.service;

import org.accenture.model.ProductRequest;
import org.accenture.model.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface IProductService {
    ProductResponse createProduct(ProductRequest request);

    ProductResponse getProductById(UUID id);

    ProductResponse updateProduct(UUID id, ProductRequest request);

    ProductResponse deleteProduct(UUID id);
}
