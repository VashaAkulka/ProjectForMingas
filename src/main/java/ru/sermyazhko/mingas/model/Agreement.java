package ru.sermyazhko.mingas.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "agreementTable")
@Data
public class Agreement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String target;
    private String content;

    @OneToMany(mappedBy = "agreement", cascade = CascadeType.ALL)
    private List<Consent> consents = new ArrayList<>();
}
