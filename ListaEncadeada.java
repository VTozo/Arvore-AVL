class ListaEncadeada {
    private No primeiro = null;
    private No ultimo = null;

    private boolean vazia(){
        return primeiro == null;
    }

    No inserePrimeiro(int dado){
        No novo = new No(dado);
        if(vazia()){
            primeiro = novo;
            ultimo = novo;
        }
        else{
            novo.proximo = primeiro;
            primeiro = novo;
        }

        return novo;
    }

    No insereDepois(int dado, No anterior){
        if(anterior == ultimo) return insereUltimo(dado);

        No novo = new No(dado);
        novo.proximo = anterior.proximo;
        anterior.proximo = novo;
        return novo;
    }

    No insereUltimo(int dado){
        No novo = new No(dado);
        if(vazia()){
            primeiro = novo;
            ultimo = novo;
        }
        else{
            ultimo.proximo = novo;
            ultimo = novo;
        }
        return novo;
    }

    void insereOrdenado(int dado){

        if(vazia() || primeiro.dado >= dado){
            inserePrimeiro(dado);
            return;
        }

        if(ultimo.dado <= dado){
            insereUltimo(dado);
            return;
        }

        No anterior = primeiro;
        No i = primeiro.proximo;
        while(i.dado < dado){
            anterior = i;
            i = i.proximo;
        }

        insereDepois(dado, anterior);

    }

    void mostraLista(){
        if(vazia()) return;

        No no = primeiro;
        System.out.print(no.dado);
        while(no.proximo != null){
            no = no.proximo;
            System.out.print(", "+no.dado);
        }
        System.out.println();
    }

    int retiraPrimeiro(){
        int retorno = primeiro.dado;
        primeiro = primeiro.proximo;
        return retorno;
    }

    int retiraUltimo(){

        int retorno = ultimo.dado;

        No no = primeiro;
        while(no.proximo != ultimo){
            no = no.proximo;
        }
        no.proximo = null;
        ultimo = no;

        return retorno;
    }

    int retiraDepois(No p){

        int retorno = p.dado;

        No no = primeiro;
        while(no.proximo != p){
            no = no.proximo;
        }

        no.proximo = p.proximo;

        return retorno;
    }

    int ultimoElemento(){
        return ultimo.dado;
    }

    No encontraElemento(int dado){
        No no = primeiro;
        while(no.proximo != null){
            if(no.dado == dado) return no;
            no = no.proximo;
        }
        return null;
    }
}
