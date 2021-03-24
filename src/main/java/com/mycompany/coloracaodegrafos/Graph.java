package com.mycompany.coloracaodegrafos;

import java.util.LinkedList;

/**
 *
 * @author joaof
 */
class Graph {

    //NUMERO DE VÉRTICES
    private int numVertices;
    //LISTA DE ADJACENCIAS
    public LinkedList<Integer> adj[]; //Adjacency List 

    /**
     * * Construtor da classe **
     */
    Graph(int numVertices) {
        this.numVertices = numVertices;
        adj = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; ++i) {
            adj[i] = new LinkedList();
        }
    }

    /**
     * * Método responsável por adicionar uma aresta ao grafo **
     */
    void addEdge(int v, int w) {
        adj[v].add(w);
//        adj[w].add(v);
    }

    void colorir() {
        for (int i = 1; i <= numVertices; i++) {
            System.out.println("TENTANDO COM " + i + " CORES.");
            int[][] cores = new int[numVertices][i];
            cores[0][0] = 1;

            for (int j = 0; j < numVertices; j++) {//PERCORRENDO OS VERTICES

                for (int k = 0; k < adj[j].size(); k++) {//PERCORRENDO OS VERTICES ADJACENTES DO VERTICE J

                    int vertAdj = adj[j].get(k);//VÉRTICE ADJACENTE A J ATUAL
                    boolean possuiCor = false;

                    for (int l = 0; l < cores[vertAdj].length; l++) {//PERCORRENDO A TABELA DO VÉRTICE ADJACENTE K
                        if (cores[j][l] == 1) {
                            cores[vertAdj][l] = -1;
                            break;
                        }
                        if (cores[vertAdj][l] == 1) {
                            possuiCor = true;
                        }
                    }
                    if (!possuiCor) {
                        for (int l = 0; l < cores[vertAdj].length; l++) {
                            if (cores[vertAdj][l] == 0) {
                                cores[vertAdj][l] = 1;
                                break;
                            }
                        }
                    }

                }
            }

            //VERIFICANDO SE ESTÁ TOTALMENTE PREENCHIDO
            boolean valido = true;
            for (int j = 0; j < cores.length; j++) {
                boolean temCor = false;
                for (int k = 0; k < cores[j].length; k++) {
                    if (cores[j][k] == 1) {
                        temCor = true;
                    }
                }
                if (!temCor) {
                    valido = false;
                    break;
                }
            }

            //ENCONTROU O NÚMERO DE CORES CERTO
            if (valido) {
                System.out.println("Problema resolvido com " + i + " cores");
                //CRIANDO O ARQUIVO DE TEXTO
                Util.gravarArquivo(numVertices, i, adj);
                break;
            }
        }
    }

    public int getNumAdj() {
        int tam = 0;
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                tam++;
            }
        }
        return tam / 2;
    }
}
