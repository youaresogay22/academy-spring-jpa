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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String ProductID;

    @Column(name = "ModelNumber")
    private String modelNumber;

    @Column(name = "")
    private String ModelName;

    @Column(name = "")
    private String ProductThumbnail;

    @Column(name = "")
    private String ProductImage;

    @Column(name = "")
    private BigDecimal UnitCost;

    @Column(name = "")
    private int UnitQuantity;

    @Column(name = "")
    private String Description;

}
