<%-- 
    Document   : listar
    Created on : 06/06/2018, 07:10:13 PM
    Author     : SARA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="LogicaDeNegocio.LNPedido"%>
<%@page import="Entidades.EntidadPedidos"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>listar</title>
    </head>
    <body>
        <%
            try{
            LNPedido pedidos = new LNPedido();
             
             List<EntidadPedidos> Listapedidos = pedidos.obtenerLista();
        %>
        <table>
             <%
            for(EntidadPedidos pedido:Listapedidos){
            %>
            <tr>
            <td> <%=pedido.getNombreCliente() %> </td>
            <td> <%=pedido.getIdPedido() %> </td>
            <td> <%=pedido.getFechaIngreso() %>  </td>
            <td> <%=pedido.getTotal() %> </td>
            </tr>
            <% }  %>
        </table>
            <%   }        
             catch(Exception e){%>
             <h1>algo salio mal </h1>
             <%}%>
       
    </body>
</html>
