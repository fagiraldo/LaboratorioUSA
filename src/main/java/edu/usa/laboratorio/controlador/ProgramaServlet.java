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
import udu.usa.laboratorio.modelo.Programa;


/**
 *
 * @author Isabel-Fabian
 */
public class ProgramaServlet extends HttpServlet {
    private static String INSERT_OR_EDIT = "programa.jsp";
  
       

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
            String txtPrograma = request.getParameter("programa");
            
            if(txtPrograma != null){
               servicio.deletePrograma(Integer.parseInt(txtPrograma));
                request.setAttribute("OK", true);    
            }else{
               request.setAttribute("OK", false);    
            }
        } else if (action.equalsIgnoreCase("edit")){
            String txtCategoria = request.getParameter("programa");
            Programa programa = servicio.getPrograma(Integer.parseInt(txtCategoria));
            request.setAttribute("programa", programa);
        } 
      }
      request.setAttribute("programas", servicio.findAllPrograma());
      RequestDispatcher view = request.getRequestDispatcher("programa.jsp");
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
         
          String txtPrograma=request.getParameter("programa");
          
          //Falta validar que este completa
          Programa programa = new Programa();
          programa.setNombre(txtPrograma);
          
          if(request.getParameter("id")!=null){
            programa.setId(Integer.parseInt(request.getParameter("id")));
            boolean respuesta = servicio.updatePrograma(programa);
            if(respuesta)
              request.setAttribute("OK", true);    
            else
             request.setAttribute("OK", false);    
          
          }else{
            boolean respuesta = servicio.savePrograma(programa);
          if(respuesta)
             request.setAttribute("OK", true);    
          else
             request.setAttribute("OK", false);    
          }
          
          
      
          request.removeAttribute("programas");
          request.setAttribute("programas", servicio.findAllPrograma());
          
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
