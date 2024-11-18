package unam.dgtic.modulo10.proyecto.repository;

import org.springframework.data.repository.CrudRepository;

import unam.dgtic.modulo10.proyecto.model.Empresa;
import java.util.List;


public interface EmpresaRepository extends CrudRepository<Empresa, Integer>{
    List<Empresa> findByNombre(String nombre);
}
