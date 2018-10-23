<%-- 
    Document   : listar_productos
    Created on : 23-10-2018, 16:05:14
    Author     : moises
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar productos</title>
        <jsp:include page="include_css.jsp"></jsp:include>
    </head>
    <body>
    <jsp:include page="navegacion.jsp"></jsp:include>
    <div class="container">
        <h1>Listar productos</h1>
        
        <table class="table table-striped">
            <tr>
                <th>Nombre</th>
                <th>Precio</th>
                <th>Stock</th>
                <th>Categoria</th>
                <th>Opciones</th>
            </tr>
            <c:forEach items="${productos}" var="p">
                <tr>
                    <td>${p.getNombre()}</td>
                    <td>${p.getPrecio()}</td>
                    <td>${p.getStock()}</td>
                    <td>${p.getCategoria().getNombre()}</td>
                    <td>
                        <a class="btn btn-danger" href="eliminar-producto?id=${p.getId()}">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <h3>${mensaje}</h3>
        </div>
    </body>
</html>
