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

/**
 *
 * @author SARA
 */
@WebServlet(urlPatterns = {"/ServletListarUsuario"})
public class ServletListarUsuario extends HttpServlet {

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
           int id_usu = Integer.parseInt(request.getParameter("id_usu"));
             LnAdmin ln = new LnAdmin();
             EntidadUsuario usu = ln.BuscaUsuario(id_usu);
              out.println("<table>");
              out.println("<tr><th>NOMBRE</th><th>APELLIDOS</th><th>USUARIO</th><th>PUESTO</th><th>TELEFONO</th><th>ID</th><th>ESTADO</th><th>ID ADMIN</th><th>CONTRASEÑA</th></tr>");
              out.println("<tr>");
              out.println("<td class='efecto' id='nombre'>"+usu.getNombres()+"</td>");
              out.println("<td class='efecto' id='apellidos'>"+usu.getApellidos()+"</td>");
              out.println("<td class='efecto' id='nombusu'>"+usu.getUsuario()+"</td>");
              out.println("<td class='efecto' id='puesto'>"+usu.getPuesto()+"</td>");
               out.println("<td class='efecto' id='telefono'>"+usu.getTelefono()+"</td>");
               out.println("<td id='id_usuario'>"+usu.getId()+"</td>");
               out.println("<td class='efecto' id='estado'>"+usu.getEstado()+"</td>");
               out.println("<td>"+usu.getIdAdmin()+"</td>");
               out.println("<td class='efecto' id='contra'>"+usu.getPassword()+"</td>");
                out.println("</tr>");
              out.println("</table>");
             
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
