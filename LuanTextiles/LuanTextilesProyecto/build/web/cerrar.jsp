<%-- 
    Document   : cerrar
    Created on : 19/06/2018, 02:17:07 PM
    Author     : SARA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
       request.getSession().invalidate();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> SESIÓN CERRADA</h1>
        <a href="/LuanTextilesProyecto/index.html">click aqui para regresar al login</a>
    </body>
</html>
