package com.kometsales.products.util;



public interface IInventoryProduct {
     String getProductName();
     String getBasePrice();
     Double getFinalFreight();

     void setProductName(String name);
     void setBasePrice(String basePrice);
     void setFinalFreight(Double finalFreight);

}
