package unam.dgtic.modulo10.proyecto.repository;

import org.springframework.data.repository.CrudRepository;

import unam.dgtic.modulo10.proyecto.model.Ciudad;
import java.util.List;


public interface CiudadRepository extends CrudRepository<Ciudad, Integer> {
    List<Ciudad> findByDescripcion(String descripcion);
}
