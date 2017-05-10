package edu.usa.laboratorio.servicios;

import edu.usa.laboratorio.dao.GenericDAO;
import java.util.List;
import udu.usa.laboratorio.modelo.Activo;
import udu.usa.laboratorio.modelo.Categoria;
import udu.usa.laboratorio.modelo.Dependencia;
import udu.usa.laboratorio.modelo.Mantenimiento;
import udu.usa.laboratorio.modelo.MantenimientoPreventivo;
import udu.usa.laboratorio.modelo.Programa;

/**Service CRUD Facade
 * Clase que ofrecer los servicios relacionados con la gestion de activos 
 * a los cuales pueden acceder los Servlets controladores 
 * @author Isabel-Fabian
 */
public class ActivoServicio<T> {
    
    /**
     * Servicio que permite registrar nuevos activos  existentes en el laboratorio de electronica.
     * @param activo Objeto de la clase activo que contiene la informacion general del activo existente en el laboratorio
     * @return true o false basado en si se inserto o no un activo satisfactoriamente.
     */
   public boolean save(Activo activo){
      GenericDAO<Activo> dao  = new GenericDAO<Activo>(Activo.class);
      return dao.save(activo);
   }
 
   /**
    * Servicio que permite cargar la informacion de una activo que tiene como codigo la informacion capturada 
    * por el lector de codigo de barras
    * @param codigo Codigo de barras del activo del cual se desea conocer la informacion
    * @return  Una instancia del Activo, el cual tiene la informacion general y de los mantenimientos realizados.
    */
   public Activo get(String codigo){
       GenericDAO<Activo> dao  = new GenericDAO<Activo>(Activo.class);
       return dao.get(codigo);
   }
    
   /**
    * Servicio que retorna la lista de activos que tienen coincidencia con el numbre del equipo.
    * Dicha funcionalidad es la base para el buscador provisto por el sistema de informacion.
    * @param valor Nombre del equipo que se esta buscando
    * @return  Listado de activos que coinciden con el el nombre del equipo solicitado en el critero de busqueda
    */
   public List<Activo> findByName(String valor){
      List<Activo> activos = null;
      GenericDAO<Activo> dao  = new GenericDAO<Activo>(Activo.class);
      activos = dao.findWithName("nombreEquipo",  valor );
      return activos;
   }
      
   /**
    * Servicio que permite registrar un mantenimiento preventivo que deben realizar los auxiliares de laboratorio para un activo.
    * @param Objeto de tiempo MantenimientoPreventivo que contiene la informacion de la actividad, materiales, periodicidad para realizar un mantenimiento preventivo
    * @return true o false basado en si se realizo o no el registro del mantenimiento preventivo. 
    */
   public boolean saveMantenimientoPreventivo(MantenimientoPreventivo mantenimiento){
      GenericDAO<MantenimientoPreventivo> dao  = new GenericDAO<MantenimientoPreventivo>(MantenimientoPreventivo.class);
      return dao.save(mantenimiento);
   }
   
   /**
    * Servicio que permite registrar un mantenimiento realizado a un equipo. Dicho mantenimiento puede ser un mantenimiento preventivo
    * o correctivo. 
    * @param mantenimiento Objeto de tipo mantenimiento que especifica el mantenimiento realizado a un activo del laboratorio.
    * @return true o false basado en si se realizo o no el registro del mantenimiento. 
    */
   public boolean saveMantenimiento(Mantenimiento mantenimiento){
     GenericDAO<Mantenimiento> dao  = new GenericDAO<Mantenimiento>(Mantenimiento.class);
      return dao.save(mantenimiento);
   }

   
   
   /**
    * Servicio que permite registrar una categoria en la cual puede ser clasificado un activo del laboratorio
    * @param caterogia Objeto de tipo categoria que especifica la categoria en la cual se puede clasificar una activo del laboratorio
    * @return true o false basado en si se realizo o no el registro del mantenimiento. 
    */
   public boolean saveCategoria(Categoria categoria){
      GenericDAO<Categoria> dao  = new GenericDAO(udu.usa.laboratorio.modelo.Categoria.class);
      return dao.save(categoria);
   }
   
   /**
    * Metodo que permite listar todas las categorias activas en el laboratorio de electronica
    * @return Lista de Categorias 
    */
   public List<Categoria> findAllCategoria(){
      List<Categoria> categorias = null;
      GenericDAO<Categoria> dao  = new GenericDAO(udu.usa.laboratorio.modelo.Categoria.class);
      categorias = dao.findAll();
      return categorias;
   }
   
   public Categoria getCategoria(Object codigo){
       GenericDAO<Categoria> dao  = new GenericDAO(udu.usa.laboratorio.modelo.Categoria.class);
       return dao.get(codigo);
   
   }
   
