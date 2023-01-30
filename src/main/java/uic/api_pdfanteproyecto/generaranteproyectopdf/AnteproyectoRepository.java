package uic.api_pdfanteproyecto.generaranteproyectopdf;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface AnteproyectoRepository extends CrudRepository<Anteproyecto, Long>{

    List<Anteproyecto> findAll();

}