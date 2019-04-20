import java.util.ArrayList;

class ArvoreBinaria {

    private Node raiz;

    Node getRaiz() {
        return raiz;
    }

    void insereElemento(int dado) {

        ArrayList<Node> lista = new ArrayList<>();

        Node novo = new Node(dado);

        if (vazia()) {
            raiz = novo;
            return;
        }

        Node pai = raiz;

        while ((pai.esquerda != null && dado < pai.getDado()) || (pai.direita != null && dado > pai.getDado())) {

            lista.add(pai);

            if (dado < pai.getDado())
                pai = pai.esquerda;
            else
                pai = pai.direita;
        }
        if (dado < pai.getDado())
            pai.esquerda = novo;
        else
            pai.direita = novo;

        for (int i = lista.size() - 1; i >= 0; i--) {
            rebalancear(lista.get(i));
        }

    }

    Node removeElemento(int dado) {
        if (vazia())
            return null;

        Node raiz_atual = raiz;
        Node pai = raiz;

        while (raiz_atual != null) {
            if (dado == raiz_atual.getDado())
                break;
            pai = raiz_atual;
            if (dado < raiz_atual.getDado())
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
        return encontraElemento(dado) != null;
    }

    Node encontraElemento(int dado) {
        if (vazia())
            return null;

        Node raiz_atual = raiz;

        while (raiz_atual != null) {
            if (dado == raiz_atual.getDado())
                break;

            if (dado < raiz_atual.getDado())
                raiz_atual = raiz_atual.esquerda;
            else
                raiz_atual = raiz_atual.direita;
        }

        return raiz_atual;
    }

    private boolean vazia() {
        return raiz == null;
    }

    void imprimePreordem(Node node) {
        if (node == null)
            return;
        System.out.println(node.getDado());
        imprimePreordem(node.esquerda);
        imprimePreordem(node.direita);
    }

    void imprimeInordem(Node node) {
        if (node == null)
            return;
        imprimeInordem(node.esquerda);
        System.out.println(node.getDado());
        imprimeInordem(node.direita);
    }

    void imprimePosordem(Node node) {
        if (node == null)
            return;
        imprimePosordem(node.esquerda);
        imprimePosordem(node.direita);
        System.out.println(node.getDado());
    }

    private int altura(Node node) {
        if (node != null)
            return 1 + Math.max(altura(node.esquerda), altura(node.direita));
        return 0;
    }

    private Node getPai(Node node) {

        if (node == raiz)
            return null;

        Node raiz_atual = raiz;

        while (raiz_atual != null) {
            if (node == raiz_atual.esquerda || node == raiz_atual.direita)
                break;
            if (node.getDado() < raiz_atual.getDado())
                raiz_atual = raiz_atual.esquerda;
            else
                raiz_atual = raiz_atual.direita;
        }

        return raiz_atual;

    }

    private int balanceamento(Node node) {
        if (node == null)
            return 0;
        return altura(node.direita) - altura(node.esquerda);
    }

    private void rebalancear(Node node) {
        if (balanceamento(node) < -1) {
            if (balanceamento(node.esquerda) > 0) {
                rotacaoEsquerda(node.esquerda);
            }
            rotacaoDireita(node);
        } else if (balanceamento(node) > 1) {
            if (balanceamento(node.direita) < 0) {
                rotacaoDireita(node.direita);
            }
            rotacaoEsquerda(node);
        }
    }

    private void rotacaoEsquerda(Node a) {

        Node pai = getPai(a);
        Node b = a.direita;

        //  pai
        //   |
        //   a
        //    \
        //     b
        //      \
        //       c

        if (a == raiz) {
            raiz = b;
        } else if (pai.getDado() <= b.getDado()) {
            pai.direita = b;
        } else {
            pai.esquerda = b;
        }

        a.direita = b.esquerda;
        b.esquerda = a;

        //   pai
        //    |
        //    b
        //   / \
        //  a   c

    }

    private void rotacaoDireita(Node c) {

        Node pai = getPai(c);
        Node b = c.esquerda;

        //     pai
        //      |
        //      c
        //     /
        //    b
        //   /
        //  a

        if (c == raiz) {
            raiz = b;
        } else if (pai.getDado() <= b.getDado()) {
            pai.direita = b;
        } else {
            pai.esquerda = b;
        }

        c.esquerda = b.direita;
        b.direita = c;

        //   pai
        //    |
        //    b
        //   / \
        //  c   c
    }

}
