package unam.dgtic.modulo10.proyecto.repository;

import org.springframework.data.repository.CrudRepository;

import unam.dgtic.modulo10.proyecto.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
    
}
