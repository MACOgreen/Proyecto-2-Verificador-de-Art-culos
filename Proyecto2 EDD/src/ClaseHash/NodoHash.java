
package ClaseHash;

public class NodoHash {

    private NodoHash next;
    private String nombre;
    private int contador;

    public NodoHash(String nombre, int contador) {
        this.next = null;
        this.nombre = nombre;
        this.contador = contador;
    }

    public NodoHash getNext() {
        return next;
    }

    public String getNodito() {
        return nombre;
    }

    public void setNext(NodoHash next) {
        this.next = next;
    }

    public void setNodito(String nombre) {
        this.nombre = nombre;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

}
