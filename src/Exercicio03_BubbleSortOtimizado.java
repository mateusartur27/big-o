import java.util.Arrays;

/**
 * Exercício 3 – Ordenação por Bubble Sort Otimizado
 *
 * Implementa Bubble Sort com flag que interrompe caso o vetor já esteja ordenado.
 * Compara o desempenho entre o melhor e o pior caso.
 *
 * Melhor caso: Vetor já ordenado → O(n) (1 passada, flag não ativada)
 * Pior caso: Vetor ordenado de forma decrescente → O(n²)
 *   Justificativa: No pior caso, a cada passada do laço externo, o maior elemento
 *   "borbulha" para sua posição final. São necessárias (n-1) passadas, e em cada
 *   passada fazemos até (n-1-i) comparações, totalizando n(n-1)/2 = O(n²).
 */
public class Exercicio03_BubbleSortOtimizado {

    /**
     * Bubble Sort otimizado com flag.
     * Retorna array [comparações, trocas].
     */
    public static int[] bubbleSortOtimizado(int[] vetor) {
        int n = vetor.length;
        int comparacoes = 0;
        int trocas = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean trocou = false;

            for (int j = 0; j < n - 1 - i; j++) {
                comparacoes++;
                if (vetor[j] > vetor[j + 1]) {
                    // Troca
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                    trocas++;
                    trocou = true;
                }
            }

            // Se não houve troca, o vetor já está ordenado
            if (!trocou) {
                break;
            }
        }

        return new int[]{comparacoes, trocas};
    }

    public static void main(String[] args) {
        System.out.println("=== Exercício 3 – Bubble Sort Otimizado ===\n");

        // Melhor caso: vetor já ordenado
        int[] vetorOrdenado = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("Melhor caso (já ordenado): " + Arrays.toString(vetorOrdenado));
        int[] res1 = bubbleSortOtimizado(vetorOrdenado);
        System.out.println("Resultado: " + Arrays.toString(vetorOrdenado));
        System.out.println("Comparações: " + res1[0] + ", Trocas: " + res1[1]);
        System.out.println();

        // Caso médio: vetor aleatório
        int[] vetorAleatorio = {5, 3, 8, 1, 7, 2, 6, 4};
        System.out.println("Caso médio (aleatório):    " + Arrays.toString(vetorAleatorio));
        int[] res2 = bubbleSortOtimizado(vetorAleatorio);
        System.out.println("Resultado: " + Arrays.toString(vetorAleatorio));
        System.out.println("Comparações: " + res2[0] + ", Trocas: " + res2[1]);
        System.out.println();

        // Pior caso: vetor ordenado de forma decrescente
        int[] vetorDecrescente = {8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("Pior caso (decrescente):   " + Arrays.toString(vetorDecrescente));
        int[] res3 = bubbleSortOtimizado(vetorDecrescente);
        System.out.println("Resultado: " + Arrays.toString(vetorDecrescente));
        System.out.println("Comparações: " + res3[0] + ", Trocas: " + res3[1]);

        System.out.println();
        System.out.println("Comparação de desempenho (n=8):");
        System.out.println("  Melhor caso (ordenado):     " + res1[0] + " comparações, " + res1[1] + " trocas  → O(n)");
        System.out.println("  Pior caso (decrescente):    " + res3[0] + " comparações, " + res3[1] + " trocas → O(n²)");
        System.out.println("  n(n-1)/2 = " + (8 * 7 / 2));
    }
}
