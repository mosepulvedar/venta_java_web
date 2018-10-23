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
public class ProductoDAO extends Modelo<Producto>{

    @Override
    public String getNombreModel() {
        return "Producto";
    }

   
}
