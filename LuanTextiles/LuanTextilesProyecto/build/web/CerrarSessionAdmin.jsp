<%-- 
    Document   : CerrarSessionAdmin
    Created on : 16/07/2018, 09:48:29 AM
    Author     : SARA
--%>

<%
      request.getSession().invalidate();
       response.sendRedirect("/LuanTextilesProyecto/LoginAdmin.html");   
%>
