class NodeLista {
    private int contador;
    private String arquivo;
    NodeLista proximo = null;

    NodeLista(String arquivo){
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
