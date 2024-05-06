package ru.sermyazhko.mingas.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "userTable")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String middleName;
    private String lastName;
    private String phoneNumber;
    private String position;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Consent> consents = new ArrayList<>();
}
