package uic.api_pdfanteproyecto.generaranteproyectopdf;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
class AnteproyectoPDF {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fecha;
    private String linea_investigacion;
    private String tema;
    private String titulo;
    private String problema;
    private String objetivo_g;
    private String objetivo_s;
    private String justificacion;
    private String alcance;
    private String m_teorico;
    private String m_metodologico;
    private String metodologia;
    private String bibliografia;
    private String presupuesto;
    private Long estudianteId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pdf_id")
    private List<AnteproyectoPDFLinea> lineas = new ArrayList<>();
}
