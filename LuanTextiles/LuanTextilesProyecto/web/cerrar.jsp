<%-- 
    Document   : cerrar
    Created on : 19/06/2018, 02:17:07 PM
    Author     : SARA
--%>


<%
       request.getSession().invalidate();
       response.sendRedirect("/LuanTextilesProyecto/index.html");
%>
