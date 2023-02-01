package uic.api_pdfanteproyecto.generaranteproyectopdf;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import jakarta.transaction.Transactional;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import uic.api_pdfanteproyecto.estudiante.CustomerDTO;
import uic.api_pdfanteproyecto.estudiante.CustomerEstudient;


@Transactional
@Service
public class AnteproyectoPDFService {
    @Autowired AnteproyectoPDFRepository anteproyectoPDFRepository;
    @Autowired CustomerEstudient customerEstudient;

    @Transactional
    public AnteproyectoPDF save(AnteproyectoPDF entity){
        return anteproyectoPDFRepository.save(entity);
    }

    public AnteproyectoPDF findById( Long id){
        return anteproyectoPDFRepository.findById(id).orElse(new AnteproyectoPDF());
    }

    public void deleteById(Long id){
        anteproyectoPDFRepository.deleteById(id);
    }

    public List<AnteproyectoPDF> findAll(){
        return anteproyectoPDFRepository.findAll();
    }

    public JasperPrint getAnteproyectoPDFReporte(Long id) {

        Map<String, Object> reportParameters = new HashMap<String, Object>();
        AnteproyectoPDF anteproyectoPDF = findById(id);
        if (anteproyectoPDF.getId()==null)
            return null;
        
        reportParameters.put("linea_investigacion", anteproyectoPDF.getLinea_investigacion());
        reportParameters.put("tema", anteproyectoPDF.getTema());
        reportParameters.put("titulo", anteproyectoPDF.getTitulo());
        reportParameters.put("problema", anteproyectoPDF.getProblema());
        reportParameters.put("fecha", anteproyectoPDF.getFecha());
        reportParameters.put("objetivo_g", anteproyectoPDF.getObjetivo_g());
        reportParameters.put("objetivo_s", anteproyectoPDF.getObjetivo_s());
        reportParameters.put("justificacion", anteproyectoPDF.getJustificacion());
        reportParameters.put("alcance", anteproyectoPDF.getAlcance());
        reportParameters.put("m_teorico", anteproyectoPDF.getM_teorico());
        reportParameters.put("m_metodologico", anteproyectoPDF.getM_metodologico());
        reportParameters.put("metodologia", anteproyectoPDF.getMetodologia());
        reportParameters.put("bibliografia", anteproyectoPDF.getBibliografia());
        reportParameters.put("presupuesto", anteproyectoPDF.getPresupuesto());
        
        CustomerDTO estudiante =  customerEstudient.findCustomerById(anteproyectoPDF.getEstudianteId());
        reportParameters.put("name", estudiante.getName());
        reportParameters.put("career", estudiante.getCareer());

        JasperPrint reportJasperPrint = null;
        try {
            reportJasperPrint = JasperFillManager.fillReport(
                    JasperCompileManager.compileReport(
                            ResourceUtils.getFile("classpath:jrxml/pdfanteproyecto.jrxml")
                                    .getAbsolutePath()) // path of the jasper report
                    , reportParameters // dynamic parameters
                    , new JREmptyDataSource());
        } catch (FileNotFoundException | JRException e) {
            e.printStackTrace();
        }
        return reportJasperPrint;
    }
}