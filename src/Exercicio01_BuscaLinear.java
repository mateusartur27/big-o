import java.util.Arrays;

/**
 * Exercício 1 – Busca Linear com Contagem de Comparações
 *
 * Implementa busca linear que procura um valor x em um vetor de n inteiros,
 * contando o número de comparações realizadas.
 *
 * Pior caso: Elemento inexistente ou na última posição.
 * Complexidade (pior caso): O(n)
 *   Justificativa: No pior caso, percorremos TODOS os n elementos do vetor
 *   antes de encontrar o valor (última posição) ou concluir que ele não existe.
 *   Cada iteração realiza exatamente 1 comparação, totalizando n comparações.
 */
public class Exercicio01_BuscaLinear {

    /**
     * Retorna um array de 2 posições:
     *   [0] = índice encontrado (ou -1)
     *   [1] = número de comparações realizadas
     */
    public static int[] buscaLinear(int[] vetor, int x) {
        int comparacoes = 0;

        for (int i = 0; i < vetor.length; i++) {
            comparacoes++;
            if (vetor[i] == x) {
                return new int[]{i, comparacoes};
            }
        }

        return new int[]{-1, comparacoes};
    }

    public static void main(String[] args) {
        int[] vetor = {10, 25, 3, 47, 15, 8, 33, 19};

        System.out.println("=== Exercício 1 – Busca Linear ===");
        System.out.println("Vetor: " + Arrays.toString(vetor));
        System.out.println();

        // Caso 1: Elemento no meio
        int[] res1 = buscaLinear(vetor, 47);
        System.out.println("Busca por 47 -> Posição: " + res1[0] + ", Comparações: " + res1[1]);

        // Caso 2: Elemento na última posição (pior caso – encontrado)
        int[] res2 = buscaLinear(vetor, 19);
        System.out.println("Busca por 19 -> Posição: " + res2[0] + ", Comparações: " + res2[1]);

        // Caso 3: Elemento inexistente (pior caso – não encontrado)
        int[] res3 = buscaLinear(vetor, 99);
        System.out.println("Busca por 99 -> Posição: " + res3[0] + ", Comparações: " + res3[1]);

        System.out.println();
        System.out.println("Pior caso: elemento inexistente ou na última posição.");
        System.out.println("Complexidade (pior caso): O(n)");
        System.out.println("Justificativa: todos os n elementos são comparados.");
    }
}
