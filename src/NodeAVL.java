class NodeAVL {

    NodeAVL esquerda;
    NodeAVL direita;

    private ListaEncadeada arquivos;
    private String palavra;

    NodeAVL(String palavra) {
        this.palavra = palavra;
    }

    String getPalavra() {
        return palavra;
    }

    void setPalavra(String dado) {
        this.palavra = dado;
    }

    NodeLista getArquivo(String nome) {
        return arquivos.encontraElemento(nome);
    }

    ListaEncadeada getArquivos() {
        return arquivos;
    }

}
