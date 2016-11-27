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
                System.out.println("Entre com o nome do arquivo\\diretorio \n");
                String string = teclado.nextLine();
                criarNovoArquivo(string);
                break;
            case "rm":
                System.out.println("Entre com o nome do arquivo que deseja excluir \n");
                string = teclado.nextLine();
                excluirArquivo(string);
                break;
            default:
                System.out.println("Comando inválido.");
        }
    }

    public static void criarNovoArquivo(String nomeArquivo) throws IOException {
        Scanner teclado = new Scanner(System.in);
        String opcao;
        final File file = new File(nomeArquivo);

        System.out.println("Deseja criar arquivo ou diretório ? \n"
                + "1- Arquivo \n"
                + "2- Diretório \n");

        opcao = teclado.nextLine();

        switch (opcao) {
            case "1":
                if (file.exists()) {
                    System.out.println("O arquivo já existe.");
                } else {
                    file.createNewFile();
                    System.out.println("Arquivo criado com sucesso!");
                }
                break;
            case "2":
                if (file.exists()) {
                    System.out.println("O diretorio já existe.");
                } else {
                    file.mkdirs();
                    System.out.println("Diretório criado com sucesso");
                }
                break;
            default:
                System.out.println("Comando inválido.");
        }
    }
    
    public static void excluirArquivo(String arquivo){
        final File file = new File(arquivo);
        
        if(file.exists() && !file.isDirectory()){
        final boolean b = file.delete();
            System.out.println("Arquivo excluido com sucesso!");
        }
        else{
            System.out.println("Não pode ser excluido pois não é um arquivo!");
        }
    }
}
