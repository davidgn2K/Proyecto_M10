package unam.dgtic.modulo10.proyecto.service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import unam.dgtic.modulo10.proyecto.dto.HabilidadDto;

public interface HabilidadDtoService {
    public HabilidadDto createHabilidad(HabilidadDto habilidad) throws ParseException;
    public HabilidadDto updateHabilidad(HabilidadDto habilidad) throws ParseException;
    public List<HabilidadDto> getHabilidades();
    public Optional<HabilidadDto> getHabilidadById(Integer idHabilidad);
    public boolean deleteHabilidad(Integer idHabilidad);
}