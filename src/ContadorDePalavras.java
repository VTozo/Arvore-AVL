import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class ContadorDePalavras {

    public static void main(String[] args) throws IOException {

        File pasta = new File("C:\\Users\\User\\Documents\\GitHub\\Arvore-AVL\\src");
        File[] listaDeArquivos = pasta.listFiles();
        Scanner scanner;
        ArrayList<ArvoreBinaria> arvores = new ArrayList<>();
        int i = 0;
        Node elemento;
        ArrayList<String> listaTxt = new ArrayList<>();

        if (listaDeArquivos != null) {
            for (File file : listaDeArquivos) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    listaTxt.add(file.getName());
                    // Abrir arquivo
                    scanner = new Scanner(file, StandardCharsets.UTF_8);

                    scanner.useDelimiter("\\s*\\s"); // Separar por espaço(s)

                    arvores.add(new ArvoreBinaria());
                    String palavra;

                    while (scanner.hasNext()) { // Para cada palavra no arquivo
                        palavra = scanner.next().replaceAll("[^a-zA-Z ]", "").toLowerCase();
                        elemento = arvores.get(i).encontraElemento(palavra);
                        if (elemento == null) {
                            arvores.get(i).insereElemento(palavra);
                        } else {
                            elemento.incrementaContador();
                        }

                    }

                    i++;
                }
            }
        }


        Scanner input = new Scanner(System.in);
        String termo = "";
        Node resultado;
        int soma;

        while (!termo.equals("sair")) {
            System.out.println();
            System.out.print("Entre com um termo a ser pesquisado: ");

            termo = input.nextLine();

            i = 0;
            soma = 0;

            for (ArvoreBinaria arvore : arvores) {
                System.out.print(listaTxt.get(i) + ": ");
                i++;

                resultado = arvore.encontraElemento(termo);

                if (resultado == null)
                    System.out.println("0");
                else{
                    System.out.println(resultado.getContador());
                    soma += resultado.getContador();
                }

            }

            System.out.println("Total: "+soma);

        }


    }

}
