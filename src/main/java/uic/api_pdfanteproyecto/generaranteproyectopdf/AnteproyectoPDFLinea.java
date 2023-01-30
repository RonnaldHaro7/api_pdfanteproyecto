package uic.api_pdfanteproyecto.generaranteproyectopdf;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
class AnteproyectoPDFLinea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private AnteproyectoPDF solicitudpdf;

    private String nombre_profesor;
    private String periodo_lectivo;
    private Date fecha;
}