package es.cic.curso09.nomasdietas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cic.curso09.nomasdietas.model.Ingrediente;
import es.cic.curso09.nomasdietas.model.Plato;
import es.cic.curso09.nomasdietas.repository.IngredienteRepository;

@Service
public class IngredienteService {

    @Autowired
    IngredienteRepository ingredienteRepository;

    public Ingrediente saveIngrediente(Ingrediente ingrediente) {
        return ingredienteRepository.save(ingrediente);
    }

    public List<Ingrediente> getAllIngredientes() {
        return ingredienteRepository.findAll();
    }

    public Optional<Ingrediente> getIngredienteById(Long id) {
        return ingredienteRepository.findById(id);
    }

    public List<Plato> getAllPlatosByIngrediente(Ingrediente ingrediente) {
        return ingrediente.getPlatos();
    }

    public void deleteIngrediente(Long id) {
        ingredienteRepository.deleteById(id);
    }

    public Ingrediente updateIngrediente(Ingrediente ingrediente) {
        return ingredienteRepository.save(ingrediente);
    }

}
