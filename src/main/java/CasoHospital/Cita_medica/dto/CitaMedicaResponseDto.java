package CasoHospital.Cita_medica.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitaMedicaResponseDto {

    private Long numCita;
    private Long folioBono;
    private Long numRegistro;
    private String numRun;
    private LocalDate fechaCita;
    private LocalTime horaCita;
    private String estadoCita;
    private BigDecimal valorCita;
}
