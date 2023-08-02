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

    private int vendorid;

    @Column(name = "vendorname")
    private String vendorName;

    private String vendorLocation;


    private String email;


    private String lastUpdatedBy;


    private LocalDateTime lastUpdatedByTimestamp;


    private String createdBy;


    private LocalDateTime createdByTimestamp;


}
