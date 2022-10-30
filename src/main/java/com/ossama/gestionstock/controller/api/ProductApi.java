package com.ossama.gestionstock.controller.api;

import com.ossama.gestionstock.dto.ProductDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ossama.gestionstock.other.Constants.PRODUCT_API;

public interface ProductApi {
    @PostMapping(value=PRODUCT_API+"/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    ProductDto saveProduct(@RequestBody ProductDto productDto);
    @GetMapping(value=PRODUCT_API+"/{productId}",produces = MediaType.APPLICATION_JSON_VALUE)
    ProductDto findProductById(@PathVariable Integer productId);
    @GetMapping(value=PRODUCT_API+"/{productCode}",produces = MediaType.APPLICATION_JSON_VALUE)
    ProductDto findProductByCode(@PathVariable String productCode);
    @GetMapping(value=PRODUCT_API+"/all",produces = MediaType.APPLICATION_JSON_VALUE)
    List<ProductDto> findAllProducts();
    @DeleteMapping(value=PRODUCT_API+"/delete/{productId}",produces = MediaType.APPLICATION_JSON_VALUE)
    ProductDto deleteProductById(@PathVariable Integer productId);
}
