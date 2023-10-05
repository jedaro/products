package com.kometsales.products.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "TBLBOXTYPEPT")
public class BoxType {

    private Integer id;
    private String code;
    private Double width;
    private Double height;
    private Double length;
    
}
