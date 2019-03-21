import java.util.Arrays;

class Pilha {

    private int topo = -1;
    private char[] dados;
    private int MAX;

    char topo(){
        if (!vazia()){
            return dados[topo];
        }
        else return '0';
    }

    boolean vazia(){
        return topo == -1;
    }

    private boolean cheia(){
        return topo == MAX-1;
    }

    void empilhar(char elemento){

        if (cheia()) {
            System.out.println("Pilha cheia");
            return;
        }

        topo++;
        dados[topo] = elemento;

        print_dados();
    }

    private void print_dados() {
        System.out.println(Arrays.copyOfRange(dados,0,topo + 1));
    }

    void desempilhar(){
        topo--;
        print_dados();
    }

    Pilha(int maximo){
        MAX = maximo;
        dados = new char[MAX];
    }
}
