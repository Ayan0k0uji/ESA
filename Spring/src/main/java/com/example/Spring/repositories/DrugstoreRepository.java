package com.example.Spring.repositories;

import com.example.Spring.entities.Drugstore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugstoreRepository extends JpaRepository<Drugstore, Long> {

}
