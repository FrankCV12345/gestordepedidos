<%-- 
    Document   : MenuSistema
    Created on : 12/05/2018, 09:56:51 PM
    Author     : SARA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Entidades.EntidadUsuario"%>
<%@page  import="Entidades.*"%> 
<%@page import="LogicaDeNegocio.*"%>
<%@page import="java.util.List"%>

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
                 var indicador = false;
          $("#btnregistrar").click(function(){
             var nomCli = $("#nomCli").val();
             var categoria = $(".cbx");
             var unidades = $(".unidades");
             var precio_unitario = $(".precio-unitario");
             var fecha_entrega =$(".fecha-entrega");
             var detalles = $(".detalles");
             var subTotal = $(".total");
             var canti = subTotal.length;
             var Subtotales = [];var categorias=[];var unidadesArreglo=[];var precios_unitarios=[]; var fechas_entregas =[]; var detallesArreglo=[];
             
                function convertDateFormat(string) {
                  var info = string.split('-');
                  return info[2] + '/' + info[1] + '/' + info[0];
                 }
             for(var  i = 1 ; i <= canti; i++){
                var cont = i-1;
                detallesArreglo[cont]=detalles[cont].value;
                fechas_entregas[cont]=convertDateFormat(fecha_entrega[cont].value);
                precios_unitarios[cont]=precio_unitario[cont].value;
                unidadesArreglo[cont] = unidades[cont].value;
                categorias[cont] = categoria[cont].value;
                Subtotales[cont]=subTotal[cont].value;
       
             }
             
             $.get("/LuanTextilesProyecto/ServletRegistrar",{"detalles[]":detallesArreglo,"FechasEntrega[]":fechas_entregas,"Subtotales[]":Subtotales,"categoria[]":categorias,"unidades[]":unidadesArreglo,"precio_unitario[]":precios_unitarios,nomCli}, function(data, status){
                 alert("Data: " + data + "\nStatus: " + status);
                });
                
             });
             
               $("#btnEliminar").click(function(){
                   var IdRegistro = $("#TxtIdElimina").val();
                 $.get("/LuanTextilesProyecto/ServletElimina",{IdRegistro}, function(data, status){
                 alert("Data: " + data + "\nStatus: " + status);
                });
               });
               
                $(".pedidos-contenido,.btnMostrarModalP").click(function(){
                    var   IdRegistroPadre = $(this).text();
                    var RegistroPadreID = parseInt(IdRegistroPadre);
                   
                    if(indicador === false){
                         $("#modlaPedido").css("display","block");
                         indicador = true;
                     }else{
                         $("#modlaPedido").css("display","none");
                         indicador = false;
                     }
                    
                   $.get("/LuanTextilesProyecto/prueba",{RegistroPadreID}, function(data, status){
                           $("#modlaPedidoHijo").html(data);
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
                        <%
                         LNPedido lnpe = new LNPedido();
                         List<EntidadPedidos> lstpedido = lnpe.ListaTodosLosPedidos();
                        %>
                        <% for(EntidadPedidos p :lstpedido ){%>
                        <div class="pedidos-contenido">
                        <%out.println("<h1>"+p.getIdPedido()+""); %>
                        </div>
                      <%}%>
                      <div id="modlaPedido">
                          <div id="modlaPedidoHijo">
                         
                          </div>
                          <input type="button" value="CERRAR" class="btnMostrarModalP" > 
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
