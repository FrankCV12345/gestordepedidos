<div id="contenedor-items-menu-sistema">
                    <div class="items-menu-sistema" style="height:70px;">
                    <div>
                    <!--INGRESAR NUEVO PEDIDO-->
                    <% HttpSession login =  request.getSession();
                    if(login.getAttribute("UsuPrueba")!=null){
                     out.println("<h5>"+login.getAttribute("UsuPrueba")+"</h5>");
                            }
                    else{
                      response.sendRedirect("/LuanTextilesProyecto/index.html");
                    }
                            %>
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
                    <div>
                        <!--BUSCAR PEDIDO-->
                        <a href="listar.jsp"><img src="img/logos/002-search.png" alt=""/></a>
                    </div>                        
                </div> 
                <div class="items-menu-sistema">
                    <div onclick="Despliega('ventana-eliminar','padre-ventanas')" >
                        <!--ELIMINAR REGISTRO DE PEDIDO-->
                        <img src="img/logos/004-delete.png" alt=""/>
                    </div>                        
                </div>                
                </div>
