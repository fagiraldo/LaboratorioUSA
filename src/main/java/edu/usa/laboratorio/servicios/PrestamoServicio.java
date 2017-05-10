/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.usa.laboratorio.servicios;

import edu.usa.laboratorio.dao.GenericDAO;
import java.util.List;
import udu.usa.laboratorio.modelo.Activo;
import udu.usa.laboratorio.modelo.DetallePrestamo;
import udu.usa.laboratorio.modelo.Prestamo;

/**Service CRUD Facade
 *Clase que permite gestionar la informacion relacionada con los prestados que se realizan en el laboratorio de electronica.
 * @author fabian.giraldo
 */
public class PrestamoServicio {
    /**
     * Servicio que permite realizar el prestamo de un activo existente en el laboratorio de la Universidad
     * @return 
     */
    public boolean prestarActivos(Prestamo prestamo){
      GenericDAO<Prestamo> dao  = new GenericDAO<Prestamo>(Prestamo.class);
      return dao.save(prestamo);
    }
    
    /**
     * Servicio que permite realizar la devolucion de una activo prestado a un usuario del laboratorio
     * @return 
     */
    public Prestamo buscarActivo(Activo activo){
        /*ActivoServicio servicio = new ActivoServicio();
        servicio.get(codigo)
        
        GenericDAO<Prestamo> daoPrestamo  = new GenericDAO<Prestamo>(Prestamo.class);
        
        List<DetallePrestamo> detalle = dao.findByProperty("idActivo",activo.getCodigo());
        if(detalle!= null){
            DetallePrestamo primero = ((DetallePrestamo) detalle.get(0));
           Prestamo prestamo = primero.getPrestamo() ;//Selecciono el primero
           return prestamo;
        }*/
        return null;
    }
    
    /**
     * Servicio que permite registrar una multa u observacion sobre un usuario del laborario
     */
    public void registrarMulta(){
    
    }
    
    public void enviarCorreoPrestamo(){
    
    }
    
    public void generarNotificaciones(){
    
    }
}
