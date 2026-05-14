package CasoHospital.Cita_medica.controller;

import CasoHospital.Cita_medica.dto.CitaMedicaResponseDto;
import CasoHospital.Cita_medica.model.CitaMedica;
import CasoHospital.Cita_medica.service.CitaMedicaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @GetMapping("/cita/{nro}")
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
    public ResponseEntity<List<CitaMedicaResponseDto>> buscarPorNum(@PathVariable String num){
        return ResponseEntity.ok(citaMedicaService.buscarNumRum(num));
    }
    @GetMapping("/fecha/{fecha}")
    public ResponseEntity<List<CitaMedicaResponseDto>> buscarPorFecha(@PathVariable LocalDate fecha){
        return ResponseEntity.ok(citaMedicaService.buscarPorCita(fecha));
    }

    @PostMapping
    public ResponseEntity<CitaMedicaResponseDto> crear(@Valid @RequestBody CitaMedicaRequestDto dto){
        CitaMedicaResponseDto respuesta = citaMedicaService.guardar(dto);
        return ResponseEntity.status(201).body(respuesta);
    }

    @PutMapping("{nro}")
    public ResponseEntity<CitaMedica> actualizar(@PathVariable Long nro,
                                                            @Valid @RequestBody CitaMedica cita){
        return citaMedicaService.actualizar(nro, cita).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{nro}")
    public ResponseEntity<Void> eliminar(@PathVariable Long nro){
        if (citaMedicaService.buscarPorNroCita(nro).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        citaMedicaService.eliminar(nro);
        return ResponseEntity.noContent().build();
    }
}
