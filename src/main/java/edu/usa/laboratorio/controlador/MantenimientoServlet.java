/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.usa.laboratorio.controlador;

import edu.usa.laboratorio.servicios.ActivoServicio;
import edu.usa.laboratorio.servicios.PersonaServicio;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import udu.usa.laboratorio.modelo.Activo;
import udu.usa.laboratorio.modelo.Auxiliar;
import udu.usa.laboratorio.modelo.Mantenimiento;
import udu.usa.laboratorio.modelo.MantenimientoPreventivo;

/**
 *
 * @author Isabel-Fabian
 */
public class MantenimientoServlet extends HttpServlet {

    

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
        if(request.getParameter("preventivo")!=null){
           String preventivo = request.getParameter("preventivo");
           boolean respuesta = servicio.deleteMantenimientoPreventivo(Integer.parseInt(preventivo));
           
            if(respuesta)
              request.setAttribute("OK", true);    
            else
             request.setAttribute("OK", false);            
           
            RequestDispatcher view = request.getRequestDispatcher("preventivo.jsp");
            view.forward(request, response);

        
        }else if(request.getParameter("correctivo")!=null){
           String preventivo = request.getParameter("correctivo");
           boolean respuesta = servicio.deleteMantenimiento(Integer.parseInt(preventivo));
           
            if(respuesta)
              request.setAttribute("OK", true);    
            else
             request.setAttribute("OK", false);            
           
            RequestDispatcher view = request.getRequestDispatcher("correctivo.jsp");
            view.forward(request, response);

        
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
        ActivoServicio servicio = new ActivoServicio();
        if(request.getParameter("preventivo")!=null){
           String txtMateriales=request.getParameter("materiales");
           String txtActivo=request.getParameter("activo");
           String txtActividad=request.getParameter("actividad");
           String txtPeriodicidad= request.getParameter("periodicidad");  
           Activo activo = servicio.get(txtActivo);
           MantenimientoPreventivo preventivo = new MantenimientoPreventivo();
           preventivo.setActivo(activo);
           preventivo.setActividad(txtActividad);
           preventivo.setMateriales(txtMateriales);
           preventivo.setNumMeses(Integer.parseInt(txtPeriodicidad));
           boolean respuesta= servicio.saveMantenimientoPreventivo(preventivo);
            if(respuesta)
              request.setAttribute("OK", true);    
            else
             request.setAttribute("OK", false);            
           
            request.setAttribute("activo", activo);
            RequestDispatcher view = request.getRequestDispatcher("preventivo.jsp");
            view.forward(request, response);
        }else if(request.getParameter("correctivo")!=null){
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Calendar calendar;
                
                String txtFechaAdquisicion=request.getParameter("fechaAdquisicion");
                Date date = (Date) sdf.parse(txtFechaAdquisicion);
                calendar = Calendar.getInstance();
                calendar.setTime(date);
                
                
                String txtDannio= request.getParameter("dannio");
                String txtActivo=request.getParameter("activo");
                Activo activo = servicio.get(txtActivo);
                
                String txtRepuesto = request.getParameter("repuesto");
                String txtDescripcion = request.getParameter("descripcion");
                PersonaServicio persona= new PersonaServicio();
                //Falta Cambiar
                Auxiliar auxiliar =  persona.getAuxiliar(1);
                
                
                
                Mantenimiento mantenimiento = new Mantenimiento();
                mantenimiento.setActivo(activo);
                mantenimiento.setAveriaEncontrada(txtDannio);
                mantenimiento.setDescripcion(txtDescripcion);
                mantenimiento.setRepuesto(txtRepuesto);
                mantenimiento.setFecha(calendar);
                mantenimiento.setAuxiliar(auxiliar);
                
                boolean respuesta= servicio.saveMantenimiento(mantenimiento);
                if(respuesta)
                  request.setAttribute("OK", true);    
                else
                 request.setAttribute("OK", false);            

                 request.setAttribute("activo", activo);

                
                
            } catch (ParseException ex) {
                request.setAttribute("OK", false);       
                
            }
            
            
            RequestDispatcher view = request.getRequestDispatcher("correctivo.jsp");
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
