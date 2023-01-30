package uic.api_anteproyecto.generarsolicitudpdf;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
class SolicitudPDFLinea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private SolicitudPDF solicitudpdf;

    private String nombre_profesor;
    private String periodo_lectivo;
    private Date fecha;
}