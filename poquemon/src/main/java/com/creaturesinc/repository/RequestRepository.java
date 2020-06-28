package com.creaturesinc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.creaturesinc.entity.RequestLog;

@Repository
public interface RequestRepository extends JpaRepository<RequestLog, Long> {
		
}
