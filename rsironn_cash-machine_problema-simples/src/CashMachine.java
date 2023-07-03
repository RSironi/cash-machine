import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CashMachine {
    private static final int[] NOTAS_VALIDAS = {100, 50, 20, 10};

    public void calculaNotas(int valor) {
        List<Integer> notasUsadas = new ArrayList<>();

        if (valor <= 0) {
            System.out.println("Valor inválido. Insira um valor positivo.");
            return;
        }

        Arrays.sort(NOTAS_VALIDAS); // Ordena as notas válidas em ordem crescente

        for (int i = NOTAS_VALIDAS.length - 1; i >= 0 && valor > 0; i--) {
            int quantidadeNotas = valor / NOTAS_VALIDAS[i];
            valor %= NOTAS_VALIDAS[i];

            for (int j = 0; j < quantidadeNotas; j++) {
                notasUsadas.add(NOTAS_VALIDAS[i]);
            }
        }

        if (valor > 0) {
            System.out.println("Não é possível obter a quantidade exata de notas.");
        } else if (notasUsadas.isEmpty()) {
            System.out.println("Não há notas válidas para o valor informado.");
        } else {
            System.out.println("Notas Utilizadas:");
            for (int nota : notasUsadas) {
                System.out.println(nota);
            }
        }
    }

    public int[] getNotasValidas() {
        return NOTAS_VALIDAS;
    }
}