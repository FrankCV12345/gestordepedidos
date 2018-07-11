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
@WebServlet(urlPatterns = {"/ServletListaryBuscar"})
public class ServletListaryBuscar extends HttpServlet {

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
            int ID = Integer.parseInt( request.getParameter("RegistroPadreID"));
             LNPedido lnpe = new LNPedido();          
            List<EntidadPedidos> lstpedido = lnpe.listaPedidos(ID);
            LnPedidoHijo lnpeHijo = new LnPedidoHijo();
            List<EntidadPedidoHijo> lstpedidoHijo = lnpeHijo.ListaPedidoHijo(ID);
              out.println("<table>");
              
              for(EntidadPedidos p :lstpedido ){
                   out.println("<tr><th>Nombre</th><th>ID pedido</th><th>Fecha de registro</th><th>Usuario</th><th>Estado</th></tr>");
                  out.println("<tr>");
                out.println("<td><h3 id='nomcli' class='efecto'>"+p.getNombreCliente()+" </h3></td>");
                out.println("<td><h3 id='IDPadre'>"+p.getIdPedido()+" </h3></td>");
                out.println("<td><h3>"+p.getFechaIngreso()+" </h3></td>");
                out.println("<td><h3>"+p.getIdUsuario()+" </h3></td>");
                out.println("<td><h3 id='estado'>"+p.getEstado()+" </h3></td>");
                out.println("</tr>");
            }
              out.println("<tr><th><h3>Categoria</h3></th><th><h3>Pre Unitario</h3></th><th><h3>Unidades</h3></th><th><h3>ID Detalle</h3></th><th><h3>ID Pedido</h3></th><th><h3>Fecha entrega</h3><th><h3>Detalles</h3></th><th><h3>Sub Total</h3></th><th><h3>Estado</h3></th></tr>");
            for(EntidadPedidoHijo p: lstpedidoHijo){
                out.println("<tr>");
                out.println("<td><h3 class='categoria efecto'>"+p.getCategoria()+" </h3></td>");
                out.println("<td><h3 class='PreUni efecto'>"+p.getPreciounitario()+" </h3></td>");
                out.println("<td><h3 class='Uni efecto'>"+p.getUnidades()+" </h3></td>");
                out.println("<td><h3 class='IdHijo'>"+p.getId_pedidos_hijo()+" </h3></td>");
                out.println("<td><h3>"+p.getId_pedidos_padre()+" </h3></td>");
                out.println("<td><h3 class='fecha efecto' >"+p.getFecha_entrega()+" </h3></td>");
                out.println("<td><h5 class='detalle efecto'>"+p.getDetalles()+" </h5></td>");
                out.println("<td><h3>"+p.getSubtotal()+" </h3></td>");
                 if(p.getEstado().equals("1")){
                out.println("<td><h3 class='estadoP efecto' style='background-color:#4267B2;'>"+p.getEstado()+" </h3></td>");
                  }else{
                  out.println("<td><h3 class='estadoP efecto'>"+p.getEstado()+" </h3></td>");
                 }
                out.println("</tr>");             
            }
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
