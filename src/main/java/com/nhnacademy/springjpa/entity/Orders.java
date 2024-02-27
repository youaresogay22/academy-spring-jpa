package com.nhnacademy.springjpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Orders")
@NoArgsConstructor
@Getter
@Setter
public class Orders {
    @Id
    private int OrderID;

    @OneToOne
    @JoinColumn(name = "CustomerId")
    private Customer customer;

    private int Quantity;

    private BigDecimal UnitCost;
}
