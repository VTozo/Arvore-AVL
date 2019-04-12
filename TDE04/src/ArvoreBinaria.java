class ArvoreBinaria {

    private Node raiz;

    Node getRaiz() {
        return raiz;
    }

    Node insereElemento(int dado) {

        Node novo = new Node(dado);

        if (vazia())
            return raiz = novo;

        Node pai = raiz;

        while ((pai.esquerda != null && dado < pai.dado) || (pai.direita != null && dado > pai.dado)) {
            if (dado < pai.dado)
                pai = pai.esquerda;
            else
                pai = pai.direita;
        }
        if (dado < pai.dado)
            return pai.esquerda = novo;
        else
            return pai.direita = novo;
    }

    Node removeElemento(int dado) {
        if (vazia())
            return null;

        Node raiz_atual = raiz;
        Node pai = raiz;

        while (raiz_atual != null) {
            if (dado == raiz_atual.dado)
                break;
            pai = raiz_atual;
            if (dado < raiz_atual.dado)
                raiz_atual = raiz_atual.esquerda;
            else
                raiz_atual = raiz_atual.direita;
        }

        if (raiz_atual == null)
            return null; // Não existe


        if (pai.direita == raiz_atual)
            pai.direita = null;
        else
            pai.esquerda = null;

        return raiz_atual;
    }

    boolean existeElemento(int dado) {
        if (vazia())
            return false;

        Node raiz_atual = raiz;

        while (raiz_atual != null) {
            if (dado == raiz_atual.dado)
                break;

            if (dado < raiz_atual.dado)
                raiz_atual = raiz_atual.esquerda;
            else
                raiz_atual = raiz_atual.direita;
        }

        return raiz_atual != null;
    }

    private boolean vazia() {
        return raiz == null;
    }

    void imprimePreordem(Node node) {
        if (node == null)
            return;
        System.out.println(node.dado);
        imprimePreordem(node.esquerda);
        imprimePreordem(node.direita);
    }

    void imprimeInordem(Node node) {
        if (node == null)
            return;
        imprimePreordem(node.esquerda);
        System.out.println(node.dado);
        imprimePreordem(node.direita);
    }

    void imprimePosordem(Node node) {
        if (node == null)
            return;
        imprimePreordem(node.esquerda);
        imprimePreordem(node.direita);
        System.out.println(node.dado);
    }

    int altura(Node node) {
        if (node != null)
            return 1 + Math.max(altura(node.esquerda), altura(node.direita));
        return 0;
    }

}
