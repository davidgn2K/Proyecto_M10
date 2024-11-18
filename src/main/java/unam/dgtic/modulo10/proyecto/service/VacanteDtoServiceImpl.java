package unam.dgtic.modulo10.proyecto.service;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unam.dgtic.modulo10.proyecto.dto.VacanteDto;
import unam.dgtic.modulo10.proyecto.model.Vacante;
import unam.dgtic.modulo10.proyecto.repository.CiudadRepository;
import unam.dgtic.modulo10.proyecto.repository.EmpresaRepository;
import unam.dgtic.modulo10.proyecto.repository.VacanteRepository;

@Service
public class VacanteDtoServiceImpl implements VacanteDtoService {
    @Autowired
    VacanteRepository vacanteRepository;

    @Autowired
    CiudadRepository ciudadRepository;

    @Autowired
    EmpresaRepository empresaRepository;

    @Autowired
    ModelMapper modelMapper;
    
    @Override
    public VacanteDto createVacante(VacanteDto vacante) throws ParseException {
        return convertToDto(vacanteRepository.save(convertToEntity(vacante)));
    }

    @Override
    public List<VacanteDto> getVacantes() {
        List<VacanteDto> res = new LinkedList<>();
        vacanteRepository.findAll().forEach(v -> res.add(convertToDto(v)));
        return res;
    }

    @Override
    public Optional<VacanteDto> getVacanteById(Integer idVacante) {
        Optional<Vacante> vacante = vacanteRepository.findById(idVacante);
        if (vacante.isPresent()) return Optional.of(convertToDto(vacante.get()));
        return Optional.empty();
    }

    @Override
    public VacanteDto updateVacante(VacanteDto vacante) throws ParseException {
        Optional<Vacante> vacOpt = vacanteRepository.findById(vacante.getId());
        if (vacOpt.isPresent()) return convertToDto(vacanteRepository.save(convertToEntity(vacante)));
        return null;
    }

    @Override
    public boolean deleteVacante(Integer idVacante) {
        Optional<Vacante> vacante = vacanteRepository.findById(idVacante);
        if (vacante.isPresent()) {
            vacanteRepository.deleteById(idVacante);
            return true;
        }
        return false;
    }

    private VacanteDto convertToDto(Vacante vacante) {
        VacanteDto vacanteDto = modelMapper.map(vacante, VacanteDto.class);
        vacanteDto.setId(vacante.getId());
        if (vacante.getCiudad() != null) vacanteDto.setCiudad(vacante.getCiudad().getDescripcion());
        if (vacante.getDescripcion() != null) vacanteDto.setDescripcion(vacante.getDescripcion());
        if (vacante.getTitulo() != null) vacanteDto.setTitulo(vacante.getTitulo());
        if (vacante.getEmpresa() != null) vacanteDto.setEmpresa(vacante.getEmpresa().getNombre());
        return vacanteDto;
    }

    private Vacante convertToEntity(VacanteDto vacanteDto) throws ParseException {
        Vacante vacante = modelMapper.map(vacanteDto, Vacante.class);
        vacante.setId(vacanteDto.getId());
        if (vacanteDto.getCiudad() != null) vacante.setCiudad(ciudadRepository.findByDescripcion(vacanteDto.getCiudad()).get(0));
        if (vacanteDto.getDescripcion() != null) vacante.setDescripcion(vacanteDto.getDescripcion());
        if (vacanteDto.getTitulo() != null) vacante.setTitulo(vacanteDto.getTitulo());
        if (vacanteDto.getEmpresa() != null) vacante.setEmpresa(empresaRepository.findByNombre(vacanteDto.getEmpresa()).get(0));
        return vacante;
    }
}
