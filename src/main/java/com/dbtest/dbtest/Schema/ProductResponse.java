package com.dbtest.dbtest.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductResponse {

    //here the message will display
    @JsonProperty
    public String message;

    @JsonProperty
    public int productId;
}
