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

    private long vendorId;
    @Column(name = "vendorName")
    private String vendorName;
    @Column(name = "vendorType")
    private String vendorType;

    private String vendorLocation;
    private String email;
    private String lastUpdatedBy;
    private LocalDateTime LastUpdatedByTimestamp;
    private String createdBy;
    private LocalDateTime createdByTimestamp;
}
