<%-- 
    Document   : venta
    Created on : 22-oct-2018, 15:33:28
    Author     : Duoc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Realizar venta</title>
        <jsp:include page="include_css.jsp"></jsp:include>
        <jsp:include page="navegacion.jsp"></jsp:include>
    </head>
    <body>
        
        <div class="container">
            
        
        <h1>Productos</h1>
        
        <form action="add" method="POST" class="form-inline">
            <label>Producto</label>
            <select name="cboProducto" required="" class="form-control">
                <option value="">Seleccionar</option>
                <c:forEach items="${productos}" var="p">
                    <option value="${p.getId()}">${p.getNombre()}</option>
                </c:forEach>
                <input class="form-control" placeholder="Cantidad" type="number" name="txtCantidad" required>
                <input type="submit" value="Agregar" class="btn btn-secondary">
            </select> 
        </form>
        
        
        <hr>
        <h3>Productos añadidos</h3>
        <table class="table table-striped">
            <tr>
                <th>Codigo</th>
                <th>Nombre</th>
                <th>Precio</th>
                <th>Cantidad</th>
                <th>Total</th>
                <th>Opciones</th>
            </tr>
            <c:forEach var="pro" items="${sessionScope.carro.getProductos()}">
                <tr>
                    <td>${pro.getId()}</td>
                    <td>${pro.getNombre()}</td>
                    <td>${pro.getPrecio()}</td>
                    <td>${pro.getCantidad()}</td>
                    <td>0</td>
                    <td>
                        <a href="remove?codigo=${pro.getId()}">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
            
        </table>
        
        
        <hr>
         
        <div>
            <a href="boucher" class="btn btn-success float-right">Finalizar venta</a>
        </div>
        
        
        </div>
        
    </body>
</html>
