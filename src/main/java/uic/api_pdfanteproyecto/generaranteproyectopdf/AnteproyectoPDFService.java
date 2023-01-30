package uic.api_pdfanteproyecto.generaranteproyectopdf;

import java.io.FileNotFoundException;
import java.sql.Date;
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
    @Autowired AnteproyectoPDFRepository solicitudPDFRepository;
    @Autowired CustomerEstudient customerEstudient;

    @Transactional
    public AnteproyectoPDF save(AnteproyectoPDF entity){
        return solicitudPDFRepository.save(entity);
    }

    public AnteproyectoPDF findById( Long id){
        return solicitudPDFRepository.findById(id).orElse(new AnteproyectoPDF());
    }

    public void deleteById(Long id){
        solicitudPDFRepository.deleteById(id);
    }

    public List<AnteproyectoPDF> findAll(){
        return solicitudPDFRepository.findAll();
    }

    public JasperPrint getSolicitudPDFReporte(Long id) {

        Map<String, Object> reportParameters = new HashMap<String, Object>();
        AnteproyectoPDF solicitudPDF = findById(id);
        if (solicitudPDF.getId()==null)
            return null;
        
        reportParameters.put("tema", solicitudPDF.getTema());
        reportParameters.put("periodo_lectivo", solicitudPDF.getPeriodo_lectivo());
        reportParameters.put("profesor", solicitudPDF.getProfesor());
        reportParameters.put("fecha",Date.valueOf(solicitudPDF.getFecha()));
        
        CustomerDTO estudiante =  customerEstudient.findCustomerById(solicitudPDF.getEstudianteId());
        reportParameters.put("name", estudiante.getName());
        reportParameters.put("nro_identificacion", estudiante.getNro_identificacion());
        reportParameters.put("career", estudiante.getCareer());
        reportParameters.put("email", estudiante.getEmail());
        reportParameters.put("cellphone", estudiante.getCellphone());

        JasperPrint reportJasperPrint = null;
        try {
            reportJasperPrint = JasperFillManager.fillReport(
                    JasperCompileManager.compileReport(
                            ResourceUtils.getFile("classpath:jrxml/solicitud.jrxml")
                                    .getAbsolutePath()) // path of the jasper report
                    , reportParameters // dynamic parameters
                    , new JREmptyDataSource());
        } catch (FileNotFoundException | JRException e) {
            e.printStackTrace();
        }
        return reportJasperPrint;
    }
}