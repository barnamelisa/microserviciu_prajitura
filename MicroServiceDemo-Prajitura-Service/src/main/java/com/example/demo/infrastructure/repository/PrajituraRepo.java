package com.example.demo.infrastructure.repository;

import com.example.demo.domain.entity.Prajitura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrajituraRepo extends JpaRepository<Prajitura, Integer> {

}