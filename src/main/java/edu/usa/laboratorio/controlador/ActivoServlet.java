/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.usa.laboratorio.controlador;

import edu.usa.laboratorio.servicios.ActivoServicio;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import udu.usa.laboratorio.modelo.Activo;
import udu.usa.laboratorio.modelo.Categoria;

/**
 *
 * @author fabian.giraldo
 */
public class ActivoServlet extends HttpServlet {

 

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
        request.setAttribute("categorias", servicio.findAllCategoria());
        RequestDispatcher view = request.getRequestDispatcher("registro.jsp");
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
       
        try {
            ActivoServicio servicio = new ActivoServicio();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar;
            //Variable para almacenar los errores producto de las validaciones especificadas.
            Map<String, String> errors= new HashMap<String, String>();
            
            boolean tieneManual = false;
            boolean funciona = false;
            Activo activo = new Activo();
            
            String nombreEquipo= request.getParameter("nombreEquipo");
            String fechaAdquisicion = request.getParameter("fechaAdquisicion");
            String codigo=  request.getParameter("codigo");
            String marca = request.getParameter("marca");
            String modelo=     request.getParameter("modelo");
            String ubicacion =  request.getParameter("ubicacion");
            String numeroSerie =    request.getParameter("numeroSerie");
            String referencia =   request.getParameter("referencia");
            String  manual =  request.getParameter("manual");
            if(manual.equals("si"))
                tieneManual = true;
            
            String funcionamiento = request.getParameter("funcionamiento");
            if(funcionamiento.equals("si"))
                funciona = true;
            
            String txtCategoria = request.getParameter("categoria");
            Categoria categoria = servicio.getCategoria(Integer.parseInt(txtCategoria));
            
            activo.setCodigo(codigo);
            activo.setNumeroSerie(numeroSerie);
            activo.setReferencia(referencia);
            activo.setNombreEquipo(nombreEquipo);
            activo.setMarca(marca);
            activo.setModelo(modelo);
            activo.setUbicacion(ubicacion);
            activo.setFuncionamiento(funciona);
            activo.setManual(tieneManual);
            activo.setCategoria(categoria);
            
            Date date = (Date) sdf.parse(fechaAdquisicion);
            calendar = Calendar.getInstance();
            calendar.setTime(date);
            activo.setFechaAdquisicion(calendar);
           
            
            boolean respuesta = servicio.save(activo);
            if(respuesta == true)
              request.setAttribute("OK", true);
            else
              request.setAttribute("KO",false);  
            
        } catch (ParseException ex) {
            request.setAttribute("KO", false);
        }
           
           RequestDispatcher rd = request.getRequestDispatcher("registro.jsp");
           rd.forward(request, response);
            
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
