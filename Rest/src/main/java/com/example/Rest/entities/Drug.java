package com.example.Rest.entities;

import com.example.Rest.entities.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "drug")
@Entity
public class Drug implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @ManyToOne
    @JoinColumn(name = "drugstore_id")
    private Drugstore drugstore;

}
