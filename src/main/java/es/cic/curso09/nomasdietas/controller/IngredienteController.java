package es.cic.curso09.nomasdietas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cic.curso09.nomasdietas.model.Ingrediente;
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
    public ResponseEntity<Ingrediente> getProgramaById(@PathVariable Long id) {
        Optional<Ingrediente> programa = ingredienteService.getIngredienteById(id);
        return programa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
