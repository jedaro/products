package com.kometsales.products.util;

public interface IProduct {

     String getProductName();
     String getCompanyName();
     String getPrice();

     void setProductName(String productName);
     void setCompanyName(String companyName);
     void setPrice( String price);
}
