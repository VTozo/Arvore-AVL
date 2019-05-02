class ListaEncadeada {

    private NodeLista primeiro = null;
    private NodeLista ultimo = null;

    void imprimirLista() {
        if (!vazia()) {
            NodeLista atual = primeiro;
            while (atual != null) {
                System.out.println(atual.getArquivo() + ": " + atual.getContador());
                atual = atual.proximo;
            }
        } else
            System.out.println();
    }

    int somaContadores() {
        if (vazia())
            return 0;

        int soma = 0;

        NodeLista no = primeiro;

        while (no != null) {
            soma += no.getContador();
            no = no.proximo;
        }

        return soma;
    }

    NodeLista getPrimeiro() {
        return primeiro;
    }

    void mostraLista() {
        if (vazia())
            return;

        NodeLista no = primeiro;
        System.out.print(no.getArquivo() + ": " + no.getContador());
        while (no.proximo != null) {
            no = no.proximo;
            System.out.print(", " + System.lineSeparator() + no.getArquivo() + ": " + no.getContador());
        }
        System.out.println();
    }

    private boolean vazia() {
        return primeiro == null;
    }

    NodeLista inserePrimeiro(String arquivo) {
        NodeLista node_lista = new NodeLista(arquivo);
        if (vazia()) {
            primeiro = node_lista;
            ultimo = node_lista;
        } else {
            node_lista.proximo = primeiro;
            primeiro = node_lista;
        }

        return node_lista;
    }

    NodeLista insereDepois(String arquivo, NodeLista anterior) {
        if (anterior == ultimo)
            return insereUltimo(arquivo);

        NodeLista node_lista = new NodeLista(arquivo);
        node_lista.proximo = anterior.proximo;
        anterior.proximo = node_lista;
        return node_lista;
    }

    NodeLista insereUltimo(String arquivo) {
        NodeLista node_lista = new NodeLista(arquivo);
        if (vazia()) {
            primeiro = node_lista;
            ultimo = node_lista;
        } else {
            ultimo.proximo = node_lista;
            ultimo = node_lista;
        }
        return node_lista;
    }

    NodeLista insereOrdenado(String arquivo) {

        if (vazia() || primeiro.getArquivo().compareTo(arquivo) >= 0) {
            return inserePrimeiro(arquivo);
        }

        if (ultimo.getArquivo().compareTo(arquivo) <= 0) {
            return insereUltimo(arquivo);
        }

        NodeLista anterior = primeiro;
        NodeLista i = primeiro.proximo;
        while (i.getArquivo().compareTo(arquivo) < 0) {
            anterior = i;
            i = i.proximo;
        }

        return insereDepois(arquivo, anterior);

    }

    String ultimoElemento() {
        return ultimo.getArquivo();
    }

    NodeLista encontraElemento(String arquivo) {
        NodeLista NodeLista = primeiro;
        while (NodeLista != null) {
            if (NodeLista.getArquivo().equals(arquivo))
                return NodeLista;
            NodeLista = NodeLista.proximo;
        }
        return null;
    }

    int tamanho() {
        if (vazia())
            return 0;

        NodeLista NodeLista = primeiro;
        int i = 1;
        while (NodeLista.proximo != null) {
            NodeLista = NodeLista.proximo;
            i++;
        }
        return i;
    }

    boolean existe(String arquivo) {
        NodeLista NodeLista = primeiro;
        while (NodeLista != null) {
            if (arquivo.equals(NodeLista.getArquivo()))
                return true;
            NodeLista = NodeLista.proximo;
        }
        return false;
    }

}