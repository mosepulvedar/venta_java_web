/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.Producto;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;

import org.hibernate.Session;

/**
 *
 * @author Duoc
 */
public class ProductoDAO {

    ArrayList<Producto> productos = new ArrayList<Producto>();

    public ProductoDAO() {
        productos.add(new Producto(1, "ropa", 20000, 20));
        productos.add(new Producto(2, "anagesico", 35000, 1));
        productos.add(new Producto(3, "pañales", 234234, 2));
    }

    public List<Producto> listar() {

        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<Producto> listaProductos = new ArrayList<>();

        try {

            Query q = sesion.createQuery("from Producto");
            listaProductos = q.list();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sesion.close();
        }

        return listaProductos;
    }

    public Producto buscar(int codigo) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Producto p = null;
        try {
            Query q = sesion.createQuery("select p from Producto p where p.id = :id");
            q.setInteger("id", codigo);
            
            p = (Producto)q.list().get(0);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sesion.close();
        }
        
        return p;
    }
}
