import java.util.*;

/**
 * Exercício 10 – Percurso Completo em Grafo (DFS e BFS)
 *
 * Implementa DFS e BFS em um grafo representado por lista de adjacência.
 * O algoritmo visita todos os vértices acessíveis a partir de um vértice inicial.
 *
 * Pior caso: Todos os vértices e arestas precisam ser visitados.
 * Complexidade (pior caso): O(V + E)
 *   Justificativa: Cada vértice é visitado exatamente uma vez (O(V)) e cada
 *   aresta é examinada no máximo duas vezes (ida e volta em grafos não
 *   direcionados) ou uma vez (em grafos direcionados). Total: O(V + E).
 */
public class Exercicio10_Grafo {

    // Representação por lista de adjacência
    private int numVertices;
    private List<List<Integer>> adjacencia;

    public Exercicio10_Grafo(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencia = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            adjacencia.add(new ArrayList<>());
        }
    }

    public void adicionarAresta(int u, int v) {
        adjacencia.get(u).add(v);
        adjacencia.get(v).add(u); // Grafo não-direcionado
    }

    // ========== DFS (Busca em Profundidade) ==========

    public void dfs(int verticeInicial) {
        boolean[] visitado = new boolean[numVertices];
        int[] contadores = {0, 0}; // [vértices visitados, arestas examinadas]
        List<Integer> ordem = new ArrayList<>();

        System.out.println("DFS a partir do vértice " + verticeInicial + ":");
        dfsRecursivo(verticeInicial, visitado, contadores, ordem);

        System.out.println("  Ordem de visita: " + ordem);
        System.out.println("  Vértices visitados: " + contadores[0]);
        System.out.println("  Arestas examinadas: " + contadores[1]);
    }

    private void dfsRecursivo(int v, boolean[] visitado, int[] contadores, List<Integer> ordem) {
        visitado[v] = true;
        contadores[0]++;
        ordem.add(v);

        for (int vizinho : adjacencia.get(v)) {
            contadores[1]++;
            if (!visitado[vizinho]) {
                dfsRecursivo(vizinho, visitado, contadores, ordem);
            }
        }
    }

    // ========== BFS (Busca em Largura) ==========

    public void bfs(int verticeInicial) {
        boolean[] visitado = new boolean[numVertices];
        int verticesVisitados = 0;
        int arestasExaminadas = 0;
        List<Integer> ordem = new ArrayList<>();

        Queue<Integer> fila = new LinkedList<>();
        visitado[verticeInicial] = true;
        fila.add(verticeInicial);

        while (!fila.isEmpty()) {
            int v = fila.poll();
            verticesVisitados++;
            ordem.add(v);

            for (int vizinho : adjacencia.get(v)) {
                arestasExaminadas++;
                if (!visitado[vizinho]) {
                    visitado[vizinho] = true;
                    fila.add(vizinho);
                }
            }
        }

        System.out.println("BFS a partir do vértice " + verticeInicial + ":");
        System.out.println("  Ordem de visita: " + ordem);
        System.out.println("  Vértices visitados: " + verticesVisitados);
        System.out.println("  Arestas examinadas: " + arestasExaminadas);
    }

    public static void main(String[] args) {
        System.out.println("=== Exercício 10 – Percurso Completo em Grafo ===\n");

        /*
         * Grafo de exemplo (7 vértices, 8 arestas):
         *
         *     0 --- 1 --- 2
         *     |     |     |
         *     3 --- 4     5
         *           |
         *           6
         */
        Exercicio10_Grafo grafo = new Exercicio10_Grafo(7);
        grafo.adicionarAresta(0, 1);
        grafo.adicionarAresta(0, 3);
        grafo.adicionarAresta(1, 2);
        grafo.adicionarAresta(1, 4);
        grafo.adicionarAresta(2, 5);
        grafo.adicionarAresta(3, 4);
        grafo.adicionarAresta(4, 6);

        System.out.println("Grafo: V=7, E=7 (não-direcionado)");
        System.out.println("Arestas: {0-1, 0-3, 1-2, 1-4, 2-5, 3-4, 4-6}\n");

        grafo.dfs(0);
        System.out.println();
        grafo.bfs(0);

        System.out.println();

        // Grafo completo (pior caso extremo)
        System.out.println("--- Grafo completo K5 (5 vértices, 10 arestas) ---\n");
        Exercicio10_Grafo completo = new Exercicio10_Grafo(5);
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                completo.adicionarAresta(i, j);
            }
        }

        completo.dfs(0);
        System.out.println();
        completo.bfs(0);

        System.out.println();
        System.out.println("Pior caso: todos os vértices e arestas são visitados.");
        System.out.println("Complexidade (pior caso): O(V + E)");
        System.out.println("  V = número de vértices, E = número de arestas.");
    }
}
