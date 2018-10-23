/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.Producto;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author moises
 */
public class Modelo<T> {
    
    private String nombreModel;

    public String getNombreModel() {
        return nombreModel;
    }
    
    
    public List<T> listar() {
        
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        
        List<T> lista = null;
        
        try {
            
            String hql = "from " + getNombreModel();
            Query q = sesion.createQuery(hql);
            
            lista = q.list();
            
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
            
        } finally {
            sesion.close();
        }
        
        return lista;
    }
    
    public T buscar(int id) {
        
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        T entidad = null;
        try {
            String hql = "select t from " + getNombreModel() + " t where id = :id";
            Query q = sesion.createQuery(hql);
            q.setInteger("id", id);
            entidad = (T)q.list().get(0);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sesion.close();
        }
        return entidad;
    }
    
    public boolean agregar(T entidad) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        
        boolean agregado = false;
        try {
            Transaction tx = sesion.beginTransaction();
            sesion.save(entidad);
            tx.commit();
            agregado = true;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally{
            sesion.close();
        }
        
        return agregado;
        
    }
    
    public boolean modificar(T entidad) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        
        boolean modificado = false;
        try {
            Transaction tx = sesion.beginTransaction();
            sesion.update(entidad);
            tx.commit();
            modificado = true;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally{
            sesion.close();
        }
        
        return modificado;
        
    }
    
    public boolean eliminar(T entidad) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        
        boolean eliminado = false;
        try {
            Transaction tx = sesion.beginTransaction();
            sesion.delete(entidad);
            tx.commit();
            eliminado = true;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally{
            sesion.close();
        }
        
        return eliminado;
        
    }
    
}
