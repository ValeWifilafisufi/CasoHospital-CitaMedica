package CasoHospital.Cita_medica.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class CitaMedicaRequestDto {

    @NotNull(message = "El numero de cita no puede estar vacio")
    @Positive(message = "El numero de cita debe ser mayor a 0")
    private Long num_cita;

    @NotNull(message = "El numero de folio del bono no puede estar vacio")
    @Positive(message = "El numero de folio del bono debe ser mayor a 0")
    private Long folio_bono;

    @NotNull(message = "El numero de registro del medico puede estar vacio")
    @Positive(message = "El numero de registro del medico debe ser mayor a 0")
    private Long num_registro;

    @NotNull(message = "El numero de rut del paciente no puede estar vacio")
    @Positive(message = "El numero de rut del paciente debe ser mayor a 0")
    private Long num_run;

    @NotNull(message = "La fecha de la cita no puede estar vacia")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaCita;

     @NotNull(message = "La hora de la cita no puede estar vacia")
     @JsonFormat(pattern = "HH:mm")
    private LocalTime horaCita;

}
