package Test;

import GUI.Nodos;
import GUI.NodosFactory;
import GUI.OSPF;
import java.util.HashMap;

public class OSPFTest {
static OSPF ospf=new OSPF("A", "G");
    public static void main(String[] args) {
//        NodosFactory.addNodo(new Nodos("A"));
//        NodosFactory.addNodo(new Nodos("B"));
//        NodosFactory.addNodo(new Nodos("C"));
//        NodosFactory.addNodo(new Nodos("D"));
//        NodosFactory.addNodo(new Nodos("E"));
//        NodosFactory.addNodo(new Nodos("F"));
//        NodosFactory.addNodo(new Nodos("G"));
        NodosFactory.getNodo("A").addApuntadores("B", 8);
        NodosFactory.getNodo("A").addApuntadores("C", 3);
        
        NodosFactory.getNodo("B").addApuntadores("D", 5);
        NodosFactory.getNodo("B").addApuntadores("E", 2);
        
        NodosFactory.getNodo("C").addApuntadores("F", 10);
        
        NodosFactory.getNodo("D").addApuntadores("G", 4);
        
        NodosFactory.getNodo("E").addApuntadores("G", 1);
        
        NodosFactory.getNodo("F").addApuntadores("G", 9);
        
        ospf.ospf(0, OSPF.Nodo_Inicial);
        
        //ospf.print();
        
    }
    
    
}
