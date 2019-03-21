public class App {
    public static void main(String[] args){
        FilaCircular fila_a = new FilaCircular(4);
        fila_a.insere(0);
        fila_a.insere(0);
        fila_a.insere(0);
        fila_a.insere(1);
        fila_a.remove();
        fila_a.remove();
        fila_a.remove();
        fila_a.insere(3);
        fila_a.insere(5);
        fila_a.insere(7);
        fila_a.imprimir();

        FilaCircular fila_b = new FilaCircular(4);
        fila_b.insere(0);
        fila_b.insere(2);
        fila_b.insere(4);
        fila_b.insere(6);
        fila_b.imprimir();

        FilaCircular fila_c;
        fila_c = fila_a.merge(fila_b);
        fila_c.imprimir();
    }
}
