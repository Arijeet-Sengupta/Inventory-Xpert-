package com.dbtest.dbtest.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductReq {

    @JsonProperty
    public Integer productId;

   public Integer getProductId() {
        return productId;
    }
//
//    public void setProductId(Integer productId) {
//        this.productId = productId;
//    }

    @JsonProperty
    public String productName;

//    public String getProductname() {
//        return productname;
//    }
//
//    public void setProductname(String productname) {
//        this.productname = productname;
//    }
}
