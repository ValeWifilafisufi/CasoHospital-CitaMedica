package CasoHospital.Cita_medica.confi;

import CasoHospital.Cita_medica.repository.CitaMedicaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DataInitializer.class);
    private final CitaMedicaRepository citaMedicaRepository;

    @Override
    public void run(String...args){
        if (citaMedicaRepository.count() > 0){
            log.info(">>> DataInitializer: la BD ya tiene datos, se omite la carga inicial.");
            return;
        }
        log.info(">>>DataInitializer: BD vacia detextada, insertando datos de prueba...");
    }


}
