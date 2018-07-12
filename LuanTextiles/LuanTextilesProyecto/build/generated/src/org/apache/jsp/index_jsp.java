package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidades.EntidadUsuario;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\n");
      out.write("<!--\n");
      out.write("To change this license header, choose License Headers in Project Properties.\n");
      out.write("To change this template file, choose Tools | Templates\n");
      out.write("and open the template in the editor.\n");
      out.write("-->\n");
      out.write(" \n");
 EntidadUsuario usuario = (EntidadUsuario) session.getAttribute("usuario");
       if(usuario == null){
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>LOGIN-USUARIO</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link href=\"EstiloLuan.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Cairo\" rel=\"stylesheet\">\n");
      out.write("       <script src=\"LuanJs.js\" type=\"text/javascript\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"contenedor-login\">\n");
      out.write("        <div id=\"cont-logo\">\n");
      out.write("            <img src=\"img/logos/IMGSGP.png\" alt=\"\" id=\"logotipo\"/>\n");
      out.write("        </div>\n");
      out.write("            <div  id=\"contenedor-frmlogin\">\n");
      out.write("                <form action=\"/LuanTextilesProyecto/ServletValidaLogin\" method=\"get\">\n");
      out.write("                    <input type=\"text\" placeholder=\"ingrese usuario\" required name=\"usu\">\n");
      out.write("                    <input type=\"password\" placeholder=\"ingrese contraseÃ±a\" required name=\"contra\">\n");
      out.write("                    <div>\n");
      out.write("                        <input type=\"submit\" value=\"INGRESAR\">\n");
      out.write("                        <input type=\"reset\" value=\"LIMPIAR\" id=\"btnLimpiar\" >\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");

    }
    else{
             response.sendRedirect("/LuanTextilesProyecto/MenuSistema.jsp"); 
            }

      out.write('\n');
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
