package uic.api_anteproyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ApiAnteproyectoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiAnteproyectoApplication.class, args);
	}

}
