package es.cic.curso09.nomasdietas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cic.curso09.nomasdietas.model.Plato;
import es.cic.curso09.nomasdietas.repository.PlatoRepository;

@Service
public class PlatoService {

    @Autowired
    PlatoRepository platoRepository;

    public Plato savePlato(Plato plato) {
        return platoRepository.save(plato);
    }

    public List<Plato> getAllPlatos() {
        return platoRepository.findAll();
    }

    public Optional<Plato> getPlatoById(Long id) {
        return platoRepository.findById(id);
    }

    public void deletePlato(Long id) {
        platoRepository.deleteById(id);
    }

    public Plato updatePlato(Plato plato) {
        return platoRepository.save(plato);
    }

}
