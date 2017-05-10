package udu.usa.laboratorio.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Isabel-Fabian
 */
@Entity
public class Usuario extends Persona implements Serializable {
       
     
    @ManyToOne
    @JoinColumn(name = "idPrograma")
    private Programa programa;
   

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    
}
