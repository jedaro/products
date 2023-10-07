package com.kometsales.products.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.kometsales.products.model.Inventory;
import com.kometsales.products.util.IInventaryProduct;

@Component
public interface IInventoryRepository  extends JpaRepository<Inventory, Long>{
    
    @Query(value=("SELECT p.NAME AS productName,\n" + //
            "       CAST(i.BASEPRICE AS varchar) AS basePrice,\n" + //
            "       (ROUND(((i.cubesPerCarrier *  ( (bt.width * bt.height * bt.length) / 1728)) / i.pack ) * (p.freshCutValue/100),2)) AS finalFreight\n" + //
            "FROM TBLINVENTORYPT i ,TBLPRODUCTPT p, TBLBOXTYPEPT bt \n" + //
            "WHERE I.PRODUCTID = p.ID AND i.BOXTYPEID = bt.ID AND bt.ID = i.BOXTYPEID AND i.COMPANYID = :companyId"), nativeQuery = true)
    public List<IInventaryProduct> getInventaryProducts(Integer companyId);
}
