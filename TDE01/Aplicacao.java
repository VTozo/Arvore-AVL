public class Aplicacao {

    public static void main(String[] args){

        Expressao expressao = new Expressao("([{}]{}){}");

        System.out.println("Expressão válida: " + expressao.verificar_delimitadores());

    }

}
