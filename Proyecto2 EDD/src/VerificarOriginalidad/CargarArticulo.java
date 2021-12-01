/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VerificarOriginalidad;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class CargarArticulo {
    
    File file;
    String path;
    
    
    public File abrirArchivo(){ 
        
        String aux="";  
        String texto;
        JFileChooser file;
        
          
        texto="";
        
        
        /**llamamos el metodo que permite cargar la ventana*/
       file=new JFileChooser();
       
       file.showOpenDialog(file);
       /**abrimos el archivo seleccionado*/
       File abre=file.getSelectedFile();
       
       return abre;   
    }
    
    public String GenerarCadena(){
        
        String line;
        String samancito_txt = "";
        
        try{
            file= abrirArchivo();
            path=file.getPath();
            
        }catch(Exception ex){
            
            //path = "test\\samancito.txt";
            //file = new File(getPath());   
            
        }
        
        try{
            
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    samancito_txt += line + "\n";
                }
            }
            
            br.close();
            JOptionPane.showMessageDialog(null, "Exito al leer");
                
        }catch(Exception e){
            String salir;
            
            
            while (true){
                
              salir=JOptionPane.showInputDialog(null, "No desea cargar un archivo ?(si/no)");  
              
              if(salir.equals("si")){
                   GenerarCadena();
              }
              else if(salir.equals("no")){
                  break;
              }
              else{
                  JOptionPane.showMessageDialog(null, "Introduzca un 'si' o un 'no' por favor. ");
              }
              
            }
          

        }
        
        return samancito_txt;
         
    }
    
    
    
    
    
    
    
    
    
}
