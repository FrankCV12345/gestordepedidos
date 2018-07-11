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
import javax.servlet.http.HttpSession;
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
            try{
             EntidadUsuario usuario = (EntidadUsuario) request.getSession().getAttribute("usuario");
             LNPedido lnpedido  = new LNPedido();
             String nombreCliente = request.getParameter("nomCli");
             int  idUsuario = usuario.getId();
             /* pedidos hijo*/
             String[] categoria = request.getParameterValues("categoria[]");
             String[] unidades = request.getParameterValues("unidades[]");
             String[] preciounitario = request.getParameterValues("precio_unitario[]");
             String[] fecha = request.getParameterValues("FechasEntrega[]");
             String[] detalle = request.getParameterValues("detalles[]");
             String[] subtotal = request.getParameterValues("Subtotales[]");            
             if(!nombreCliente.equals("") ){
             EntidadPedidos pedido = new EntidadPedidos(nombreCliente,idUsuario);           
             lnpedido.Registrar(pedido);
             LnPedidoHijo ultimoId = new  LnPedidoHijo();
                 int Ultimo = ultimoId.UltimoId();
             int longitud = subtotal.length;
               for(int i = 0; i< longitud ;i++){
                Double subT =Double.parseDouble(subtotal[i]);
                Double PreUnitario = Double.parseDouble(preciounitario[i]);
                int uni = Integer.parseInt(unidades[i]);
                EntidadPedidoHijo pedido_hijo = new EntidadPedidoHijo(categoria[i],uni,Ultimo,PreUnitario,fecha[i],detalle[i],subT);
                LnPedidoHijo lnphijo = new LnPedidoHijo();
                lnphijo.Registrar(pedido_hijo);
               }
                  out.println("si se registro el id de su pedido es :"+Ultimo);
             }
             else{
                 out.println(" no se registro");
             } 
             }catch(Exception e){
              out.println("NO SE PUDO"+e); 
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
