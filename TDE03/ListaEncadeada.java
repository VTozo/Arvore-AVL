class ListaEncadeada {

    private No primeiro = null;
    private No ultimo = null;

    int tamanho_recursivo(No no, int i){
        if (no == null) return i;
        return tamanho_recursivo(no.proximo, ++i);
    }

    No getPrimeiro() {
        return primeiro;
    }

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

    No insereOrdenado(int dado){

        if(vazia() || primeiro.dado >= dado){
            return inserePrimeiro(dado);
        }

        if(ultimo.dado <= dado){
            return insereUltimo(dado);
        }

        No anterior = primeiro;
        No i = primeiro.proximo;
        while(i.dado < dado){
            anterior = i;
            i = i.proximo;
        }

        return insereDepois(dado, anterior);

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

        if (p == ultimo) return 0;

        int retorno = p.proximo.dado;

        p.proximo = p.proximo.proximo;

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

    int tamanho(){
        if (vazia()) return 0;

        No no = primeiro;
        int i = 1;
        while(no.proximo != null){
            no = no.proximo;
            i++;
        }
        return i;
    }

    boolean existe(int dado) {
        No no = primeiro;
        while (no != null) {
            if (dado == no.dado) return true;
            no = no.proximo;
        }
        return false;
    }

    double similaridade(ListaEncadeada lista){
        if (tamanho() != lista.tamanho()) return 0;

        No no_1 = primeiro;
        No no_2 = lista.primeiro;

        double numerador = 0;
        double denominador_1 = 0;
        double denominador_2 = 0;

        while(no_1 != null){
            numerador += no_1.dado * no_2.dado;

            denominador_1 += Math.pow(no_1.dado, 2);
            denominador_2 += Math.pow(no_2.dado, 2);

            no_1 = no_1.proximo;
            no_2 = no_2.proximo;
        }

        return numerador/Math.sqrt(denominador_1*denominador_2);
    }

    ListaEncadeada interseccao(ListaEncadeada lista){

        ListaEncadeada resultado = new ListaEncadeada();

        No no_a = primeiro;
        while(no_a != null){
            No no_b = lista.primeiro;
            while(no_b != null){

                if (no_a.dado == no_b.dado){
                    if(!resultado.existe(no_a.dado))
                    resultado.insereOrdenado(no_a.dado);
                    break;
                }

                no_b = no_b.proximo;
            }

            no_a = no_a.proximo;
        }

        return resultado;
    }
}
