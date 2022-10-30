package com.ossama.gestionstock.controller.api;

import com.ossama.gestionstock.dto.SalesDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ossama.gestionstock.other.Constants.SALES_API;

public interface SalesApi {
    @PostMapping(value =SALES_API+"/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    SalesDto saveSales(@RequestBody SalesDto salesDto);
    @GetMapping(value=SALES_API+"/{salesId}",produces = MediaType.APPLICATION_JSON_VALUE)
    SalesDto findSalesById(@PathVariable Integer salesId);
    @GetMapping(value=SALES_API+"/{salesCode}",produces = MediaType.APPLICATION_JSON_VALUE)
    SalesDto findSalesByCode(@PathVariable String salesCode);
    @GetMapping(value=SALES_API+"/all",produces = MediaType.APPLICATION_JSON_VALUE)
    List<SalesDto> findAllSales();
    @DeleteMapping(value=SALES_API+"/delete/{salesId}",produces = MediaType.APPLICATION_JSON_VALUE)
    SalesDto deleteSalesById(@PathVariable Integer salesId);
}
