package com.nhnacademy.springjpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Orders")
@NoArgsConstructor
@Getter
@Setter
public class Orders {
    @Id
    @Column(name = "OrderID")
    private int orderID;

    @OneToOne
    @JoinColumn(name = "userId")
    private users users;

    @Column(name = "OrderDate")
    private LocalDateTime orderDate;

    @Column(name = "ShipDate")
    private LocalDateTime shipDate;
}
