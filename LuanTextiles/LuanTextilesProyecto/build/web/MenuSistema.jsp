<%-- 
    Document   : MenuSistema
    Created on : 12/05/2018, 09:56:51 PM
    Author     : SARA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Entidades.EntidadUsuario"%>
<% /*HttpSession login =  request.getSession();*/
    EntidadUsuario usuario = (EntidadUsuario)session.getAttribute("usuario");
    if(usuario!=null){%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MENU SISTEMA</title>
        <link href="EstiloLuan.css" rel="stylesheet" type="text/css"/>
         <link href="https://fonts.googleapis.com/css?family=Cairo" rel="stylesheet">
          <!--<script src="LuanJs.js" type="text/javascript"></script>-->
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script>
          $(document).ready(function(){
          $("#btnregistrar").click(function(){
              var nomCli = $("#nomCli").val();
              var total =  $("#totaljsp").val();
               $.get("/LuanTextilesProyecto/ServletRegistrar",{nomCli,total}, function(data, status){
                 alert("Data: " + data + "\nStatus: " + status);
                });
             });
           });
        </script>
    </head>
    <body>
        <div id="app">
            <div id="contenerdor-padre">
                <!--
                
                Menu
                -->
                <jsp:include page="menuVendedor.jsp"/> 
                <div id="contenido">
                    <div class="contenido-hijo"> 
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 1</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 2</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 3</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 4</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 5</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 6</h1>
                    </div>
                     <div class="pedidos-contenido">
                        <h1>PEDIDO 1</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 2</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 3</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 4</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 5</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 6</h1>
                    </div>
                     <div class="pedidos-contenido">
                        <h1>PEDIDO 1</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 2</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 3</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 4</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 5</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 6</h1>
                    </div>
                     <div class="pedidos-contenido">
                        <h1>PEDIDO 1</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 2</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 3</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 4</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 5</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 6</h1>
                    </div>
                     <div class="pedidos-contenido">
                        <h1>PEDIDO 1</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 2</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 3</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 4</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 5</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 6</h1>
                    </div>
                     <div class="pedidos-contenido">
                        <h1>PEDIDO 1</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 2</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 3</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 4</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 5</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 6</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 1</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 2</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 3</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 4</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 5</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 6</h1>
                    </div>
                     <div class="pedidos-contenido">
                        <h1>PEDIDO 1</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 2</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 3</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 4</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 5</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 6</h1>
                    </div>
                     <div class="pedidos-contenido">
                        <h1>PEDIDO 1</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 2</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 3</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 4</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 5</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 6</h1>
                    </div>
                     <div class="pedidos-contenido">
                        <h1>PEDIDO 1</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 2</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 3</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 4</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 5</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 6</h1>
                    </div>
                     <div class="pedidos-contenido">
                        <h1>PEDIDO 1</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 2</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 3</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 4</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 5</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 6</h1>
                    </div>
                     <div class="pedidos-contenido">
                        <h1>PEDIDO 1</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 2</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 3</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 4</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 5</h1>
                    </div>
                    <div class="pedidos-contenido">
                        <h1>PEDIDO 6</h1>
                    </div>
                   </div>
                   <div class="padre-ventanas" >
                       <!--
                       ventana Registrar
                       -->
                       <jsp:include page="frmRegistrar.jsp"/> 
                        <!--
                       ventana Modificar
                       -->
                       <jsp:include page="frmModificar.jsp"/>  
                        <!--
                       ventana Eliminar
                       -->
                       <jsp:include page="frmEliminar.jsp"/>  
                      
                   </div>
                </div>
            </div>
        </div>
                      
          <script src="LuanJs.js" type="text/javascript"></script>
    </body>
</html>
 <%}
  else{ response.sendRedirect("/LuanTextilesProyecto/index.html");}
 %>
