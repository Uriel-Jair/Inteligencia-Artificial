
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ArbolBusqueda {

    Nodo raiz;
    String objetivo;

    public ArbolBusqueda(Nodo raiz, String objetivo) {
        this.raiz = raiz;
        this.objetivo = objetivo;
    }

    //Busqueda por Anchura
    public void busquedaPorAnchura() {
        Nodo nodoActual = raiz;
        Collection<String> estadosVisitados = new ArrayList();
        Queue<Nodo> estadosPorVisitar = new LinkedList();
        while (!nodoActual.getEstado().equals(objetivo)) {
            estadosVisitados.add(nodoActual.getEstado());
            //Generar a los Nodos Hijos
            Collection<String> hijos = nodoActual.generaHijos();	//<-- Cada Equipo tiene que ingeniarselas para crear este metodo!
            for (String hijo : hijos) {
                if (!estadosVisitados.contains(hijo)) {
                    //System.out.println("---Metiendo nuevo Nodo");
                    //Crear nuevo Nodo.
                    Nodo nHijo = new Nodo(hijo);
                    nHijo.setPadre(nodoActual);
                    estadosPorVisitar.add(nHijo);
                }
            }
            nodoActual = estadosPorVisitar.poll();
        }
        System.out.println("YA SE ENCONTRO EL NODO OBJETIVO");
        System.out.println(nodoActual.imprimeSolucion(nodoActual));
    }

    //Busqueda por Anchura
    public void busquedaPorProfundidad() {
        Nodo nodoActual = raiz;
        Collection<String> estadosVisitados = new ArrayList();
        Stack<Nodo> estadosPorVisitar = new Stack();
        while (!nodoActual.getEstado().equals(objetivo)) {
            estadosVisitados.add(nodoActual.getEstado());
            //Generar a los Nodos Hijos
            Collection<String> hijos = nodoActual.generaHijos();	//<-- Cada Equipo tiene que ingeniarselas para crear este metodo!
            for (String hijo : hijos) {
                if (!estadosVisitados.contains(hijo)) {
                    //System.out.println("---Metiendo nuevo Nodo");
                    //Crear nuevo Nodo.
                    Nodo nHijo = new Nodo(hijo);
                    nHijo.setPadre(nodoActual);
                    estadosPorVisitar.add(nHijo);
                }
            }
            nodoActual = estadosPorVisitar.pop();
        }
        System.out.println("NODO OBJETIVO ENCONTRADO");
        System.out.println(nodoActual.imprimeSolucion(nodoActual));
    }

    public Comparator<Nodo> h1() {
        Comparator<Nodo> c = new Comparator<Nodo>() {
            @Override
            public int compare(Nodo nodo, Nodo nodo2) {
                return H1(raiz.getEstado());
            }
        };
        return c;
    }

    public int H1(String estado) {

        int valorHeuristico = 0;

        for (int i = 0; i < estado.length(); i++) {
            if (estado.charAt(i) != objetivo.charAt(i)) {
                valorHeuristico++;
            }
        }
        return valorHeuristico;
    }

    public Comparator<Nodo> h2() {
        Comparator<Nodo> c = new Comparator<Nodo>() {
            @Override
            public int compare(Nodo nodo, Nodo nodo2) {
                return H2(raiz.getEstado());
            }
        };
        return c;
    }

    private int H2(String estado) {

        int valorheuristico = 0, caracter1 = 0, caracter2 = 0, valorheuricaracter = 0;

        for (int i = 0; i < estado.length(); i++) {
            valorheuricaracter = 0;
            caracter1 = (int) estado.charAt(i);
            caracter2 = (int) objetivo.charAt(i);
            valorheuricaracter = caracter1 - caracter2;
            valorheuricaracter = Math.abs(valorheuricaracter);
            valorheuristico = valorheuricaracter + valorheuristico;
        }
        return valorheuristico;
    }

    public int H3(String estado) {
        int filas = 0, columnas = 0;
        int filasObjetivo = 0, columnasObjetivo = 0;
        int salida = 0;

        salida = 0;
        filas = (int) estado.charAt(0) + (int) estado.charAt(1) + (int) estado.charAt(2);
        filasObjetivo = (int) objetivo.charAt(0) + (int) objetivo.charAt(1) + (int) objetivo.charAt(2);
        salida += Math.abs(filas - filasObjetivo);

        filas = (int) estado.charAt(3) + (int) estado.charAt(4) + (int) estado.charAt(5);
        filasObjetivo = (int) objetivo.charAt(3) + (int) objetivo.charAt(4) + (int) objetivo.charAt(5);
        salida += Math.abs(filas - filasObjetivo);

        filas = (int) estado.charAt(6) + (int) estado.charAt(7) + (int) estado.charAt(8);
        filasObjetivo = (int) objetivo.charAt(6) + (int) objetivo.charAt(7) + (int) objetivo.charAt(8);
        salida += Math.abs(filas - filasObjetivo);

        columnas = (int) estado.charAt(0) + (int) estado.charAt(3) + (int) estado.charAt(6);
        columnasObjetivo = (int) objetivo.charAt(0) + (int) objetivo.charAt(3) + (int) objetivo.charAt(6);
        salida += Math.abs(columnas - columnasObjetivo);

        columnas = (int) estado.charAt(1) + (int) estado.charAt(4) + (int) estado.charAt(7);
        columnasObjetivo = (int) objetivo.charAt(1) + (int) objetivo.charAt(4) + (int) objetivo.charAt(7);
        salida += Math.abs(columnas - columnasObjetivo);

        columnas = (int) estado.charAt(2) + (int) estado.charAt(5) + (int) estado.charAt(8);
        columnasObjetivo = (int) objetivo.charAt(2) + (int) objetivo.charAt(5) + (int) objetivo.charAt(8);
        salida += Math.abs(columnas - columnasObjetivo);

        return salida;
    }

    public void busquedaPorHeuristica(int Heuristica) {
        Comparator<Nodo> heuristica = null;
        switch (Heuristica) {
            case 1:
                heuristica = h1();
                break;
            case 2:
                heuristica = h1();
                break;
            case 3:
                heuristica = h1();
                break;
        }
        Nodo nodoActual = raiz;
        Collection<String> estadosVisitados = new ArrayList();
        PriorityQueue<Nodo> estadosPorVisitar = new PriorityQueue(heuristica);
        while (!nodoActual.getEstado().equals(objetivo)) {
            estadosVisitados.add(nodoActual.getEstado());
            //Generar a los Nodos Hijos
            Collection<String> hijos = nodoActual.generaHijos();
            for (String hijo : hijos) {
                if (!estadosVisitados.contains(hijo)) {

                    //Crear nuevo Nodo.
                    Nodo nHijo = new Nodo(hijo);
                    nHijo.setPadre(nodoActual);
                    estadosPorVisitar.add(nHijo);
                }
            }
            nodoActual = estadosPorVisitar.poll();
        }

        System.out.println(nodoActual.imprimeSolucion(nodoActual));
    }
}
