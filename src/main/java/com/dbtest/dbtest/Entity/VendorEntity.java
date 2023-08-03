package com.dbtest.dbtest.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vendordetails")
public class VendorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vendorid")
    private int vendorid;

    @Column(name = "vendorname")
    private String vendorName;
    @Column(name = "vendorlocation")
    private String vendorLocation;

    @Column(name = "email")
    private String email;

    @Column(name = "lastupdatedby")
    private String lastUpdatedBy;

    @Column(name = "lastupdatedbytimestamp")
    private LocalDateTime lastUpdatedByTimestamp;

    @Column(name = "createdby")
    private String createdBy;

    @Column(name = "createdbytimestamp")
    private LocalDateTime createdByTimestamp;


}
