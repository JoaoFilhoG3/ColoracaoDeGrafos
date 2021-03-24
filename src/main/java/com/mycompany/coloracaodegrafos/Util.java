package com.mycompany.coloracaodegrafos;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;

public class Util {

    public static int fatorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * fatorial(n - 1);
        }
    }

    public static int combinacao(int n, int s) {
        return fatorial(n) / (fatorial(s) * fatorial(n - s));
    }

    public static void gravarArquivo(int numVertices, int numCores, LinkedList<Integer> vertices[]) {
        try {

            int[][] cores = new int[numVertices][numCores];

            int value = 1;
            for (int j = 0; j < cores.length; j++) {
                for (int k = 0; k < cores[j].length; k++) {
                    cores[j][k] = value;
                    value++;
                }
            }

            int variaveis = numVertices * numCores;
            int clausulas = numVertices + (numVertices * combinacao(numCores, 2)) + (numCores * getNumVertices(vertices));

            FileWriter arq = new FileWriter("/home/joaof/funcao.cnf");
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.println("c Trabalho de lógica para computação");
            gravarArq.println("c João Filho Freire Lopes 371537");
            gravarArq.println("c Anderson Alexandre Paz Cardoso 370194");
            gravarArq.println("p cnf " + variaveis + " " + clausulas);

            for (int j = 0; j < numVertices; j++) {
                String linhaCoresDisponiveis = "";
                String linhaCoresDuplicadas = "";
                for (int k = 0; k < cores[j].length; k++) {
                    linhaCoresDisponiveis += cores[j][k] + " ";

                    for (int l = k + 1; l < cores[j].length; l++) {
                        linhaCoresDuplicadas += "-" + cores[j][k] + " -" + cores[j][l] + " 0\n";
                    }
                }
                linhaCoresDisponiveis += "0";
                gravarArq.println(linhaCoresDisponiveis);
                gravarArq.print(linhaCoresDuplicadas);
            }

            for (int j = 0; j < vertices.length; j++) {
                for (int k = 0; k < vertices[j].size(); k++) {
                    for (int l = 0; l < cores[j].length; l++) {
                        String linhaAdjacencias = "-" + cores[j][l] + " -" + cores[vertices[j].get(k)][l] + " 0";
                        gravarArq.println(linhaAdjacencias);
                    }
                }

            }

            arq.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static int getNumVertices(LinkedList<Integer> adj[]) {
        int tam = 0;
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                tam++;
            }
        }
        return tam;
    }
}
