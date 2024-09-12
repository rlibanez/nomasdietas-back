package es.cic.curso09.nomasdietas;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.cic.curso09.nomasdietas.model.Ingrediente;
import es.cic.curso09.nomasdietas.model.Plato;
import es.cic.curso09.nomasdietas.repository.IngredienteRepository;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext
public class IngredienteControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IngredienteRepository ingredienteRepository;

    @Autowired
    private ObjectMapper objectMapper;
    
    // @Autowired
    // private WebApplicationContext webApplicationContext;

    // @BeforeEach
    // public void setup() {
    //     mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    //     ingredienteRepository.deleteAll(); 
    // }

    @Test
    void testGetAllIngredientes() throws Exception {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNombre("Ingrediente de prueba uno");
        ingredienteRepository.save(ingrediente);

        mockMvc.perform(get("/api/ingrediente"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].nombre").value("Ingrediente de prueba uno"));
    }

    @Test
    void testGetIngredienteById() throws Exception {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNombre("Ingrediente de prueba dos");
        Ingrediente savedIngrediente = ingredienteRepository.save(ingrediente);

        mockMvc.perform(get("/api/ingrediente/" + savedIngrediente.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Ingrediente de prueba dos"));
    }

    @Test
    void testCreateIngrediente() throws Exception {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNombre("Nuevo Ingrediente");

        mockMvc.perform(post("/api/ingrediente")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ingrediente)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNumber()); // createIngrediente devuelve el id del ingrediente creado

        List<Ingrediente> ingredientes = ingredienteRepository.findAll();
        assertThat(ingredientes).hasSize(1);
        assertThat(ingredientes.get(0).getNombre()).isEqualTo("Nuevo Ingrediente");
    }

    @Test
    public void testCreateIngredienteJson() throws Exception {
        String ingredienteJson = "{\"nombre\": \"Arroz\", \"descripcion\": \"Arroz blanco\"}";

        mockMvc.perform(post("/api/ingrediente")
                .contentType(MediaType.APPLICATION_JSON)
                .content(ingredienteJson))
                .andExpect(status().isOk()) 
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isNumber());
    }

    @Test
    void testUpdateIngrediente() throws Exception {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNombre("Ingrediente Antiguo");
        Ingrediente savedIngrediente = ingredienteRepository.save(ingrediente);

        ingrediente.setNombre("Ingrediente Actualizado");

        mockMvc.perform(put("/api/ingrediente")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ingrediente)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Ingrediente Actualizado"));

        Ingrediente fetchedIngrediente = ingredienteRepository.findById(savedIngrediente.getId()).orElseThrow();
        assertThat(fetchedIngrediente.getNombre()).isEqualTo("Ingrediente Actualizado");
    }

    @Test
    void testDeleteIngrediente() throws Exception {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNombre("Ingrediente a eliminar");
        Ingrediente savedIngrediente = ingredienteRepository.save(ingrediente);

        mockMvc.perform(delete("/api/ingrediente/" + savedIngrediente.getId()))
                .andExpect(status().isNoContent());

        assertThat(ingredienteRepository.findById(savedIngrediente.getId())).isEmpty();
    }

    @Test
    void testGetAllPlatosByIngrediente() throws Exception {
        Ingrediente ingrediente = new Ingrediente();

        Plato plato1 = new Plato();
        plato1.setNombre("Plato1 con ingrediente");
        plato1.setIngrediente(ingrediente);

        Plato plato2 = new Plato();
        plato2.setNombre("Plato2 con ingrediente");
        plato2.setIngrediente(ingrediente);

        ingrediente.setNombre("Ingrediente con platos");
        ingrediente.setPlatos(List.of(plato1, plato2));

        Ingrediente savedIngrediente = ingredienteRepository.save(ingrediente);

        mockMvc.perform(get("/api/ingrediente/platos/" + savedIngrediente.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2)); 
    }

}