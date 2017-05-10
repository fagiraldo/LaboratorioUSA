/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.usa.laboratorio.controlador;

import edu.usa.laboratorio.servicios.PersonaServicio;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import udu.usa.laboratorio.modelo.Auxiliar;
import udu.usa.laboratorio.modelo.Dependencia;
import udu.usa.laboratorio.modelo.Docente;
import udu.usa.laboratorio.modelo.Programa;
import udu.usa.laboratorio.modelo.Usuario;

/**
 *
 * @author Isabel-Fabian
 */
public class PersonaServlet extends HttpServlet {

    

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
         PersonaServicio servicio = new PersonaServicio();
                 
        if(request.getParameter("indexAuxiliar")!=null){
            request.setAttribute("auxiliares", servicio.findAllAuxiliar());
           
            RequestDispatcher view = request.getRequestDispatcher("auxiliar.jsp");
            view.forward(request, response);
        }else if(request.getParameter("indexDocente")!=null){
           request.setAttribute("docentes", servicio.findAllDocente());
           request.setAttribute("dependencias", servicio.findAllDependencias());

            RequestDispatcher view = request.getRequestDispatcher("docente.jsp");
            view.forward(request, response);
        }
        else if(request.getParameter("indexEstudiante")!=null){
            request.setAttribute("estudiantes", servicio.findAllUsuario());
            request.setAttribute("programas", servicio.findAllProgramas());

            RequestDispatcher view = request.getRequestDispatcher("estudiante.jsp");
            view.forward(request, response);
        
        }
        
        String action = request.getParameter("action");
        if(action != null){ 
            if(request.getParameter("auxiliar")!=null){
                if (action.equalsIgnoreCase("delete")){
                    String txtAuxiliar = request.getParameter("auxiliar");

                    if(txtAuxiliar != null){
                       servicio.deleteAuxiliar(Integer.parseInt(txtAuxiliar));
                        request.setAttribute("OK", true);    
                    }else{
                       request.setAttribute("OK", false);    
                    }
                    
                     request.setAttribute("auxiliares", servicio.findAllAuxiliar());
                } else if (action.equalsIgnoreCase("edit")){
                    String txtAuxiliar = request.getParameter("auxiliar");
                    Auxiliar auxiliar = servicio.getAuxiliar(Integer.parseInt(txtAuxiliar));
                    request.setAttribute("auxiliar", auxiliar);
                    request.setAttribute("auxiliares", servicio.findAllAuxiliar());
                }   
                
                  RequestDispatcher view = request.getRequestDispatcher("auxiliar.jsp");
                 view.forward(request, response);
            
            }else if(request.getParameter("docente")!=null){
                if (action.equalsIgnoreCase("delete")){
                    String txtAuxiliar = request.getParameter("docente");

                    if(txtAuxiliar != null){
                       servicio.deleteDocente(Integer.parseInt(txtAuxiliar));
                        request.setAttribute("OK", true);    
                    }else{
                       request.setAttribute("OK", false);    
                    }
                    
                     request.setAttribute("docentes", servicio.findAllAuxiliar());
                     request.setAttribute("dependencias", servicio.findAllDependencias());

                } else if (action.equalsIgnoreCase("edit")){
                    String txtAuxiliar = request.getParameter("docente");
                    Docente auxiliar = servicio.getDocente(Integer.parseInt(txtAuxiliar));
                    request.setAttribute("docente", auxiliar);
                    request.setAttribute("docentes", servicio.findAllDocente());
                    request.setAttribute("dependencias", servicio.findAllDependencias());

                    
                } 
                
                  RequestDispatcher view = request.getRequestDispatcher("docente.jsp");
                view.forward(request, response);

            }else if(request.getParameter("estudiante")!=null){
                if (action.equalsIgnoreCase("delete")){
                    String txtAuxiliar = request.getParameter("estudiante");

                    if(txtAuxiliar != null){
                       servicio.deleteUsuario(Integer.parseInt(txtAuxiliar));
                        request.setAttribute("OK", true);    
                    }else{
                       request.setAttribute("OK", false);    
                    }
                    
                     request.setAttribute("estudiantes", servicio.findAllUsuario());
                     request.setAttribute("programas", servicio.findAllProgramas());

                } else if (action.equalsIgnoreCase("edit")){
                    String txtAuxiliar = request.getParameter("estudiante");
                    Usuario auxiliar = servicio.getUsuario(Integer.parseInt(txtAuxiliar));
                    request.setAttribute("estudiante", auxiliar);
                    request.setAttribute("estudiantes", servicio.findAllUsuario());
                    request.setAttribute("programas", servicio.findAllProgramas());

                    
                }   
            
                RequestDispatcher view = request.getRequestDispatcher("estudiante.jsp");
                view.forward(request, response);
            }
            
          
         
      }
       
    
        
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
        
