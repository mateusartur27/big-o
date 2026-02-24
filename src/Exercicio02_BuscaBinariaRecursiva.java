import java.util.Arrays;

/**
 * Exercício 2 – Busca Binária Recursiva
 *
 * Implementa busca binária de forma recursiva em vetor ordenado.
 * Considera vetores com tamanho potência de 2.
 *
 * Pior caso: Elemento não está no vetor ou só é eliminado após todas as divisões.
 * Complexidade (pior caso): O(log n)
 *   Justificativa: A cada chamada recursiva, o espaço de busca é dividido pela
 *   metade. No pior caso, dividimos até sobrar 1 elemento, resultando em
 *   ⌊log₂(n)⌋ + 1 comparações.
 */
public class Exercicio02_BuscaBinariaRecursiva {

    /**
     * Busca binária recursiva.
     * Retorna o índice do elemento ou -1 se não encontrado.
     */
    public static int buscaBinaria(int[] vetor, int x, int esquerda, int direita) {
        if (esquerda > direita) {
            return -1;
        }

        int meio = esquerda + (direita - esquerda) / 2;

        if (vetor[meio] == x) {
            return meio;
        } else if (x < vetor[meio]) {
            return buscaBinaria(vetor, x, esquerda, meio - 1);
        } else {
            return buscaBinaria(vetor, x, meio + 1, direita);
        }
    }

    /**
     * Versão com contagem de comparações.
     * Retorna array [índice, comparações].
     */
    public static int[] buscaBinariaComContagem(int[] vetor, int x, int esquerda, int direita, int comparacoes) {
        if (esquerda > direita) {
            return new int[]{-1, comparacoes};
        }

        int meio = esquerda + (direita - esquerda) / 2;
        comparacoes++;

        if (vetor[meio] == x) {
            return new int[]{meio, comparacoes};
        } else if (x < vetor[meio]) {
            return buscaBinariaComContagem(vetor, x, esquerda, meio - 1, comparacoes);
        } else {
            return buscaBinariaComContagem(vetor, x, meio + 1, direita, comparacoes);
        }
    }

    public static void main(String[] args) {
        // Vetor ordenado com tamanho potência de 2 (16 elementos)
        int[] vetor = {2, 5, 8, 12, 16, 23, 38, 42, 55, 67, 72, 81, 93, 95, 97, 99};

        System.out.println("=== Exercício 2 – Busca Binária Recursiva ===");
        System.out.println("Vetor (n=" + vetor.length + "): " + Arrays.toString(vetor));
        System.out.println();

        // Caso 1: Elemento existente
        int[] res1 = buscaBinariaComContagem(vetor, 23, 0, vetor.length - 1, 0);
        System.out.println("Busca por 23 -> Posição: " + res1[0] + ", Comparações: " + res1[1]);

        // Caso 2: Elemento existente na extremidade
        int[] res2 = buscaBinariaComContagem(vetor, 2, 0, vetor.length - 1, 0);
        System.out.println("Busca por 2  -> Posição: " + res2[0] + ", Comparações: " + res2[1]);

        // Caso 3: Elemento inexistente (pior caso)
        int[] res3 = buscaBinariaComContagem(vetor, 50, 0, vetor.length - 1, 0);
        System.out.println("Busca por 50 -> Posição: " + res3[0] + ", Comparações: " + res3[1]);

        // Caso 4: Elemento inexistente fora do intervalo
        int[] res4 = buscaBinariaComContagem(vetor, 100, 0, vetor.length - 1, 0);
        System.out.println("Busca por 100-> Posição: " + res4[0] + ", Comparações: " + res4[1]);

        System.out.println();
        System.out.println("Para n=" + vetor.length + ", log₂(n) = " + (int)(Math.log(vetor.length) / Math.log(2)));
        System.out.println("Pior caso: elemento ausente, todas as divisões são feitas.");
        System.out.println("Complexidade (pior caso): O(log n)");
    }
}
