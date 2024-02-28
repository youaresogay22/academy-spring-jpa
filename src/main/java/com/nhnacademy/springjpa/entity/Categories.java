package com.nhnacademy.springjpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Categories")
@NoArgsConstructor
@Getter
@Setter
public class Categories {
    @Id
    @Column(name = "CategoryID")
    private int categoryId;

    @Column(name = "CategoryName")
    private String categoryName;

    @ManyToOne
    @JoinColumn(name = "ProductID")
    private Products product;
}
