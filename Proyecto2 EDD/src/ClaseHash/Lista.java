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
public class Lista {

    private NodoLista first;
    private NodoLista last;
    private int size;

    public Lista() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public NodoLista getFirst() {
        return first;
    }

    public NodoLista getLast() {
        return last;
    }

    public int getSize() {
        return size;
    }

    public void setFirst(NodoLista first) {
        this.first = first;
    }

    public void setLast(NodoLista last) {
        this.last = last;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isEmpty() {  //Consulta si la lista esta vacia
        return first == null;
    }

    public void empty() {
        this.first = this.last = null;
        this.size = 0;
    }

//    public void ordenamiento() { // Ordena de forma ascendiente una lista
//
//        if (!this.isEmpty()) {
//            NodoLista node = this.first;
//            int mayor = this.first.getNumber();
//            while (node != null) {
//                if (node.getNumber() > mayor) {
//                    mayor = node.getNumber();
//                }
//                node = node.getNext();
//            }
//
//            eliminar_valor(mayor);
//            ordenamiento();
//            //this.addAtTheEnd(mayor);
//        }
//
//    }
//
//    public void eliminar_valor(int valor) {
//        NodoLista node = this.first;
//        NodoLista aux = null;
//
//        while (node != null) {
//            if (node.getNumber() == valor) {
//                break;
//            }
//            node = node.getNext();
//            if (aux == null) {
//                aux = this.first;
//            } else {
//                aux = aux.getNext();
//            }
//        }
//
//        if (node != null) {
//            if (node == this.first) {
//                this.first = this.first.getNext();
//
//            } else if (node == this.last) {
//                this.last = aux;
//                aux.setNext(null);
//
//            } else {
//                aux.setNext(node.getNext());
//
//            }
//            size--;
//        }
//
//    }

    public void addAtTheEnd(Hash_table tablahash, Lista2 lista1) {  //Agrega un nodo al final de la lista
        NodoLista node = new NodoLista(tablahash, lista1);
        if (this.isEmpty()) {
            this.first = this.last = node;
        } else {
            this.last.setNext(node);
            this.last = node;
        }
        size++;
    }
    

    public void print() {
        NodoLista temp = first;
        if (this.isEmpty()) {
            System.out.println("The list is empty.");
        }
        while (temp != null) {
            System.out.println(temp.getTablahash());
            temp = temp.getNext();
        }
    }
}
