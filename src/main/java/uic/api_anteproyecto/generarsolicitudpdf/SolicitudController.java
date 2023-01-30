package uic.api_anteproyecto.generarsolicitudpdf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Controlador de la solicitud")
@RestController
@RequestMapping("api/solicitud")
@CrossOrigin({"*"})
public class SolicitudController {
    @Autowired SolicitudService solicitudService;

    @Operation(summary = "Obtiene todos los productos registrados en este microservicio")
    @GetMapping("/")
    public List<Solicitud> findAll(){
        return solicitudService.findAll();
    }

    @GetMapping("/{id}/")
    public Solicitud findById(@PathVariable Long id){
        return solicitudService.findById(id);
    }

    @PostMapping("/")
    public Solicitud save(@RequestBody Solicitud entity){
        return solicitudService.save(entity);
    }

    @PutMapping("/{id}/")
    public Solicitud update(@RequestBody Solicitud entity){
        return solicitudService.save(entity);
    }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id){
        solicitudService.deleteById(id);
    }
}
