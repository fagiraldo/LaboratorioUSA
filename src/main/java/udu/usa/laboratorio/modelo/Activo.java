package udu.usa.laboratorio.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * Clase que permite almacenar la informacion relacionada con todos los activos que 
 * son administrados por el laboratorio
 * @author Isabel-Fabian
 * @version 1
 * @since 18/09/2016
 */
@Entity
public class Activo implements Serializable {
     @Id
     private String codigo;
     private String nombreEquipo;
     private String numeroSerie;
     
     private boolean funcionamiento; 
     private boolean  manual ;
     @Temporal(TemporalType.DATE)
     private java.util.Calendar fechaAdquisicion;
     private String marca;
     private String modelo ;
     private String referencia   ;
     private String ubicacion ;
    
    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;
         
     @OneToMany( mappedBy = "activo",  fetch = FetchType.LAZY)
     @JoinColumn(name="activo_id")
     private Collection<MantenimientoPreventivo> mantenimientoPreventivo;
  
     @OneToMany( mappedBy = "activo",  fetch = FetchType.LAZY)
     @JoinColumn(name="activo_id")
     private Collection<Mantenimiento> mantenimiento;
        
           
     @OneToMany( mappedBy = "activo",  fetch = FetchType.LAZY)
     @JoinColumn(name="idActivo")
     private Collection<DetallePrestamo> detalleprestamo;

    public Collection<DetallePrestamo> getDetalleprestamo() {
        return detalleprestamo;
    }

    public void setDetalleprestamo(Collection<DetallePrestamo> detalleprestamo) {
        this.detalleprestamo = detalleprestamo;
    }
     
     public Collection<MantenimientoPreventivo> getMantenimientoPreventivo() {
         return mantenimientoPreventivo;
     }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Collection<Mantenimiento> getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(Collection<Mantenimiento> mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    public void setMantenimientoPreventivo(Collection<MantenimientoPreventivo> mantenimientoPreventivo) {
        this.mantenimientoPreventivo = mantenimientoPreventivo;
    }
    
    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public Calendar getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(Calendar fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

  
    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public boolean isFuncionamiento() {
        return funcionamiento;
    }

    public void setFuncionamiento(boolean funcionamiento) {
        this.funcionamiento = funcionamiento;
    }

    public boolean isManual() {
        return manual;
    }

    public void setManual(boolean manual) {
        this.manual = manual;
    }

  
    @Override
    public String toString() {
        return "Activo{" + "nombreEquipo=" + nombreEquipo + ", fechaAdquisicion=" + fechaAdquisicion + ", codigo=" + codigo + ", marca=" + marca + ", modelo=" + modelo + ", ubicacion=" + ubicacion + ", numeroSerie=" + numeroSerie + ", funcionamiento=" + funcionamiento + ", referencia=" + referencia + ", manual=" + manual + '}';
    }
           
}


 