package udu.usa.laboratorio.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Clase que permite gestionar la informacion de los mantenimientos preventivos que se deben
 * realizar a los activos existentes en el laboratorio de electronica.
 * @author Isabel-Fabian
 * @version 1
 * @since 18/09/2016
 */
@Entity
public class MantenimientoPreventivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String actividad;
    private String materiales;
    private int numMeses;
    
    @ManyToOne
    @JoinColumn(name = "activo_id")
    private Activo activo;
    
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

    public int getNumMeses() {
        return numMeses;
    }

    public void setNumMeses(int numMeses) {
        this.numMeses = numMeses;
    }

   

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getMateriales() {
        return materiales;
    }

    public void setMateriales(String materiales) {
        this.materiales = materiales;
    }

    
    @Override
    public String toString() {
        return "udu.usa.laboratorio.modelo.MantenimientoPreventivo[ id=" + id + " ]";
    }
    
}
