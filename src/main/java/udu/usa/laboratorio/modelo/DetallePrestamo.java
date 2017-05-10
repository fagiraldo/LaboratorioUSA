package udu.usa.laboratorio.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Clase que referencia un activo que va ser parte de un prestamo.
 * @author fabian.giraldo
 */
@Entity
public class DetallePrestamo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //Referencia el activo que va ser prestado.
    @ManyToOne
    @JoinColumn(name = "idActivo")
    private Activo activo;
    
    //Determina el estado del activo cuando es prestado por el usuario
    private String estado;
    
    //Observacion referente al 
    private String observacion;
    
    @ManyToOne
    @JoinColumn(name = "prestamo_id")
    private Prestamo prestamo;

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }
    
    
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
        
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Activo getActivo() {
        return activo;
    }

    public void setActivo(Activo activo) {
        this.activo = activo;
    }


    @Override
    public String toString() {
        return "udu.usa.laboratorio.modelo.DetallePrestamo[ id=" + id + " ]";
    }
    
}
