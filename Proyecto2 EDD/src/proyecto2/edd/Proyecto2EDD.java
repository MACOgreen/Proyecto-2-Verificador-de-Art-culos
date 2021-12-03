
package proyecto2.edd;


import VerificarOriginalidad.*;
import ClaseHash.Hash_table;
import ClaseHash.Lista;
import ClaseHash.Lista2;
import Lectura.Base_de_Datos;
        
public class Proyecto2EDD {

    
    public static void main(String[] args) {
        
    
        Base_de_Datos bdatos = new Base_de_Datos();
        Lista lista = new Lista();
        Lista2 lista1 = new Lista2();
        Hash_table tablahash = new Hash_table(10111);
        //tablahash.insertar("Maria", tablahash);
        //tablahash.insertar("Maria", tablahash);
        //tablahash.insertar("Maria", tablahash);
        //System.out.println(tablahash.hashing("Maria"));
        //System.out.println(tablahash.buscar("Maria").getNodito());
        //System.out.println(tablahash.buscar("Maria").getContador());
        //tablahash = bdatos.datos();
        //lista.print();
        //tablahash.contar_repeticiones(tablahash);
        //tablahash.buscar_palabra(tablahash);
        //System.out.println(tablahash.buscar("a ").getContador());
        bdatos.listas_info(lista, lista1);
        tablahash = lista.getFirst().getTablahash();
        //tablahash.contar_repeticiones(tablahash);
        tablahash.mostrar_palabras(lista.getFirst().getLista1());

    }
    
}
