package com.example.bankapp.entity;

import com.example.bankapp.entity.enums.AccountStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id")
    private Client clientId;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private int type;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "currency_code")
    private int currencyCode;

    @Column(name = "create_at")
    private LocalDate createAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    public Account() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (!id.equals(account.id)) return false;
        return name.equals(account.name);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
