package com.nhnacademy.springjpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

// TODO #2: `Locker` Entity
@Getter
@Setter
@Entity
@Table(name = "Lockers")
public class Locker {
    @Id
    @Column(name = "locker_id")
    private Long id;

    @Column(name = "locker_name")
    private String name;

}
