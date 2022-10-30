package com.ossama.gestionstock.controller.api.impl;

import com.ossama.gestionstock.controller.api.ProductApi;
import com.ossama.gestionstock.dto.ProductDto;
import com.ossama.gestionstock.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ProductApiImpl implements ProductApi {
    private ProductService productService;
    @Autowired
    public ProductApiImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        return this.productService.addProduct(productDto);
    }

    @Override
    public ProductDto findProductById(Integer productId) {
        return this.productService.getProductById(productId);
    }

    @Override
    public ProductDto findProductByCode(String productCode) {
        return this.productService.getProductByCode(productCode);
    }

    @Override
    public List<ProductDto> findAllProducts() {
        return this.productService.getAllProducts();
    }

    @Override
    public ProductDto deleteProductById(Integer productId) {
        return this.productService.deleteProduct(productId);
    }
}
