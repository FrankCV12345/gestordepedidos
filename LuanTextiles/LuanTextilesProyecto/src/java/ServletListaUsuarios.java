/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Entidades.*;
import LogicaDeNegocio.*;
import java.util.List;
/**
 *
 * @author SARA
 */
@WebServlet(urlPatterns = {"/ServletListaUsuarios"})
public class ServletListaUsuarios extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           try{
                LnAdmin ln = new LnAdmin();
             List<EntidadUsuario> ListaUsuarios = ln.ListarUsuarios();
              out.println("<table>");
              out.println("<tr><th>NOMBRE</th><th>APELLIDOS</th><th>NOMBRE USUARIO</th><th>PUESTO</th><th>TELEFONO</th><th>ID</th><th>ID ADMIN</th><th>ESTADO</th></tr>");
              for(EntidadUsuario usu :ListaUsuarios){
                  out.println("<tr>");
                out.println("<td>"+usu.getNombres()+"</td>");
                out.println("<td>"+usu.getApellidos()+"</td>");
                out.println("<td>"+usu.getUsuario()+"</td>");
                out.println("<td>"+usu.getPuesto()+"</td>");
                out.println("<td>"+usu.getTelefono()+"</td>");
                out.println("<td>"+usu.getId()+"</td>");
                out.println("<td>"+usu.getIdAdmin()+"</td>"); 
                out.println("<td>"+usu.getEstado()+"</td>");
                out.println("</tr>");
              }
              out.println("</table>");
            }catch(Exception e){
                out.println(e);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
