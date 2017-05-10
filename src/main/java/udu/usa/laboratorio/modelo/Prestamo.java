package udu.usa.laboratorio.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase que permite gestionar la informacion relacionada con los prestamos efectuados por usuarios del laboratorio de electronica.
 * @author fabian.giraldo
 */
@Entity
public class Prestamo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    //Permite almacenar la referencia a los activos que estan incluidos en un prestamo realizado por un usuario
    
    @OneToMany( mappedBy = "Prestamo",  fetch = FetchType.LAZY , cascade = CascadeType.PERSIST)
    @JoinColumn(name="prestamo_id")
    private Collection<DetallePrestamo> detallesPrestamo;
    
    //Permite especificar el semestre en que fue prestado el activo
    private int semestre;
       
    //Representa la fecha en la cual se tramita el prestamo
    @Temporal(TemporalType.DATE)
    private java.util.Calendar fechaSolicitud;
        
    //Fecha limite para la entrega del activo al laboratorio
    @Temporal(TemporalType.DATE)
    private java.util.Calendar fechaDevolucion;
       
       
    //Ubicacion donde van estar el activo
    private String lugarSalida; 
    
    
        
    //Permite conocer le usuario (docente, estudiante, funcionario) que realizo el prestamo.
    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Usuario estudiante;
  
    //Permite conocer le usuario (docente, estudiante, funcionario) que realizo el prestamo.
    @ManyToOne
    @JoinColumn(name = "docente_id")
    private Docente docente;

    
    //Atributo que indica que el prestamo fue autorizado por el coordinador del laboratorio
    private boolean aprobacionCoordinador;
    
    //Campo que es utilizado cuando un estudiante realiza un prestamo. 1. Practica Libre 2. Practica dirigida.
    private String tipoPractica;
    
    private boolean saleU;

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    
    
    public String getTipoPractica() {
        return tipoPractica;
    }

    public void setTipoPractica(String tipoPractica) {
        this.tipoPractica = tipoPractica;
    }

        public boolean getSaleU() {
        return saleU;
    }

    public void setSaleU(boolean saleU) {
        this.saleU = saleU;
    }
    
       
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Usuario estudiante) {
        this.estudiante = estudiante;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }
  
    public Calendar getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Calendar fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Calendar getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Calendar fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

   
    /*
    //Permite especificar el auxiliar que realizo el prestamo.
    @ManyToOne
    @JoinColumn(name = "idAuxiliar")
    private Auxiliar auxiliar;
    
   
    public Auxiliar getAuxiliar() {
        return auxiliar;
    }

    public void setAuxiliar(Auxiliar auxiliar) {
        this.auxiliar = auxiliar;
    }

   

    */

   public boolean isAprobacionCoordinador() {
        return aprobacionCoordinador;
    }

    public void setAprobacionCoordinador(boolean aprobacionCoordinador) {
        this.aprobacionCoordinador = aprobacionCoordinador;
    }
    

    public String getLugarSalida() {
        return lugarSalida;
    }

    public void setLugarSalida(String lugarSalida) {
        this.lugarSalida = lugarSalida;
    }


    
    public Collection<DetallePrestamo> getDetallesPrestamo() {
        return detallesPrestamo;
    }

    public void setDetallesPrestamo(Collection<DetallePrestamo> detallesPrestamo) {
        this.detallesPrestamo = detallesPrestamo;
    }
    

    @Override
    public String toString() {
        return "udu.usa.laboratorio.modelo.Prestamo[ id=" + id + " ]";
    }
    
}
