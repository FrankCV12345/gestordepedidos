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
import static Datos.BDconexion.msg;
import java.util.List;
/**
 *
 * @author SARA
 */
@WebServlet(urlPatterns = {"/ServletListaPorFecha"})
public class ServletListaPorFecha extends HttpServlet {

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
                    String  fecha = request.getParameter("fecha");
               LnAdmin ln = new LnAdmin();
               
              List<EntidadVentasPorFecha> lista = ln.ListaVentasPorFecha(fecha);
              double total =0.0;
                 out.println("<table style='font-size :12px;'>");
                  out.println("<tr><th>ID PEDIDO</th><th>CATEGORIA</th><th>DETALLE</th><th>FECHA ENTREGA</th><th>UNIDADES</th><th>PRECIO UNIT</th><th>ESTADO</th><th>SUB TOTAL</th></tr>");
              for(EntidadVentasPorFecha v :lista ){
                   out.println("<tr>");
                    out.println("<td>"+v.getIdpadre()+"</td>"); 
                    out.println("<td>"+v.getCategoria()+"</td>");
                    out.println("<td>"+v.getDetalle()+"</td>");
                    out.println("<td>"+ v.getFecha_entrega().substring(0, 10)+"</td>");
                    out.println("<td>"+v.getUnidades()+"</td>");
                    out.println("<td>"+v.getPrecio_unitario()+"</td>");
                    out.println("<td>"+v.getEstado()+"</td>");
                    out.println("<td>"+v.getSubTotal()+"</td>");
                   out.println("</tr>"); 
                   total = total +v.getSubTotal();
              }
              out.println("</table>");
              out.println("<label style='color:black;padding:2px;'> TOTAL S/"+total+"</label>");
           
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
