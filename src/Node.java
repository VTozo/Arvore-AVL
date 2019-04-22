class Node {

    Node esquerda;
    Node direita;
    private int contador;
    private String palavra;

    Node(String palavra) {
        this.palavra = palavra;
        this.contador = 1;
    }

    String getDado() {
        return palavra;
    }

    void setDado(String dado) {
        this.palavra = dado;
    }

    void incrementar(){
        contador++;
    }
}
