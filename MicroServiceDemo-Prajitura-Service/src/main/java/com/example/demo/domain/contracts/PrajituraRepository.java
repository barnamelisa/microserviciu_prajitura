package com.example.demo.domain.contracts;

import com.example.demo.domain.entity.Prajitura;

import java.util.List;
import java.util.Optional;

public interface PrajituraRepository {
    List<Prajitura> findAll();
    Optional<Prajitura> findById(int id);
    Prajitura save(Prajitura prajitura);
    void deleteById(int id);
}
