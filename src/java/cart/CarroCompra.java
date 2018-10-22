/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import entity.Producto;
import java.util.ArrayList;

/**
 *
 * @author Duoc
 */
public class CarroCompra {
    
    private ArrayList<Producto> productos = new ArrayList<Producto>();

    public ArrayList<Producto> getProductos() {
        return productos;
    }
    
    public boolean agregar(Producto p) {
        this.productos.add(p);
        return true;
    }
    
    public boolean eliminar(int codigo) {
        this.productos.remove(buscar(codigo));
        return true;
    }
    
    public Producto buscar(int codigo) {
        for (Producto producto : productos) {
            if(producto.getId()== codigo) {
                return producto;
            }
        }
        return null;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public CarroCompra() {
    }
    
    public int totalCompra() {
        
        int monto = 0;
        
        for (Producto producto : productos) {
            monto+=producto.getPrecio()*producto.getCantidad();
        }
        
        return monto;
        
    }
    
    
}
