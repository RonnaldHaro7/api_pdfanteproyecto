package uic.api_anteproyecto.estudiante;

import lombok.Data;

@Data
public class CustomerDTO {
    private Long id;
    private String name;
    private String nro_identificacion;
    private String email;
    private String cellphone;
    private String career;
}