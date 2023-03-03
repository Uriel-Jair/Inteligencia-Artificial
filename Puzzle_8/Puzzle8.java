import java.util.Collection;

public class Puzzle8 {

    public static String estadoInicial = "41275386 ";
    public static String estadoFinal = "12345678 ";
    
    public static void main(String[] args) {
        //Instanciar el arbol
        ArbolBusqueda a = new ArbolBusqueda(new Nodo(estadoInicial), estadoFinal);
        //Ejecuta la busqueda
        a.busquedaPorAnchura();
        	a.busquedaPorHeuristica(1);
        	System.out.println("Heuristica " + 1 + " termina" +"\n");
                
                a.busquedaPorHeuristica(2);
        	System.out.println("Heuristica " + 2 + " termina" +"\n"); 
                
                a.busquedaPorHeuristica(3);
        	System.out.println("Heuristica " + 2 + " termina" +"\n");
                
        //Medicion por Anchura
        long inicio = System.nanoTime();

        a.busquedaPorAnchura();

        long fin = System.nanoTime();

        double TAnchura = (double) (fin - inicio) / 1000000000;
        
        //Medicion por profundidad
        inicio = System.nanoTime();

        a.busquedaPorProfundidad();

        fin = System.nanoTime();

        double TProfundidad = (double) (fin - inicio) / 1000000000;
        
        //Medicion H1
        inicio = System.nanoTime();

        a.busquedaPorHeuristica(1);

        fin = System.nanoTime();

        double TH1 = (double) (fin - inicio) / 1000000000;
        
        //Medicion H2
        inicio = System.nanoTime();

        a.busquedaPorHeuristica(2);

        fin = System.nanoTime();

        double TH2 = (double) (fin - inicio) / 1000000000;
        
        //Medicion H3
        inicio = System.nanoTime();

        a.busquedaPorHeuristica(3);

        fin = System.nanoTime();

        double TH3 = (double) (fin - inicio) / 1000000000;

        System.out.println("Anchura: " + TAnchura);
        System.out.println("Profundidad: " + TProfundidad);
        System.out.println("Heuristica 1: " + TH1);
        System.out.println("Heuristica 2: " + TH2);
        System.out.println("Heuristica 3: " + TH3);

    }
  
    }
    