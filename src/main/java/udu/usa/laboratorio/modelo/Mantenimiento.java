package udu.usa.laboratorio.modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase que permite registrar los mantenimientos preventivos y correctivos realizados
 * a los activos existentes en el laboratorio.
 * @author Isabel-Fabian
 */
@Entity
public class Mantenimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String descripcion;
    private String averiaEncontrada;
    private String repuesto;
    @Temporal(TemporalType.DATE)
    private java.util.Calendar fecha;
    
     
    @ManyToOne
    @JoinColumn(name = "activo_id")
    private Activo activo;

    
    @ManyToOne
    @JoinColumn(name = "idPersona")
    private Auxiliar auxiliar;
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getFecha() {
       
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAveriaEncontrada() {
        return averiaEncontrada;
    }

    public void setAveriaEncontrada(String averiaEncontrada) {
        this.averiaEncontrada = averiaEncontrada;
    }

    public String getRepuesto() {
        return repuesto;
    }

    public void setRepuesto(String repuesto) {
        this.repuesto = repuesto;
    }

    public Activo getActivo() {
        return activo;
    }

    public void setActivo(Activo activo) {
        this.activo = activo;
    }

    public Auxiliar getAuxiliar() {
        return auxiliar;
    }

    public void setAuxiliar(Auxiliar auxiliar) {
        this.auxiliar = auxiliar;
    }
    
    
    @Override
    public String toString() {
        return "udu.usa.laboratorio.modelo.MantenimientoCorrectivo[ id=" + id + " ]";
    }
    
}
