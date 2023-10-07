package com.kometsales.products.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.kometsales.products.model.Product;
import com.kometsales.products.util.IProduct;
import com.kometsales.products.util.IProductName;

@Component
public interface IProductRepository extends JpaRepository<Product, Long>{
    
    @Query(value = "SELECT P.NAME AS productName, \n" + //
            "              CP.NAME AS companyName, \n" + //
            "              ( CAST(ROUND( I.BASEPRICE - ( I.BASEPRICE * ( C.MARKDOWN / 100 ) )  , 2 )  AS VARCHAR) )  AS price \n" + //
            "FROM TBLCUSTOMERPT C, TBLINVENTORYPT I, TBLCOMPANYPT CP, TBLPRODUCTPT P\n" + //
            "WHERE I.PRODUCTID = P.ID AND I.COMPANYID=CP.ID AND C.ID = :customerId", nativeQuery = true)
    public List<IProduct> getCustomerProducts(Integer customerId);

    @Query(value = "SELECT P.NAME AS productName \n" + //
         "       FROM TBLINVENTORYPT I, TBLCOMPANYPT C, TBLPRODUCTPT P \n" + //
         "       WHERE I.PRODUCTID = P.ID AND I.COMPANYID = C.ID AND C.ID = :companyId", nativeQuery = true)
    public List<IProductName> getProducts(Integer companyId);
}
