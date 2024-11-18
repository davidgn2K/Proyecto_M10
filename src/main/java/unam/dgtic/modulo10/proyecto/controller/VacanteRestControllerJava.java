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

import unam.dgtic.modulo10.proyecto.dto.VacanteDto;
import unam.dgtic.modulo10.proyecto.service.VacanteDtoService;

@RestController
@RequestMapping("/api/vacantes")
public class VacanteRestControllerJava {
    @Autowired
    VacanteDtoService VacanteDtoService;

    @PostMapping(path = "/")
    public ResponseEntity<VacanteDto> createVacanteDto(@RequestBody VacanteDto VacanteDto) throws ParseException {
        if (VacanteDtoService.getVacanteById(VacanteDto.getId()).isEmpty()) {
            return ResponseEntity.ok(VacanteDtoService.createVacante(VacanteDto));
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/")
    public ResponseEntity<List<VacanteDto>> getAllDto() {
        return new ResponseEntity<>(VacanteDtoService.getVacantes(), HttpStatusCode.valueOf(200));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<VacanteDto> getDtoById(@PathVariable int id) {
        Optional<VacanteDto> VacanteDto = VacanteDtoService.getVacanteById(id);
        if (VacanteDto.isPresent()) return ResponseEntity.ok(VacanteDto.get());
        return ResponseEntity.notFound().build();
    }
    
    @PutMapping(path = "/{id}")
    public ResponseEntity<VacanteDto> modificarVacante(@PathVariable int id, @RequestBody VacanteDto VacanteDto) throws ParseException{
        VacanteDto.setId(id);
        VacanteDto est = VacanteDtoService.updateVacante(VacanteDto);
        if (est != null) return ResponseEntity.of(VacanteDtoService.getVacanteById(id));
        VacanteDtoService.createVacante(VacanteDto);
        return new ResponseEntity<>(VacanteDtoService.getVacanteById(id).get(), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> eliminarVacante (@PathVariable int id) {
        return (VacanteDtoService.deleteVacante(id))?ResponseEntity.ok().build():ResponseEntity.notFound().build();
    }
}
