// Utilize a implementação de árvore AVL para desenvolter um contador de palavras em arquivos txt.
// O programa deve receber como entrada o nome de um diretório onde há arquivos ".txt"
// e apresentar como saída um relatório que indica quantas vezes um termo foi encontrado em cada arquivo e o total de ocorrências.
// Exemplo:
//
//Entre com um termo a ser pesquisado: "computador"
//
//Total de ocorrências de "computador": 6
//
//Arquivo "teste.txt": 3
//
//Arquivo "livro.txt": 2
//
//Arquivo "exame.txt": 1

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ContadorDePalavras {

    public static void main(String[] args) throws FileNotFoundException {

        // Abrir arquivo
        String fileName = "C:\\Users\\User\\Documents\\GitHub\\Arvore-AVL\\src\\file.txt";
        FileInputStream file = new FileInputStream(fileName);
        Scanner scanner = new Scanner(file, StandardCharsets.UTF_8);

        scanner.useDelimiter("\\s*\\s"); // Separar por espaço(s)

        ArvoreBinaria arvore = new ArvoreBinaria();

        String palavra;

        while (scanner.hasNext()) { // Para cada palavra no arquivo
            palavra = scanner.next().toLowerCase();
            System.out.println(palavra);
            Node elemento = arvore.encontraElemento(palavra);
            if (elemento == null) {
                arvore.insereElemento(palavra);
            } else {
                elemento.incrementaContador();
            }

        }

        Scanner input = new Scanner(System.in);
        String termo = "";
        Node resultado;

        while (!termo.equals("sair")) {
            System.out.print("Entre com um termo a ser pesquisado: ");

            termo = input.nextLine();

            resultado = arvore.encontraElemento(termo);

            if (resultado == null)
                System.out.println("0");
            else
                System.out.println(resultado.getContador());

        }


    }

}
