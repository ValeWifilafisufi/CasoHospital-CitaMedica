package CasoHospital.Cita_medica.dto;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class CitaMedicaResponseDto {

    private Long num_cita;
    private Long folio_bono;
    private Long num_registro;
    private Long num_run;
    private LocalDate fechaCita;
    private LocalTime horaCita;
    private String estadoCita;
    private BigDecimal valorCita;
}
