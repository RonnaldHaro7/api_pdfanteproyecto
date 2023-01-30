package uic.api_anteproyecto.generarsolicitudpdf;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface SolicitudPDFRepository extends CrudRepository<SolicitudPDF, Long>{

    List<SolicitudPDF> findAll();
}
