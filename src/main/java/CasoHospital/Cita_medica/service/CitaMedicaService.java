package CasoHospital.Cita_medica.service;

import CasoHospital.Cita_medica.dto.CitaMedicaResponseDto;
import CasoHospital.Cita_medica.model.CitaMedica;
import CasoHospital.Cita_medica.repository.CitaMedicaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class CitaMedicaService {

    private final CitaMedicaRepository citaMedicaRepository;

    private CitaMedicaResponseDto mapToDto(CitaMedica cita){
        return new CitaMedicaResponseDto(
                cita.getNumCita(),
                cita.getFolioBono(),
                cita.getNumRegistro(),
                cita.getNumRun(),
                cita.getFechaCita(),
                cita.getHoraCita(),
                cita.getEstadoCita(),
                cita.getValorCita()
        );
    }

    public List<CitaMedicaResponseDto> obtenerTodas(){
        return citaMedicaRepository.findAll().stream()
                .map(this::mapToDto).collect(Collectors.toList());
    }

    public Optional<CitaMedicaResponseDto> buscarPorNroCita(Long nro){
        return citaMedicaRepository.findById(nro).map(this::mapToDto);
    }

    //guardar
    public CitaMedicaResponseDto guardar(CitaMedica cita){
        CitaMedica citanueva = citaMedicaRepository.save(cita);
        return mapToDto(citanueva);
    }

    //Actualizar
    public Optional<CitaMedica> actualizar(Long nro, CitaMedica cita){
        return citaMedicaRepository.findById(nro).map(existente ->
                {existente.setFechaCita(cita.getFechaCita());
                existente.setHoraCita(cita.getHoraCita());
                existente.setEstadoCita(cita.getEstadoCita());
                existente.setValorCita(cita.getValorCita());

                return citaMedicaRepository.save(existente);
                });
     }

    //Eliminar
    public void eliminar(Long nro){citaMedicaRepository.deleteById(nro);}

    //Busqueda personalizada
    public List<CitaMedicaResponseDto> buscarPorFolio(Long folio){
        return citaMedicaRepository.findByFolioBono(folio)
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public List<CitaMedicaResponseDto> buscarPorNumRegistro(Long nro){
        return citaMedicaRepository.findByNumRegistro(nro)
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public List<CitaMedicaResponseDto> buscarNumRum(String run){
        return citaMedicaRepository.findByNumRun(run)
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public List<CitaMedicaResponseDto> buscarPorCita(LocalDate fecha){
        return citaMedicaRepository.findByFechaCita(fecha)
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }
}
