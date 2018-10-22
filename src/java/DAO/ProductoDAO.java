/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.Producto;
import java.util.ArrayList;

/**
 *
 * @author Duoc
 */
public class ProductoDAO {

    ArrayList<Producto> productos = new ArrayList<Producto>();

    public ProductoDAO() {
        productos.add(new Producto(1, "ropa", 20000,20));
        productos.add(new Producto(2, "anagesico", 35000,1));
        productos.add(new Producto(3, "pañales", 234234,2));
    }
    
    public ArrayList<Producto> listar() {
        return productos;
    }
    
    public Producto buscar(int codigo) {
        for (Producto producto : productos) {
            if(producto.getId()== codigo) {
                return producto;
            }
        }
        
        return null;
    }
}
