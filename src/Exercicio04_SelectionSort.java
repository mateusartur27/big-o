import java.util.Arrays;

/**
 * Exercício 4 – Selection Sort e Análise de Trocas
 *
 * Implementa Selection Sort contando comparações e trocas.
 * Compara os resultados para diferentes ordens de entrada.
 *
 * Pior caso: Independente da ordem inicial do vetor.
 * Complexidade (pior caso): O(n²)
 *   Justificativa: O Selection Sort SEMPRE percorre o subvetor não ordenado
 *   buscando o mínimo. Independente da entrada, o número de comparações é
 *   n(n-1)/2. O número de TROCAS é no máximo (n-1) — o que varia entre
 *   entradas é apenas o número de trocas, NÃO as comparações.
 */
public class Exercicio04_SelectionSort {

    /**
     * Selection Sort com contagem.
     * Retorna array [comparações, trocas].
     */
    public static int[] selectionSort(int[] vetor) {
        int n = vetor.length;
        int comparacoes = 0;
        int trocas = 0;

        for (int i = 0; i < n - 1; i++) {
            int indiceMenor = i;

            for (int j = i + 1; j < n; j++) {
                comparacoes++;
                if (vetor[j] < vetor[indiceMenor]) {
                    indiceMenor = j;
                }
            }

            // Troca apenas se necessário
            if (indiceMenor != i) {
                int temp = vetor[i];
                vetor[i] = vetor[indiceMenor];
                vetor[indiceMenor] = temp;
                trocas++;
            }
        }

        return new int[]{comparacoes, trocas};
    }

    public static void main(String[] args) {
        System.out.println("=== Exercício 4 – Selection Sort ===\n");

        // Caso 1: Vetor já ordenado
        int[] v1 = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("Já ordenado:    " + Arrays.toString(v1));
        int[] res1 = selectionSort(v1);
        System.out.println("Resultado:      " + Arrays.toString(v1));
        System.out.println("Comparações: " + res1[0] + ", Trocas: " + res1[1]);
        System.out.println();

        // Caso 2: Vetor aleatório
        int[] v2 = {5, 3, 8, 1, 7, 2, 6, 4};
        System.out.println("Aleatório:      " + Arrays.toString(v2));
        int[] res2 = selectionSort(v2);
        System.out.println("Resultado:      " + Arrays.toString(v2));
        System.out.println("Comparações: " + res2[0] + ", Trocas: " + res2[1]);
        System.out.println();

        // Caso 3: Vetor decrescente
        int[] v3 = {8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("Decrescente:    " + Arrays.toString(v3));
        int[] res3 = selectionSort(v3);
        System.out.println("Resultado:      " + Arrays.toString(v3));
        System.out.println("Comparações: " + res3[0] + ", Trocas: " + res3[1]);
        System.out.println();

        System.out.println("Observação: o número de COMPARAÇÕES é sempre " + res1[0]);
        System.out.println("  = n(n-1)/2 = 8×7/2 = 28, independente da ordem.");
        System.out.println("  O que muda é apenas o número de TROCAS.");
        System.out.println("Complexidade (pior caso): O(n²)");
    }
}
