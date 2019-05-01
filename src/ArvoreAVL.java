import java.util.ArrayList;

class ArvoreAVL {

    private NodeAVL raiz;

    NodeAVL getRaiz() {
        return raiz;
    }

    void insereElemento(String dado) {

        ArrayList<NodeAVL> lista = new ArrayList<>();

        NodeAVL novo = new NodeAVL(dado);

        if (vazia()) {
            raiz = novo;
            return;
        }

        NodeAVL pai = raiz;

        while ((pai.esquerda != null && dado.compareTo(pai.getPalavra()) < 0) || (pai.direita != null && dado.compareTo(pai.getPalavra()) > 0)) {

            lista.add(pai);

            if (dado.compareTo(pai.getPalavra()) < 0)
                pai = pai.esquerda;
            else
                pai = pai.direita;
        }
        if (dado.compareTo(pai.getPalavra()) < 0)
            pai.esquerda = novo;
        else
            pai.direita = novo;

        for (int i = lista.size() - 1; i >= 0; i--) {
            rebalancear(lista.get(i));
        }

    }

    void removeElemento(String dado) {
        if (vazia())
            return;

        NodeAVL elemento = encontraElemento(dado);

        if (elemento == null)
            return; // Não existe

        NodeAVL pai = getPai(elemento);

        if (elemento.esquerda == null && elemento.direita == null) {
            // Se o elemento a retirar for uma folha
            if (elemento == raiz)
                raiz = null;
            else if (pai.direita == elemento)
                pai.direita = null;
            else
                pai.esquerda = null;
        } else if (elemento.esquerda == null) {
            // Se o elemento a retirar tiver UM filho (direita)
            if (elemento == raiz)
                raiz = elemento.direita;
            else if (pai.direita == elemento)
                pai.direita = elemento.direita;
            else
                pai.esquerda = elemento.direita;
        } else if (elemento.direita == null) {
            // Se o elemento a retirar tiver UM filho (esquerda)
            if (elemento == raiz)
                raiz = elemento.esquerda;
            else if (pai.esquerda == elemento)
                pai.esquerda = elemento.esquerda;
            else
                pai.direita = elemento.esquerda;
        } else {
            // Se o elemento a retirar tiver os dois filhos
            NodeAVL substituto = encontraMenorElemento(elemento.direita);
            elemento.setPalavra(substituto.getPalavra());
            removeElemento(substituto);
        }

    }

    void removeElemento(NodeAVL elemento) {

        NodeAVL pai = getPai(elemento);

        if (elemento.esquerda == null && elemento.direita == null) {
            // Se o elemento a retirar for uma folha
            if (elemento == raiz)
                raiz = null;
            else if (pai.direita == elemento)
                pai.direita = null;
            else
                pai.esquerda = null;
        } else if (elemento.esquerda == null) {
            // Se o elemento a retirar tiver UM filho (direita)
            if (elemento == raiz)
                raiz = elemento.direita;
            else if (pai.direita == elemento)
                pai.direita = elemento.direita;
            else
                pai.esquerda = elemento.direita;
        } else if (elemento.direita == null) {
            // Se o elemento a retirar tiver UM filho (esquerda)
            if (elemento == raiz)
                raiz = elemento.esquerda;
            else if (pai.esquerda == elemento)
                pai.esquerda = elemento.esquerda;
            else
                pai.direita = elemento.esquerda;
        } else {
            // Se o elemento a retirar tiver os dois filhos
            NodeAVL substituto = encontraMenorElemento(elemento.direita);
            elemento.setPalavra(substituto.getPalavra());
            removeElemento(substituto);
        }

    }

    boolean existeElemento(String dado) {
        return encontraElemento(dado) != null;
    }

    NodeAVL encontraElemento(String dado) {
        if (vazia())
            return null;

        NodeAVL raiz_atual = raiz;

        while (raiz_atual != null) {
            if (dado.equals(raiz_atual.getPalavra()))
                break;

            if (dado.compareTo(raiz_atual.getPalavra()) < 0)
                raiz_atual = raiz_atual.esquerda;
            else
                raiz_atual = raiz_atual.direita;
        }

        return raiz_atual;
    }

    NodeAVL encontraMenorElemento(NodeAVL nodeAVL) {

        NodeAVL raiz_atual = nodeAVL;

        while (raiz_atual.esquerda != null) {
            raiz_atual = raiz_atual.esquerda;
        }

        return raiz_atual;
    }

    private boolean vazia() {
        return raiz == null;
    }

    void imprimePreordem(NodeAVL nodeAVL) {
        if (nodeAVL == null)
            return;
        System.out.println(nodeAVL.getPalavra());
        imprimePreordem(nodeAVL.esquerda);
        imprimePreordem(nodeAVL.direita);
    }

    void imprimeInordem(NodeAVL nodeAVL) {
        if (nodeAVL == null)
            return;
        imprimeInordem(nodeAVL.esquerda);
        System.out.println(nodeAVL.getPalavra());
        imprimeInordem(nodeAVL.direita);
    }

    void imprimePosordem(NodeAVL nodeAVL) {
        if (nodeAVL == null)
            return;
        imprimePosordem(nodeAVL.esquerda);
        imprimePosordem(nodeAVL.direita);
        System.out.println(nodeAVL.getPalavra());
    }

    private int altura(NodeAVL nodeAVL) {
        if (nodeAVL != null)
            return 1 + Math.max(altura(nodeAVL.esquerda), altura(nodeAVL.direita));
        return 0;
    }

    private NodeAVL getPai(NodeAVL nodeAVL) {

        if (nodeAVL == raiz)
            return null;

        NodeAVL raiz_atual = raiz;

        while (raiz_atual != null) {
            if (nodeAVL == raiz_atual.esquerda || nodeAVL == raiz_atual.direita)
                break;
            if (nodeAVL.getPalavra().compareTo(raiz_atual.getPalavra()) < 0)
                raiz_atual = raiz_atual.esquerda;
            else
                raiz_atual = raiz_atual.direita;
        }

        return raiz_atual;

    }

    private int balanceamento(NodeAVL nodeAVL) {
        if (nodeAVL == null)
            return 0;
        return altura(nodeAVL.direita) - altura(nodeAVL.esquerda);
    }

    private void rebalancear(NodeAVL nodeAVL) {
        if (balanceamento(nodeAVL) < -1) {
            if (balanceamento(nodeAVL.esquerda) > 0) {
                rotacaoEsquerda(nodeAVL.esquerda);
            }
            rotacaoDireita(nodeAVL);
        } else if (balanceamento(nodeAVL) > 1) {
            if (balanceamento(nodeAVL.direita) < 0) {
                rotacaoDireita(nodeAVL.direita);
            }
            rotacaoEsquerda(nodeAVL);
        }
    }

    private void rotacaoEsquerda(NodeAVL a) {

        NodeAVL pai = getPai(a);
        NodeAVL b = a.direita;

        //  pai
        //   |
        //   a
        //    \
        //     b
        //      \
        //       c

        if (a == raiz) {
            raiz = b;
        } else if (pai.getPalavra().compareTo(b.getPalavra()) <= 0) {
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

    private void rotacaoDireita(NodeAVL c) {

        NodeAVL pai = getPai(c);
        NodeAVL b = c.esquerda;

        //     pai
        //      |
        //      c
        //     /
        //    b
        //   /
        //  a

        if (c == raiz) {
            raiz = b;
        } else if (pai.getPalavra().compareTo(b.getPalavra()) <= 0) {
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
        //  c   a
    }

}
