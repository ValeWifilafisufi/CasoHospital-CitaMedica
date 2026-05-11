package CasoHospital.Cita_medica.repository;
import CasoHospital.Cita_medica.dto.CitaMedicaResponseDto;
import CasoHospital.Cita_medica.model.CitaMedica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface CitaMedicaRepository extends JpaRepository<CitaMedica, Long> {

    List<CitaMedicaResponseDto> finByFolioBono(Long folioBono);
    List<CitaMedicaResponseDto> finByNumRegistro (Long numRegistro);
    List<CitaMedicaResponseDto> finByNumRun(Long numRun);
    List<CitaMedicaResponseDto> findByFechaCita(LocalDate fecha);


//    private Long num_cita;
//    private Long folio_bono;
//    private Long num_registro;
//    private Long num_run;
//    private LocalDate fechaCita;
//    private LocalTime horaCita;
//    private String estadoCita;
//    private BigDecimal valorCita;


}
