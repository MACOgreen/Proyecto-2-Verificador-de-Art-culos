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
        AlgorRK pr= new AlgorRK();
        
        String cadena;
        cadena=prueba.GenerarCadena();
        String patron="";
        int impar=101;
        int indice;
        
        indice= (int) pr.RabinKarp(patron, cadena , impar);
        
        
        
        System.out.println(indice);
        
    }
    
}
