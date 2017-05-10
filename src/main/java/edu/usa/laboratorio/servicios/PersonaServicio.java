/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.usa.laboratorio.servicios;

import edu.usa.laboratorio.dao.GenericDAO;
import java.util.List;
import udu.usa.laboratorio.modelo.Auxiliar;
import udu.usa.laboratorio.modelo.Categoria;
import udu.usa.laboratorio.modelo.Dependencia;
import udu.usa.laboratorio.modelo.Docente;
import udu.usa.laboratorio.modelo.Persona;
import udu.usa.laboratorio.modelo.Programa;
import udu.usa.laboratorio.modelo.Usuario;

/**
 * Service CRUD Facade
 * Clase que permite gestionar la informacion de los actores que van a interactuar con el sistema de gestion del laboratorio.
 * Especificament: Auxiliares de laboratorio, Coordinadores de laboratorio, Usuarios (Docentes, Estudiantes) que utilizaran el 
 * servicio de prestamo.
 * @author fabian.giraldo
 */
public class PersonaServicio {
    
     /**
     * Servicio que permite registrar nuevos usuarios en la aplicacion (coordinador, auxiliar, estudiante).
     * @param persona Objeto de la clase Persona que contiene la informacion general de un usuario que va a prestar o gestionar un laboratorio.
     * @return true o false basado en si se inserto o no la persona satisfactoriamente.
     */
   public boolean save(Persona persona){
      GenericDAO<Persona> dao  = new GenericDAO<Persona>(Persona.class);
      return dao.save(persona);
   }
 
   /**
    * Servicio que permite cargar la informacion de una persona que puede tener acceso o prestar activos en el laboratorio 
    * a partir de la cedula del usuario.
    * @param cedula Numero de cedula del usuario a buscar
    * @return  Una instancia de la Persona, el cual tiene la informacion general.
    */
   public Auxiliar getAuxiliar(Object codigo){
       GenericDAO<Auxiliar> dao  = new GenericDAO<Auxiliar>(Auxiliar.class);
       return dao.get(codigo);
   }
   
   
    public boolean deleteAuxiliar(int id){
         GenericDAO<Auxiliar> dao  = new GenericDAO(udu.usa.laboratorio.modelo.Auxiliar.class);
         Auxiliar auxiliar = dao.get(id);
         if(auxiliar != null){
             dao.delete(auxiliar);
             return true;
         }else {
             return false;
         }
   }
    
    
    public boolean updateAuxiliar(Auxiliar oldcategoria){
         GenericDAO<Auxiliar> dao  = new GenericDAO(udu.usa.laboratorio.modelo.Auxiliar.class);
         Auxiliar auxiliar = dao.update(oldcategoria);
         if(auxiliar != null){
           return true;
         }
         return false;
   }
    

   /**
    * Servicio que permite cargar la informacion de una persona que puede tener acceso o prestar activos en el laboratorio 
    * a partir de la cedula del usuario.
    * @param cedula Numero de cedula del usuario a buscar
    * @return  Una instancia de la Persona, el cual tiene la informacion general.
    */
   public Docente getDocente(Object codigo){
       GenericDAO<Docente> dao  = new GenericDAO<Docente>(Docente.class);
       return dao.get(codigo);
   }
   
   
    public boolean deleteDocente(int id){
         GenericDAO<Docente> dao  = new GenericDAO(udu.usa.laboratorio.modelo.Docente.class);
         Docente auxiliar = dao.get(id);
         if(auxiliar != null){
             dao.delete(auxiliar);
             return true;
         }else {
             return false;
         }
   }
    
    
    public boolean updateDocente(Docente oldcategoria){
         GenericDAO<Docente> dao  = new GenericDAO(udu.usa.laboratorio.modelo.Docente.class);
         Docente auxiliar = dao.update(oldcategoria);
         if(auxiliar != null){
           return true;
         }
         return false;
   }

    
    
