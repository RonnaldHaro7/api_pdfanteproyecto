package uic.api_anteproyecto.generarsolicitudpdf;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface SolicitudRepository extends CrudRepository<Solicitud, Long>{

    List<Solicitud> findAll();

}