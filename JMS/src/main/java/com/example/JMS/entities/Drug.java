package com.example.JMS.entities;

import com.example.JMS.entities.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

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
    @ToString.Exclude
    private Drugstore drugstore;

}
