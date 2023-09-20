package com.example.bankapp.entity;

import com.example.bankapp.entity.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    private Manager manager;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

//    @NotBlank(message = "{validation.client.tax_code}")
//    @Length(max = 20, message = "{validation.client.tax_code.length}")
    @Column(name = "tax_code")
    private String taxCode;

//    @NotBlank(message = "{validation.client.tax_code}")
//    @Length(max = 100, message = "{validation.client.tax_code.length}")
    @Column(name = "first_name")
    private String firstName;

//    @NotBlank(message = "{validation.client.tax_code}")
//    @Length(max = 50, message = "{validation.client.tax_code.length}")
    @Column(name = "last_name")
    private String lastName;


//    @Email(message = "{validation.client.email}")
//    @NotBlank(message = "{validation.client.email}")
//    @Length(max = 25, message = "{validation.cafe.email.length}")
    @Column(name = "email")
    private String email;

//    @NotBlank(message = "{validation.client.address}")
//    @Length(max = 80, message = "{validation.client.address.length}")
    @Column(name = "address")
    private String address;

//    @NotBlank(message = "{validation.client.phone}")
//    @Length(max = 80, message = "{validation.client.phone.length}")
    @Column(name = "phone")
    private String phone;

//    @NotBlank(message = "{validation.client.create_at}")
    @Column(name = "create_at")
    private LocalDate createAt;

//    @NotBlank(message = "{validation.client.updated_at}")
    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Account> accounts = new HashSet<>();

    public Client() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (!id.equals(client.id)) return false;
        if (!taxCode.equals(client.taxCode)) return false;
        return firstName.equals(client.firstName);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + taxCode.hashCode();
        result = 31 * result + firstName.hashCode();
        return result;
    }
}
