import java.util.Arrays;

/**
 * Exercício 6 – Merge Sort e Uso de Memória
 *
 * Implementa Merge Sort para ordenar um vetor de n elementos.
 * Analisa o tempo e o espaço adicional utilizados.
 *
 * Pior caso: O mesmo para qualquer entrada.
 * Complexidade (pior caso): O(n log n)
 *   Justificativa: O Merge Sort SEMPRE divide o vetor ao meio (log n níveis)
 *   e em cada nível realiza O(n) operações de merge. Portanto, T(n) = O(n log n)
 *   para TODOS os casos (melhor, médio e pior).
 *
 * Espaço adicional: O(n)
 *   Justificativa: O merge requer vetores auxiliares de tamanho total n
 *   para combinar os subvetores.
 */
public class Exercicio06_MergeSort {

    static int comparacoes;
    static int memoriaExtra; // bytes alocados adicionalmente (contagem de elementos)

    public static void mergeSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int meio = inicio + (fim - inicio) / 2;
            mergeSort(vetor, inicio, meio);
            mergeSort(vetor, meio + 1, fim);
            merge(vetor, inicio, meio, fim);
        }
    }

    private static void merge(int[] vetor, int inicio, int meio, int fim) {
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;

        // Vetores auxiliares
        int[] esq = new int[n1];
        int[] dir = new int[n2];
        memoriaExtra += (n1 + n2);

        // Copia dados para os vetores auxiliares
        for (int i = 0; i < n1; i++) {
            esq[i] = vetor[inicio + i];
        }
        for (int j = 0; j < n2; j++) {
            dir[j] = vetor[meio + 1 + j];
        }

        // Merge dos dois vetores auxiliares de volta ao vetor original
        int i = 0, j = 0, k = inicio;

        while (i < n1 && j < n2) {
            comparacoes++;
            if (esq[i] <= dir[j]) {
                vetor[k] = esq[i];
                i++;
            } else {
                vetor[k] = dir[j];
                j++;
            }
            k++;
        }

        // Copia elementos restantes
        while (i < n1) {
            vetor[k] = esq[i];
            i++;
            k++;
        }
        while (j < n2) {
            vetor[k] = dir[j];
            j++;
            k++;
        }
    }

    private static void testar(String descricao, int[] vetor) {
        comparacoes = 0;
        memoriaExtra = 0;
        System.out.println(descricao + ": " + Arrays.toString(vetor));
        mergeSort(vetor, 0, vetor.length - 1);
        System.out.println("Resultado:       " + Arrays.toString(vetor));
        System.out.println("Comparações:     " + comparacoes);
        System.out.println("Memória extra:   " + memoriaExtra + " elementos auxiliares alocados (total)");
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("=== Exercício 6 – Merge Sort ===\n");

        testar("Já ordenado", new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        testar("Aleatório", new int[]{5, 3, 8, 1, 7, 2, 6, 4});
        testar("Decrescente", new int[]{8, 7, 6, 5, 4, 3, 2, 1});

        System.out.println("Observação: o número de comparações é similar em todos os");
        System.out.println("casos, pois o Merge Sort sempre divide e intercala.");
        System.out.println("Complexidade (pior caso): O(n log n)");
        System.out.println("Espaço adicional: O(n)  –  vetores auxiliares no merge.");
    }
}
