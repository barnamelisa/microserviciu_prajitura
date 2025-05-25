package com.example.demo.infrastructure.repository;

import com.example.demo.domain.contracts.PrajituraRepository;
import com.example.demo.domain.entity.Prajitura;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PrajituraRepositoryImpl implements PrajituraRepository {

    private final PrajituraRepo jpaRepo;

    public PrajituraRepositoryImpl(PrajituraRepo jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public List<Prajitura> findAll() {
        return jpaRepo.findAll();
    }

    @Override
    public Optional<Prajitura> findById(int id) {
        return jpaRepo.findById(id);
    }

    @Override
    public Prajitura save(Prajitura prajitura) {
        return jpaRepo.save(prajitura);
    }

    @Override
    public void deleteById(int id) {
        jpaRepo.deleteById(id);
    }
}

