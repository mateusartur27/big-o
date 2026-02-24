/**
 * Exercício 9 – Substring por Força Bruta
 *
 * Implementa busca de padrão (P) em um texto (T) usando força bruta.
 * Conta o número de comparações realizadas.
 *
 * Pior caso: Falha apenas no último caractere do padrão, repetidamente.
 *   Exemplo: T = "aaaaab", P = "aab" → em quase toda posição, compara m
 *   caracteres antes de falhar.
 * Complexidade (pior caso): O(n · m)
 *   Justificativa: Para cada uma das (n - m + 1) posições no texto, comparamos
 *   até m caracteres do padrão. No pior caso: (n - m + 1) × m ≈ O(n · m).
 */
public class Exercicio09_SubstringForcaBruta {

    /**
     * Busca de padrão por força bruta.
     * Retorna array [posição encontrada (-1 se não), comparações].
     */
    public static int[] buscaForcaBruta(String texto, String padrao) {
        int n = texto.length();
        int m = padrao.length();
        int comparacoes = 0;

        for (int i = 0; i <= n - m; i++) {
            int j = 0;

            while (j < m) {
                comparacoes++;
                if (texto.charAt(i + j) != padrao.charAt(j)) {
                    break;
                }
                j++;
            }

            if (j == m) {
                return new int[]{i, comparacoes}; // Padrão encontrado na posição i
            }
        }

        return new int[]{-1, comparacoes}; // Padrão não encontrado
    }

    /**
     * Busca todas as ocorrências.
     */
    public static void buscaTodasOcorrencias(String texto, String padrao) {
        int n = texto.length();
        int m = padrao.length();
        int comparacoes = 0;
        int ocorrencias = 0;

        System.out.println("Texto:  \"" + texto + "\" (n=" + n + ")");
        System.out.println("Padrão: \"" + padrao + "\" (m=" + m + ")");

        for (int i = 0; i <= n - m; i++) {
            int j = 0;

            while (j < m) {
                comparacoes++;
                if (texto.charAt(i + j) != padrao.charAt(j)) {
                    break;
                }
                j++;
            }

            if (j == m) {
                System.out.println("  → Encontrado na posição " + i);
                ocorrencias++;
            }
        }

        System.out.println("Ocorrências: " + ocorrencias + " | Comparações: " + comparacoes);
    }

    private static void testarSimples(String texto, String padrao) {
        int[] res = buscaForcaBruta(texto, padrao);
        System.out.printf("T=\"%s\", P=\"%s\" → Posição: %d, Comparações: %d%n",
                texto, padrao, res[0], res[1]);
    }

    public static void main(String[] args) {
        System.out.println("=== Exercício 9 – Substring por Força Bruta ===\n");

        // Casos normais
        testarSimples("algoritmos e estruturas", "estrut");
        testarSimples("abcdefgh", "efg");
        testarSimples("abcdefgh", "xyz");
        System.out.println();

        // Pior caso: falha apenas no último caractere repetidamente
        System.out.println("--- Pior caso ---");
        testarSimples("aaaaaaaab", "aaab");
        testarSimples("aaaaaaaaaaaaaab", "aaaab");
        System.out.println();

        // Busca com todas as ocorrências
        System.out.println("--- Todas as ocorrências ---");
        buscaTodasOcorrencias("ababababab", "aba");
        System.out.println();

        // Demonstração do pior caso teórico
        System.out.println("--- Demonstração pior caso teórico ---");
        buscaTodasOcorrencias("aaaaaaaaaa", "aaaa");

        System.out.println();
        System.out.println("Pior caso: falha no último caractere do padrão repetidamente.");
        System.out.println("Complexidade (pior caso): O(n × m)");
    }
}
