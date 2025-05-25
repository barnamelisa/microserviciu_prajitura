package com.example.demo.service;


import com.example.demo.domain.entity.Prajitura;
import com.example.demo.infrastructure.repository.PrajituraRepo;
import com.example.demo.domain.dto.PrajituraDTO;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PrajituraService {

    @Autowired
    private PrajituraRepo prajituraRepo;

    @Autowired
    private ModelMapper mapper;

    @PostConstruct
    public void initMapper() {
        mapper.typeMap(PrajituraDTO.class, Prajitura.class).addMappings(m -> {
            m.map(PrajituraDTO::getPrajitura_id, Prajitura::setId); // 👈 adăugat
            m.map(PrajituraDTO::getNume_prajitura, Prajitura::setName);
            m.map(PrajituraDTO::getDescriere, Prajitura::setDescriere);
            m.map(PrajituraDTO::getCofetarie_id, Prajitura::setCofetarieId);
            m.map(PrajituraDTO::getPret, Prajitura::setPret);
            m.map(PrajituraDTO::getData_productie, Prajitura::setDataProductie);
            m.map(PrajituraDTO::getData_expirare, Prajitura::setDataExpirare);
            m.map(PrajituraDTO::getImagine, Prajitura::setImagine);
        });

        mapper.typeMap(Prajitura.class, PrajituraDTO.class).addMappings(m -> {
            m.map(Prajitura::getId, PrajituraDTO::setPrajitura_id); // 👈 adăugat
            m.map(Prajitura::getName, PrajituraDTO::setNume_prajitura);
            m.map(Prajitura::getDescriere, PrajituraDTO::setDescriere);
            m.map(Prajitura::getCofetarieId, PrajituraDTO::setCofetarie_id);
            m.map(Prajitura::getPret, PrajituraDTO::setPret);
            m.map(Prajitura::getDataProductie, PrajituraDTO::setData_productie);
            m.map(Prajitura::getDataExpirare, PrajituraDTO::setData_expirare);
            m.map(Prajitura::getImagine, PrajituraDTO::setImagine);
        });

    }

    public PrajituraDTO getPrajituraById(int id) {
        Optional<Prajitura> optional = prajituraRepo.findById(id);
        return optional.map(prajitura -> mapper.map(prajitura, PrajituraDTO.class)).orElse(null);
    }

    public List<PrajituraDTO> getAllPrajituri() {
        return prajituraRepo.findAll().stream()
                .map(prajitura -> mapper.map(prajitura, PrajituraDTO.class))
                .collect(Collectors.toList());
    }

    public PrajituraDTO addPrajitura(PrajituraDTO dto) {
        dto.setPrajitura_id(0);
        Prajitura entity = mapper.map(dto, Prajitura.class);
        Prajitura saved = prajituraRepo.save(entity);
        return mapper.map(saved, PrajituraDTO.class);
    }

    public PrajituraDTO updatePrajitura(int id, PrajituraDTO dto) {
        Optional<Prajitura> optional = prajituraRepo.findById(id);
        if (optional.isPresent()) {
            Prajitura existing = optional.get();
            existing.setName(dto.getNume_prajitura());
            existing.setDescriere(dto.getDescriere());
            existing.setCofetarieId(dto.getCofetarie_id());
            existing.setPret(dto.getPret());
            existing.setDataProductie(dto.getData_productie());
            existing.setDataExpirare(dto.getData_expirare());
            existing.setImagine(dto.getImagine());
            Prajitura updated = prajituraRepo.save(existing);
            return mapper.map(updated, PrajituraDTO.class);
        }
        return null;
    }

    public boolean deletePrajitura(int id) {
        if (prajituraRepo.existsById(id)) {
            prajituraRepo.deleteById(id);
            return true;
        }
        return false;
    }
}