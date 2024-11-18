package unam.dgtic.modulo10.proyecto.repository;

import org.springframework.data.repository.CrudRepository;

import unam.dgtic.modulo10.proyecto.model.Sector;
import java.util.List;

public interface SectorRepository extends CrudRepository<Sector, Integer> {
    List<Sector> findByDescripcion(String descripcion);
}
