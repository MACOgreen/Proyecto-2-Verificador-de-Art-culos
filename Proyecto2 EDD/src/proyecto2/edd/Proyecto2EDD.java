/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2.edd;

import VerificarOriginalidad.*;
        
public class Proyecto2EDD {

    
    public static void main(String[] args) {
        CargarArticulo prueba = new CargarArticulo();
        String cadena;
        cadena=prueba.GenerarCadena();
        
        System.out.println(cadena);
        
    }
    
}
