package com.example.drugstore.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "drug")
@Entity
public class Drug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @ManyToOne
    @JoinColumn(name = "drugstore_id")
    private Drugstore drugstore;

}
