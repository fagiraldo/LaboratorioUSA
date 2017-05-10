/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.usa.laboratorio.utilidades;

import java.util.HashMap;
import udu.usa.laboratorio.modelo.Activo;
import udu.usa.laboratorio.modelo.Usuario;

/**
 *  *
 *  * @author fabian.giraldo
 
 */
public class Cart {
   private Usuario usuario;
   private  HashMap<String, Activo> cartItems;

    public Cart() {
        cartItems = new HashMap();

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    

    public HashMap getCartItems() {
        return cartItems;
    }

    public void addToCart(String codigo, Activo activo) {
        cartItems.put(codigo, activo);
    }
    
    public void deleteFromCart(String codigo){
        cartItems.remove(codigo);
    }

}
