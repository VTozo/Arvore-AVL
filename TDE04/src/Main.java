class Main {
    public static void main(String[] args) {

        ArvoreBinaria arvore = new ArvoreBinaria();
        arvore.insereElemento(9);
        arvore.insereElemento(12);
        arvore.insereElemento(16);
        arvore.insereElemento(3);
        arvore.insereElemento(21);
        arvore.insereElemento(13);
        arvore.insereElemento(45);
        arvore.insereElemento(23);
        arvore.insereElemento(0);
        arvore.insereElemento(14);
        arvore.insereElemento(8);
        arvore.insereElemento(1);

        arvore.imprimeInordem(arvore.getRaiz());
        System.out.println();
        System.out.println(arvore.getRaiz().getDado());

    }
}
