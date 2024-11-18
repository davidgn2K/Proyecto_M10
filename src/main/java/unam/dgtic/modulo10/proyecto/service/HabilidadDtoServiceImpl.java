package unam.dgtic.modulo10.proyecto.service;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unam.dgtic.modulo10.proyecto.dto.HabilidadDto;
import unam.dgtic.modulo10.proyecto.model.Habilidad;
import unam.dgtic.modulo10.proyecto.repository.HabilidadRepository;

@Service
public class HabilidadDtoServiceImpl implements HabilidadDtoService {
    @Autowired
    HabilidadRepository habilidadRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public HabilidadDto createHabilidad(HabilidadDto habilidad) throws ParseException {
        return convertToDto(habilidadRepository.save(convertToEntity(habilidad)));
    }

    @Override
    public List<HabilidadDto> getHabilidades() {
        List<HabilidadDto> res = new LinkedList<>();
        habilidadRepository.findAll().forEach(h -> res.add(convertToDto(h)));
        return res;
    }

    @Override
    public Optional<HabilidadDto> getHabilidadById(Integer idHabilidad) {
        Optional<Habilidad> habOpt = habilidadRepository.findById(idHabilidad);
        if (habOpt.isPresent()) return Optional.of(convertToDto(habOpt.get()));
        return Optional.empty();
    }

    @Override
    public HabilidadDto updateHabilidad(HabilidadDto habilidad) throws ParseException {
        Optional<Habilidad> habOpt = habilidadRepository.findById(habilidad.getId());
        if (habOpt.isPresent()) return convertToDto(habilidadRepository.save(convertToEntity(habilidad)));
        return null;
    }

    @Override
    public boolean deleteHabilidad(Integer idHabilidad) {
        Optional<Habilidad> habilidad = habilidadRepository.findById(idHabilidad);
        if (habilidad.isPresent()) {
            habilidadRepository.deleteById(idHabilidad);
            return true;
        }
        return false;
    }

    private HabilidadDto convertToDto(Habilidad habilidad) {
        HabilidadDto habilidadDto = modelMapper.map(habilidad, HabilidadDto.class);
        habilidadDto.setId(habilidad.getId());
        if (habilidad.getDescripcion() != null) habilidadDto.setDescripcion(habilidad.getDescripcion());
        return habilidadDto;
    }

    private Habilidad convertToEntity(HabilidadDto habilidadDto) throws ParseException {
        Habilidad habilidad = modelMapper.map(habilidadDto, Habilidad.class);
        habilidad.setId(habilidadDto.getId());
        if (habilidadDto.getDescripcion() != null) habilidad.setDescripcion(habilidadDto.getDescripcion());
        return habilidad;
    }
}
