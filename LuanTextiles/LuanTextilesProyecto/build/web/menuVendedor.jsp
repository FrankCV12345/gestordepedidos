<%@page import="Entidades.EntidadUsuario"%>
<div id="contenedor-items-menu-sistema">
    <div class="items-menu-sistema" style="height:70px;">                     
                     <div onclick="DespliegaCS()">
                         <!--LOGO USUARIO-->
                    <%  EntidadUsuario usuario = (EntidadUsuario)session.getAttribute("usuario");
                        out.println("<h4>"+usuario.getNombres()+"</h4>");  %>
                     </div> 
                     <div id="cerrarsesion">
                         <a href="cerrar.jsp">CERRAR SESIÓN </a>                         
                     </div>
                </div>
                <div class="items-menu-sistema">
                    <div onclick="Despliega('ventana-registrar','padre-ventanas')">
                    <!--INGRESAR NUEVO PEDIDO-->
                    <img src="img/logos/003-new-file.png" alt=""/>
                    </div>                          
                </div>
                <div class="items-menu-sistema">
                    <div onclick="Despliega('ventana-modificar','padre-ventanas')">
                        <!--MODIFICAR PEDIDO-->
                        <img src="img/logos/001-file.png" alt=""/>
                    </div>                        
                </div> 
                <div class="items-menu-sistema">
                    <div onclick="Despliega('ventana-buscar','padre-ventanas')">
                        <!--BUSCAR PEDIDO-->
                        <img src="img/logos/002-search.png" alt=""/>
                    </div>                        
                </div> 
                <div class="items-menu-sistema">
                    <div onclick="Despliega('ventana-eliminar','padre-ventanas')" >
                        <!--ELIMINAR REGISTRO DE PEDIDO-->
                        <img src="img/logos/004-delete.png" alt=""/>
                    </div>                        
                </div>                
                </div>
