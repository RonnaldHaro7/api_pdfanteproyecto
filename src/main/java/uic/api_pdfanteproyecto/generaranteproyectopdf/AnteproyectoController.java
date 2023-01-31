package uic.api_pdfanteproyecto.generaranteproyectopdf;

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

@Tag(name = "Controlador del anteproyecto")
@RestController
@RequestMapping("api/anteproyecto")
@CrossOrigin({"*"})
public class AnteproyectoController {
    @Autowired AnteproyectoService anteproyectoService;

    @Operation(summary = "Obtiene todos los anteproyectos registrados en este microservicio")
    @GetMapping("/")
    public List<Anteproyecto> findAll(){
        return anteproyectoService.findAll();
    }

    @GetMapping("/{id}/")
    public Anteproyecto findById(@PathVariable Long id){
        return anteproyectoService.findById(id);
    }

    @PostMapping("/")
    public Anteproyecto save(@RequestBody Anteproyecto entity){
        return anteproyectoService.save(entity);
    }

    @PutMapping("/{id}/")
    public Anteproyecto update(@RequestBody Anteproyecto entity){
        return anteproyectoService.save(entity);
    }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id){
        anteproyectoService.deleteById(id);
    }
}
