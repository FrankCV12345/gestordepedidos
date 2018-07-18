<%-- 
    Document   : MenuSistemaAdmin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="Entidades.*"%> 
<%@page import="LogicaDeNegocio.*"%>
<%@page import="java.util.List"%>

<% /*HttpSession login =  request.getSession();*/
    EntidadAdministrador admin = (EntidadAdministrador)session.getAttribute("admin");
    
    if(admin!=null){%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MENU ADMIN</title>
        <link href="EstiloLuan.css" rel="stylesheet" type="text/css"/>
         <link href="https://fonts.googleapis.com/css?family=Cairo" rel="stylesheet">
          <!--<script src="LuanJs.js" type="text/javascript"></script>-->
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
          <script>
            
           $(document).ready(function(){
               var bandera = false;
               var bandera2 = false;
               $("#nomusu").keyup(function(){
                    var nom = $("#nomusu").val();
                     var tamaño = nom.length;
                     if(tamaño>=6){
                         $.get("/LuanTextilesProyecto/ServletVerificaUsuario",{nom},function(data){
                              if(data === "false"){
                                  $("#nomusu").css("background-color","green");
                                    bandera = true;
                              }else{
                                   $("#nomusu").css("background-color","red");
                                    bandera = false;
                              }
                              
                         });
                     }
                    
               });
               $("#contrasenia").keyup(function(){
                   var contra1 = $("#contraseniaA").val();
                   var contra = $("#contrasenia").val();
               
                   if(contra1 === contra  && contra === contra1 ){
                       $("#contrasenia").css("background-color","green");
                        bandera2 = true;
                   }
                   else{
                       $("#contrasenia").css("background-color","red");
                        bandera2 = false;
                   }
                   
               });
                 $("#btnregistrar").click(function(){
                     var nombre = $("#Nombre").val();
                     var apellido = $("#ApellidosUsuario").val();
                     var telefono = $("#telefonoUsuario").val();
                     var nombreUsuario = $("#nomusu").val();
                     var puesto = $("#puestoR").val();
                     var contra = $("#contrasenia").val();
                      if(nombre ==="" || apellido ==="" || telefono ===""|| nombreUsuario ==="" || puesto ===""|| contra ===""){
                           alert("llene todos los datos");
                      }else{
                          if(bandera === true && bandera2 === true){
                        $.get("/LuanTextilesProyecto/ServletRegistraUsuarios",{nombre,apellido,telefono,nombreUsuario,puesto,contra},function(data){
                            alert(data);
                          });
                       }else{
                           alert("datos incorrectos");
                       }
                      }
                 });
                 $("#btnBuscar").click(function(){
                         var id_usu = $("#IdPedidoPadre").val();
                         $.get("/LuanTextilesProyecto/ServletListarUsuario",{id_usu},function(data){
                             $("#caja-pedido").html(data);
                          });
                    
                 });
                 $("body").on("click","#nombre ,#apellidos,#nombusu,#puesto,#telefono,#estado,#contra",function(){
                     var id = $(this).attr("id");
                     var id_usu = parseInt($("#id_usuario").text());
                     var definidor = null;
                      switch(id){
                          case "nombre": definidor = 0;
                              break;
                          case "apellidos":definidor = 1;
                              break;
                          case "nombusu": definidor = 2;
                              break;
                          case "puesto": definidor = 3;
                              break;
                          case "telefono": definidor = 4;
                              break;
                          case "estado": definidor = 5;
                              break;
                          case "contra": definidor = 6;
                              break;
                      }
                      var campo = prompt("ingrese  campo");
                      if(campo===null){
                          alert("no ingreso datos");
                      }
                      else{
                     $.get("/LuanTextilesProyecto/ServletModificarUser",{id_usu,definidor,campo},function(data){
                         alert(data);
                     });
                         }
                 });
                 
                 $("#MosListaUsuarios").click(function(){
                      $.get("/LuanTextilesProyecto/ServletListaUsuarios",{},function(data){
                          $("#lista-users").html(data);
                     });
                 });
                 
                 $("#btnEliminar").click(function(){
                     var iduser = $("#TxtIdElimina").val();
                      $.get("/LuanTextilesProyecto/ServletEliminaUser",{iduser},function(data){
                          alert(data);
                     });
                 });
                 $("#busVentPorUsu").click(function(){
                     var id_usu = $("#idUsuVent").val();
                      id_usu = parseInt(id_usu);
                      $.get("/LuanTextilesProyecto/ServletListaPedidosPorUsuario",{id_usu},function(data){
                          $("#contenedor-lista-ventas-vendedor").html(data);
                      });
                 });
                 
                 
                 $("#busVentPorfecha").click(function(){
                     var fecha = $("#fechaVent").val();
                       function convertDateFormat(string) {
                       var info = string.split('-');
                      return info[2] + '/' + info[1] + '/' + info[0];
                            }
                           fecha = convertDateFormat(fecha);
                    
                      $.get("/LuanTextilesProyecto/ServletListaPorFecha",{fecha},function(data){
                          $("#contenedor-lista-ventas-fecha").html(data);
                      });
                 });
                 
                 $("#busVentPorEstado").click(function(){
                  
                      $.get("/LuanTextilesProyecto/ServletListarPorEstado",{},function(data){
                          $("#contenedor-lista-ventas-estado").html(data);
                        
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
                <jsp:include page="menuAdmin.jsp"/> 
                <div id="contenido">
                    <div class="contenido-hijo"> 
                        <div class="cont-opcionesAdmin">
                            <div class="frm-admin">
                              <div class="opcionesAdmin">
                               BUSCAR VENTAS POR VENDEDOR
                              </div>
                                <form style="text-align: center;">
                                   
                                    <input type="number" placeholder="inrese codigo" class="txtBuscaVent" id="idUsuVent" >
                                    <input type="button" value="BUSCAR" class="btn" id="busVentPorUsu">
                                  
                                </form>
                                <div id="contenedor-lista-ventas-vendedor">
                                    
                                </div>
                            </div>
                            <div class="frm-admin">
                              <div class="opcionesAdmin">
                               VER VENTAS POR FECHA
                              </div>
                                <form style="text-align: center;">
                                   
                                    <input type="date" placeholder="inrese codigo" class="txtBuscaFecha" id="fechaVent" >
                                    <input type="button" value="BUSCAR" class="btn" id="busVentPorfecha">
                                  
                                </form>
                                <div id="contenedor-lista-ventas-fecha">
                                    
                                </div>
                            </div>
                             <div class="frm-admin">
                                 <div class="opcionesAdmin">
                                VER  PENDIENTES
                              </div>
                                <form style="text-align: center;">
                                   
                                    
                                    <input type="button" value="VER" class="btn" id="busVentPorEstado">
                                  
                                </form>
                                <div id="contenedor-lista-ventas-estado">
                                    
                                </div>
                            </div>
                            
                        </div>
                       
                   <div class="padre-ventanas" >
                       <!--
                       ventana Registrar
                       -->
                       <jsp:include page="frmRegistrarUsuario.jsp"/> 
                        <!--
                       ventana Modificar
                       -->
                       <jsp:include page="frmModificar.jsp"/>  
                        <!--
                       ventana listar
                       -->
                        <jsp:include page="divListarUsuarios.jsp"/>  
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
  else{ response.sendRedirect("/LuanTextilesProyecto/LoginAdmin.html");}
 %>

