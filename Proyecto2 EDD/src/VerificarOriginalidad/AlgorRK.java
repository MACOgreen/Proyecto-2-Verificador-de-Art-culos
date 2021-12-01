/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VerificarOriginalidad;

/**
 *
 * @author mani
 */
public class AlgorRK {
    
    public float RabinKarp(String patron, String articulo, int NumImpar){
        int m=patron.length();
        int n= articulo.length();
        
        int i,j;
        int d=256; // Numero de caracteres posibles
        int p = 0; // Valor hash del patron
        int t = 0; // Valor hash del txt
        
        int h = 1;
        
        
        //Se halla el valor de h
        for ( i = 0; i < m - 1; i++){
            h = (h * NumImpar) % NumImpar; 
        }
        
        for ( i = 0; i < m; i++) 
        { 
            p = (d * p + patron.codePointAt(i)) % NumImpar; 
            t = (d * t + articulo.codePointAt(i)) % NumImpar; 
        } 
        
        for ( i = 0; i <= n - m; i++){
            
            if ( p == t ){
                
                boolean mismoHash= true;
                
                 for ( j = 0; j < m; j++) 
                { 
                    if (articulo.codePointAt(i+j) != patron.codePointAt(j))
                    {
                        mismoHash = false;
                        break;
                    }
                    
                    if(mismoHash){
                       //cout<<i<<" ";
                    }
                       
                }
                 
                if (j == m){
                    System.out.println("Patron encontrado en  indice: "+ i);
                    return i; 
                }
                
            }
            
            if ( i < n-m ){
                
                t = (d*(t - articulo.codePointAt(i)*h) + articulo.codePointAt(i+m))%NumImpar; 
                
                if (t < 0){
                    t = (t + NumImpar);
                }
                
            }
            
            
        }
        
        return (float) i;
  
        
    }
    
}
