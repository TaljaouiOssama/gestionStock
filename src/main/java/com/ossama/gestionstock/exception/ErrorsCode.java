package com.ossama.gestionstock.exception;

public enum ErrorsCode {
    Category_Not_Found(1000),
    Category_Not_Valid(1001),
    Client_Not_Found(2000),
    Client_Not_Valid(2001),
    ClientOrder_Not_Found(3000),
    ClientOrder_Not_Valid(3001),
    ClientOrderLine_Not_Found(4000),
    ClientOrderLine_Not_Valid(4001),
    Entreprise_Not_Found(5000),
    Entreprise_Not_Valid(5001),
    Product_Not_Found(6000),
    Product_Not_Valid(6001),
    Roles_Not_Found(7000),
    Roles_Not_Valid(7001),
    Sales_Not_Found(8000),
    Sales_Not_Valid(8001),
    SalesLine_Not_Found(9000),
    SalesLine_Not_Valid(9001),
    StockMovement_Not_Found(10000),
    StockMovement_Not_Valid(10001),
    Supplier_Not_Found(11000),
    Supplier_Not_Valid(11001),
    SupplierOrder_Not_Found(12000),
    SupplierOrder_Not_Valid(12001),
    SupplierOrderLine_Not_Found(13000),
    SupplierOrderLine_Not_Valid(13001),
    Users_Not_Found(14000),
    Users_Not_Valid(14001),
    ;
    private int code;

    ErrorsCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
