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
public class NodoLista2 {
    private NodoLista2 next;
    private String nombre;
    private int number;

    public NodoLista2(String nombre, int number) {
        this.nombre = nombre;
        this.number = number;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumber() {
        return number;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setNext(NodoLista2 next) {
        this.next = next;
    }

    public NodoLista2 getNext() {
        return next;
    }
    
}
