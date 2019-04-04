
public class App {
    public static void main(String[] args){

        ListaEncadeada lista_1 = new ListaEncadeada();
        lista_1.insereUltimo(2);
        lista_1.insereUltimo(5);
        lista_1.insereUltimo(3);
        lista_1.insereUltimo(7);
        lista_1.insereUltimo(7);
        lista_1.insereUltimo(7);

        lista_1.mostraLista();

        System.out.println(lista_1.tamanho_recursivo(lista_1.getPrimeiro(),0));
    }

}
