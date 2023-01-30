package uic.api_anteproyecto.generarsolicitudpdf;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
    
@Service
public class SolicitudService {
    @Autowired SolicitudRepository solicitudRepository;

    public Solicitud save(Solicitud entity){
        return solicitudRepository.save(entity);
    }

    public Solicitud findById( Long id){
        return solicitudRepository.findById(id).orElse(new Solicitud());
    }

    public void deleteById(Long id){
        solicitudRepository.deleteById(id);
    }

    public List<Solicitud> findAll(){
        return solicitudRepository.findAll();
    }
}