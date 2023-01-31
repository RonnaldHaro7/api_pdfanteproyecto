package uic.api_pdfanteproyecto.generaranteproyectopdf;

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

@Tag(name = "Controlador del anteproyecto")
@RestController
@RequestMapping("api/anteproyectopdf")
@CrossOrigin({"*"})
public class AnteproyectoPDFController {
    @Autowired AnteproyectoPDFService anteproyectoPDFService;

    @Operation(summary = "Obtiene todas los anteproyectos pdf")
    @GetMapping("/")
    public List<AnteproyectoPDF> findAll(){
        return anteproyectoPDFService.findAll();
    }

    @GetMapping("/{id}/")
    public AnteproyectoPDF findById(@PathVariable Long id){
        return anteproyectoPDFService.findById(id);
    }

    @PostMapping("/")
    public AnteproyectoPDF save(@RequestBody AnteproyectoPDF entity){
        return anteproyectoPDFService.save(entity);
    }

    @PutMapping("/{id}/")
    public AnteproyectoPDF update(@RequestBody AnteproyectoPDF entity){
        return anteproyectoPDFService.save(entity);
    }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id){
        anteproyectoPDFService.deleteById(id);
    }

    @GetMapping("/pdf/{id}/")
	public ResponseEntity<byte[]> getAnteproyectoPDFReporte(@PathVariable long id) throws JRException {

		JasperPrint reporte = anteproyectoPDFService.getAnteproyectoPDFReporte(id);
        
        if (reporte==null)
            return new ResponseEntity<byte[]>(null, null, HttpStatus.NOT_FOUND);
        

		HttpHeaders headers = new HttpHeaders();
		// set the PDF format
		headers.setContentType(MediaType.APPLICATION_PDF);
		headers.setContentDispositionFormData("filename", "anteproyectoPDF.pdf");
		// create the report in PDF format
		return new ResponseEntity<byte[]>(JasperExportManager.exportReportToPdf(reporte), headers, HttpStatus.OK);

	}
}