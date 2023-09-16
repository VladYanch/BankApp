package com.example.bankapp.entity;

import com.example.bankapp.entity.enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private UUID id;

    @JoinColumn(name = "account_id")
    @ManyToOne(optional = false)
//    @Column(name = "debit_account_id")
    private Account debitAccount;

    @JoinColumn(name = "credit_account_id")
    @ManyToOne(optional = false)
//    @Column(name = "credit_account_id")
    private Account creditAccount;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "description")
    private String description;

    @Column(name = "create_at")
    private LocalDate createAt;

    public Transaction() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (!id.equals(that.id)) return false;
        if (!debitAccount.equals(that.debitAccount)) return false;
        return creditAccount.equals(that.creditAccount);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + debitAccount.hashCode();
        result = 31 * result + creditAccount.hashCode();
        return result;
    }
}
