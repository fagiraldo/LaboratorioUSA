/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.usa.laboratorio.controlador;

import edu.usa.laboratorio.servicios.ActivoServicio;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import udu.usa.laboratorio.modelo.Activo;

/**
 *
 * @author Isabel-Fabian
 */
public class SearchServlet extends HttpServlet {

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
        if(request.getParameter("activo") != null){
           String activo = request.getParameter("activo");
            if(activo!= null){
                ActivoServicio servicio = new ActivoServicio();
                Activo activoRequerido = servicio.get(activo);
                request.setAttribute("categorias", servicio.findAllCategoria());

                if(activoRequerido != null){
                  request.setAttribute("Activo", activoRequerido);
                }else{
                    request.setAttribute("KO","KO"); 
                    request.setAttribute("busqueda", false);
                }

                RequestDispatcher rd = request.getRequestDispatcher("busqueda.jsp");
                rd.forward(request, response);
            }
          }else if(request.getParameter("nombreActivo") != null){
            String activo = request.getParameter("nombreActivo");
                if(activo!=null){
                  ActivoServicio servicio = new ActivoServicio();
                  List<Activo> activos = servicio.findByName(activo);
                   request.setAttribute("activos", activos);
                    RequestDispatcher rd = request.getRequestDispatcher("buscador.jsp");
                    rd.forward(request, response);
                  
                }else{
                  request.setAttribute("KO","KO");
                }
        
            }else if(request.getParameter("preventivo") != null){
            String txtActivo = request.getParameter("preventivo");
                if(txtActivo!=null){
                  ActivoServicio servicio = new ActivoServicio();
                  Activo activo = servicio.get(txtActivo);
                  
                  if(activo == null)
                      request.setAttribute("busqueda", false);
                  request.setAttribute("activo", activo);
                  
                  RequestDispatcher rd = request.getRequestDispatcher("preventivo.jsp");
                  rd.forward(request, response);
                  
                }else{
                  request.setAttribute("KO","KO");
                }
        
            }else if(request.getParameter("correctivo") != null){
            String txtActivo = request.getParameter("correctivo");
                if(txtActivo!=null){
                  ActivoServicio servicio = new ActivoServicio();
                  Activo activo = servicio.get(txtActivo);
                  
                  if(activo == null)
                      request.setAttribute("busqueda", false);
                  request.setAttribute("activo", activo);
                  
                  RequestDispatcher rd = request.getRequestDispatcher("correctivo.jsp");
                  rd.forward(request, response);
                  
                }else{
                  request.setAttribute("KO","KO");
                }
        
            }
            else{
              request.setAttribute("KO","KO");
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
