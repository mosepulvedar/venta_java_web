<%-- 
    Document   : agregar_producto
    Created on : 23-10-2018, 15:27:46
    Author     : moises
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar producto</title>
        <jsp:include page="include_css.jsp"></jsp:include>
    </head>
    <body>
        <jsp:include page="navegacion.jsp"></jsp:include>
        
        <div class="container">
            <h1>Agregar Producto</h1>
            
            <form action="save-producto" method="post">
                
                <label>Nombre</label>
                <input type="text" name="txtNombre" class="form-control">
                <br>
                <label for="">Precio</label>
                <input type="number" name="txtPrecio" id="txtPrecio" class="form-control">
                <br>
                <label for="">Categoria</label>
                <select name="cboCategoria" id="cboCategoria" class="form-control">
                    <option value="">Seleccionar</option>
                    <c:forEach var="c" items="${categorias}">
            <option value="${c.getId()}">${c.getNombre()}</option>
                    </c:forEach>
                </select>
                
                <br>
                <label for="">Stock</label>
                <input type="number" name="txtStock" id="txtStock" class="form-control">
                <br>
                <input type="submit" value="Guardar" class="btn btn-success">
            </form>
            
        </div>
        
        
        <h3>${mensaje}</h3>
        
    </body>
</html>
