/**
 * Exercício 8 – Verificação de Palíndromo
 *
 * Implementa algoritmo que verifica se uma string de tamanho n é um palíndromo.
 * Comparação caractere a caractere.
 *
 * Pior caso: Todos os caracteres precisam ser comparados (string é palíndromo
 *            ou a diferença só aparece nos caracteres centrais).
 * Complexidade (pior caso): O(n)
 *   Justificativa: Comparamos caracteres das extremidades em direção ao centro.
 *   No pior caso (palíndromo verdadeiro), fazemos n/2 comparações → O(n).
 */
public class Exercicio08_Palindromo {

    /**
     * Verifica se uma string é palíndromo.
     * Retorna array [resultado (0 ou 1), comparações].
     */
    public static int[] verificarPalindromo(String s) {
        int comparacoes = 0;
        int esquerda = 0;
        int direita = s.length() - 1;

        while (esquerda < direita) {
            comparacoes++;
            if (s.charAt(esquerda) != s.charAt(direita)) {
                return new int[]{0, comparacoes}; // Não é palíndromo
            }
            esquerda++;
            direita--;
        }

        return new int[]{1, comparacoes}; // É palíndromo
    }

    private static void testar(String s) {
        int[] resultado = verificarPalindromo(s);
        String ehPalindromo = resultado[0] == 1 ? "SIM" : "NÃO";
        System.out.printf("\"%s\" (n=%d) → %s | Comparações: %d%n",
                s, s.length(), ehPalindromo, resultado[1]);
    }

    public static void main(String[] args) {
        System.out.println("=== Exercício 8 – Verificação de Palíndromo ===\n");

        // Palíndromos (pior caso – compara todos os pares)
        testar("arara");
        testar("racecar");
        testar("abacaba");
        testar("amanaplanacanalpanama");

        System.out.println();

        // Não-palíndromos (melhor caso – falha logo no início)
        testar("algoritmo");
        testar("java");
        testar("abcdef");

        System.out.println();

        // Falha próxima ao centro (quase pior caso)
        testar("abcdedcxa");

        System.out.println();
        System.out.println("Pior caso: string é palíndromo → n/2 comparações.");
        System.out.println("Complexidade (pior caso): O(n)");
    }
}
