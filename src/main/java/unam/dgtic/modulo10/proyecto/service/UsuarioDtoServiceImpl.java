package unam.dgtic.modulo10.proyecto.service;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unam.dgtic.modulo10.proyecto.dto.UsuarioDto;
import unam.dgtic.modulo10.proyecto.model.Usuario;
import unam.dgtic.modulo10.proyecto.repository.CiudadRepository;
import unam.dgtic.modulo10.proyecto.repository.UsuarioRepository;

@Service
public class UsuarioDtoServiceImpl implements UsuarioDtoService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    CiudadRepository ciudadRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public UsuarioDto createUsuario(UsuarioDto usuario) throws ParseException {
        return convertToDto(usuarioRepository.save(convertToEntity(usuario)));
    }

    @Override
    public List<UsuarioDto> getUsuarios() {
        List<UsuarioDto> res = new LinkedList<>();
        usuarioRepository.findAll().forEach(u -> res.add(convertToDto(u)));
        return res;
    }

    @Override
    public Optional<UsuarioDto> getUsuarioById(Integer idUsuario) {
        Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
        if (usuario.isPresent()) return Optional.of(convertToDto(usuario.get()));
        return Optional.empty();
    }

    @Override
    public UsuarioDto updateUsuario(UsuarioDto usuario) throws ParseException {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(usuario.getId());
        if (usuarioOpt.isPresent()) return convertToDto(usuarioRepository.save(convertToEntity(usuario)));
        return null;
    }

    @Override
    public boolean deleteUsuario(Integer idUsuario) {
        Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
        if (usuario.isPresent()) {
            usuarioRepository.deleteById(idUsuario);
            return true;
        }
        return false;
    }

    private UsuarioDto convertToDto(Usuario usuario) {
        UsuarioDto usuarioDto = modelMapper.map(usuario, UsuarioDto.class);
        usuarioDto.setId(usuario.getId());
        if (usuario.getApMaterno() != null) usuarioDto.setApMaterno(usuario.getApMaterno());
        if (usuario.getApPaterno() != null) usuarioDto.setApPaterno(usuario.getApPaterno());
        if (usuario.getCiudad() != null) usuarioDto.setCiudad(usuario.getCiudad().getDescripcion());
        if (usuario.getContrasena() != null) usuarioDto.setContrasena(usuario.getContrasena());
        if (usuario.getEdad() > 0) usuarioDto.setEdad(usuario.getEdad());
        if (usuario.getEmail() != null) usuarioDto.setEmail(usuario.getEmail());
        usuarioDto.setGenero(usuario.getGenero());
        if (usuario.getNombre() != null) usuarioDto.setNombre(usuario.getNombre());
        return usuarioDto;
    }

    private Usuario convertToEntity(UsuarioDto usuarioDto) throws ParseException {
        Usuario usuario = modelMapper.map(usuarioDto, Usuario.class);
        usuario.setId(usuarioDto.getId());
        if (usuarioDto.getApMaterno() != null) usuario.setApMaterno(usuarioDto.getApMaterno());
        if (usuarioDto.getApPaterno() != null) usuario.setApPaterno(usuarioDto.getApPaterno());
        if (usuarioDto.getCiudad() != null) usuario.setCiudad(ciudadRepository.findByDescripcion(usuarioDto.getCiudad()).get(0));
        if (usuarioDto.getContrasena() != null) usuario.setContrasena(usuarioDto.getContrasena());
        if (usuarioDto.getEdad() > 0) usuario.setEdad(usuarioDto.getEdad());
        if (usuarioDto.getEmail() != null) usuario.setEmail(usuarioDto.getEmail());
        usuario.setGenero(usuarioDto.getGenero());
        if (usuarioDto.getNombre() != null) usuario.setNombre(usuarioDto.getNombre());
        return usuario;
    }
}
