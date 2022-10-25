package com.ossama.gestionstock.service.Impl;

import com.ossama.gestionstock.dto.CategoryDto;
import com.ossama.gestionstock.dto.ProductDto;
import com.ossama.gestionstock.exception.EntityNotFoundException;
import com.ossama.gestionstock.exception.ErrorsCode;
import com.ossama.gestionstock.exception.InvalidEntityException;
import com.ossama.gestionstock.model.Category;
import com.ossama.gestionstock.model.Product;
import com.ossama.gestionstock.repository.CategoryRepository;
import com.ossama.gestionstock.repository.ProductRepository;
import com.ossama.gestionstock.service.ProductService;
import com.ossama.gestionstock.validator.ProductValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository,CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository=categoryRepository;
    }

    @Override
    @Transactional
    public ProductDto addProduct(ProductDto productDto) {
        List<String> errors= ProductValidator.validate(productDto);
        if(!errors.isEmpty()){// we got errors
            log.error("add:Product is not Valid",productDto);
            throw new InvalidEntityException("Product is not Valid", ErrorsCode.Product_Not_Valid,errors);
        }
        Optional<Category> category=categoryRepository.findById(productDto.getCategory().getId());
        if(!category.isPresent()){
            log.error("add:Product category is not present",productDto.getCategory());
            throw new EntityNotFoundException("Product Category Not Found",ErrorsCode.Category_Not_Found);
        }
        category.get().getProductList().add(ProductDto.toEntity(productDto));
        categoryRepository.save(category.get());
        return ProductDto.fromEntity(
                productRepository.save(
                        ProductDto.toEntity(productDto)
                )
        );
    }

    @Override
    public ProductDto getProductById(Integer id) {
        if(id==null){
            log.error("get: ProductId is NULL");
            return null;
        }
        Optional<Product> product=productRepository.findById(id);
        return product.map(ProductDto::fromEntity)
                .orElseThrow(
                        ()->new EntityNotFoundException("Product with id"+id+" Not found",ErrorsCode.Product_Not_Found));

    }

    @Override
    public ProductDto getProductByCode(String code) {
        if(code==null){
            log.error("get: ProductCode is NULL");
            return null;
        }
        Optional<Product> product=productRepository.findProductByCode(code);
        return product.map(ProductDto::fromEntity)
                .orElseThrow(
                        ()->new EntityNotFoundException("Product with code"+code+" Not found",ErrorsCode.Product_Not_Found));

    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream()
                .map(ProductDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProduct(Integer id, ProductDto productDto) {
        List<String> errors= ProductValidator.validate(productDto);
        if(!errors.isEmpty()){
            log.error("productDto is Not Valid",productDto);
            throw new InvalidEntityException("ProductDto is Not Valid", ErrorsCode.Product_Not_Valid,errors);
        }

        if(id==null){
            log.error("update: ProductDto is NULL");
            return null;
        }
        Optional<Category> category=categoryRepository.findById(productDto.getCategory().getId());

        if(!category.isPresent()){
            log.error("add:Product category is not present",productDto.getCategory());
            throw new EntityNotFoundException("Product Category Not Found",ErrorsCode.Category_Not_Found);
        }


        Optional<Product> product=productRepository.findById(id);
        if(product.isPresent()){
            category.get().getProductList().remove(product.get().getCategory());
            category.get().getProductList().add(ProductDto.toEntity(productDto));
            categoryRepository.save(category.get());
            product.get().setDescription(productDto.getDescription());
           product.get().setCode(productDto.getCode());
           product.get().setPicture(productDto.getPicture());
           product.get().setRateTVA(productDto.getRateTVA());
           product.get().setUnitPriceTTC(productDto.getUnitPriceTTC());
           product.get().setUnitPriceHT(productDto.getUnitPriceHT());
           product.get().setCategory(CategoryDto.toEntity(productDto.getCategory()));

           productRepository.save(product.get());

        }
        return productRepository.findById(id).map(ProductDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("Product with id "+id+"not found",ErrorsCode.Product_Not_Found));

    }

    @Override
    @Transactional
    public ProductDto deleteProduct(Integer id) {
        if(id==null){
            log.error("delete: Product with id NULL");
            return null;
        }
        Optional<Product> product=productRepository.findById(id);
        if(product.isPresent()){
            Optional<Category> category=categoryRepository.findById(product.get().getCategory().getId());
            category.get().getProductList().remove(product.get().getCategory());
            categoryRepository.save(category.get());
            productRepository.deleteById(id);
            return ProductDto.fromEntity(product.get());
        }
        throw new EntityNotFoundException("Product with id "+id+" not found",ErrorsCode.Product_Not_Found);

    }
}
