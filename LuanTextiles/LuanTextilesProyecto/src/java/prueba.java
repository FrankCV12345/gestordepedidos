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
import java.util.Date;
import Entidades.*;
import LogicaDeNegocio.*;
import java.util.List;
/**
 *
 * @author SARA
 */
@WebServlet(urlPatterns = {"/prueba"})
public class prueba extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. 
             out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet prueba</title>");            
            out.println("</head>");
            out.println("<body>");*/
              int ID = Integer.parseInt( request.getParameter("RegistroPadreID"));
             LNPedido lnpe = new LNPedido();          
            List<EntidadPedidos> lstpedido = lnpe.listaPedidos(ID);
            LnPedidoHijo lnpeHijo = new LnPedidoHijo();
            List<EntidadPedidoHijo> lstpedidoHijo = lnpeHijo.ListaPedidoHijo(ID);
              out.println("<table>");
              
              for(EntidadPedidos p :lstpedido ){
                  out.println("<tr>");
                out.println("<td><h3>"+p.getNombreCliente()+" </h3></td>");
                out.println("<td><h3>"+p.getIdPedido()+" </h3></td>");
                out.println("<td><h3>"+p.getFechaIngreso()+" </h3></td>");
                out.println("<td><h3>"+p.getIdUsuario()+" </h3></td>");
                out.println("</tr>");
            }
              
            for(EntidadPedidoHijo p: lstpedidoHijo){
                out.println("<tr>");
                out.println("<td><h3>"+p.getCategoria()+" </h3></td>");
                out.println("<td><h3>"+p.getPreciounitario()+" </h3></td>");
                out.println("<td><h3>"+p.getUnidades()+" </h3></td>");
                out.println("<td><h3>"+p.getId_pedidos_hijo()+" </h3></td>");
                out.println("<td><h3>"+p.getId_pedidos_padre()+" </h3></td>");
                out.println("<td><h3>"+p.getFecha_entrega()+" </h3></td>");
                out.println("<td><h3>"+p.getDetalles()+" </h3></td>");
                out.println("<td><h3>"+p.getSubtotal()+" </h3></td>");
                out.println("</tr>");             
            }
             out.println("</table>");
            
            /*
            out.println("</body>");
            out.println("</html>");*/
        
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
