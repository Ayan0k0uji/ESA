package com.example.drugstore.entities;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "drugstore")
public class Drugstore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

}
