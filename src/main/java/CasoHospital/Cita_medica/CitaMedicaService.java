package CasoHospital.Cita_medica;

import CasoHospital.Cita_medica.dto.CitaMedicaResponseDto;
import CasoHospital.Cita_medica.model.CitaMedica;
import CasoHospital.Cita_medica.repository.CitaMedicaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class CitaMedicaService {

    private final CitaMedicaRepository citaMedicaRepository;

    private CitaMedicaResponseDto mapToDto(CitaMedica cita){
        return new CitaMedicaResponseDto(

        );
    }
}
