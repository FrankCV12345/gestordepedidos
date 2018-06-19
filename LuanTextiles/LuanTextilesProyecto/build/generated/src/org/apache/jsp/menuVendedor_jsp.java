package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class menuVendedor_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<div id=\"contenedor-items-menu-sistema\">\n");
      out.write("    <div class=\"items-menu-sistema\" style=\"height:70px;\">                     \n");
      out.write("                     <div onclick=\"DespliegaCS()\">\n");
      out.write("                         <!--LOGO USUARIO-->\n");
      out.write("                    ");
 HttpSession login =  request.getSession();
                    if(login.getAttribute("UsuPrueba")!=null){
                     out.println("<h4>"+login.getAttribute("UsuPrueba")+"</h4>");
                            }
                    else{
                      response.sendRedirect("http://localhost:8090/LuanTextilesProyecto/index.html");
                     
                    }
                            
      out.write("\n");
      out.write("                     </div> \n");
      out.write("                     <div id=\"cerrarsesion\"><a href=\"cerrar.jsp\">CERRAR SESIÓN </a></div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"items-menu-sistema\">\n");
      out.write("                    <div onclick=\"Despliega('ventana-registrar','padre-ventanas')\">\n");
      out.write("                    <!--INGRESAR NUEVO PEDIDO-->\n");
      out.write("                    <img src=\"img/logos/003-new-file.png\" alt=\"\"/>\n");
      out.write("                    </div>                          \n");
      out.write("                </div>\n");
      out.write("                <div class=\"items-menu-sistema\">\n");
      out.write("                    <div onclick=\"Despliega('ventana-modificar','padre-ventanas')\">\n");
      out.write("                        <!--MODIFICAR PEDIDO-->\n");
      out.write("                        <img src=\"img/logos/001-file.png\" alt=\"\"/>\n");
      out.write("                    </div>                        \n");
      out.write("                </div> \n");
      out.write("                <div class=\"items-menu-sistema\">\n");
      out.write("                    <div>\n");
      out.write("                        <!--BUSCAR PEDIDO-->\n");
      out.write("                        <a href=\"listar.jsp\"><img src=\"img/logos/002-search.png\" alt=\"\"/></a>\n");
      out.write("                    </div>                        \n");
      out.write("                </div> \n");
      out.write("                <div class=\"items-menu-sistema\">\n");
      out.write("                    <div onclick=\"Despliega('ventana-eliminar','padre-ventanas')\" >\n");
      out.write("                        <!--ELIMINAR REGISTRO DE PEDIDO-->\n");
      out.write("                        <img src=\"img/logos/004-delete.png\" alt=\"\"/>\n");
      out.write("                    </div>                        \n");
      out.write("                </div>                \n");
      out.write("                </div>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
