package br.com.desafio_backend_cezarmarcal.crud_plantas.controller;

import br.com.desafio_backend_cezarmarcal.crud_plantas.dto.PlantaDTO;
import br.com.desafio_backend_cezarmarcal.crud_plantas.model.Planta;
import br.com.desafio_backend_cezarmarcal.crud_plantas.service.PlantaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/plantas")
public class PlantaController {

    private final PlantaService plantaService;

    @Autowired
    public PlantaController(PlantaService plantaService) {
        this.plantaService = plantaService;
    }

    @PostMapping
    public ResponseEntity<Planta> criarPlanta(@RequestBody PlantaDTO plantaDTO) {
        Planta planta = plantaService.salvarPlanta(plantaDTO);
        return new ResponseEntity<>(planta, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Planta>> listarPlantas() {
        List<Planta> plantas = plantaService.listarPlantas();
        return new ResponseEntity<>(plantas, HttpStatus.OK);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Planta> buscarPlanta(@PathVariable Long codigo) {
        Optional<Planta> planta = plantaService.buscarPlantaPorCodigo(codigo);
        return planta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Planta> atualizarPlanta(@PathVariable Long codigo, @RequestBody PlantaDTO plantaDTO) {
        Planta plantaAtualizada = plantaService.atualizarPlanta(codigo, plantaDTO);
        return plantaAtualizada != null ? ResponseEntity.ok(plantaAtualizada) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deletarPlanta(@PathVariable Long codigo) {
        plantaService.deletarPlanta(codigo);
        return ResponseEntity.noContent().build();
    }
}