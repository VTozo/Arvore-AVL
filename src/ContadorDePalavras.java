import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ContadorDePalavras {

    public static void main(String[] args) throws IOException {

        ArvoreAVL arvore = new ArvoreAVL();

        Scanner input = new Scanner(System.in);

        System.out.println();
        System.out.print("Entre com o endereço de uma pasta: ");
        String endereco_pasta = input.nextLine();


        File pasta = new File(endereco_pasta);
        File[] listaDeArquivos = pasta.listFiles();

        if (listaDeArquivos == null){
            System.out.println("Nenhum arquivo txt foi encontrado!");
            System.exit(0);;
        }

        Scanner scanner;
        NodeAVL elemento;
        ArrayList<String> listaTxt = new ArrayList<>();

        for (File file : listaDeArquivos) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                String nome_arquivo = file.getName();
                // Abrir arquivo
                scanner = new Scanner(file, "utf-8");

                scanner.useDelimiter("\\s*\\s"); // Separar por espaço(s)

                String palavra;

                while (scanner.hasNext()) { // Para cada palavra no arquivo
                    palavra = scanner.next().replaceAll("[^a-zA-Z ]", "").toLowerCase();
                    elemento = arvore.encontraElemento(palavra);
                    if (elemento == null) {
                        arvore.insereElemento(palavra);
                    } else {
                        elemento.getArquivo(nome_arquivo).incrementaContador();
                    }

                }

            }
        }

        String termo = "";
        NodeAVL resultado;
        int soma;

        while (!termo.equals("sair")) {
            System.out.println();
            System.out.print("Entre com um termo a ser pesquisado: ");

            termo = input.nextLine();

            resultado = arvore.encontraElemento(termo);

            if (resultado == null)
                System.out.println("Não encontrado");
            else{
                System.out.println("Total: "+resultado.getArquivos().somaContadores());
            }

        }


    }

}
