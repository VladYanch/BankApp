package com.example.bankapp.entity;

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
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "manager_id")
    private Manager managerId;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private int status;

    @Column(name = "currency_code")
    private int currencyCode;

    @Column(name = "interest_rate")
    private BigDecimal interestRate;

    @Column(name = "total")
    private int total;

    @Column(name = "create_at")
    private LocalDate createAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    public Product() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!id.equals(product.id)) return false;
        return name.equals(product.name);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
