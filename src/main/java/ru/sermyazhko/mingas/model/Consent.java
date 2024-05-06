package ru.sermyazhko.mingas.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "consentTable")
@Data
public class Consent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fromData;
    private LocalDate toData;
    private Boolean agree;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private User user;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Agreement agreement;
}
