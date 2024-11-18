package unam.dgtic.modulo10.proyecto.service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import unam.dgtic.modulo10.proyecto.dto.UsuarioDto;

public interface UsuarioDtoService {
    public UsuarioDto createUsuario(UsuarioDto usuario) throws ParseException;
    public UsuarioDto updateUsuario(UsuarioDto usuario) throws ParseException;
    public List<UsuarioDto> getUsuarios();
    public Optional<UsuarioDto> getUsuarioById(Integer idUsuario);
    public boolean deleteUsuario(Integer idUsuario);
}
