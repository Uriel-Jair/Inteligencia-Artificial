package Diagnóstico;

public class Nodo {

    int valor;
    String nombre;
    Nodo nodoIzquierdo;
    Nodo nodoDerecho;

    public Nodo(int valor, String nombre) {
        this.valor = valor;
        this.nombre = nombre;
        nodoIzquierdo = null;
        nodoDerecho = null;
    }
}
