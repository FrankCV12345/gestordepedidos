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
import static Datos.BDconexion.msg;
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
             int  idUsus = 5;
            LnAdmin ln = new LnAdmin();
             List<EntidadListaVentasUsuario> listaVEntas =  ln.ListaVentasPorUsuario(idUsus);
             Double total =0.0;
             out.println("<table>");
             out.println("<tr><td>ID PEDIDO</td><td>CATEGORIA</td><td>UNIDADES</td><td>PRECIO UNITARIO</td><td>DETALLES</td><td>SUBTOTAL</td></tr>");
              for(EntidadListaVentasUsuario v :listaVEntas ){
                  out.println("<tr>");
                  out.println("<td>"+v.getId_padre()+"</td>");
                  out.println("<td>"+v.getCategoria()+"</td>");
                  out.println("<td>"+v.getUnidades()+"</td>");
                  out.println("<td>"+v.getPrecio_unitario()+"</td>");
                  out.println("<td>"+v.getDetalle()+"</td>");
                  out.println("<td>"+v.getSubTotal()+"</td>");
                  out.println("</tr>");
                  total =total +v.getSubTotal();
              }
              out.println("</table>");
              out.println("<label  name='total' class='lbl-A'> TOTAL S/"+total+"</label>");
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
