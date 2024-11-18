package unam.dgtic.modulo10.proyecto.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unam.dgtic.modulo10.proyecto.dto.UsuarioDto;
import unam.dgtic.modulo10.proyecto.service.UsuarioDtoService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioRestController {
    @Autowired
    UsuarioDtoService usuarioDtoService;

    @PostMapping(path = "/")
    public ResponseEntity<UsuarioDto> createUsuarioDto(@RequestBody UsuarioDto UsuarioDto) throws ParseException {
        if (usuarioDtoService.getUsuarioById(UsuarioDto.getId()).isEmpty()) {
            return ResponseEntity.ok(usuarioDtoService.createUsuario(UsuarioDto));
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/")
    public ResponseEntity<List<UsuarioDto>> getAllDto() {
        return new ResponseEntity<>(usuarioDtoService.getUsuarios(), HttpStatusCode.valueOf(200));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UsuarioDto> getDtoById(@PathVariable int id) {
        Optional<UsuarioDto> UsuarioDto = usuarioDtoService.getUsuarioById(id);
        if (UsuarioDto.isPresent()) return ResponseEntity.ok(UsuarioDto.get());
        return ResponseEntity.notFound().build();
    }
    
    @PutMapping(path = "/{id}")
    public ResponseEntity<UsuarioDto> modificarUsuario(@PathVariable int id, @RequestBody UsuarioDto UsuarioDto) throws ParseException{
        UsuarioDto.setId(id);
        UsuarioDto est = usuarioDtoService.updateUsuario(UsuarioDto);
        if (est != null) return ResponseEntity.of(usuarioDtoService.getUsuarioById(id));
        usuarioDtoService.createUsuario(UsuarioDto);
        return new ResponseEntity<>(usuarioDtoService.getUsuarioById(id).get(), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> eliminarUsuario (@PathVariable int id) {
        return (usuarioDtoService.deleteUsuario(id))?ResponseEntity.ok().build():ResponseEntity.notFound().build();
    }
}
