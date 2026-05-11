package CasoHospital.Cita_medica.controller;

import CasoHospital.Cita_medica.dto.CitaMedicaResponseDto;
import CasoHospital.Cita_medica.model.CitaMedica;
import CasoHospital.Cita_medica.service.CitaMedicaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/citaMedica")
@RequiredArgsConstructor

public class CitaMedicaController {
    private final CitaMedicaService citaMedicaService;

    @GetMapping
    public ResponseEntity<List<CitaMedicaResponseDto>> obtenerTodas(){
        return ResponseEntity.ok(citaMedicaService.obtenerTodas());
    }

    @GetMapping("/cita/{}")
    public ResponseEntity<CitaMedicaResponseDto> buscarPorNroCita(@PathVariable Long nro){
        return citaMedicaService.buscarPorNroCita(nro).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/folio/{folio}")
    public ResponseEntity<List<CitaMedicaResponseDto>> buscarPorFolio(@PathVariable Long folio){
        return ResponseEntity.ok(citaMedicaService.buscarPorFolio(folio));
    }

    @GetMapping("/registro/{num}")
    public ResponseEntity<List<CitaMedicaResponseDto>> buscarPorRegistro(@PathVariable Long num){
        return ResponseEntity.ok(citaMedicaService.buscarPorNumRegistro(num));
    }

    @GetMapping("/run/{num}")
    public ResponseEntity<List<CitaMedicaResponseDto>> buscarPorNum(@PathVariable Long num){
        return ResponseEntity.ok(citaMedicaService.buscarNumRum(num));
    }
    @GetMapping("/hora/{hora}")
    public ResponseEntity<List<CitaMedicaResponseDto>> buscarPorFecha(@PathVariable LocalDate date){
        return ResponseEntity.ok(citaMedicaService.buscarPorCita(date));
    }

    @PostMapping("/{run}")
    public ResponseEntity<CitaMedicaResponseDto> crear(@Valid @RequestBody CitaMedica cita){
        CitaMedicaResponseDto dto = citaMedicaService.guardar(cita);
        return ResponseEntity.status(201).body(dto);
    }

    @PutMapping("{nro}")
    public ResponseEntity<CitaMedicaResponseDto> actualizar(@PathVariable Long nro,
                                                            @Valid @RequestBody CitaMedicaResponseDto cita){
        return citaMedicaService.actualizar(nro, cita).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{nro}")
    public ResponseEntity<Void> 
}
