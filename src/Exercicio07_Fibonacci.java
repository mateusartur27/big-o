/**
 * Exercício 7 – Fibonacci Recursivo vs Programação Dinâmica
 *
 * Implementa:
 * 1. Fibonacci recursivo simples
 * 2. Fibonacci usando programação dinâmica (bottom-up)
 *
 * Compara o número de chamadas recursivas.
 *
 * Pior caso (recursivo simples): Valores grandes de n.
 * Complexidade:
 *   Recursivo simples: O(2ⁿ)
 *     Justificativa: cada chamada gera 2 subchamadas, formando uma árvore
 *     binária de profundidade n. O número de nós ≈ 2ⁿ.
 *   Programação dinâmica: O(n)
 *     Justificativa: calcula cada valor uma única vez, de 0 até n,
 *     em um laço simples de n iterações.
 */
public class Exercicio07_Fibonacci {

    static long chamadasRecursivas;

    // ========== 1. Fibonacci Recursivo Simples ==========

    public static long fibRecursivo(int n) {
        chamadasRecursivas++;
        if (n <= 1) {
            return n;
        }
        return fibRecursivo(n - 1) + fibRecursivo(n - 2);
    }

    // ========== 2. Fibonacci com Programação Dinâmica (Bottom-Up) ==========

    public static long fibDP(int n) {
        if (n <= 1) return n;

        long[] tabela = new long[n + 1];
        tabela[0] = 0;
        tabela[1] = 1;

        for (int i = 2; i <= n; i++) {
            tabela[i] = tabela[i - 1] + tabela[i - 2];
        }

        return tabela[n];
    }

    // ========== 3. Fibonacci com Memoização (Top-Down) ==========

    static long chamadasMemoizacao;

    public static long fibMemoizacao(int n, long[] memo) {
        chamadasMemoizacao++;
        if (memo[n] != -1) {
            return memo[n];
        }
        if (n <= 1) {
            memo[n] = n;
            return n;
        }
        memo[n] = fibMemoizacao(n - 1, memo) + fibMemoizacao(n - 2, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println("=== Exercício 7 – Fibonacci Recursivo vs Programação Dinâmica ===\n");

        int[] valores = {10, 20, 30, 40};

        System.out.println("--- Fibonacci Recursivo Simples ---");
        for (int n : valores) {
            chamadasRecursivas = 0;
            long inicio = System.nanoTime();
            long resultado = fibRecursivo(n);
            long tempo = System.nanoTime() - inicio;
            System.out.printf("fib(%d) = %d | Chamadas: %,d | Tempo: %.3f ms%n",
                    n, resultado, chamadasRecursivas, tempo / 1_000_000.0);
        }

        System.out.println("\n--- Fibonacci com Programação Dinâmica (Bottom-Up) ---");
        for (int n : valores) {
            long inicio = System.nanoTime();
            long resultado = fibDP(n);
            long tempo = System.nanoTime() - inicio;
            System.out.printf("fib(%d) = %d | Iterações: %d | Tempo: %.3f ms%n",
                    n, resultado, Math.max(0, n - 1), tempo / 1_000_000.0);
        }

        System.out.println("\n--- Fibonacci com Memoização (Top-Down) ---");
        for (int n : valores) {
            chamadasMemoizacao = 0;
            long[] memo = new long[n + 1];
            java.util.Arrays.fill(memo, -1);
            long inicio = System.nanoTime();
            long resultado = fibMemoizacao(n, memo);
            long tempo = System.nanoTime() - inicio;
            System.out.printf("fib(%d) = %d | Chamadas: %,d | Tempo: %.3f ms%n",
                    n, resultado, chamadasMemoizacao, tempo / 1_000_000.0);
        }

        System.out.println("\n--- Comparação ---");
        System.out.println("Recursivo simples: O(2ⁿ) → crescimento exponencial.");
        System.out.println("Prog. Dinâmica:    O(n)  → crescimento linear.");
        System.out.println("Memoização:        O(n)  → evita recálculos com cache.");
    }
}
