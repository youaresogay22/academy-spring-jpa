package com.nhnacademy.springjpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Products", schema = "nhn_academy_29")
@NoArgsConstructor
@Getter
@Setter
public class Products {
    @Id
    @Column(name = "ProductID")
    private String productId;

    @Column(name = "ModelNumber")
    private String modelNumber;

    @Column(name = "ModelName")
    private String modelName;

    @Column(name = "ProductThumbnail")
    private String productThumbnail;

    @Column(name = "ProductImage")
    private String productImage;

    @Column(name = "UnitCost")
    private BigDecimal unitCost;

    @Column(name = "UnitQuantity")
    private int unitQuantity;

    @Column(name = "Description")
    private String description;

}
