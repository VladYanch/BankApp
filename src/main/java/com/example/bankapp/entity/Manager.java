package com.example.bankapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "manager")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String first_name;
    private String last_name;
    private int status;
    private LocalDate create_at;
    private LocalDate updated_at;

    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Client> clientList = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Manager manager = (Manager) o;

        if (!id.equals(manager.id)) return false;
        if (!first_name.equals(manager.first_name)) return false;
        return last_name.equals(manager.last_name);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + first_name.hashCode();
        result = 31 * result + last_name.hashCode();
        return result;
    }
}
