package br.com.cwi.crescer.exercicio02;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author jeniffer.costa
 */
public class MeuFileUtils {

    public static void main(String a[]) throws IOException {
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Entre com a instrução \n");
        String opcao = teclado.nextLine();

        switch (opcao) {
            case "mk": 
                System.out.println("Entre com o nome e extensão do arquivo \n");
                String string = teclado.nextLine();
                criarNovoArquivo(string);
                break;
            default:
                System.out.println("Comando inválido.");
        }
    }

    public static void criarNovoArquivo(String nomeArquivo) throws IOException {
        final File file = new File(nomeArquivo);
       
        if (file.exists()) {
            System.out.println("O arquivo já existe.");
        }
        else{
            file.createNewFile();
            System.out.println("Criado com sucesso!");
        }
    }
}
