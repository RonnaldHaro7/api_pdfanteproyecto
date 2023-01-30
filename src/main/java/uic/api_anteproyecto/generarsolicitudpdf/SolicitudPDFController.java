package uic.api_anteproyecto.generarsolicitudpdf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

import java.util.List;

@Tag(name = "Controlador de la solicitudpdf")
@RestController
@RequestMapping("api/solicitudpdf")
@CrossOrigin({"*"})
public class SolicitudPDFController {
    @Autowired SolicitudPDFService solicitudPDFService;

    @Operation(summary = "Obtiene todas las solicitudes pdf")
    @GetMapping("/")
    public List<SolicitudPDF> findAll(){
        return solicitudPDFService.findAll();
    }

    @GetMapping("/{id}/")
    public SolicitudPDF findById(@PathVariable Long id){
        return solicitudPDFService.findById(id);
    }

    @PostMapping("/")
    public SolicitudPDF save(@RequestBody SolicitudPDF entity){
        return solicitudPDFService.save(entity);
    }

    @PutMapping("/{id}/")
    public SolicitudPDF update(@RequestBody SolicitudPDF entity){
        return solicitudPDFService.save(entity);
    }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id){
        solicitudPDFService.deleteById(id);
    }

    @GetMapping("/pdf/{id}/")
	public ResponseEntity<byte[]> getSolicitudPDFReporte(@PathVariable long id) throws JRException {

		JasperPrint reporte = solicitudPDFService.getSolicitudPDFReporte(id);
        
        if (reporte==null)
            return new ResponseEntity<byte[]>(null, null, HttpStatus.NOT_FOUND);
        

		HttpHeaders headers = new HttpHeaders();
		// set the PDF format
		headers.setContentType(MediaType.APPLICATION_PDF);
		headers.setContentDispositionFormData("filename", "solicitudPDF.pdf");
		// create the report in PDF format
		return new ResponseEntity<byte[]>(JasperExportManager.exportReportToPdf(reporte), headers, HttpStatus.OK);

	}
}