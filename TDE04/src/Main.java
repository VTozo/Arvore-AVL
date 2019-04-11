class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        arvore.insereElemento(5);
        arvore.insereElemento(12);
        arvore.insereElemento(7);
        arvore.insereElemento(9);
        arvore.insereElemento(22);
        arvore.insereElemento(3);
        arvore.insereElemento(1);
        arvore.insereElemento(4);
        arvore.insereElemento(18);
        arvore.insereElemento(16);
        arvore.insereElemento(13);

        arvore.removeElemento(13);
        arvore.removeElemento(16);

        arvore.imprimePreordem(arvore.getRaiz());
        System.out.println();
        arvore.imprimeInordem(arvore.getRaiz());
        System.out.println();
        arvore.imprimePosordem(arvore.getRaiz());
    }
}
