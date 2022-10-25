package com.ossama.gestionstock.service;

import com.ossama.gestionstock.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto addProduct(ProductDto productDto);
    ProductDto getProductById(Integer id);
    ProductDto getProductByCode(String code);
    List<ProductDto> getAllProducts();
    ProductDto updateProduct(Integer id,ProductDto productDto);
    ProductDto deleteProduct(Integer id);
}
