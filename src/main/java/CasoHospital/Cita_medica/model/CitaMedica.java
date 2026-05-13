package CasoHospital.Cita_medica.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cita_medica")

public class CitaMedica {

    @Id
    private Long numCita;

    @Column(name = "folio_bono", nullable = false)
    private Long folioBono;

    @Column(name = "num_registro_medico", nullable = false)
    private Long numRegistro;

    @Column(name = "num_run", nullable = false)
    private String numRun;

    @Column(nullable = false)
    private LocalDate fechaCita;

    @Column(nullable = false)
    private LocalTime horaCita;

    @Column(nullable = false)
    private String estadoCita;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valorCita;
}
