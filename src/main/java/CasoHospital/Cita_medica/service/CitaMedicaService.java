package CasoHospital.Cita_medica.service;

import CasoHospital.Cita_medica.dto.CitaMedicaRequestDto;
import CasoHospital.Cita_medica.dto.CitaMedicaResponseDto;
import CasoHospital.Cita_medica.model.CitaMedica;
import CasoHospital.Cita_medica.repository.CitaMedicaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class CitaMedicaService {

    private final CitaMedicaRepository citaMedicaRepository;
    private final PacienteClient pacienteClient;
    private final StaffClient staffClient;
    private final BonoClient bonoClient;

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
    public CitaMedicaResponseDto guardar(CitaMedicaRequestDto dto) {

        // VALIDAR PACIENTE
        Map<String, Object> paciente =
                pacienteClient.obtenerPaciente(dto.getNum_run());
        if (paciente == null) {
            throw new RuntimeException("Paciente no encontrado");
        }
        // VALIDAR MEDICO
        Map<String, Object> staff = staffClient.obtenerStaff(dto.getNum_registro());
        if (staff == null) {
            throw new RuntimeException("Medico no encontrado");
        }
        // VALIDAR BONO
        Map<String, Object> bono = bonoClient.obtenerBono(dto.getFolio_bono());

        if (bono == null) {
            throw new RuntimeException("Bono no encontrado");
        }

        // CREAR CITA
        CitaMedica nuevaCita = new CitaMedica();

        nuevaCita.setFolioBono(dto.getFolio_bono());
        nuevaCita.setNumRegistro(dto.getNum_registro());
        nuevaCita.setNumRun(dto.getNum_run());
        nuevaCita.setFechaCita(dto.getFechaCita());
        nuevaCita.setHoraCita(dto.getHoraCita());

        // valores automáticos
        nuevaCita.setEstadoCita("PENDIENTE");
        nuevaCita.setValorCita(new BigDecimal("25000"));

        CitaMedica citaGuardada =
                citaMedicaRepository.save(nuevaCita);

        return mapToDto(citaGuardada);
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
