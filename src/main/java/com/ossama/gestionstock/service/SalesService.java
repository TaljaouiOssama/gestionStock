package com.ossama.gestionstock.service;

import com.ossama.gestionstock.dto.SalesDto;
import com.ossama.gestionstock.dto.SalesLineDto;

import java.util.List;

public interface SalesService {
    SalesDto addSales(SalesDto salesDto);
    SalesDto addLinesToSales(Integer id, List<SalesLineDto> salesLineDtoList);
    SalesDto removeLinesToSales(Integer id, List<SalesLineDto> salesLineDtoList);
    SalesDto getSalesById(Integer id);
    SalesDto getSalesByCode(String code);
    List<SalesDto> getAllSales();
    SalesDto updateSales(Integer id,SalesDto salesDto);
    SalesDto deleteSales(Integer id);
}
