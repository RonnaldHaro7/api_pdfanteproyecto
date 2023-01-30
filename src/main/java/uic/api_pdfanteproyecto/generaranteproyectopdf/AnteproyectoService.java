package uic.api_pdfanteproyecto.generaranteproyectopdf;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
    
@Service
public class AnteproyectoService {
    @Autowired AnteproyectoRepository solicitudRepository;

    public Anteproyecto save(Anteproyecto entity){
        return solicitudRepository.save(entity);
    }

    public Anteproyecto findById( Long id){
        return solicitudRepository.findById(id).orElse(new Anteproyecto());
    }

    public void deleteById(Long id){
        solicitudRepository.deleteById(id);
    }

    public List<Anteproyecto> findAll(){
        return solicitudRepository.findAll();
    }
}