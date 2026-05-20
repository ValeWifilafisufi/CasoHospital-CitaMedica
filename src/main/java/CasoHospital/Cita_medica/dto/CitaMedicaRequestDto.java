package CasoHospital.Cita_medica.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CitaMedicaRequestDto {

    @NotNull(message = "El numero de folio del bono no puede estar vacio")
    @Positive(message = "El numero de folio del bono debe ser mayor a 0")
    private Long folio_bono;

    @NotNull(message = "El numero de registro del medico puede estar vacio")
    @Positive(message = "El numero de registro del medico debe ser mayor a 0")
    private Long num_registro;

    @NotBlank(message = "El numero de rut del paciente no puede estar vacio")
    @Pattern(
            regexp = "^[0-9]{1,2}\\.[0-9]{3}\\.[0-9]{3}-[0-9kK]$",
            message = "El run debe tener formato 12.345.678-9"
    )
    private String num_run;

    @NotNull(message = "La fecha de la cita no puede estar vacia")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaCita;

     @NotNull(message = "La hora de la cita no puede estar vacia")
     @JsonFormat(pattern = "HH:mm")
    private LocalTime horaCita;

}
