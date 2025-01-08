package br.com.desafio_backend_cezarmarcal.crud_plantas.service;

import br.com.desafio_backend_cezarmarcal.crud_plantas.dto.PlantaDTO;
import br.com.desafio_backend_cezarmarcal.crud_plantas.model.Planta;
import br.com.desafio_backend_cezarmarcal.crud_plantas.repository.PlantaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlantaService {

    private final PlantaRepository plantaRepository;

    @Autowired
    public PlantaService(PlantaRepository plantaRepository) {
        this.plantaRepository = plantaRepository;
    }

    public Planta salvarPlanta(PlantaDTO plantaDTO) {
        Planta planta = new Planta(plantaDTO.descricao());
        return plantaRepository.save(planta);
    }

    public List<Planta> listarPlantas() {
        return plantaRepository.findAll();
    }

    public Optional<Planta> buscarPlantaPorCodigo(Long codigo) {
        return plantaRepository.findById(codigo);
    }

    public void deletarPlanta(Long codigo) {
        plantaRepository.deleteById(codigo);
    }

    public Planta atualizarPlanta(Long codigo, PlantaDTO plantaDTO) {
        Optional<Planta> plantaExistente = plantaRepository.findById(codigo);
        if (plantaExistente.isPresent()) {
            Planta planta = plantaExistente.get();
            planta.setDescricao(plantaDTO.descricao());
            return plantaRepository.save(planta);
        }

        return null; // Poderia ser lançando uma exceção em um cenário real
    }
}