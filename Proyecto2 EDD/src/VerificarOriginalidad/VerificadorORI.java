/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VerificarOriginalidad;



public class VerificadorORI {
    
    public String comenzar(String cadena, String patron){
        
        CargarArticulo prueba = new CargarArticulo();
        AlgorRK pr= new AlgorRK();
        
        //String cadena;
        
        String cadenaResaltada="";
        
       // cadena=prueba.GenerarCadena();   // Aqui se aloja el texto del articulo
        
        //String patron="It is a single software in which all parts of development are done.";//// El fragmento que se quiere buscar en el articulo.
        
        int impar=101;
        int indice;
        
        indice= (int) pr.RabinKarp(patron, cadena , impar);
        
        
        ///Reescribo la cadena en otra variable para remarcar el fragmento encontrado. 
        for(int i=0;i<cadena.length();i++){
            
            if( i==indice-1){
                cadenaResaltada+= "{{<<<<<";
                cadenaResaltada+= (char) cadena.codePointAt(i);
                continue;
            }
            
            if(i==indice+patron.length()){
               cadenaResaltada+= ">>>>>}}";
               cadenaResaltada+= (char) cadena.codePointAt(i);
               continue; 
            }
            
            cadenaResaltada+= (char) cadena.codePointAt(i);
   
        }
        ///
        
        
        System.out.println( cadenaResaltada);
        
        return cadenaResaltada;
        
        
        
        
        
        
        
    }
    
}
