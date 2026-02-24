import java.util.Arrays;

/**
 * Exercício 5 – QuickSort com Pivô Fixo
 *
 * Implementa QuickSort escolhendo sempre o primeiro elemento como pivô.
 * Testa com vetores já ordenados para evidenciar o pior caso.
 *
 * Pior caso: Vetor já ordenado ou ordenado inversamente.
 * Complexidade (pior caso): O(n²)
 *   Justificativa: Quando o pivô é sempre o primeiro elemento e o vetor está
 *   ordenado, a partição gera subvetores de tamanhos 0 e (n-1). Isso resulta
 *   em n chamadas recursivas, cada uma fazendo O(n) comparações: T(n) = T(n-1) + n → O(n²).
 */
public class Exercicio05_QuickSort {

    static int comparacoes;
    static int trocas;

    /**
     * QuickSort com pivô fixo (primeiro elemento).
     */
    public static void quickSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int posPivo = particionar(vetor, inicio, fim);
            quickSort(vetor, inicio, posPivo - 1);
            quickSort(vetor, posPivo + 1, fim);
        }
    }

    /**
     * Partição usando o primeiro elemento como pivô (esquema Lomuto adaptado).
     */
    private static int particionar(int[] vetor, int inicio, int fim) {
        int pivo = vetor[inicio];
        int i = inicio + 1;

        for (int j = inicio + 1; j <= fim; j++) {
            comparacoes++;
            if (vetor[j] < pivo) {
                // Troca vetor[i] com vetor[j]
                int temp = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = temp;
                trocas++;
                i++;
            }
        }

        // Coloca o pivô na posição correta
        int temp = vetor[inicio];
        vetor[inicio] = vetor[i - 1];
        vetor[i - 1] = temp;
        trocas++;

        return i - 1;
    }

    private static void testar(String descricao, int[] vetor) {
        comparacoes = 0;
        trocas = 0;
        System.out.println(descricao + ": " + Arrays.toString(vetor));
        quickSort(vetor, 0, vetor.length - 1);
        System.out.println("Resultado:      " + Arrays.toString(vetor));
        System.out.println("Comparações: " + comparacoes + ", Trocas: " + trocas);
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("=== Exercício 5 – QuickSort com Pivô Fixo ===\n");

        // Caso médio: vetor aleatório
        testar("Aleatório", new int[]{5, 3, 8, 1, 7, 2, 6, 4});

        // Pior caso: vetor já ordenado (crescente)
        testar("Já ordenado (pior caso)", new int[]{1, 2, 3, 4, 5, 6, 7, 8});

        // Pior caso: vetor ordenado inversamente
        testar("Decrescente (pior caso)", new int[]{8, 7, 6, 5, 4, 3, 2, 1});

        System.out.println("Observação: com pivô fixo (1º elemento), vetores já");
        System.out.println("ordenados ou inversamente geram partições desbalanceadas.");
        System.out.println("Comparações no pior caso ≈ n(n-1)/2 = 28 para n=8.");
        System.out.println("Complexidade (pior caso): O(n²)");
    }
}
