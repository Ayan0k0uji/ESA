package com.example.JMS.notification.repository;

import com.example.JMS.notification.model.NotificationCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationConditionRepository extends JpaRepository<NotificationCondition, Long> {
    List<NotificationCondition> findByEntityName(String entityName);
}