public class App {
    public static void main(String[] args){
        ListaEncadeada lista = new ListaEncadeada();

        No no_a = lista.inserePrimeiro(4);
        lista.mostraLista();
        lista.insereDepois(3, no_a);
        lista.mostraLista();
        lista.insereUltimo(2);

        lista.mostraLista();

    }
}
