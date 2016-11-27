package br.com.cwi.crescer.exercicio02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

/**
 * @author jeniffer.costa
 */
public class MeuReaderUtils {

    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Entre com o nome do arquivo que deseja ler \n");
        String arquivo = teclado.nextLine();
        lerArquivo(arquivo);
    }

    public static void lerArquivo(String arquivo) {
        String extensao = arquivo.substring(arquivo.lastIndexOf("."), arquivo.length());
        if (extensao.equalsIgnoreCase(".txt")) {
            try (
                    FileReader file = new FileReader(arquivo);
                    BufferedReader lerArq = new BufferedReader(file);) {
                String linha = lerArq.readLine();
                while (linha != null) {
                    System.out.printf("%s\n", linha);
                    linha = lerArq.readLine();
                }
            } catch (IOException e) {
                System.err.printf("Erro na abertura do arquivo: %s.\n",
                        e.getMessage());
            }
        }
        else{
            System.out.println("Arquivo incompatível!");
        }
    }
}
