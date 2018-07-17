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
                 location.reload();
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
                    
                   $.get("/LuanTextilesProyecto/ServletListaryBuscar",{RegistroPadreID}, function(data){
                           $("#modlaPedidoHijo").html(data);
                     });
                  });
                  
                  
                  $("#btnBuscar").click(function(){
                    var RegistroPadreID = $("#IdPedidoPadre").val();  
                    $.get("/LuanTextilesProyecto/ServletListaryBuscar",{RegistroPadreID},function(data){
                            $("#caja-pedido").html(data); 
                       });
                    });
                    $("#btnBuscarB").click(function(){
                    var RegistroPadreID = $("#IdPedidoPadreB").val();  
                    $.get("/LuanTextilesProyecto/ServletListaryBuscar",{RegistroPadreID},function(data){
                            $("#caja-pedidoB").html(data); 
                       });
                    });
                    
                $("body").on('click','#nomcli',function(){
                    var  nombre = prompt("Ingrese nuevo nombre", "nuevo nombre");
                    var  IdPadre =parseInt($("#IDPadre").text());
                        if(!isNaN(nombre) || nombre >= 0 || nombre <= 0){
                           alert("no ingreso un nombre ");
                        }
                        else{
                        $.get("/LuanTextilesProyecto/ServletModificaPedidoPadre",{nombre,IdPadre},function(data){
                         alert(data); 
                          location.reload();
                           }); 
                         } 
                    });
                     $("body").on('click','#estado',function(){
                    var  estado = prompt(" 0 : en espera , 1 : entregado", "solo ingrese 0 / 1");
                    var  IdPadre =parseInt($("#IDPadre").text());
                        if(isNaN(estado) || estado > 1 || estado < 0){
                           alert("no ingreso un estado ");
                        }
                        else{
                        $.get("/LuanTextilesProyecto/ServletCambiaEstadoPedido",{estado,IdPadre},function(data){
                         alert(data); 
                          location.reload();
                           }); 
                         } 
                    });
                $("body").on('click',".categoria",function(){
                      var campo1 = prompt("ingrese  nueva categoria","nueva categoria");
                      var definidor = 0;
                     var indice = $(".categoria").index(this) ;
                      var valorIdHijo = $(".IdHijo");
                      valorIdHijo =   valorIdHijo[indice].innerText;
                       if(!isNaN(campo1)){
                           alert("no ingreso una categoria ");
                        }
                        else{
                      $.get("/LuanTextilesProyecto/ServletModificaPedidohijo",{definidor ,valorIdHijo,campo1},function(data){
                          alert(data);
                           location.reload();
                      });
                         }
                });
                
                  $("body").on('click',".PreUni",function(){
                      var campo1 = prompt("ingrese nuevo precio","nuevo precio unitario");
                       var definidor = 1;
                      var indice = $(".PreUni").index(this) ;
                      var valorIdHijo = $(".IdHijo");
                      valorIdHijo =   valorIdHijo[indice].innerText;
                      if(isNaN(campo1)){
                           alert("no ingreso un numero   ");
                        }
                        else{
                      $.get("/LuanTextilesProyecto/ServletModificaPedidohijo",{definidor ,valorIdHijo,campo1},function(data){
                          alert(data);
                           location.reload();
                      });
                      }
                });
                $("body").on('click',".Uni",function(){
                      var campo1 = prompt("ingrese unidades","unidades");
                      var definidor =2;
                      var indice = $(".Uni").index(this) ;
                      var valorIdHijo = $(".IdHijo");
                      valorIdHijo =   valorIdHijo[indice].innerText;
                      if(isNaN(campo1)){
                           alert("no un numero");
                        }
                        else{
                      $.get("/LuanTextilesProyecto/ServletModificaPedidohijo",{definidor ,valorIdHijo,campo1},function(data){
                          alert(data);
                           location.reload();
                      });
                      }
                });
                 $("body").on('click',".fecha",function(){
                      var campo1 = prompt("ingrese nueva fecha","DD/MM/AAAA");
                       var definidor = 3;
                      var indice = $(".fecha").index(this) ;
                      var valorIdHijo = $(".IdHijo");
                      valorIdHijo =   valorIdHijo[indice].innerText;
                      if(campo1 === null){
                           alert("no ingreso una fecha");
                        }
                        else{
                      $.get("/LuanTextilesProyecto/ServletModificaPedidohijo",{definidor ,valorIdHijo,campo1},function(data){
                          alert(data);
                           location.reload();
                      });
                      }
                });
                $("body").on('click',".detalle",function(){
                      var campo1 = prompt("ingrese nuevo detalle","detalle");
                      var definidor = 4;
                      var indice = $(".detalle").index(this) ;
                      var valorIdHijo = $(".IdHijo");
                      valorIdHijo =   valorIdHijo[indice].innerText;
                      if(campo1 === null){
                           alert("no ingreso un detalle");
                        }
                        else{
                      $.get("/LuanTextilesProyecto/ServletModificaPedidohijo",{definidor ,valorIdHijo,campo1},function(data){
                          alert(data);
                           location.reload();
                      });
                      }
                });
                $("body").on("click",".estadoP",function(){
                    var campo1 = prompt("ingrese estado 0/1","0/1");
                    var indice = $(".estadoP").index(this) ;
                    var valorIdHijo = $(".IdHijo");
                    valorIdHijo =   valorIdHijo[indice].innerText;
                    var definidor = 5;
                   
                    if(isNaN(campo1)  || campo1 >1 || campo1 <0){
                        alert(" no valido");
                    }else{
                        $.get("/LuanTextilesProyecto/ServletModificaPedidohijo",{definidor ,valorIdHijo,campo1},function(data){
                          alert(data);
                           location.reload();
                      });
                    }
                    
                   
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
                        <% for(EntidadPedidos p :lstpedido ){
                           String estado = p.getEstado();
                           if(estado.equals("0")){
                           %>
                        <div class="pedidos-contenido">
                        <%  out.println("<h1>"+p.getIdPedido()+"</h1>"); %>
                        </div>
                        <%} else{%>
                        <div class="pedidos-contenido estado">
                        <%  out.println("<h1>"+p.getIdPedido()+"</h1>"); %>
                        </div>
                        <%}%>
                        
                      <%}%>
                      <div id="modlaPedido">
                          <div id="modlaPedidoHijo">
                         
                          </div>
                          <input type="button" value="CERRAR" class="btnMostrarModalP datos-pedido more btn" > 
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
                       ventana bsucar
                       -->
                       <jsp:include page="frmBuscar.jsp"/>  
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
