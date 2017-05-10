package edu.usa.laboratorio.dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;


/**
 * Clase que implementa los metodos genericos a utilizar para persistir objetos
 * como tuplas de una relacion en un motor de base de datos.
 * @author fabian.giraldo
 * @version 1
 * @param <T>
 * @since 18/09/2016
 */
public class GenericDAO<T> implements DAO<T>  {
    private EntityManagerFactory emf = null;
    private EntityManager entityManager = null;
    protected Class type;
    protected String entity;
    
    public GenericDAO(Class type){
        this.type = type;
       
    }
            
    
    
    @Override
    public T get(Object id){
        startOperation();
        T t = (T) entityManager.find(type, id);
        entityManager.close();
        emf.close(); 
        return t;
    }

    @Override
    public void delete(T object){
         startOperation();
        entityManager.getTransaction().begin();
        T objectRemove= entityManager.merge(object);
        entityManager.remove(objectRemove);
        entityManager.getTransaction().commit();
        entityManager.close();
        emf.close(); 
    }

    @Override
    public List<T> findAll(){
        startOperation();
        Query query;
                 
        query = entityManager.createNativeQuery("select * from Categoria "    );
        startOperation();
        List<T> ts = (List<T>) query.getResultList();;
        entityManager.close();
        emf.close(); 
        return ts;
    }

    public List findWithName(String prop, Object val) {
         startOperation();
         
          Query query = 
            entityManager.createQuery("select x from " + 
                                                     type.getName() + 
                                                   " x where x." + prop + " LIKE  ?1");
          
          
           query.setParameter(1, "%" + val + "%"  );
           List<T> ts = (List<T>) query.getResultList();
           entityManager.close();
           emf.close(); 
           return ts;
      
}
    
    
    @Override
    public List<T> findByProperty(String prop, Object val){
        startOperation();
        Query query = 
            entityManager.createQuery("select x from " + 
                                                     type.getName() + 
                                                   " x where x." + prop + " = ?1");
       
        query.setParameter(1,  val  );
       
        List<T> ts = (List<T>) query.getResultList();
        entityManager.close();
        emf.close(); 
        return ts;
    }

    @Override
    public boolean save(T object){
        startOperation();
        entityManager.getTransaction().begin();
        entityManager.persist(object);
        entityManager.getTransaction().commit();
        entityManager.close();
        emf.close(); 
        return true;
    }

    @Override
    public T update(T object){
         startOperation();
        entityManager.getTransaction().begin();
        T t = entityManager.merge(object);
        entityManager.getTransaction().commit();
        entityManager.close();
        emf.close(); 
        return t;
    }
    

    public Class getType(){
        return type;
    }

    public String getEntityName(){
        if ( type.getName() == null) {
            Entity entityAnn = (Entity) type.getAnnotation(Entity.class);
            if (entityAnn != null && !entityAnn.name().equals("")){
                entity = entityAnn.name();
            } else{
                entity = type.getSimpleName();
            }
        }
        
        return entity;
    }
    
    public T customQuery(String txtQuery){
          startOperation();
          Query query =   entityManager.createQuery(txtQuery);
          T ts = (T)query.getSingleResult();
          entityManager.close();
          emf.close(); 
          return ts;
    }
    
    protected void startOperation() { 
        URI dbUri = null;
        try {
            dbUri = new URI(System.getenv("DATABASE_URL")); 
            String username = dbUri.getUserInfo().split(":")[0];
            String password = dbUri.getUserInfo().split(":")[1];
            String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

            Map<String, String> properties = new HashMap<String, String>();
            properties.put("javax.persistence.jdbc.url", dbUrl);
            properties.put("javax.persistence.jdbc.user", username );
            properties.put("javax.persistence.jdbc.password", password );
            properties.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
            properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
            this.emf = Persistence.createEntityManagerFactory("LaboratorioPU",properties);
            this.entityManager = emf.createEntityManager();
        } catch (URISyntaxException ex) {
            Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }
}
