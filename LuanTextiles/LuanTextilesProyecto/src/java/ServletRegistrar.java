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
/**
 *
 * @author SARA
 */
@WebServlet(urlPatterns = {"/ServletRegistrar"})
public class ServletRegistrar extends HttpServlet {

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
            /*out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletRegistrar</title>");            
            out.println("</head>");
            out.println("<body>");
               
            out.println("<h1> HOLA </h1>");*/
             
              Date FechaActual = new Date();    
              
             LNPedido lnpedido  = new LNPedido();
           
             String nombreCliente = request.getParameter("nomCli");
            
             int total = Integer.parseInt(request.getParameter("total"));
           
             
             /* pedidos hijo
             String[] categoria = request.getParameterValues("categoriacbx");
             String[] unidades = request.getParameterValues("unidades");
             String[] preciounitario = request.getParameterValues("precioUni");
             String[] fecha = request.getParameterValues("fechaEntrega");
             String[] detalle = request.getParameterValues("detalles");
             String[] subtotal = request.getParameterValues("subTotal");*/
             
             
             if(nombreCliente!="" && total!=0 ){
             EntidadPedidos pedido = new EntidadPedidos(nombreCliente,total);           
             lnpedido.Registrar(pedido);
                  out.println("si se registro");
             }
             else{
                 out.println(" no se registro");
             }
             
         
               
              
            
              /*out.println("<h1>----------------------------------------</h1>");
             out.println("<h1>"+unidades.length+"</h1>");
             int longitud= unidades.length;
             for (int  i=0; i< longitud;i++){
             out.println("<h3> categoria :"+categoria[i]+"</h3>");
             out.println("<h3> unidades :"+unidades[i]+"</h3>");
             out.println("<h3>preciounitario :"+preciounitario[i]+"</h3>");
             out.println("<h3> fecha :"+fecha[i]+"</h3>");
             out.println("<h3> detalle :"+detalle[i]+"</h3>");
             out.println("<h3>subtotal :"+subtotal[i]+"</h3>");
             }
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
