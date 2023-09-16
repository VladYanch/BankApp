package com.example.bankapp.entity;

import com.example.bankapp.entity.enums.AgreementStatus;
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
@Table(name = "agreement")
public class Agreement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private UUID id;

    @OneToOne(optional = false)
    @JoinColumn(name = "account_id")
    private Account accountId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id")
    private Product productId;
//    Set<Product> productId;

    @Column(name = "interest_rate")
    private BigDecimal interestRate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private AgreementStatus status;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "create_at")
    private LocalDate createAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    public Agreement() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Agreement agreement = (Agreement) o;

        return id.equals(agreement.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
