package com.ossama.gestionstock.service.Impl;

import com.ossama.gestionstock.dto.SupplierOrderDto;
import com.ossama.gestionstock.dto.SupplierOrderLineDto;
import com.ossama.gestionstock.exception.EntityNotFoundException;
import com.ossama.gestionstock.exception.ErrorsCode;
import com.ossama.gestionstock.exception.InvalidEntityException;
import com.ossama.gestionstock.model.Supplier;
import com.ossama.gestionstock.model.SupplierOrder;
import com.ossama.gestionstock.model.Product;
import com.ossama.gestionstock.repository.SupplierOrderRepository;
import com.ossama.gestionstock.repository.SupplierRepository;
import com.ossama.gestionstock.repository.ProductRepository;
import com.ossama.gestionstock.service.SupplierOrderService;
import com.ossama.gestionstock.validator.SupplierOrderValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Slf4j
@Service
public class SupplierOrderServiceImpl implements SupplierOrderService {
    SupplierRepository supplierRepository;

    SupplierOrderRepository supplierOrderRepository;
    ProductRepository productRepository;
    @Autowired
    public SupplierOrderServiceImpl(SupplierRepository supplierRepository,SupplierOrderRepository supplierOrderRepository,ProductRepository productRepository) {
        this.supplierRepository = supplierRepository;
        this.supplierOrderRepository=supplierOrderRepository;
        this.productRepository=productRepository;
    }

    @Override
    @Transactional
    public SupplierOrderDto addSupplierOrder(SupplierOrderDto supplierOrderDto) {
        List<String> errors= SupplierOrderValidator.validate(supplierOrderDto);
        if(!errors.isEmpty()){
            log.error("add: supplierOrderDto is not valid",supplierOrderDto);
            throw new InvalidEntityException("supplierOrderDto is not valid", ErrorsCode.SupplierOrder_Not_Valid,errors);
        }
        Optional<Supplier> supplier=supplierRepository.findById(supplierOrderDto.getSupplier().getId());
        if(!supplier.isPresent()){
            log.error("supplier With id {} is not present",supplierOrderDto.getSupplier().getId());
            throw new EntityNotFoundException("supplier With id "+supplierOrderDto.getSupplier().getId()+" is not Found",ErrorsCode.Supplier_Not_Found);
        }
        supplier.get().getSupplierOrderList().add(SupplierOrderDto.toEntity(supplierOrderDto));
        supplierRepository.save(supplier.get());


        return SupplierOrderDto.fromEntity(
                supplierOrderRepository.save(
                        SupplierOrderDto.toEntity(supplierOrderDto)
                )
        );
    }

    @Override
    public SupplierOrderDto addLinesToSupplierOrder(Integer id, List<SupplierOrderLineDto> supplierOrderLineDtoList) {
        if(id==null){
            log.error("get: supplierOrderId is null");
            return null;
        }
        Optional<SupplierOrder> supplierOrder=supplierOrderRepository.findById(id);
        if(!supplierOrder.isPresent()){
            throw new EntityNotFoundException("supplierOrder with id "+id+" not found",ErrorsCode.SupplierOrder_Not_Found);
        }
        supplierOrderLineDtoList.forEach( supplierOrderLine ->{
            if(supplierOrderLine!=null){
                Optional<Product> product=productRepository.findById(supplierOrderLine.getProduct().getId());
                if(!product.isPresent()){
                    log.error("product With id {} is not present",supplierOrderLine.getProduct().getId());
                    throw new EntityNotFoundException("product With id "+supplierOrderLine.getProduct().getId()+" is not Found",ErrorsCode.Product_Not_Found);
                }
                product.get().getSupplierOrderLineList().add(SupplierOrderLineDto.toEntity(supplierOrderLine));
                productRepository.save(product.get());
            }
        } );
        supplierOrder.get().getSupplierOrderLineList().addAll(
                supplierOrderLineDtoList.stream().map(SupplierOrderLineDto::toEntity).collect(Collectors.toList()));

        return SupplierOrderDto.fromEntity(
                supplierOrderRepository.save(supplierOrder.get()));

    }

