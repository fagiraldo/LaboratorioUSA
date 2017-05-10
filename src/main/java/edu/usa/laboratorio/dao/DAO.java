package edu.usa.laboratorio.dao;

import java.io.Serializable;
import java.util.List;
/**
 *Interface que define los operaciones generales a ejecutar sobre un motor
 * gestor de base de datos.
 * @author Isabel-Fabian
 * @param <T> Tipo de Clase a ser persistida en un motor de base de datos.
 * @since 18/09/2016
 * @version 1
 */
public interface DAO<T> 
{
   
    T get(Object id);
    boolean save(T object);
    T update(T object);
    void delete(T object);
    List<T> findAll();
    List<T> findByProperty(String prop, Object val);
    List<T> findWithName(String prop, Object val);
}
