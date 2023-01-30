package uic.api_pdfanteproyecto.generaranteproyectopdf;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface AnteproyectoPDFRepository extends CrudRepository<AnteproyectoPDF, Long>{

    List<AnteproyectoPDF> findAll();
}
