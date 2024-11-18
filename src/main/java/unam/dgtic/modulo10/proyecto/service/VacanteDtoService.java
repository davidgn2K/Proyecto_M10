package unam.dgtic.modulo10.proyecto.service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import unam.dgtic.modulo10.proyecto.dto.VacanteDto;

public interface VacanteDtoService {
    public VacanteDto createVacante(VacanteDto vacante) throws ParseException;
    public VacanteDto updateVacante(VacanteDto vacante) throws ParseException;
    public List<VacanteDto> getVacantes();
    public Optional<VacanteDto> getVacanteById(Integer idVacante);
    public boolean deleteVacante(Integer idVacante);
}
