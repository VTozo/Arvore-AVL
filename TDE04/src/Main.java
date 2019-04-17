class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        arvore.insereElemento(12);
        arvore.insereElemento(5);
        arvore.insereElemento(16);
        arvore.insereElemento(13);

        arvore.rotacaoDireita(arvore.encontraElemento(16));
    }
}
