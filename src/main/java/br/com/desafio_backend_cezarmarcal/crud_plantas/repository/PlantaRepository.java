package br.com.desafio_backend_cezarmarcal.crud_plantas.repository;

import br.com.desafio_backend_cezarmarcal.crud_plantas.model.Planta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantaRepository extends JpaRepository<Planta, Long> {
}