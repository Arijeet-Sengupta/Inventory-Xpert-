package com.dbtest.dbtest.Schema;

import lombok.Data;

@Data
public class InventoryRequest {

    String productType;
    String stockLocation;
    String producName;
    String subProductName;
    int quantity;
    String vendorName;

}
