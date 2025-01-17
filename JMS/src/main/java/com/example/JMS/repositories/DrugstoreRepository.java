package com.example.JMS.repositories;

import com.example.JMS.entities.Drugstore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugstoreRepository extends JpaRepository<Drugstore, Long> {

}