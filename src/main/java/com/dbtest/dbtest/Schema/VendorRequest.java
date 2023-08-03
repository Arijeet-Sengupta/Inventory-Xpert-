package com.dbtest.dbtest.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VendorRequest {
    @JsonProperty
    public int vendorid;
    @JsonProperty
    public String vendorname;
    @JsonProperty
    public String  vendorlocation;
    @JsonProperty
    public String email;
}
