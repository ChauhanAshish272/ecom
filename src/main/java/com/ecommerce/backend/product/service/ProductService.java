package com.ecommerce.backend.product.service;

import com.ecommerce.backend.product.model.dto.CreateProductRequestDto;
import com.ecommerce.backend.product.model.dto.ProductDto;
import jakarta.validation.Valid;

import java.util.List;

public interface ProductService {
    List<ProductDto> fetchAllProducts();

    ProductDto fetchProductById(Long id);

    ProductDto createProduct(@Valid CreateProductRequestDto productDto);
}
