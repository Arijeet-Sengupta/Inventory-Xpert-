package com.dbtest.dbtest.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VendorResponse {
    @JsonProperty
    public String message;
    @JsonProperty
    public int vendorid;
}
