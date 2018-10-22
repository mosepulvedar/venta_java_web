/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import DAO.ProductoDAO;
import entity.Producto;

/**
 *
 * @author Duoc
 */
public class TestProducto {
    
    
    public static void main(String [] args) {
        
        ProductoDAO pDAO = new ProductoDAO();
        
        for (Producto p : pDAO.listar()) {
            System.out.println(p.getNombre());
        }
        
        
    }
    
}
