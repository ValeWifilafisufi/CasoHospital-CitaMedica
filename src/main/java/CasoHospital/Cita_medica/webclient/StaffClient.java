package CasoHospital.Cita_medica.webclient;

public class StaffClient {

    private final WebClient webClient;

    public StaffClient(@Value("${staff-service.url}") String staffUrl) {
        this.webClient = WebClient.builder()
                .baseUrl(staffUrl)
                .build();
    }

    public Map<String, Object> obtenerStaff(Long numRegistro) {
        return webClient.get()
                .uri("/nro_registro/{id}", numRegistro)
                .retrieve()
                .bodyToMono(Map.class)
                .block();
    }
}
