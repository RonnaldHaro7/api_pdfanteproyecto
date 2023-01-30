package uic.api_anteproyecto.estudiante;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "bff.customer", url = "http://localhost:8000/api/estudiante")
public interface CustomerEstudient {

    @GetMapping("/{id}/")
    CustomerDTO findCustomerById(@PathVariable("id") Long id);
}