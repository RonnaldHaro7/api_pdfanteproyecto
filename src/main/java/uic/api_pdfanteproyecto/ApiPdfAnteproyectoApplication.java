package uic.api_pdfanteproyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ApiPdfAnteproyectoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiPdfAnteproyectoApplication.class, args);
	}

}
