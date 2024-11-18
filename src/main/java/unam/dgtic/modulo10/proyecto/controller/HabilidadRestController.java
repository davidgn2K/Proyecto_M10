package unam.dgtic.modulo10.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unam.dgtic.modulo10.proyecto.dto.HabilidadDto;
import unam.dgtic.modulo10.proyecto.service.HabilidadDtoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/habilidades")
public class HabilidadRestController {
    @Autowired
    HabilidadDtoService habilidadDtoService;

    @PostMapping(path = "/")
    public ResponseEntity<HabilidadDto> createHabilidadDto(@RequestBody HabilidadDto habilidadDto) throws ParseException {
        if (habilidadDtoService.getHabilidadById(habilidadDto.getId()).isEmpty()) {
            return ResponseEntity.ok(habilidadDtoService.createHabilidad(habilidadDto));
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/")
    public ResponseEntity<List<HabilidadDto>> getAllDto() {
        return new ResponseEntity<>(habilidadDtoService.getHabilidades(), HttpStatusCode.valueOf(200));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<HabilidadDto> getDtoById(@PathVariable int id) {
        Optional<HabilidadDto> habilidadDto = habilidadDtoService.getHabilidadById(id);
        if (habilidadDto.isPresent()) return ResponseEntity.ok(habilidadDto.get());
        return ResponseEntity.notFound().build();
    }
    
    @PutMapping(path = "/{id}")
    public ResponseEntity<HabilidadDto> modificarHabilidad(@PathVariable int id, @RequestBody HabilidadDto habilidadDto) throws ParseException{
        habilidadDto.setId(id);
        HabilidadDto est = habilidadDtoService.updateHabilidad(habilidadDto);
        if (est != null) return ResponseEntity.of(habilidadDtoService.getHabilidadById(id));
        habilidadDtoService.createHabilidad(habilidadDto);
        return new ResponseEntity<>(habilidadDtoService.getHabilidadById(id).get(), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> eliminarHabilidad (@PathVariable int id) {
        return (habilidadDtoService.deleteHabilidad(id))?ResponseEntity.ok().build():ResponseEntity.notFound().build();
    }
}
