class NodeLista {
    NodeLista proximo = null;
    private int contador;
    private String arquivo;

    NodeLista(String arquivo) {
        this.arquivo = arquivo;
        this.contador = 1;
    }

    String getArquivo() {
        return arquivo;
    }

    int getContador() {
        return contador;
    }

    void incrementaContador() {
        this.contador++;
    }

}
