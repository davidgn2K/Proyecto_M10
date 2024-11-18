package unam.dgtic.modulo10.proyecto.service;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unam.dgtic.modulo10.proyecto.dto.EmpresaDto;
import unam.dgtic.modulo10.proyecto.model.Empresa; 
import unam.dgtic.modulo10.proyecto.repository.EmpresaRepository;
import unam.dgtic.modulo10.proyecto.repository.SectorRepository;

@Service
public class EmpresaDtoServiceImpl implements EmpresaDtoService{
    @Autowired
    EmpresaRepository empresaRepository;

    @Autowired
    SectorRepository sectorRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public EmpresaDto createEmpresa(EmpresaDto empresa) throws ParseException {
        return convertToDto(empresaRepository.save(convertToEntity(empresa)));
    }

    @Override
    public List<EmpresaDto> getEmpresas() {
        List<EmpresaDto> res = new LinkedList<>();
        empresaRepository.findAll().forEach(e -> res.add(convertToDto(e)));
        return res;
    }

    @Override
    public Optional<EmpresaDto> getEmpresaById(Integer idEmpresa) {
        Optional<Empresa> empresa = empresaRepository.findById(idEmpresa);
        if (empresa.isPresent()) return Optional.of(convertToDto(empresa.get()));
        return Optional.empty();
    }

    @Override
    public EmpresaDto updateEmpresa(EmpresaDto empresa) throws ParseException {
        Optional<Empresa> empOpt = empresaRepository.findById(empresa.getIdEmpresa());
        if (empOpt.isPresent()) return convertToDto(empresaRepository.save(convertToEntity(empresa)));
        return null;
    }

    @Override
    public boolean deleteEmpresa(Integer idEmpresa) {
        Optional<Empresa> empresa = empresaRepository.findById(idEmpresa);
        if (empresa.isPresent()) {
            empresaRepository.deleteById(idEmpresa);
            return true;
        }
        return false;
    }

    private EmpresaDto convertToDto(Empresa empresa) {
        EmpresaDto empresaDto = modelMapper.map(empresa, EmpresaDto.class);
        empresaDto.setIdEmpresa(empresa.getIdEmpresa());
        if (empresa.getNombre() != null) empresaDto.setNombre(empresa.getNombre());
        if (empresa.getNumEmpleados() != null && empresa.getNumEmpleados() >= 0) empresaDto.setNumEmpleados(empresa.getNumEmpleados());
        if (empresa.getSector() != null) empresaDto.setSector(empresa.getSector().getDescripcion());
        if (empresa.getSitioWeb() != null) empresaDto.setSitioWeb(empresa.getSitioWeb());
        return empresaDto;
    }

    private Empresa convertToEntity(EmpresaDto empresaDto) throws ParseException{
        Empresa empresa = modelMapper.map(empresaDto, Empresa.class);
        empresa.setIdEmpresa(empresaDto.getIdEmpresa());
        if (empresaDto.getNombre() != null) empresa.setNombre(empresaDto.getNombre());
        if (empresaDto.getNumEmpleados() != null && empresaDto.getNumEmpleados() >= 0) empresa.setNumEmpleados(empresaDto.getNumEmpleados());
        if (empresaDto.getSector() != null) empresa.setSector(sectorRepository.findByDescripcion(empresaDto.getSector()).get(0));
        if (empresaDto.getSitioWeb() != null) empresa.setSitioWeb(empresaDto.getSitioWeb());
        return empresa;
    }
}
