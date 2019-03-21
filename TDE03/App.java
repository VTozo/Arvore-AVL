
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
        lista_2.insereUltimo(2);
        lista_2.insereUltimo(5);

        lista_1.mostraLista();
        lista_2.mostraLista();

        lista_1.interseccao(lista_2).mostraLista();
    }

}
