class FilaCircular {
    private int primeiro = 0;
    private int MAX;
    private int ultimo = -1;
    private int[] dados;
    private int tamanho = 0;

    FilaCircular(int max) {
        MAX = max;
        dados = new int[MAX];
    }

    void imprimir() {
        if (vazia()) {
            System.out.println("Fila está vazia");
            return;
        }

        for (int i = primeiro; i < primeiro + tamanho - 1; i++) {
            System.out.print(dados[i % MAX] + ", ");
        }

        System.out.println(ultimo());
    }

    void insere(int n) {
        if (cheia()) {
            System.out.println("A fila está cheia");
            return;
        }

        ultimo = ++ultimo % MAX;
        dados[ultimo] = n;
        tamanho++;
    }

    Integer remove() {
        if (vazia()) {
            System.out.println("A fila está vazia");
            return null;
        }

        int retorno = dados[primeiro];
        primeiro = ++primeiro % MAX;
        tamanho--;

        return retorno;
    }

    private Integer primeiro() {
        if (vazia()) return null;
        return dados[primeiro];
    }

    private Integer ultimo() {
        if (vazia()) return null;
        return dados[ultimo];
    }

    private boolean vazia() {
        return tamanho == 0;
    }

    private boolean cheia() {
        return tamanho == MAX;
    }

    FilaCircular merge(FilaCircular b) {
        FilaCircular resultado = new FilaCircular(MAX + b.MAX);

        while (!vazia() || !b.vazia()) {

            if (b.primeiro() == null) resultado.insere(remove());
            else if (primeiro() == null) resultado.insere(b.remove());
            else if (primeiro() < b.primeiro()) resultado.insere(remove());
            else resultado.insere(b.remove());

        }

        return resultado;
    }
}
