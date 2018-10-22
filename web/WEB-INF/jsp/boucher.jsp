<%-- 
    Document   : boucher
    Created on : 22-oct-2018, 16:25:48
    Author     : Duoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resumen de la compra</title>
        <jsp:include page="include_css.jsp"></jsp:include>
    </head>
    <body>
        
        <jsp:include page="navegacion.jsp"></jsp:include>
        
        <h1>Total Compra</h1>
        
        <h3>Total: ${monto}</h3>
        
        
    </body>
</html>
