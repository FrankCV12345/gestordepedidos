<%-- 
    Document   : menuAdmin
    Created on : 07/07/2018, 11:18:36 AM
    Author     : SARA
--%>

<%@page import="Entidades.EntidadAdministrador"%>
<div id="contenedor-items-menu-sistema">
    <div class="items-menu-sistema" style="height:70px;">                     
                     <div onclick="DespliegaCS()">
                         <!--LOGO USUARIO-->
                    <%  EntidadAdministrador admin = (EntidadAdministrador)session.getAttribute("admin");
                        out.println("<h4>"+admin.getNombres()+"</h4>");  %>
                     </div> 
                     <div id="cerrarsesion"><a href="CerrarSessionAdmin.jsp">CERRAR SESIÓN </a></div>
                </div>
                <div class="items-menu-sistema">
                    <div onclick="Despliega('ventana-registrar','padre-ventanas')">
                    <!--INGRESAR NUEVO USER-->
                    <img src="img/logos/admin-icons/add-user.png" alt=""/>
                    </div>                          
                </div>
                <div class="items-menu-sistema">
                    <div onclick="Despliega('ventana-modificar','padre-ventanas')">
                        <!--MODIFICAR USER-->
                        <img src="img/logos/admin-icons/update-user.png" alt="" />
                    </div>                        
                </div> 
                <div class="items-menu-sistema">
                    <div onclick="Despliega('ventana-listar','padre-ventanas')">
                        <!--LISTAR USER-->
                        <img src="img/logos/admin-icons/shared-user.png" alt="" id="MosListaUsuarios"/>
                    </div>                        
                </div> 
                <div class="items-menu-sistema">
                    <div onclick="Despliega('ventana-eliminar','padre-ventanas')" >
                        <!--ELIMINAR USER-->
                        <img src="img/logos/admin-icons/delete-user.png" alt=""/>
                    </div>                        
                </div>                
                </div>
