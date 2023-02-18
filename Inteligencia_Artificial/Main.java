package Diagnóstico;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Arbol arbol = new Arbol();
        Scanner leer = new Scanner(System.in);

        System.out.println("Ingrese los valores del arbol separados por comas: ");
        String valores = leer.nextLine();

        String[] valoresArray = valores.split(",");
        for (String valor : valoresArray) {
            int val = Integer.parseInt(valor.trim());
            System.out.println("Ingrese el nombre del nodo " + val + ": ");
            String nombre = leer.nextLine();
            arbol.insertar(val, nombre);
        }

        System.out.println("Ingrese el nombre del nodo a buscar: ");
        String nombreBuscar = leer.nextLine();
        Nodo nodoEncontrado = arbol.buscarNodo(nombreBuscar);
        if (nodoEncontrado == null) {
            System.out.println("Nodo no encontrado");
        } else {
            System.out.println("Nodo encontrado: " + nodoEncontrado.valor + " " + nodoEncontrado.nombre);
        }

        System.out.println("Arbol en orden: ");
        arbol.imprimirArbol(arbol.raiz);
    }
}
