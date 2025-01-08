package br.com.desafio_backend_cezarmarcal.crud_plantas;

import br.com.desafio_backend_cezarmarcal.crud_plantas.dto.PlantaDTO;
import br.com.desafio_backend_cezarmarcal.crud_plantas.model.Planta;
import br.com.desafio_backend_cezarmarcal.crud_plantas.repository.PlantaRepository;
import br.com.desafio_backend_cezarmarcal.crud_plantas.service.PlantaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;
import java.util.List;
import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
public class PlantaServiceTest {

    @Mock
    private PlantaRepository plantaRepository;

    @InjectMocks
    private PlantaService plantaService;

    private PlantaDTO plantaDTO;
    private Planta planta;

    @BeforeEach
    public void setup() {
        plantaDTO = new PlantaDTO("Planta Mock");
        planta = new Planta("Planta de Exemplo");
    }

    @Test
    public void testSalvarPlanta() {
        when(plantaRepository.save(any(Planta.class))).thenReturn(planta);

        Planta resultado = plantaService.salvarPlanta(plantaDTO);

        assertNotNull(resultado);
        assertEquals("Planta de Exemplo", resultado.getDescricao());
        verify(plantaRepository, times(1)).save(any(Planta.class));
    }

    @Test
    public void testListarPlantas() {
        when(plantaRepository.findAll()).thenReturn(Arrays.asList(planta));

        List<Planta> plantas = plantaService.listarPlantas();

        assertNotNull(plantas);
        assertEquals(1, plantas.size());
        assertEquals("Planta de Exemplo", plantas.get(0).getDescricao());
        verify(plantaRepository, times(1)).findAll();
    }

    @Test
    public void testBuscarPlantaPorCodigo() {
        when(plantaRepository.findById(1L)).thenReturn(Optional.of(planta));

        Optional<Planta> resultado = plantaService.buscarPlantaPorCodigo(1L);

        assertTrue(resultado.isPresent());
        assertEquals("Planta de Exemplo", resultado.get().getDescricao());
        verify(plantaRepository, times(1)).findById(1L);
    }

    @Test
    public void testBuscarPlantaPorCodigoNaoEncontrada() {
        when(plantaRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<Planta> resultado = plantaService.buscarPlantaPorCodigo(1L);

        assertFalse(resultado.isPresent());
        verify(plantaRepository, times(1)).findById(1L);
    }

    @Test
    public void testAtualizarPlanta() {
        Planta plantaExistente = new Planta("Planta Antiga Mock");
        plantaExistente.setCodigo(1L);

        PlantaDTO plantaDTOAtualizada = new PlantaDTO("Planta Atualizada Mock");

        when(plantaRepository.findById(1L)).thenReturn(Optional.of(plantaExistente));
        when(plantaRepository.save(any(Planta.class))).thenReturn(plantaExistente);

        Planta resultado = plantaService.atualizarPlanta(1L, plantaDTOAtualizada);

        assertNotNull(resultado);
        assertEquals("Planta Atualizada Mock", resultado.getDescricao());
        verify(plantaRepository, times(1)).findById(1L);
        verify(plantaRepository, times(1)).save(any(Planta.class));
    }

    @Test
    public void testDeletarPlanta() {
        Long codigoPlanta = 1L;

        doNothing().when(plantaRepository).deleteById(codigoPlanta);

        plantaService.deletarPlanta(codigoPlanta);

        verify(plantaRepository, times(1)).deleteById(codigoPlanta);
    }
}
