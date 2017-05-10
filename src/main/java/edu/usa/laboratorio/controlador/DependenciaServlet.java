/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.usa.laboratorio.controlador;

import edu.usa.laboratorio.servicios.ActivoServicio;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import udu.usa.laboratorio.modelo.Dependencia;

/**
 *
 * @author Isabel-Fabian
 */
public class DependenciaServlet extends HttpServlet {
    private static String INSERT_OR_EDIT = "dependencia.jsp";
  
       

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
        ActivoServicio servicio = new ActivoServicio();
       
      
        String action = request.getParameter("action");
        if(action != null){ 
        if (action.equalsIgnoreCase("delete")){
            String txtCategoria = request.getParameter("dependencia");
            
            if(txtCategoria != null){
               servicio.deleteDependencia(Integer.parseInt(txtCategoria));
                request.setAttribute("OK", true);    
            }else{
               request.setAttribute("OK", false);    
            }
        } else if (action.equalsIgnoreCase("edit")){
            String txtCategoria = request.getParameter("dependencia");
            Dependencia dependencia = servicio.getDependencia(Integer.parseInt(txtCategoria));
            request.setAttribute("dependencia", dependencia);
        } 
      }
       request.setAttribute("dependencias", servicio.findAllDependencia());
      RequestDispatcher view = request.getRequestDispatcher("dependencia.jsp");
      view.forward(request, response);
        
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
          
          ActivoServicio servicio = new ActivoServicio();
         
          String txtCategoria=request.getParameter("dependencia");
          
          //Falta validar que este completa
          Dependencia dependencia = new Dependencia();
          dependencia.setNombre(txtCategoria);
          
          if(request.getParameter("id")!=null){
            dependencia.setId(Integer.parseInt(request.getParameter("id")));
            boolean respuesta = servicio.updateDependencia(dependencia);
            if(respuesta)
              request.setAttribute("OK", true);    
            else
             request.setAttribute("OK", false);    
          
          }else{
            boolean respuesta = servicio.saveDependencia(dependencia);
          if(respuesta)
             request.setAttribute("OK", true);    
          else
             request.setAttribute("OK", false);    
          }
          
          
      
          request.removeAttribute("dependencias");
          request.setAttribute("dependencias", servicio.findAllDependencia());
          
        RequestDispatcher view = request.getRequestDispatcher(INSERT_OR_EDIT);
        view.forward(request, response);
        
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
