package CasoHospital.Cita_medica.repository;
import CasoHospital.Cita_medica.dto.CitaMedicaResponseDto;
import CasoHospital.Cita_medica.model.CitaMedica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface CitaMedicaRepository extends JpaRepository<CitaMedica, Long> {

    List<CitaMedica> findByFolioBono(Long folioBono);
    List<CitaMedica> findByNumRegistro (Long numRegistro);
    List<CitaMedica> findByNumRun(String numRun);
    List<CitaMedica> findByFechaCita(LocalDate fecha);

}
