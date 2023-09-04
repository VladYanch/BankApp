package com.example.bankapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
//@Entity
//@Table(name = "aggreement")
public class Aggreement {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne(optional = false)
//    @JoinColumn(name = "account_id")
//    private Account account_id;
    private Long account_id;


    private Long product_id;
    private BigDecimal interest_rate;
    private int status;
    private BigDecimal sum;
    private LocalDate create_at;
    private LocalDate updated_at;
}
