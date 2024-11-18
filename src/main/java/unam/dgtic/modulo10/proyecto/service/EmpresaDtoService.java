package unam.dgtic.modulo10.proyecto.service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import unam.dgtic.modulo10.proyecto.dto.EmpresaDto;

public interface EmpresaDtoService {
    public EmpresaDto createEmpresa(EmpresaDto empresa) throws ParseException;
    public EmpresaDto updateEmpresa(EmpresaDto empresa) throws ParseException;
    public List<EmpresaDto> getEmpresas();
    public Optional<EmpresaDto> getEmpresaById(Integer idEmpresa);
    public boolean deleteEmpresa(Integer idEmpresa);
}
