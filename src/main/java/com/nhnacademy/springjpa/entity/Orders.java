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
    private int OrderID;

    @OneToOne
    @JoinColumn(name = "userId")
    private users users;

    private LocalDateTime OrderDate;

    private LocalDateTime ShipDate;
}
