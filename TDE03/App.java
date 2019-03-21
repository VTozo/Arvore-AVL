
public class App {
    public static void main(String[] args){

        ListaEncadeada lista_1 = new ListaEncadeada();
        lista_1.insereUltimo(2);
        lista_1.insereUltimo(5);
        lista_1.insereUltimo(3);
        lista_1.insereUltimo(7);

        ListaEncadeada lista_2 = new ListaEncadeada();
        lista_2.insereUltimo(2);
        lista_2.insereUltimo(5);
        lista_2.insereUltimo(3);
        No no = lista_2.insereUltimo(7);

        lista_2.retiraDepois(no);

        lista_1.mostraLista();
        lista_2.mostraLista();
    }

}