     /**
    * Servicio que permite cargar la informacion de una persona que puede tener acceso o prestar activos en el laboratorio 
    * a partir de la cedula del usuario.
    * @param cedula Numero de cedula del usuario a buscar
    * @return  Una instancia de la Persona, el cual tiene la informacion general.
    */
   public Usuario getUsuario(Object codigo){
       GenericDAO<Usuario> dao  = new GenericDAO<Usuario>(Usuario.class);
       return dao.get(codigo);
   }
   
   
   public Usuario getUsuarioxCedula(Object codigo){
        GenericDAO<Usuario> dao  = new GenericDAO(udu.usa.laboratorio.modelo.Usuario.class);
        List<Usuario> usuario = dao.findByProperty("cedula", codigo);
        if(usuario != null && usuario.size()>0){
          return usuario.get(0);
        }else 
             return null;
   }
  
   
     public Docente getDocentexCedula(Object codigo){
        GenericDAO<Docente> dao  = new GenericDAO(udu.usa.laboratorio.modelo.Docente.class);
        List<Docente> usuario = dao.findByProperty("cedula", codigo);
        if(usuario != null && usuario.size()>0){
          return usuario.get(0);
        }else 
             return null;
   }
     
     
    public boolean deleteUsuario(int id){
         GenericDAO<Usuario> dao  = new GenericDAO(udu.usa.laboratorio.modelo.Usuario.class);
         Usuario auxiliar = dao.get(id);
         if(auxiliar != null){
             dao.delete(auxiliar);
             return true;
         }else {
             return false;
         }
   }
    
    
    public boolean updateUsuario(Usuario oldcategoria){
         GenericDAO<Usuario> dao  = new GenericDAO(udu.usa.laboratorio.modelo.Usuario.class);
         Usuario auxiliar = dao.update(oldcategoria);
         if(auxiliar != null){
           return true;
         }
         return false;
   }

    
    
    
   /**
     * Servicio que permite registrar nuevos progrados de la universidad, con el fin de poder asociarlos al usuario.
     * @param programa Objeto de la clase Programa que contiene el nombre del programa de pregrado.
     * @return true o false basado en si se inserto o no el programa satisfactoriamente.
     */
   public boolean savePrograma(Programa programa){
       GenericDAO<Programa> dao  = new GenericDAO<Programa>(Programa.class);
       return dao.save(programa);
   }
    
   /**
    * Servicio que permite buscar la lista de programas de pregrado que tiene estudiantes que pueden realizar prestamo de activos.
    * @return Lista de Programas registrados.
    */
   public List<Programa> findAllProgramas(){
      GenericDAO<Programa> dao  = new GenericDAO<Programa>(Programa.class);
      List<Programa> programas = dao.findAll();
      return programas;
   }
   
   
   /**
     * Servicio que permite registrar nuevas dependencias, con el fin de poder asociarlos al usuario.
     * @param programa Objeto de la clase Dependencia que contiene el nombre de la dependencia de la universidad.
     * @return true o false basado en si se inserto o no la dependencia satisfactoriamente.
     */
   public boolean saveDependencia(Dependencia dependencia){
       GenericDAO<Dependencia> dao  = new GenericDAO<Dependencia>(Dependencia.class);
       return dao.save(dependencia);
   }
    
   /**
    * Servicio que permite buscar la lista de dependencias de la universidad en la que laboran los docentes o administrativos
    *  que pueden realizar prestamo de activos.
    * @return Lista de Programas registrados.
    */
   public List<Dependencia> findAllDependencias(){
      GenericDAO<Dependencia> dao  = new GenericDAO<Dependencia>(Dependencia.class);
      List<Dependencia> dependencias = dao.findAll();
      return dependencias;
   }
   
   
   /**
    * Servicio que permite buscar la lista de dependencias de la universidad en la que laboran los docentes o administrativos
    *  que pueden realizar prestamo de activos.
    * @return Lista de Programas registrados.
    */
   public List<Auxiliar> findAllAuxiliar(){
      GenericDAO<Auxiliar> dao  = new GenericDAO(Auxiliar.class);
      List<Auxiliar> auxiliares = dao.findAll();
      return auxiliares;
   }
   
   
   
   /**
    * Servicio que permite buscar la lista de dependencias de la universidad en la que laboran los docentes o administrativos
    *  que pueden realizar prestamo de activos.
    * @return Lista de Programas registrados.
    */
   public List<Docente> findAllDocente(){
      GenericDAO<Docente> dao  = new GenericDAO(Docente.class);
      List<Docente> auxiliares = dao.findAll();
      return auxiliares;
   }
   
   /**
    * Servicio que permite buscar la lista de dependencias de la universidad en la que laboran los docentes o administrativos
    *  que pueden realizar prestamo de activos.
    * @return Lista de Programas registrados.
    */
   public List<Usuario> findAllUsuario(){
      GenericDAO<Usuario> dao  = new GenericDAO(Usuario.class);
      List<Usuario> auxiliares = dao.findAll();
      return auxiliares;
   }
   
   
    public Dependencia getDependencia(Object codigo){
       GenericDAO<Dependencia> dao  = new GenericDAO(udu.usa.laboratorio.modelo.Dependencia.class);
       return dao.get(codigo);
   
   }
    
    public Programa getPrograma(Object codigo){
       GenericDAO<Programa> dao  = new GenericDAO(udu.usa.laboratorio.modelo.Programa.class);
       return dao.get(codigo);
   
   }
   
   /**
    *  Permite a un usuario del sistema enviar una notificacion usando el sistema de chat interno de la aplicacion.
    */
   public void publicarNotificacion(){
     
   }
   
}