   public boolean deleteCategoria(int id){
         GenericDAO<Categoria> dao  = new GenericDAO(udu.usa.laboratorio.modelo.Categoria.class);
         Categoria categoria = dao.get(id);
         if(categoria != null){
             dao.delete(categoria);
             return true;
         }else {
             return false;
         }
   }
   
  
     public boolean deleteMantenimientoPreventivo(int id){
         GenericDAO<MantenimientoPreventivo> dao  = new GenericDAO(udu.usa.laboratorio.modelo.MantenimientoPreventivo.class);
         MantenimientoPreventivo mantenimiento = dao.get(id);
         if(mantenimiento != null){
             dao.delete(mantenimiento);
             return true;
         }else {
             return false;
         }
   }
   
     
     
     public boolean deleteMantenimiento(int id){
         GenericDAO<Mantenimiento> dao  = new GenericDAO(udu.usa.laboratorio.modelo.Mantenimiento.class);
         Mantenimiento mantenimiento = dao.get(id);
         if(mantenimiento != null){
             dao.delete(mantenimiento);
             return true;
         }else {
             return false;
         }
   }
     
     
   public boolean updateCategoria(Categoria oldcategoria){
         GenericDAO<Categoria> dao  = new GenericDAO(udu.usa.laboratorio.modelo.Categoria.class);
         Categoria categoria = dao.update(oldcategoria);
         if(categoria != null){
           return true;
         }
         return false;
   }
   
   
   /**
    * Servicio que permite registrar una dependencia a la cual pertenece un docente de la universidad
    * @param Dependencia Objeto de tipo dependencia que especifica la dependencia a la cual pertenece un docente de la universidad
    * @return true o false basado en si se realizo o no el registro de la dependencia. 
    */
   public boolean saveDependencia(Dependencia dependencia){
      GenericDAO<Dependencia> dao  = new GenericDAO(udu.usa.laboratorio.modelo.Dependencia.class);
      return dao.save(dependencia);
   }
   /**
    * Metodo que permite listar todas las categorias activas en el laboratorio de electronica
    * @return Lista de Categorias 
    */
   public List<Dependencia> findAllDependencia(){
      List<Dependencia> dependencias = null;
      GenericDAO<Dependencia> dao  = new GenericDAO(udu.usa.laboratorio.modelo.Dependencia.class);
      dependencias = dao.findAll();
      return dependencias;
   }
   
   public Dependencia getDependencia(Object codigo){
       GenericDAO<Dependencia> dao  = new GenericDAO(udu.usa.laboratorio.modelo.Dependencia.class);
       return dao.get(codigo);
   
   }
   public boolean deleteDependencia(int id){
         GenericDAO<Dependencia> dao  = new GenericDAO(udu.usa.laboratorio.modelo.Dependencia.class);
         Dependencia dependencia = dao.get(id);
         if(dependencia != null){
             dao.delete(dependencia);
             return true;
         }else {
             return false;
         }
   }
   
   
   public boolean updateDependencia(Dependencia oldcategoria){
         GenericDAO<Dependencia> dao  = new GenericDAO(udu.usa.laboratorio.modelo.Dependencia.class);
         Dependencia dependencia = dao.update(oldcategoria);
         if(dependencia != null){
           return true;
         }
         return false;
   }
   
   
   
   /**
    * Servicio que permite registrar un Programa a la cual pertenece un estudiante de la universidad
    * @param Programa Objeto de tipo programa que especifica el programa a la cual pertenece un estudiante de la universidad
    * @return true o false basado en si se realizo o no el registro del programa. 
    */
   public boolean savePrograma(Programa programa){
      GenericDAO<Programa> dao  = new GenericDAO(udu.usa.laboratorio.modelo.Programa.class);
      return dao.save(programa);
   }
   /**
    * Metodo que permite listar todas las categorias activas en el laboratorio de electronica
    * @return Lista de Categorias 
    */
   public List<Programa> findAllPrograma(){
      List<Programa> programas = null;
      GenericDAO<Programa> dao  = new GenericDAO(udu.usa.laboratorio.modelo.Programa.class);
      programas = dao.findAll();
      return programas;
   }
   
   public Programa getPrograma(Object codigo){
       GenericDAO<Programa> dao  = new GenericDAO(udu.usa.laboratorio.modelo.Programa.class);
       return dao.get(codigo);
   
   }
   public boolean deletePrograma(int id){
         GenericDAO<Programa> dao  = new GenericDAO(udu.usa.laboratorio.modelo.Programa.class);
         Programa programa = dao.get(id);
         if(programa != null){
             dao.delete(programa);
             return true;
         }else {
             return false;
         }
   }
   
   
   public boolean updatePrograma(Programa oldprograma){
         GenericDAO<Programa> dao  = new GenericDAO(udu.usa.laboratorio.modelo.Programa.class);
         Programa programa = dao.update(oldprograma);
         if(programa != null){
           return true;
         }
         return false;
   }
   
   /**
    * Clase que permite identificar los activos que tienen pendiente la realizacion de mantenimientos preventivos o que se han reportado
    * como defectuosos posterior a un prestamo.
    */
   public void generarNotificaciones(){
    
   }

    public Activo get(Activo activo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}