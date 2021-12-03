/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClaseHash;

/**
 *
 * @author aleja
 */
public class NodoLista {
    //private int number;
    private NodoLista next;
    private Lista2 lista1;
    //private String nombre;
    private Hash_table tablahash;
    private String articulo;

    public NodoLista(Hash_table tablahash, Lista2 lista1) { 
        this.tablahash = tablahash;
        this.lista1 = lista1;
        this.next = null;
    }

    public Hash_table getTablahash() {
        return tablahash;
    }

    public void setTablahash(Hash_table tablahash) {
        this.tablahash = tablahash;
    }

    

    public NodoLista getNext() {
        return next;
    }

    public void setNext(NodoLista next) {
        this.next = next;
    }

    public Lista2 getLista1() {
        return lista1;
    }

    public void setLista1(Lista2 lista1) {
        this.lista1 = lista1;
    }

    /**
     * @return the path
     */
    public String getAR() {
        return articulo;
    }

    /**
     * @param articulo the path to set
     */
    public void setAR(String articulo) {
        this.articulo = articulo;
    }

}
