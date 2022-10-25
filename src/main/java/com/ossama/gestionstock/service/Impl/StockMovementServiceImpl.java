package com.ossama.gestionstock.service.Impl;

import com.ossama.gestionstock.dto.ClientDto;
import com.ossama.gestionstock.dto.ProductDto;
import com.ossama.gestionstock.dto.StockMovementDto;
import com.ossama.gestionstock.exception.EntityNotFoundException;
import com.ossama.gestionstock.exception.ErrorsCode;
import com.ossama.gestionstock.exception.InvalidEntityException;
import com.ossama.gestionstock.model.Client;
import com.ossama.gestionstock.model.Product;
import com.ossama.gestionstock.model.StockMovement;
import com.ossama.gestionstock.repository.ProductRepository;
import com.ossama.gestionstock.repository.StockMovementRepository;
import com.ossama.gestionstock.service.StockMovementService;
import com.ossama.gestionstock.validator.ClientValidator;
import com.ossama.gestionstock.validator.StockMovementValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StockMovementServiceImpl implements StockMovementService {
    private StockMovementRepository stockMovementRepository;
    private ProductRepository productRepository;
    @Autowired
    public StockMovementServiceImpl(StockMovementRepository stockMovementRepository) {
        this.stockMovementRepository = stockMovementRepository;
    }

    @Override
    @Transactional
    public StockMovementDto addStockMovement(StockMovementDto stockMovementDto) {
        List<String> errors= StockMovementValidator.validate(stockMovementDto);
        if(!errors.isEmpty()){
            log.error("stockMovementDto is Not Valid",stockMovementDto);
            throw new InvalidEntityException("stockMovementDto is Not Valid", ErrorsCode.StockMovement_Not_Valid,errors);
        }
        Optional<Product> product=productRepository.findById(stockMovementDto.getProduct().getId());
        if(!product.isPresent()){
            log.error("StockMovement's product is not present");
            throw new EntityNotFoundException("StockMovement's product is not present",ErrorsCode.Product_Not_Found);
        }
        product.get().getStockMovementList().add(StockMovementDto.toEntity(stockMovementDto));
        return StockMovementDto.fromEntity(
                stockMovementRepository.save(StockMovementDto.toEntity(stockMovementDto))
        );
    }

    @Override
    public StockMovementDto getStockMovementById(Integer id) {
        if(id==null){
            log.error("get: StockMovementId is NULL");
            return null;
        }
        Optional<StockMovement> stockMovement=stockMovementRepository.findById(id);
        return stockMovement.map(StockMovementDto::fromEntity)
                .orElseThrow(
                        ()->new EntityNotFoundException("StockMovement with id"+id+" Not found",ErrorsCode.StockMovement_Not_Found));

    }

    @Override
    public StockMovementDto getStockMovementByCode(String code) {
        if(code==null){
            log.error("get: StockMovementCode is NULL");
            return null;
        }
        Optional<StockMovement> stockMovement=stockMovementRepository.findStockMovementByCode(code);
        return stockMovement.map(StockMovementDto::fromEntity)
                .orElseThrow(
                        ()->new EntityNotFoundException("StockMovement with code"+code+" Not found",ErrorsCode.StockMovement_Not_Found));

    }

    @Override
    public List<StockMovementDto> getAllStockMovements() {
        return stockMovementRepository.findAll().stream()
                .map(StockMovementDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public StockMovementDto updateStockMovement(Integer id, StockMovementDto stockMovementDto) {
        if(id==null){
            log.error("update: StockMovementId is NULL");
            return null;
        }
        List<String> errors= StockMovementValidator.validate(stockMovementDto);
        if(!errors.isEmpty()){
            log.error("stockMovementDto is Not Valid",stockMovementDto);
            throw new InvalidEntityException("stockMovementDto is Not Valid", ErrorsCode.StockMovement_Not_Valid,errors);
        }
        Optional<Product> product=productRepository.findById(stockMovementDto.getProduct().getId());
        if(!product.isPresent()){
            log.error("StockMovement's product is not present");
            throw new EntityNotFoundException("StockMovement's product is not present",ErrorsCode.Product_Not_Found);
        }
        Optional<StockMovement> stockMovement=stockMovementRepository.findById(id);
        if(stockMovement.isPresent()){
            product.get().getStockMovementList().remove(stockMovement.get());
            product.get().getStockMovementList().add(StockMovementDto.toEntity(stockMovementDto));
            stockMovement.get().setType(stockMovementDto.getType());
            stockMovement.get().setQuantity(stockMovementDto.getQuantity());
            stockMovement.get().setMvtDate(stockMovementDto.getMvtDate());
            stockMovement.get().setProduct(ProductDto.toEntity(stockMovementDto.getProduct()));
            stockMovementRepository.save(stockMovement.get());
        }
        return stockMovementRepository.findById(id).map(StockMovementDto::fromEntity)
                .orElseThrow(
                        ()->new EntityNotFoundException("StockMovement with id"+id+" Not found",ErrorsCode.StockMovement_Not_Found));


    }

    @Override
    public StockMovementDto deleteStockMovement(Integer id) {
        if(id==null){
            log.error("delete: StockMovement with id NULL");
            return null;
        }
        Optional<StockMovement> stockMovement=stockMovementRepository.findById(id);
        Optional<Product> product=productRepository.findById(stockMovement.get().getProduct().getId());
        if(stockMovement.isPresent()){
            stockMovementRepository.deleteById(id);
            product.get().getStockMovementList().remove(stockMovement.get());
            return StockMovementDto.fromEntity(stockMovement.get());
        }
        throw new EntityNotFoundException("stockMovement with id "+id+" not found",ErrorsCode.StockMovement_Not_Found);
    }
}