    @Override
    @Transactional
    public SupplierOrderDto removeLinesToSupplierOrder(Integer id, List<SupplierOrderLineDto> supplierOrderLineDtoList) {
        if(id==null){
            log.error("get: supplierOrderId is null");
            return null;
        }
        Optional<SupplierOrder> supplierOrder=supplierOrderRepository.findById(id);
        if(!supplierOrder.isPresent()){
            throw new EntityNotFoundException("supplierOrder with id "+id+" not found",ErrorsCode.SupplierOrder_Not_Found);
        }
        supplierOrderLineDtoList.forEach( supplierOrderLine ->{
            if(supplierOrderLine!=null){
                Optional<Product> product=productRepository.findById(supplierOrderLine.getProduct().getId());
                if(!product.isPresent()){
                    log.error("product With id {} is not present",supplierOrderLine.getProduct().getId());
                    throw new EntityNotFoundException("product With id "+supplierOrderLine.getProduct().getId()+" is not Found",ErrorsCode.Product_Not_Found);
                }
                product.get().getSupplierOrderLineList().remove(SupplierOrderLineDto.toEntity(supplierOrderLine));
                productRepository.save(product.get());
            }
        } );
        supplierOrder.get().getSupplierOrderLineList().removeAll(
                supplierOrderLineDtoList.stream().map(SupplierOrderLineDto::toEntity).collect(Collectors.toList()));

        return SupplierOrderDto.fromEntity(
                supplierOrderRepository.save(supplierOrder.get()));
    }

    @Override
    public SupplierOrderDto getSupplierOrderById(Integer id) {
        if(id==null){
            log.error("get: supplierOrderId is null");
            return null;
        }
        return supplierOrderRepository.findById(id).map(SupplierOrderDto::fromEntity).orElseThrow(
                ()->new EntityNotFoundException("supplierOrder with id "+id+" not found",ErrorsCode.SupplierOrder_Not_Found)
        );
    }

    @Override
    public SupplierOrderDto getSupplierOrderByCode(String code) {
        if(code==null){
            log.error("get: supplierOrderCode is null");
            return null;
        }
        return supplierOrderRepository.findSupplierOrderByCode(code).map(SupplierOrderDto::fromEntity).orElseThrow(
                ()->new EntityNotFoundException("supplierOrder with code "+code+" not found",ErrorsCode.SupplierOrder_Not_Found)
        );
    }

    @Override
    public List<SupplierOrderDto> getAllSupplierOrders() {
        return supplierOrderRepository.findAll()
                .stream()
                .map(SupplierOrderDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public SupplierOrderDto updateSupplierOrder(Integer id, SupplierOrderDto supplierOrderDto) {
        List<String> errors= SupplierOrderValidator.validate(supplierOrderDto);
        if(!errors.isEmpty()){
            log.error("add: supplierOrderDto is not valid",supplierOrderDto);
            throw new InvalidEntityException("supplierOrderDto is not valid", ErrorsCode.SupplierOrder_Not_Valid,errors);
        }
        if(id==null){
            log.error("update: supplierOrderId is null");
            return null;
        }
        Optional<SupplierOrder> supplierOrder=supplierOrderRepository.findById(id);
        if(!supplierOrder.isPresent()){
            log.error("supplierOrder with id "+id+" not found");
            throw new EntityNotFoundException("supplierOrder with id "+id+" not found",ErrorsCode.SupplierOrder_Not_Found);
        }
        Optional<Supplier> supplier=supplierRepository.findById(supplierOrderDto.getSupplier().getId());
        if(!supplier.isPresent()){
            log.error("supplier With id {} is not present",supplierOrderDto.getSupplier().getId());
            throw new EntityNotFoundException("supplier With id "+supplierOrderDto.getSupplier().getId()+" is not Found",ErrorsCode.Supplier_Not_Found);
        }
        supplier.get().getSupplierOrderList().add(SupplierOrderDto.toEntity(supplierOrderDto));
        supplier.get().getSupplierOrderList().remove(supplierOrder.get());
        supplierRepository.save(supplier.get());
        supplierOrder.get().setSupplier(supplier.get());
        supplierOrder.get().setOrderDate(supplierOrderDto.getOrderDate());
        supplierOrder.get().setCode(supplierOrderDto.getCode());
        return SupplierOrderDto.fromEntity(
                supplierOrderRepository.save(supplierOrder.get())
        );
    }

    @Override
    @Transactional
    public SupplierOrderDto deleteSupplierOrder(Integer id) {
        if(id==null){
            log.error("delete: supplierOrderId is null");
            return null;
        }
        Optional<SupplierOrder> supplierOrder=supplierOrderRepository.findById(id);
        if(!supplierOrder.isPresent()){
            log.error("supplierOrder with id "+id+" not found");
            throw new EntityNotFoundException("supplierOrder with id "+id+" not found",ErrorsCode.SupplierOrder_Not_Found);
        }
        Optional<Supplier> supplier=supplierRepository.findById(supplierOrder.get().getSupplier().getId());
        if(!supplier.isPresent()){
            log.error("supplier With id {} is not present",supplierOrder.get().getSupplier().getId());
            throw new EntityNotFoundException("supplier With id "+supplierOrder.get().getSupplier().getId()+" is not Found",ErrorsCode.Supplier_Not_Found);
        }
        supplier.get().getSupplierOrderList().remove(supplierOrder.get());
        supplierRepository.save(supplier.get());
        supplierOrderRepository.deleteById(id);
        return SupplierOrderDto.fromEntity(supplierOrder.get());
    }
}
