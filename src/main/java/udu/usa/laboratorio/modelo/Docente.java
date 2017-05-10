package udu.usa.laboratorio.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Clase que permite gestionar la informacion de los docentes que van a realizar prestamos en el laboratorio.
 * @author fabian.giraldo
 */
@Entity
public class Docente extends Persona implements Serializable {
    @ManyToOne
    @JoinColumn(name = "idDependencia")
    private Dependencia dependencia;

    public Dependencia getDependencia() {
        return dependencia;
    }

    public void setDependencia(Dependencia dependencia) {
        this.dependencia = dependencia;
    }
    
    
    
}
