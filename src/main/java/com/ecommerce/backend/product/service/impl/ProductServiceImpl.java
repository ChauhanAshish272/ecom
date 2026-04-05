package com.ecommerce.backend.product.service.impl;

import com.ecommerce.backend.product.exception.NotFoundException;
import com.ecommerce.backend.product.model.dto.CreateProductRequestDto;
import com.ecommerce.backend.product.model.dto.ProductDto;
import com.ecommerce.backend.product.model.dto.UpdateProductRequestDto;
import com.ecommerce.backend.product.model.entity.Product;
import com.ecommerce.backend.product.repository.ProductRepository;
import com.ecommerce.backend.product.service.ProductService;
import com.ecommerce.backend.product.util.ProductUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<ProductDto> fetchAllProducts() {
        log.info("Fetching all products");
        return productRepository.findAll().stream().map(ProductUtil::mapToProductDto).toList();
    }

    @Override
    public ProductDto fetchProductById(Long id) {
        return ProductUtil
                .mapToProductDto(
                        productRepository.findById(id)
                                .orElseThrow(() -> {
                                    log.warn("Fetching product by ID {} failed", id);
                                    return new NotFoundException("Product not found with id " + id);
                                })
                );
    }

    @Override
    public ProductDto createProduct(CreateProductRequestDto productDto) {
        log.info("Creating product {}", productDto);
        return ProductUtil.mapToProductDto(productRepository.save(Product.builder()
                .name(productDto.getProductName())
                .description(productDto.getProductDescription())
                .productStatus(productDto.getProductStatus())
                .brand(productDto.getProductBrand())
                .category(productDto.getProductCategory())
                .price(productDto.getProductPrice())
                .createdAt(LocalDateTime.now())
                .build()));
    }

    @Override
    public ProductDto updateProduct(Long id, UpdateProductRequestDto productDto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Fetching product by ID {} failed", id);
                    return new NotFoundException("Product not found with id " + id);
                });
        if (productDto.getProductName() != null && !productDto.getProductName().isEmpty()) {
            product.setName(productDto.getProductName());
        }
        if (productDto.getProductDescription() != null && !productDto.getProductDescription().isEmpty()) {
            product.setDescription(productDto.getProductDescription());
        }
        if (productDto.getProductStatus() != null) {
            product.setProductStatus(productDto.getProductStatus());
        }
        if (productDto.getProductBrand() != null && !productDto.getProductBrand().isEmpty()) {
            product.setBrand(productDto.getProductBrand());
        }
        if (productDto.getProductCategory() != null && !productDto.getProductCategory().isEmpty()) {
            product.setCategory(productDto.getProductCategory());
        }
        if (productDto.getProductPrice() != null && productDto.getProductPrice() > 0) {
            product.setPrice(productDto.getProductPrice());
        }
        Product savedProduct = productRepository.save(product);
        return ProductUtil.mapToProductDto(savedProduct);
    }

    @Override
    public String deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Fetching product by ID {} failed", id);
                    return new NotFoundException("Product not found with id " + id);
                });
        product.setActive(false);
        product.setDeleted(true);
        productRepository.save(product);
        return "Product deleted Successfully";
    }


}
