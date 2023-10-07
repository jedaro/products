package com.kometsales.products.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "TBLINVENTORYPT")
public class Inventory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;           

    @Column(name = "boxTypeId")
    private Integer boxTypeId; 
    
    @Column(name = "productId")
	private Integer productId;     
    
    @Column(name = "companyId")
	private Integer companyId;    
    
    @Column(name = "cubesPerCarrier")
	private Double cubesPerCarrier; 

    @Column(name = "pack")
	private Integer pack;   
    
    @Column(name = "basePrice")
	private Double basePrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBoxTypeId() {
        return boxTypeId;
    }

    public void setBoxTypeId(Integer boxTypeId) {
        this.boxTypeId = boxTypeId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Double getCubesPerCarrier() {
        return cubesPerCarrier;
    }

    public void setCubesPerCarrier(Double cubesPerCarrier) {
        this.cubesPerCarrier = cubesPerCarrier;
    }

    public Integer getPack() {
        return pack;
    }

    public void setPack(Integer pack) {
        this.pack = pack;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    
}
