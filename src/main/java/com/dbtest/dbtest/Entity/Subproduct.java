package com.dbtest.dbtest.Entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name= "subproductdetails")
public class Subproduct {
    @Id
    @Column(name="subProductId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subProductId;

    @Column(name="subProductName")
    private String subProductName;

    @OneToOne
    @JoinColumn(name = "productId", referencedColumnName = "productId")
    private ProductEntity productDetails;

    @OneToOne
    @JoinColumn(name = "vendorId", referencedColumnName = "vendorId")
    private VendorEntity vendorDetails;

    @Column(name="productSellingPrice")
    private float productSellingPrice;

    @Column(name="productPurchasePrice")
    private float productPurchasePrice;

    @Column(name="lastUpdatedBy")
    private String lastUpdatedBy;

    @Column(name="lastUpdatedTimestamp")
    private LocalDateTime lastUpdatedTimestamp;

    @Column(name="createdBy")
    private String createdBy;

    @Column(name="createdByTimestamp")
    private LocalDateTime createdByTimestamp;

}
