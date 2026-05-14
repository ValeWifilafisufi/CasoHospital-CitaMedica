package CasoHospital.Cita_medica.webclient;

public class BonoClient {

    private final WebClient webClient;

    public BonoClient(@Value("${bono-service.url}") String bonoUrl) {
        this.webClient = WebClient.builder()
                .baseUrl(bonoUrl)
                .build();
    }

    public Map<String, Object> obtenerBono(Long folio) {
        return webClient.get()
                .uri("/{folio}", folio)
                .retrieve()
                .bodyToMono(Map.class)
                .block();
    }
}
