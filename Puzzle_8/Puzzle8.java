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
    }
    
}