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
import udu.usa.laboratorio.modelo.Categoria;

/**
 *
 * @author Isabel-Fabian
 */
public class CategoriaServlet extends HttpServlet {
    private static String INSERT_OR_EDIT = "categorias.jsp";
  
       

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
       
        String forward="INSERT_OR_EDIT";
        String action = request.getParameter("action");
        if(action != null){ 
        if (action.equalsIgnoreCase("delete")){
            String txtCategoria = request.getParameter("categoria");
            
            if(txtCategoria != null){
               servicio.deleteCategoria(Integer.parseInt(txtCategoria));
               forward = INSERT_OR_EDIT;
                request.setAttribute("OK", true);    
            }else{
               request.setAttribute("OK", false);    
            }
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            String txtCategoria = request.getParameter("categoria");
            Categoria categoria = servicio.getCategoria(Integer.parseInt(txtCategoria));
            request.setAttribute("categoria", categoria);
        }  else {
            forward = INSERT_OR_EDIT;
        }
      }
      request.setAttribute("categorias", servicio.findAllCategoria());
      RequestDispatcher view = request.getRequestDispatcher("categorias.jsp");
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
         
          String txtCategoria=request.getParameter("categoria");
          
          //Falta validar que este completa
          Categoria categoria = new Categoria();
          categoria.setNombre(txtCategoria);
          
          if(request.getParameter("id")!=null){
            categoria.setId(Integer.parseInt(request.getParameter("id")));
            boolean respuesta = servicio.updateCategoria(categoria);
            if(respuesta)
              request.setAttribute("OK", true);    
            else
             request.setAttribute("OK", false);    
          
          }else{
            boolean respuesta = servicio.saveCategoria(categoria);
          if(respuesta)
             request.setAttribute("OK", true);    
          else
             request.setAttribute("OK", false);    
          }
          
          
      
          request.removeAttribute("categorias");
          request.setAttribute("categorias", servicio.findAllCategoria());
          
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
