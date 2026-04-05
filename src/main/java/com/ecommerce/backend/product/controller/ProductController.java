package com.ecommerce.backend.product.controller;

import com.ecommerce.backend.product.model.dto.CreateProductRequestDto;
import com.ecommerce.backend.product.model.dto.ProductDto;
import com.ecommerce.backend.product.model.dto.ResponseDto;
import com.ecommerce.backend.product.model.dto.UpdateProductRequestDto;
import com.ecommerce.backend.product.model.enums.ProductStatus;
import com.ecommerce.backend.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService service;

    @GetMapping("/get-all")
    public ResponseDto<?> getAllProducts() {
        log.info("Request received for ::Fetching all products");
        List<ProductDto> productDto = service.fetchAllProducts();
        if (productDto.isEmpty()) {
            log.info("Product not found");
            return new ResponseDto<>(
                    true,
                    "Product Not found",
                    productDto
            );
        }
        log.info("Response received for ::Fetching all products");
        return new ResponseDto<>(
                true,
                "Product Fetched successfully",
                productDto
        );
    }

    @GetMapping("/get/{id}")
    public ResponseDto<?> getProductById(@PathVariable Long id) {
        log.info("Request received for ::Fetching product by ID");
        ProductDto productDto = service.fetchProductById(id);
        log.info("Response received for ::Fetching product by ID");
        return new ResponseDto<>(
                true,
                "Product Fetched successfully",
                productDto
        );
    }

    @PostMapping("/create")
    public ResponseDto<?> createProduct(@Valid @RequestBody CreateProductRequestDto productDto) {
        log.info("Request received for ::Creating product");
        ProductDto dto = service.createProduct(productDto);
        return new ResponseDto<>(
                true,
                "Product Fetched successfully",
                productDto
        );
    }

    @PatchMapping("/update/{id}")
    public ResponseDto<?> updateProduct(@PathVariable Long id, @RequestBody UpdateProductRequestDto productDto) {
        log.info("Request received for ::Updating product");
        ProductDto dto = service.updateProduct(id, productDto);
        log.info("Response received for ::Updating product");
        return new ResponseDto<>(
                true,
                "Product Updated successfully",
                productDto
        );
    }

    @DeleteMapping("{id}")
    public ResponseDto<?> deleteProduct(@PathVariable Long id) {
        log.info("Request received for ::Deleting product");
        String response = service.deleteProduct(id);
        log.info("Response received for ::Deleting product");
        return new ResponseDto<>(
                true,
                response
        );
    }

    @PatchMapping("/update/status/{id}")
    public ResponseDto<?> updateProductStatus(@PathVariable Long id, ProductStatus status) {
        log.info("Request received for ::Updating product Status");
        String response = service.updateProductStatus(id, status);
        log.info("Response received for ::Updating product Status");
        return new ResponseDto<>(
                true,
                response
        );
    }

}
