class Node {

    Node esquerda;
    Node direita;
    private int dado;

    Node(int dado) {
        this.dado = dado;
    }

    int getDado() {
        return dado;
    }

    public void setDado(int dado) {
        this.dado = dado;
    }
}
