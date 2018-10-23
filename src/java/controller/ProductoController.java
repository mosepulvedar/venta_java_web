/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.CategoriaDAO;
import DAO.ProductoDAO;
import entity.Categoria;
import entity.Producto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author moises
 */
@Controller
public class ProductoController {

    private ProductoDAO pDAO = new ProductoDAO();
    private CategoriaDAO cDAO = new CategoriaDAO();
    
    @RequestMapping(value="/agregar-producto", method = RequestMethod.GET)
    public String agregarProducto(Model model) {
        
        model.addAttribute("categorias", cDAO.listar());
        
        return "agregar_producto";
    }
    
    @RequestMapping(value="/save-producto", method = RequestMethod.POST)
    public String saveProducto(Model model, RedirectAttributes ra,
            @RequestParam("txtNombre") String nombre,
            @RequestParam("txtPrecio") int precio,
            @RequestParam("txtStock") int stock,
            @RequestParam("cboCategoria") int categoriaId) {
        
        Categoria categoria = new Categoria();
        categoria.setId(categoriaId);
        
        Producto p = new Producto();
        p.setNombre(nombre);
        p.setStock(stock);
        p.setPrecio(precio);
        p.setCategoria(categoria);
        
        String mensaje = "Error al guardar";
        
        if(pDAO.agregar(p)) {
            mensaje = "Guardado correctamente";
        }
        
        model.addAttribute("mensaje", mensaje);
        
        ra.addFlashAttribute("mensaje", mensaje);
        
        return "redirect:listar-productos";
        
        
    }
    
    @RequestMapping(value="listar-productos", method=RequestMethod.GET)
    public String listar(Model model) {
        
        model.addAttribute("productos", pDAO.listar());
        
        return "listar_productos";
    }
    
    @RequestMapping(value="eliminar-producto", method=RequestMethod.GET)
    public String eliminar(Model model, RedirectAttributes ra,
            @RequestParam("id")int idProducto) {
        
        
        Producto p = pDAO.buscar(idProducto);
        
        
        String mensaje = "No se ha podido eliminar";
       
        if(p==null) {
            mensaje = "No existe el producto";
        } else if(pDAO.eliminar(p)) {
           mensaje = "Eliminado correctamente";
       }
       
       ra.addFlashAttribute("mensaje", mensaje);
       return "redirect:listar-productos";
        
    }
}
