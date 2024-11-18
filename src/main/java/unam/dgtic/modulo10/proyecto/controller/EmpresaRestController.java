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

import unam.dgtic.modulo10.proyecto.dto.EmpresaDto;
import unam.dgtic.modulo10.proyecto.service.EmpresaDtoService;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaRestController {
    @Autowired
    EmpresaDtoService empresaDtoService;

    @PostMapping(path = "/")
    public ResponseEntity<EmpresaDto> createEmpresaDto(@RequestBody EmpresaDto EmpresaDto) throws ParseException {
        if (empresaDtoService.getEmpresaById(EmpresaDto.getIdEmpresa()).isEmpty()) {
            return ResponseEntity.ok(empresaDtoService.createEmpresa(EmpresaDto));
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/")
    public ResponseEntity<List<EmpresaDto>> getAllDto() {
        return new ResponseEntity<>(empresaDtoService.getEmpresas(), HttpStatusCode.valueOf(200));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<EmpresaDto> getDtoById(@PathVariable int id) {
        Optional<EmpresaDto> EmpresaDto = empresaDtoService.getEmpresaById(id);
        if (EmpresaDto.isPresent()) return ResponseEntity.ok(EmpresaDto.get());
        return ResponseEntity.notFound().build();
    }
    
    @PutMapping(path = "/{id}")
    public ResponseEntity<EmpresaDto> modificarEmpresa(@PathVariable int id, @RequestBody EmpresaDto EmpresaDto) throws ParseException{
        EmpresaDto.setIdEmpresa(id);
        EmpresaDto est = empresaDtoService.updateEmpresa(EmpresaDto);
        if (est != null) return ResponseEntity.of(empresaDtoService.getEmpresaById(id));
        empresaDtoService.createEmpresa(EmpresaDto);
        return new ResponseEntity<>(empresaDtoService.getEmpresaById(id).get(), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> eliminarEmpresa (@PathVariable int id) {
        return (empresaDtoService.deleteEmpresa(id))?ResponseEntity.ok().build():ResponseEntity.notFound().build();
    }
}
