package com.ossama.gestionstock.service.Impl;

import com.ossama.gestionstock.dto.SupplierDto;
import com.ossama.gestionstock.exception.EntityNotFoundException;
import com.ossama.gestionstock.exception.ErrorsCode;
import com.ossama.gestionstock.exception.InvalidEntityException;
import com.ossama.gestionstock.model.Supplier;
import com.ossama.gestionstock.repository.SupplierRepository;
import com.ossama.gestionstock.service.SupplierService;
import com.ossama.gestionstock.validator.SupplierValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@Slf4j
public class SupplierServiceImpl implements SupplierService {
    SupplierRepository supplierRepository;
    public SupplierServiceImpl(SupplierRepository supplierRepository){
        this.supplierRepository=supplierRepository;
    }
    @Override
    public SupplierDto addSupplier(SupplierDto supplierDto) {
        List<String> errors= SupplierValidator.validate(supplierDto);
        if(!errors.isEmpty()){
            log.error("supplierDto is Not Valid",supplierDto);
            throw new InvalidEntityException("supplierDto is Not Valid", ErrorsCode.Supplier_Not_Valid,errors);
        }
        return SupplierDto.fromEntity(
                supplierRepository.save(SupplierDto.toEntity(supplierDto))
        );
    }

    @Override
    public SupplierDto getSupplierById(Integer id) {
        if(id==null){
            log.error("get: SupplierID is NULL");
            return null;
        }
        Optional<Supplier> supplier=supplierRepository.findById(id);
        return supplier.map(SupplierDto::fromEntity)
                .orElseThrow(
                        ()->new EntityNotFoundException("Supplier with id"+id+" Not found",ErrorsCode.Supplier_Not_Found));

    }

    @Override
    public SupplierDto getSupplierByCode(String code) {
        if(code==null){
            log.error("get SupplierCode is NULL");
            return null;
        }
        Optional<Supplier> supplier=supplierRepository.findSupplierByCode(code);
        return supplier.map(SupplierDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("Supplier with code"+code+" Not found",ErrorsCode.Supplier_Not_Found));


    }

    @Override
    public List<SupplierDto> getAllSuppliers() {
        return supplierRepository.findAll().stream()
                .map(SupplierDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public SupplierDto updateSupplier(Integer id, SupplierDto supplierDto) {
        List<String> errors= SupplierValidator.validate(supplierDto);
        if(!errors.isEmpty()){
            log.error("supplierDto is Not Valid",supplierDto);
            throw new InvalidEntityException("supplierDto is Not Valid", ErrorsCode.Supplier_Not_Valid,errors);
        }

        if(id==null){
            log.error("update SupplierId is NULL");
            return null;
        }
        Optional<Supplier> supplier=supplierRepository.findById(id);
        if(supplier.isPresent()){
            supplier.get().setFirstName(supplierDto.getFirstName());
            supplier.get().setLastName(supplierDto.getLastName());
            supplier.get().setPhone(supplierDto.getPhone());
            supplier.get().setEmail(supplierDto.getEmail());
            supplier.get().setPicture(supplierDto.getPicture());
            supplierRepository.save(supplier.get());
        }
        return supplierRepository.findById(id).map(SupplierDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("Supplier with id "+id+"not found",ErrorsCode.Supplier_Not_Found));

    }

    @Override
    public SupplierDto deleteSupplier(Integer id) {
        if(id==null){
            log.error("delete: Supplier with id NULL");
            return null;
        }
        Optional<Supplier> supplier=supplierRepository.findById(id);
        if(supplier.isPresent()){
            supplierRepository.deleteById(id);
            return SupplierDto.fromEntity(supplier.get());
        }
        throw new EntityNotFoundException("supplier with id "+id+" not found",ErrorsCode.Supplier_Not_Found);

    }
}
