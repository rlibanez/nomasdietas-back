package es.cic.curso09.nomasdietas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cic.curso09.nomasdietas.model.Plato;
import es.cic.curso09.nomasdietas.service.PlatoService;

@RestController
@RequestMapping("/api/plato")
public class PlatoController {

    @Autowired
    PlatoService platoService;

    @GetMapping
    public ResponseEntity<List<Plato>> getAllPlatos() {
        List<Plato> platos = platoService.getAllPlatos();
        return ResponseEntity.ok(platos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plato> getPlatoById(@PathVariable Long id) {
        Optional<Plato> plato = platoService.getPlatoById(id);
        return plato.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
