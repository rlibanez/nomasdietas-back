package es.cic.curso09.nomasdietas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cic.curso09.nomasdietas.model.Ingrediente;
import es.cic.curso09.nomasdietas.model.Plato;
import es.cic.curso09.nomasdietas.service.IngredienteService;

@RestController
@RequestMapping("/api/ingrediente")
public class IngredienteController {

    @Autowired
    IngredienteService ingredienteService;

    @GetMapping
    public ResponseEntity<List<Ingrediente>> getAllIngredientes() {
        List<Ingrediente> ingredientes = ingredienteService.getAllIngredientes();
        return ResponseEntity.ok(ingredientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingrediente> getIngredienteyId(@PathVariable Long id) {
        Optional<Ingrediente> ingrediente = ingredienteService.getIngredienteById(id);
        return ingrediente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/platos/{id}")
    public ResponseEntity<List<Plato>> getAllPlatosByIngrediente(@PathVariable Long id) {
        Optional<Ingrediente> optionalIngrediente = ingredienteService.getIngredienteById(id);
        if (optionalIngrediente.isPresent()) {
            Ingrediente ingrediente = optionalIngrediente.get();
            List<Plato> platos = ingredienteService.getAllPlatosByIngrediente(ingrediente);
            return ResponseEntity.ok(platos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Long> createIngrediente(@RequestBody Ingrediente ingrediente) {
        Ingrediente savedIngrediente = ingredienteService.saveIngrediente(ingrediente);
        return ResponseEntity.ok(savedIngrediente.getId());
    }

    @PutMapping
    public ResponseEntity<Ingrediente> updateIngrediente(@RequestBody Ingrediente newIngrediente) throws Exception {

        Optional<Ingrediente> existingIngrediente = ingredienteService.getIngredienteById(newIngrediente.getId());

        if (existingIngrediente.isPresent()) {
            // Ingrediente programaToUpdate = existingIngrediente.get();
            // ingrediente.setFechaModificacion(LocalDateTime.now());
            // TODO: comprobar fechas de newIngrediente
            return ResponseEntity.ok(ingredienteService.updateIngrediente(newIngrediente));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngrediente(@PathVariable Long id) {

        Optional<Ingrediente> existingIngrediente = ingredienteService.getIngredienteById(id);
        if (existingIngrediente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        ingredienteService.deleteIngrediente(id);
        return ResponseEntity.noContent().build();
    }

}
