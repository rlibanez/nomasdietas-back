package es.cic.curso09.nomasdietas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import es.cic.curso09.nomasdietas.model.Plato;
import es.cic.curso09.nomasdietas.repository.PlatoRepository;
import es.cic.curso09.nomasdietas.service.PlatoService;

@ExtendWith(MockitoExtension.class)
public class PlatoServiceTest {

    @Mock
    private PlatoRepository platoRepository;

    @InjectMocks
    private PlatoService platoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllPlatos() {
        Plato plato1 = new Plato();
        plato1.setNombre("Plato 1");

        Plato plato2 = new Plato();
        plato2.setNombre("Plato 2");

        List<Plato> platos = Arrays.asList(plato1, plato2);

        when(platoRepository.findAll()).thenReturn(platos);

        List<Plato> result = platoService.getAllPlatos();

        assertEquals(2, result.size());
        assertEquals("Plato 1", result.get(0).getNombre());
        assertEquals("Plato 2", result.get(1).getNombre());
        verify(platoRepository, times(1)).findAll();
    }

    @Test
    public void testGetPlatoById() {
        Plato plato = new Plato();
        plato.setNombre("Plato 3");

        when(platoRepository.findById(anyLong())).thenReturn(Optional.of(plato));

        Optional<Plato> result = platoService.getPlatoById(1L);

        assertTrue(result.isPresent());
        assertEquals("Plato 3", result.get().getNombre());
        verify(platoRepository, times(1)).findById(1L);
    }

    @Test
    public void testSavePlato() {
        Plato plato = new Plato();
        plato.setNombre("Plato guardado");

        when(platoRepository.save(any(Plato.class))).thenReturn(plato);

        Plato savedPlato = platoService.savePlato(plato);

        assertNotNull(savedPlato);
        assertEquals("Plato guardado", savedPlato.getNombre());
        verify(platoRepository, times(1)).save(plato);
    }

    @Test
    public void testDeletePlato() {
        doNothing().when(platoRepository).deleteById(anyLong());

        platoService.deletePlato(1L);

        verify(platoRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testUpdatePlato() {
        Plato plato = new Plato();
        plato.setNombre("Plato actualizado");

        when(platoRepository.save(any(Plato.class))).thenReturn(plato);

        Plato updatedPlato = platoService.updatePlato(plato);

        assertNotNull(updatedPlato);
        assertEquals("Plato actualizado", updatedPlato.getNombre());
        verify(platoRepository, times(1)).save(plato);
    }

}
