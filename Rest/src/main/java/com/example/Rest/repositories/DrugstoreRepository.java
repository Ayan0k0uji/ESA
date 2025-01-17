package com.example.Rest.repositories;

import com.example.Rest.entities.Drugstore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugstoreRepository extends JpaRepository<Drugstore, Long> {

}
