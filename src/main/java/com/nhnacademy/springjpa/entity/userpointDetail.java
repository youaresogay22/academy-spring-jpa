package com.nhnacademy.springjpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "userpointDetail")
@NoArgsConstructor
@Getter
@Setter
public class userpointDetail {
    @Id
    @Column(name = "userpointDetailID")
    private String userPointDetailID;

    @ManyToOne
    @JoinColumn(name = "userId")
    private users users;

    @Column(name = "userpointchange")
    private String userPointChange;

    @Column(name = "userpointchangeamount")
    private BigDecimal userPointChangeAmount;

    @Column(name = "userpointchangedate")
    private LocalDateTime userPointChangeDate;

}
