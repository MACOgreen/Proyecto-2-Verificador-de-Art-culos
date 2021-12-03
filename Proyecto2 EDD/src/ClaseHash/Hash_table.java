package ClaseHash;

import java.util.Scanner;

public class Hash_table {

    private NodoHash tabla[];
    private int tamano_tabla; // 10111 numero primo

    public Hash_table(int tamaño) {
        this.tamano_tabla = tamaño;
        this.tabla = new NodoHash[tamano_tabla];
        for (int i = 0; i < tamano_tabla; i++) {
            this.tabla[i] = null;
        }
    }

    public NodoHash[] getTabla() {
        return tabla;
    }

    public int getTamano_tabla() {
        return tamano_tabla;
    }

    public void setTabla(NodoHash[] tabla) {
        this.tabla = tabla;
    }

    public void setTamano_tabla(int tamano_tabla) {
        this.tamano_tabla = tamano_tabla;
    }

    public int hashing(String clave) {
        int valor = 0;
        int posicion = 1;
        for (int i = 0; i < clave.length(); i++) {
            if (clave.codePointAt(i) == 32) {
                valor += 0;
            } else if (clave.codePointAt(i) >= 48 && clave.codePointAt(i) <= 57) {
                valor += ((clave.codePointAt(i) - 47) * posicion);
            } else if (clave.codePointAt(i) >= 65 && clave.codePointAt(i) <= 90) {
                valor += ((clave.codePointAt(i) - 54) * posicion);
            } else if (clave.codePointAt(i) >= 97 && clave.codePointAt(i) <= 122) {
                valor += ((clave.codePointAt(i) - 60) * posicion);
            }
            posicion++;
        }
        return (valor % tamano_tabla);
    }

//    public void insertar(String nombre) {
//        int posicion = hashing(nombre);
//        boolean existe = false;
//        if (this.tabla[posicion] != null) {
//            NodoHash temp = this.tabla[posicion];
//            if (temp.getNodito().equals(nombre)) {
//                existe = true;
//            }
//            while (temp.getNext() != null) {
//                temp = temp.getNext();
//                if (temp.getNodito().equals(nombre)) {
//                    existe = true;
//                }
//            }
//            if (!existe) {
//                NodoHash nuevo2 = new NodoHash(nombre);
//                temp.setNext(nuevo2);
//            }
//        } else {
//            NodoHash nuevo2 = new NodoHash(nombre);
//            this.tabla[posicion] = nuevo2;
//        }
//    }
    public void insertar(String nombre, Hash_table tablahash) {
        int posicion = hashing(nombre);
        boolean existe = false;
        if (this.tabla[posicion] != null) {
            NodoHash temp = this.tabla[posicion];
            if (temp.getNodito().equals(nombre)) {
                existe = true;
            }
            while (temp.getNext() != null) {
                temp = temp.getNext();
                if (temp.getNodito().equals(nombre)) {
                    existe = true;
                }
            }
            if (existe) {
                int contador = tablahash.buscar(nombre).getContador();
                int nuevo_contador = contador + 1;
                tablahash.buscar(nombre).setContador(nuevo_contador);
            }
        } else {
            int nuevo_contador = 1;
            NodoHash nuevo2 = new NodoHash(nombre, nuevo_contador);
            this.tabla[posicion] = nuevo2;
        }
    }

    public NodoHash buscar(String documento) {
        int posicion = hashing(documento);
        NodoHash temp = this.tabla[posicion];
        boolean existe = false;
        if (temp != null) {
            if (temp.getNext() == null) {
                existe = true;
            }
        } else {
            while (temp.getNext() != null && !existe) {
                if (temp.getNodito().equals(documento)) {
                    existe = true;
                } else {
                    temp = temp.getNext();
                }
            }
        }
        if (existe) {
            return temp;
        } else {
            return null;
        }
    }

    public void imprimir() {
        for (int i = 0; i < tamano_tabla; i++) {
            if (this.tabla[i] != null) {
                System.out.println(this.tabla[i].getNodito());
                if (this.tabla[i].getNext() != null) {
                    NodoHash temp = this.tabla[i].getNext();
                    while (temp != null) {
                        System.out.println(temp.getNodito());
                        temp = temp.getNext();
                    }
                }
            }
        }
    }

    public void vaciado() {
        for (int i = 0; i < tamano_tabla; i++) {
            this.tabla[i] = null;
        }
    }

    public void contar_repeticiones(Hash_table tablahash) {
        for (int i = 0; i < tablahash.getTamano_tabla(); i++) {
            NodoHash temp = this.tabla[i];
            if (temp != null) {
                NodoHash a = tablahash.buscar(temp.getNodito());
                System.out.println("Palabra " + a.getNodito() + " del texto: " + a.getContador());
            }
        }
    }
    
    public void buscar_palabra(Hash_table tablahash){
        System.out.println("Ingrese la palabra que desea buscar: ");
        Scanner entrada = new Scanner(System.in);
        String palabra = entrada.nextLine();
        palabra = palabra.toLowerCase();
        try{
            System.out.println("Palabra " + tablahash.buscar(palabra).getNodito() + " del texto: " + tablahash.buscar(palabra).getContador());
        }
        catch (Exception NullPointerException){
            System.out.println("Esta palabra no se encuentra en el texto");
        }   
    }
    
    public String mostrar_palabras(Lista2 lista1){
        lista1.ordenamiento();
        String PalabrasDescendientes="";
        NodoLista2 temp = lista1.getFirst();
        for (int i = 0; i < lista1.getSize(); i++) {
            if (temp != null) {
                System.out.println("Palabra " + temp.getNombre() + " del texto: " + temp.getNumber());
                PalabrasDescendientes+="Palabra " +"'"+ temp.getNombre()+"'" + " del texto: " + temp.getNumber()+"\n";
                temp = temp.getNext();
            }
        }
        return PalabrasDescendientes;
    }
}
