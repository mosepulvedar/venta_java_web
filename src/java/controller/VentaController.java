/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ProductoDAO;
import cart.CarroCompra;
import entity.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Duoc
 */
@Controller
public class VentaController {

    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String agregarProducto(HttpServletRequest req, Model model,
            @RequestParam("cboProducto") int codigo,
            @RequestParam("txtCantidad") int cantidad) {
            
        Producto p = new ProductoDAO().buscar(codigo);
        
        CarroCompra carro = new CarroCompra();
        
        if(req.getSession().getAttribute("carro")!=null) {
            carro = (CarroCompra)req.getSession().getAttribute("carro");
        }
        p.setCantidad(cantidad);
        carro.agregar(p);
        req.getSession().setAttribute("carro", carro);
        
        return "redirect:venta";
    }
    
    @RequestMapping(value="/venta",method = RequestMethod.GET)
    public String venta(Model model, HttpServletRequest req) {
        
        ProductoDAO productoDAO = new ProductoDAO();
           
        model.addAttribute("productos", productoDAO.listar());
        return "venta";
        
    }
    
    
    @RequestMapping(value="/remove", method = RequestMethod.GET)
    public String remove(Model model, HttpServletRequest req,
            @RequestParam("codigo") int codigo) {
            
        CarroCompra carro = new CarroCompra();
        
        if(req.getSession().getAttribute("carro")!=null) {
            carro = (CarroCompra)req.getSession().getAttribute("carro");
        }
        
        carro.eliminar(codigo);
        
        return "redirect:venta";
    }
    
    @RequestMapping(value="/boucher", method = RequestMethod.GET)
    public String boucher(Model model, HttpServletRequest req) {
        
        CarroCompra carro = new CarroCompra();
        
        if(req.getSession().getAttribute("carro")!=null) {
            carro = (CarroCompra)req.getSession().getAttribute("carro");
        }
        
        model.addAttribute("monto", carro.totalCompra());
        
        return "boucher";
        
    }
        

}
