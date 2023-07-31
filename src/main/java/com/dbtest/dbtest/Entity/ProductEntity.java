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
@Table(name="productdetails")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="productId")
    private int productId;

    @Column(name="productName")
    private String productName;

    @Column(name="lastUpdatedBy")
    private String lastUpdatedBy;

    @Column(name="lastUpdatedByTimestamp")
    private LocalDateTime lastUpdatedByTimestamp;

    @Column(name="createdBy")
    private String createdBy;

    @Column(name="createdByTimestamp")
    private LocalDateTime createdByTimestamp;

}
