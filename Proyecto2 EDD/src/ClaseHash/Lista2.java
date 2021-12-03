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
public class Lista2 { // Lista para el apartado 5
    private NodoLista2 first;
    private NodoLista2 last;
    private int size;

    public Lista2() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public NodoLista2 getFirst() {
        return first;
    }

    public NodoLista2 getLast() {
        return last;
    }

    public int getSize() {
        return size;
    }

    public void setFirst(NodoLista2 first) {
        this.first = first;
    }

    public void setLast(NodoLista2 last) {
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
    
    public void addAtTheEnd2(String palabra, Lista2 lista) {  //Agrega un nodo al final de la lista
        int contador = 1;
        NodoLista2 node = new NodoLista2(palabra, contador);
        NodoLista2 temp = lista.getFirst();
        Boolean entro = false;
        if (this.isEmpty()) {
            this.first = this.last = node;
        } else {
            for (int i = 0; i < lista.getSize(); i++) {
                if (temp.getNombre().equals(palabra)){
                    temp.setNumber(temp.getNumber() + 1);
                    entro = true;
            }
            temp = temp.getNext();
        } if (entro == false){
        this.last.setNext(node);
        this.last = node; 
        size++;}
    }
    }
    
    public void agregar(String palabra, int contador) {
        NodoLista2 nodo = new NodoLista2(palabra, contador);
        if (this.isEmpty()) {
            this.first = this.last = nodo;
        } else {
            this.last.setNext(nodo);
            this.last = nodo;
        }
        size++;
    }
    
    public void ordenamiento() { // Ordena de forma ascendiente una lista

        if (!this.isEmpty()) {
            NodoLista2 node = this.first;
            int mayor = this.first.getNumber();
            String nombre = this.first.getNombre();
            while (node != null) {
                if (node.getNumber() < mayor) {
                    mayor = node.getNumber();
                    nombre = node.getNombre();
                }
                node = node.getNext();
            }

            eliminar_valor(mayor);
            ordenamiento();
            this.agregar(nombre,mayor);
        }

    }

    public void eliminar_valor(int valor) {
        NodoLista2 node = this.first;
        NodoLista2 aux = null;

        while (node != null) {
            if (node.getNumber() == valor) {
                break;
            }
            node = node.getNext();
            if (aux == null) {
                aux = this.first;
            } else {
                aux = aux.getNext();
            }
        }

        if (node != null) {
            if (node == this.first) {
                this.first = this.first.getNext();

            } else if (node == this.last) {
                this.last = aux;
                aux.setNext(null);

            } else {
                aux.setNext(node.getNext());
            }
            size--;
        }

    }
}
