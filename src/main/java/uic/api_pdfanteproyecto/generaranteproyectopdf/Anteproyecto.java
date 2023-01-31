package uic.api_pdfanteproyecto.generaranteproyectopdf;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
class Anteproyecto {

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
}