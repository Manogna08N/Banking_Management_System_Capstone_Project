package com.example.notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.notification.entity.DeliveryLog;

public interface DeliveryLogRepository extends JpaRepository<DeliveryLog, Long>  {

}
