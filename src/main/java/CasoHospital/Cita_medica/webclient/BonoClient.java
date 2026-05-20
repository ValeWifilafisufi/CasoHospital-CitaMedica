package CasoHospital.Cita_medica.webclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.Map;

@Component
public class BonoClient {

    private final WebClient webClient;

    public BonoClient(@Value("${bono-service.url}") String bonoUrl) {
        this.webClient = WebClient.builder()
                .baseUrl(bonoUrl)
                .build();
    }

    public Map<String, Object> obtenerBono(Long folio) {
        return webClient.get()
                .uri("/fono/{folio}", folio)
                .retrieve()
                .bodyToMono(Map.class)
                .block();
    }
}
