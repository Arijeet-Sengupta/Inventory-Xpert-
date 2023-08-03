package com.dbtest.dbtest.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.RequestParam;

public class SubProductSchema {
    @JsonProperty
    public String subProductName;

    @JsonProperty
    public String productName;

    @JsonProperty
    public String vendorName;

    @JsonProperty
    public Double productSellingPrice;

    @JsonProperty
    public Double productPurchasePrice;

    @JsonProperty
    public int subproductId;

}
