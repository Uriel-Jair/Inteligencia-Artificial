package Diagnóstico;

public class Arbol {

    Nodo raiz;

    public Arbol() {
        raiz = null;
    }

    public boolean esVacio() {
        return raiz == null;
    }

    public void insertar(int valor, String nombre) {
        Nodo nuevoNodo = new Nodo(valor, nombre);
        if (esVacio()) {
            raiz = nuevoNodo;
        } else {
            Nodo nodoActual = raiz;
            while (true) {
                if (valor < nodoActual.valor) {
                    if (nodoActual.nodoIzquierdo == null) {
                        nodoActual.nodoIzquierdo = nuevoNodo;
                        break;
                    }
                    nodoActual = nodoActual.nodoIzquierdo;
                } else {
                    if (nodoActual.nodoDerecho == null) {
                        nodoActual.nodoDerecho = nuevoNodo;
                        break;
                    }
                    nodoActual = nodoActual.nodoDerecho;
                }
            }
        }
    }

    public Nodo buscarNodo(String nombre) {
        if (esVacio()) {
            return null;
        } else {
            Nodo nodoActual = raiz;
            while (nodoActual != null) {
                if (nombre.equalsIgnoreCase(nodoActual.nombre)) {
                    return nodoActual;
                } else if (nombre.compareToIgnoreCase(nodoActual.nombre) > 0) {
                    nodoActual = nodoActual.nodoIzquierdo;
                } else if (nombre.compareToIgnoreCase(nodoActual.nombre) < 0) {
                    nodoActual = nodoActual.nodoDerecho;
                }else {
                    nodoActual = nodoActual.nodoDerecho;
                }
            }
            return null;
        }
    }

    public void imprimirArbol(Nodo nodo) {
        if (nodo != null) {
            imprimirArbol(nodo.nodoIzquierdo);
            System.out.print(nodo.valor + " ");
            System.out.print(nodo.nombre + " ");
            imprimirArbol(nodo.nodoDerecho);
        }
    }
}
