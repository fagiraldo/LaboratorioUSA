/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.usa.laboratorio.controlador;

import edu.usa.laboratorio.servicios.ActivoServicio;
import edu.usa.laboratorio.servicios.PersonaServicio;
import edu.usa.laboratorio.servicios.PrestamoServicio;
import edu.usa.laboratorio.utilidades.Cart;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import udu.usa.laboratorio.modelo.Activo;
import udu.usa.laboratorio.modelo.DetallePrestamo;
import udu.usa.laboratorio.modelo.Docente;
import udu.usa.laboratorio.modelo.Prestamo;
import udu.usa.laboratorio.modelo.Usuario;

/**
 *
 * @author Isabel-Fabian
 */
public class ServletPrestamo extends HttpServlet {

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
            throws ServletException, IOException, ParseException {
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("yyyy-MM-dd");
        request.setAttribute("fecha", hourdateFormat.format(date));
       
        if(request.getParameter("usuarioSearch")!=null){
            String cedula = request.getParameter("cedula");
            PersonaServicio servicio = new PersonaServicio();
             Usuario usuario = servicio.getUsuarioxCedula(cedula);
              
            if(usuario != null){
                 request.setAttribute("usuario", usuario);
            }else{
               Docente docente = servicio.getDocentexCedula(cedula);
               if(docente!=null){
                  request.setAttribute("docente", docente);
               }else{
                  request.setAttribute("busqueda", false);
               }
            }
            
            RequestDispatcher view = request.getRequestDispatcher("prestamo.jsp");
            view.forward(request, response);
            
            
            System.out.println("Presiono boton busqueda usuario");
        }
        else  if(request.getParameter("activoSearch")!=null){
            String activo = request.getParameter("activo");
            ActivoServicio servicio = new ActivoServicio();
            Activo activoRequerido = servicio.get(activo);
            
            
            if(request.getParameter("docente")!=null){
                PersonaServicio persona = new PersonaServicio();
                String cedula = request.getParameter("docente");
                Docente docente = persona.getDocentexCedula(cedula);
                request.setAttribute("docente",docente);
                System.out.println("Envie informacion docente");
            }else if(request.getParameter("usuario")!=null){
                PersonaServicio persona = new PersonaServicio();
                String cedula = request.getParameter("usuario");
                Usuario usuario = persona.getUsuarioxCedula(cedula);
                request.setAttribute("usuario",usuario);
            }
            
            
            if(activoRequerido !=null){
                HttpSession session =  request.getSession();
                Cart shoppingCart;
                shoppingCart = (Cart) session.getAttribute("cart");

                if(session.getAttribute("cart")==null){
                  shoppingCart = new Cart();
                  session.setAttribute("cart", shoppingCart);
                }

                shoppingCart.addToCart(activoRequerido.getCodigo(), activoRequerido);
                session.setAttribute("cart", shoppingCart);
                

            }else{
                System.out.println("No se encuentra el activo solicitado");
            }
            
            RequestDispatcher view = request.getRequestDispatcher("prestamo.jsp");
            view.forward(request, response);
            
            //response.sendRedirect("prestamo.jsp#tips");
        }else if(request.getParameter("devolucionSearch")!=null){
            String txtactivo = request.getParameter("devolucionSearch");
            ActivoServicio activoServicio = new ActivoServicio();
            Activo activo = activoServicio.get(txtactivo);
            request.setAttribute("activo", activo);
            if(activo.getDetalleprestamo()!=null){
               List<DetallePrestamo> detallePrestamo =(List) activo.getDetalleprestamo();
               Prestamo prestamo = detallePrestamo.get(0).getPrestamo();
              request.setAttribute("prestamo", prestamo);
              request.setAttribute("detalle", detallePrestamo.get(0));
            }
            
            RequestDispatcher view = request.getRequestDispatcher("devolucion.jsp");
            view.forward(request, response);
            
            System.out.println("devolucion...");
        }
        else{
            ActivoServicio<Activo> activoServicio = new ActivoServicio();
            PersonaServicio personaServicio = new PersonaServicio();
                    
            int numItem = 0;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calFechaSolicitud;
            Calendar calFechaDevolucion;
            
            String txtfechaSolicitud=request.getParameter("fecha");
            String txtfechaDevolucion = request.getParameter("devolucion");
            String semestre =  request.getParameter("semestre");
            String lugarSalida = request.getParameter("lugarSalida");
            String tipoPractica = request.getParameter("tipoPractica");
            String aprobado=request.getParameter("aprobado");
            String saleU = request.getParameter("salida");
            
            String usuario = ""; 
            
            HttpSession session =  request.getSession();
            Cart shoppingCart;
            shoppingCart = (Cart) session.getAttribute("cart");
            Prestamo prestamo = new Prestamo();
            
            
            if(request.getParameter("usuario")!=null){
              usuario = request.getParameter("usuario");
              System.out.println(usuario);
             
              Usuario estudiante = personaServicio.getUsuarioxCedula(usuario);
              prestamo.setEstudiante(estudiante);
             
            }else if(request.getParameter("docente")!= null){
              usuario = request.getParameter("docente");
              System.out.println(usuario);
             
              Docente docente = personaServicio.getDocentexCedula(usuario);
              prestamo.setDocente(docente);
            }else{
                System.out.println("Error usuario no existe");   
            }
             
            Date fechaSolicitud = (Date) sdf.parse(txtfechaSolicitud);
            calFechaSolicitud = Calendar.getInstance();
            calFechaSolicitud.setTime(fechaSolicitud);
            
            Date fechaDevolucion = (Date) sdf.parse(txtfechaDevolucion);
            calFechaDevolucion = Calendar.getInstance();
            calFechaDevolucion.setTime(fechaDevolucion);
                        
            prestamo.setFechaDevolucion(calFechaDevolucion);
            prestamo.setFechaSolicitud(calFechaSolicitud);
            prestamo.setSemestre(Integer.parseInt(semestre));
            prestamo.setLugarSalida(lugarSalida);
            prestamo.setTipoPractica(tipoPractica);
            
            if(aprobado != null)
               prestamo.setAprobacionCoordinador(true);
            
            if(saleU!=null)
                prestamo.setSaleU(true);
            
            Collection<DetallePrestamo> detalles = new ArrayList();
            if(shoppingCart!=null){
              numItem  =  shoppingCart.getCartItems().size();
              String txtactivo = null;
              String txtstatus = null;
              String txtobservacion = null;
              for(int i = 0;i < numItem ; i++){
                  txtactivo = request.getParameter("activo" + (i+1));
                  txtstatus = request.getParameter("status" + (i+1));
                  txtobservacion = request.getParameter("observacion" + (i+1));
                  Activo activo = activoServicio.get(txtactivo);
                  DetallePrestamo detalle = new DetallePrestamo();
                  detalle.setActivo(activo);
                  detalle.setEstado(txtstatus);
                  detalle.setObservacion(txtobservacion);
                  detalle.setPrestamo(prestamo);
                  detalles.add(detalle);
              }
              
              
             prestamo.setDetallesPrestamo(detalles);
             
             PrestamoServicio prestamoServicio = new PrestamoServicio();
             boolean respuesta =prestamoServicio.prestarActivos(prestamo);
            
             if(respuesta == true){
                request.setAttribute("OK", true);
                session.removeAttribute("cart");
                
             }
             
             else
              request.setAttribute("KO",false);  
            
            
             RequestDispatcher rd = request.getRequestDispatcher("prestamo.jsp");
             rd.forward(request, response);
           
                             
            }else{
                request.setAttribute("KO",false);  
                RequestDispatcher rd = request.getRequestDispatcher("prestamo.jsp");
                rd.forward(request, response);
            }    
                    
                
            System.out.println("Presiono el boton general");
            
        }
              
        System.out.println("");
        
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ServletPrestamo.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ServletPrestamo.class.getName()).log(Level.SEVERE, null, ex);
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
