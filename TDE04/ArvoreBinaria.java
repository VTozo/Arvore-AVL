class ArvoreBinaria {
    
    private Node raiz;
    
    Node insereElemento(int dado){
        Node novo = new Node(dado);
        if (vazia()) return raiz = novo;
        
        Node raiz_atual = raiz;
        while (raiz_atual != null){
            if (dado < raiz_atual.dado) raiz_atual = raiz_atual.esquerda;
            else raiz_atual = raiz_atual.direita;
        }
        return novo;
    }
    
    void removeElemento(){}
    
    private boolean vazia(){
        return raiz == null;
    }
    
}
