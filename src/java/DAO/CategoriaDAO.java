/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entity.Categoria;

/**
 *
 * @author moises
 */
public class CategoriaDAO extends Modelo<Categoria> {

    @Override
    public String getNombreModel() {
        return "Categoria";
    }
    
}
