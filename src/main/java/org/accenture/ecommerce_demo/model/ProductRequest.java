package org.accenture.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequest {
    private String name;
    private String description;
    private Double price;
    private int discount;
    private String imageUrl;
    private int category;
}