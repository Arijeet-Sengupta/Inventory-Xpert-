package com.dbtest.dbtest.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductReq {

    @JsonProperty
    public Integer productId;


   public Integer getProductId() {
        return productId;
    }


    @JsonProperty
    public String productName;


}