        //Falta realizar los procesos de validacion 
        String cedula= request.getParameter("cedula");
        String email= request.getParameter("email");
        String nombre = request.getParameter("nombre");
        String apellido= request.getParameter("apellido");
        String telefono= request.getParameter("telefono");
        
        if(request.getParameter("auxiliar")!=null){
             Auxiliar auxiliar = new Auxiliar();
             auxiliar.setCedula(cedula);
             auxiliar.setNombre(nombre);
             auxiliar.setEmail(email);
             auxiliar.setApellido(apellido);
             auxiliar.setTelefono(telefono);
             PersonaServicio servicio = new PersonaServicio();

             if(request.getParameter("id")!=null){
                auxiliar.setId(Integer.parseInt(request.getParameter("id")));
                
                boolean respuesta = servicio.updateAuxiliar(auxiliar);
             
                if(respuesta)
                   request.setAttribute("OK", true);    
                else
                   request.setAttribute("OK", false);    
              
             }else{
                boolean respuesta = servicio.save(auxiliar);
             
                if(respuesta)
                   request.setAttribute("OK", true);    
                else
                   request.setAttribute("OK", false);    

 
             } 
            
            request.setAttribute("auxiliares", servicio.findAllAuxiliar());
          
            
            RequestDispatcher view = request.getRequestDispatcher("auxiliar.jsp");
            view.forward(request, response);
        }else if(request.getParameter("docente")!=null){
            PersonaServicio servicio = new PersonaServicio();
 
            String txtDependencia = request.getParameter("dependencia");
            Dependencia dependencia=servicio.getDependencia(Integer.parseInt(txtDependencia));
            
             Docente docente = new Docente();
             docente.setCedula(cedula);
             docente.setNombre(nombre);
             docente.setEmail(email);
             docente.setApellido(apellido);
             docente.setTelefono(telefono);
             docente.setDependencia(dependencia);
             
             if(request.getParameter("id")!=null){
                docente.setId(Integer.parseInt(request.getParameter("id")));
                
                boolean respuesta = servicio.updateDocente(docente);
             
                if(respuesta)
                   request.setAttribute("OK", true);    
                else
                   request.setAttribute("OK", false);    
              
             }else{
                boolean respuesta = servicio.save(docente);
             
                if(respuesta)
                   request.setAttribute("OK", true);    
                else
                   request.setAttribute("OK", false);    

 
             } 
            
            request.setAttribute("docentes", servicio.findAllDocente());
            request.setAttribute("dependencias", servicio.findAllDependencias());
            
            RequestDispatcher view = request.getRequestDispatcher("docente.jsp");
            view.forward(request, response);
        }else if(request.getParameter("estudiante")!=null){
            PersonaServicio servicio = new PersonaServicio();
 
            String txtPrograma = request.getParameter("programa");
            Programa programa = servicio.getPrograma(Integer.parseInt(txtPrograma));
            
            
             Usuario usuario = new Usuario();
             usuario.setCedula(cedula);
             usuario.setNombre(nombre);
             usuario.setEmail(email);
             usuario.setApellido(apellido);
             usuario.setTelefono(telefono);
             usuario.setPrograma(programa);
             
             if(request.getParameter("id")!=null){
                usuario.setId(Integer.parseInt(request.getParameter("id")));
                
                boolean respuesta = servicio.updateUsuario(usuario);
             
                if(respuesta)
                   request.setAttribute("OK", true);    
                else
                   request.setAttribute("OK", false);    
              
             }else{
                boolean respuesta = servicio.save(usuario);
             
                if(respuesta)
                   request.setAttribute("OK", true);    
                else
                   request.setAttribute("OK", false);    

 
             } 
            
            request.setAttribute("estudiantes", servicio.findAllUsuario());
            request.setAttribute("programas", servicio.findAllProgramas());
            
            RequestDispatcher view = request.getRequestDispatcher("estudiante.jsp");
            view.forward(request, response);
        }
        
        
        
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
