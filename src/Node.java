class Node {

    Node esquerda;
    Node direita;
    private int contador;
    private String palavra;

    Node(String palavra) {
        this.palavra = palavra;
        this.contador = 1;
    }

    String getPalavra() {
        return palavra;
    }

    void setPalavra(String dado) {
        this.palavra = dado;
    }

    void incrementaContador() {
        contador++;
    }

    public int getContador() {
        return contador;
    }
}
