package com.mycompany.coloracaodegrafos;

/**
 *
 * @author joaof
 */
public class Main {

    public static void main(String args[]) {
//        Graph g1 = new Graph(4);
//        g1.addEdge(0, 1);
//        g1.addEdge(0, 2);
//        g1.addEdge(1, 2);
//        g1.addEdge(1, 3);
//        
//        g1.colorir();

        Graph g1 = new Graph(7);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(0, 3);
        g1.addEdge(1, 2);
        g1.addEdge(1, 4);
        g1.addEdge(2, 3);
        g1.addEdge(2, 4);
        g1.addEdge(3, 4);
        g1.addEdge(4, 5);
        g1.addEdge(5, 6);

        g1.colorir();

    }
}
