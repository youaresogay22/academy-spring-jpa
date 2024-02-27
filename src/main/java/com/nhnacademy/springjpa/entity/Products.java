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
    private String ModelNumber;
    private String ModelName;
    private String ProductThumbnail;
    private String ProductImage;
    private BigDecimal UnitCost;
    private int UnitQuantity;
    private String Description;

}
