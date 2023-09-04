package com.example.bankapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
//@Entity
//@Table(name = "transaction")
public class Transaction {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne(optional = false)
//    @JoinColumn(name = "account_id")
//    private Account debit_account_id;
    private Long debit_account_id;

    private Long credit_account_id;
    private int type;
    private BigDecimal amount;
    private String description;
    private LocalDate create_at;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (!id.equals(that.id)) return false;
        if (!debit_account_id.equals(that.debit_account_id)) return false;
        return credit_account_id.equals(that.credit_account_id);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + debit_account_id.hashCode();
        result = 31 * result + credit_account_id.hashCode();
        return result;
    }
}
