package com.example.demo.controller;

import com.example.demo.domain.dto.PrajituraDTO;
import com.example.demo.service.PrajituraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/prajitura")
public class PrajituraController {

    @Autowired
    private PrajituraService prajituraService;

    @GetMapping("/{id}")
    public ResponseEntity<PrajituraDTO> getPrajituraDetails(@PathVariable("id") int id) {
        PrajituraDTO prajituraDTO = prajituraService.getPrajituraById(id);
        if (prajituraDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(prajituraDTO);
    }

    @GetMapping
    public ResponseEntity<List<PrajituraDTO>> getAllPrajituri() {
        List<PrajituraDTO> prajituraDTOList = prajituraService.getAllPrajituri();
        return ResponseEntity.ok(prajituraDTOList);
    }

    @PostMapping
    public ResponseEntity<PrajituraDTO> addPrajitura(@RequestBody PrajituraDTO dto) {
        PrajituraDTO created = prajituraService.addPrajitura(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrajituraDTO> updatePrajitura(@PathVariable int id, @RequestBody PrajituraDTO dto) {
        PrajituraDTO updated = prajituraService.updatePrajitura(id, dto);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrajitura(@PathVariable int id) {
        boolean deleted = prajituraService.deletePrajitura(id);
        if (!deleted) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}