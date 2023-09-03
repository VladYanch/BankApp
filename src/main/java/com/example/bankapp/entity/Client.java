package com.example.bankapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Id
    private Long manager_id;

//    @NotBlank(message = "{validation.client.tax_code}")
    private int status; // был инт

//    @NotBlank(message = "{validation.client.tax_code}")
//    @Length(max = 20, message = "{validation.client.tax_code.length}")
    private String tax_code;

//    @NotBlank(message = "{validation.client.tax_code}")
//    @Length(max = 100, message = "{validation.client.tax_code.length}")
    private String first_name;

//    @NotBlank(message = "{validation.client.tax_code}")
//    @Length(max = 50, message = "{validation.client.tax_code.length}")
    private String last_name;

//    @Email(message = "{validation.client.email}")
//    @NotBlank(message = "{validation.client.email}")
//    @Length(max = 25, message = "{validation.cafe.email.length}")
    private String email;

//    @NotBlank(message = "{validation.client.address}")
//    @Length(max = 80, message = "{validation.client.address.length}")
    private String address;

//    @NotBlank(message = "{validation.client.phone}")
//    @Length(max = 80, message = "{validation.client.phone.length}")
    private String phone;

//    @NotBlank(message = "{validation.client.create_at}")
    private LocalDate create_at;

//    @NotBlank(message = "{validation.client.updated_at}")
    private LocalDate updated_at;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (!id.equals(client.id)) return false;
        if (!tax_code.equals(client.tax_code)) return false;
        return first_name.equals(client.first_name);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + tax_code.hashCode();
        result = 31 * result + first_name.hashCode();
        return result;
    }
}
