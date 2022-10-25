package com.ossama.gestionstock.service.Impl;

import com.ossama.gestionstock.dto.SalesDto;
import com.ossama.gestionstock.dto.SalesLineDto;
import com.ossama.gestionstock.exception.EntityNotFoundException;
import com.ossama.gestionstock.exception.ErrorsCode;
import com.ossama.gestionstock.exception.InvalidEntityException;
import com.ossama.gestionstock.model.Sales;
import com.ossama.gestionstock.model.Product;
import com.ossama.gestionstock.repository.SalesRepository;
import com.ossama.gestionstock.repository.ClientRepository;
import com.ossama.gestionstock.repository.ProductRepository;
import com.ossama.gestionstock.service.SalesService;
import com.ossama.gestionstock.validator.SalesValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SalesServiceImpl implements SalesService {
    ClientRepository clientRepository;

    SalesRepository salesRepository;
    ProductRepository productRepository;
    @Autowired
    public SalesServiceImpl(ClientRepository clientRepository,SalesRepository salesRepository,ProductRepository productRepository) {
        this.clientRepository = clientRepository;
        this.salesRepository=salesRepository;
        this.productRepository=productRepository;
    }

    @Override
    @Transactional
    public SalesDto addSales(SalesDto salesDto) {
        List<String> errors= SalesValidator.validate(salesDto);
        if(!errors.isEmpty()){
            log.error("add: salesDto is not valid",salesDto);
            throw new InvalidEntityException("salesDto is not valid", ErrorsCode.Sales_Not_Valid,errors);
        }
        return SalesDto.fromEntity(
                salesRepository.save(
                        SalesDto.toEntity(salesDto)
                )
        );
    }

    @Override
    public SalesDto addLinesToSales(Integer id, List<SalesLineDto> salesLineDtoList) {
        if(id==null){
            log.error("get: salesId is null");
            return null;
        }
        Optional<Sales> sales=salesRepository.findById(id);
        if(!sales.isPresent()){
            throw new EntityNotFoundException("sales with id "+id+" not found",ErrorsCode.Sales_Not_Found);
        }
        salesLineDtoList.forEach( salesLine ->{
            if(salesLine!=null){
                Optional<Product> product=productRepository.findById(salesLine.getProduct().getId());
                if(!product.isPresent()){
                    log.error("product With id {} is not present",salesLine.getProduct().getId());
                    throw new EntityNotFoundException("product With id "+salesLine.getProduct().getId()+" is not Found",ErrorsCode.Product_Not_Found);
                }
                product.get().getSalesLineList().add(SalesLineDto.toEntity(salesLine));
                productRepository.save(product.get());
            }
        } );
        sales.get().getSalesLineList().addAll(
                salesLineDtoList.stream().map(SalesLineDto::toEntity).collect(Collectors.toList()));

        return SalesDto.fromEntity(
                salesRepository.save(sales.get()));

    }

    @Override
    @Transactional
    public SalesDto removeLinesToSales(Integer id, List<SalesLineDto> salesLineDtoList) {
        if(id==null){
            log.error("get: salesId is null");
            return null;
        }
        Optional<Sales> sales=salesRepository.findById(id);
        if(!sales.isPresent()){
            throw new EntityNotFoundException("sales with id "+id+" not found",ErrorsCode.Sales_Not_Found);
        }
        salesLineDtoList.forEach( salesLine ->{
            if(salesLine!=null){
                Optional<Product> product=productRepository.findById(salesLine.getProduct().getId());
                if(!product.isPresent()){
                    log.error("product With id {} is not present",salesLine.getProduct().getId());
                    throw new EntityNotFoundException("product With id "+salesLine.getProduct().getId()+" is not Found",ErrorsCode.Product_Not_Found);
                }
                product.get().getSalesLineList().remove(SalesLineDto.toEntity(salesLine));
                productRepository.save(product.get());
            }
        } );
        sales.get().getSalesLineList().removeAll(
                salesLineDtoList.stream().map(SalesLineDto::toEntity).collect(Collectors.toList()));

        return SalesDto.fromEntity(
                salesRepository.save(sales.get()));
    }

    @Override
    public SalesDto getSalesById(Integer id) {
        if(id==null){
            log.error("get: salesId is null");
            return null;
        }
        return salesRepository.findById(id).map(SalesDto::fromEntity).orElseThrow(
                ()->new EntityNotFoundException("sales with id "+id+" not found",ErrorsCode.Sales_Not_Found)
        );
    }

    @Override
    public SalesDto getSalesByCode(String code) {
        if(code==null){
            log.error("get: salesCode is null");
            return null;
        }
        return salesRepository.findSalesByCode(code).map(SalesDto::fromEntity).orElseThrow(
                ()->new EntityNotFoundException("sales with code "+code+" not found",ErrorsCode.Sales_Not_Found)
        );
    }

    @Override
    public List<SalesDto> getAllSales() {
        return salesRepository.findAll()
                .stream()
                .map(SalesDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public SalesDto updateSales(Integer id, SalesDto salesDto) {
        List<String> errors= SalesValidator.validate(salesDto);
        if(!errors.isEmpty()){
            log.error("add: salesDto is not valid",salesDto);
            throw new InvalidEntityException("salesDto is not valid", ErrorsCode.Sales_Not_Valid,errors);
        }
        if(id==null){
            log.error("update: salesId is null");
            return null;
        }
        Optional<Sales> sales=salesRepository.findById(id);
        if(!sales.isPresent()){
            log.error("sales with id "+id+" not found");
            throw new EntityNotFoundException("sales with id "+id+" not found",ErrorsCode.Sales_Not_Found);
        }

        sales.get().setSalesDate(salesDto.getSalesDate());
        sales.get().setCode(salesDto.getCode());
        return SalesDto.fromEntity(
                salesRepository.save(sales.get())
        );
    }

    @Override
    @Transactional
    public SalesDto deleteSales(Integer id) {
        if(id==null){
            log.error("delete: salesId is null");
            return null;
        }
        Optional<Sales> sales=salesRepository.findById(id);
        if(!sales.isPresent()){
            log.error("sales with id "+id+" not found");
            throw new EntityNotFoundException("sales with id "+id+" not found",ErrorsCode.Sales_Not_Found);
        }
        salesRepository.deleteById(id);
        return SalesDto.fromEntity(sales.get());
    }
}
