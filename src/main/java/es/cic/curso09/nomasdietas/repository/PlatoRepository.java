package es.cic.curso09.nomasdietas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.cic.curso09.nomasdietas.model.Plato;

@Repository
public interface PlatoRepository extends JpaRepository<Plato, Long> {

}
