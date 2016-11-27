package br.com.cwi.crescer.exercicio02;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jeniffer.costa
 */
public class MeuWriterUtils {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Entre com o arquivo: \n");
        String arquivo = teclado.nextLine();
        System.out.println("Entre com o texto: \n");
        String texto = teclado.nextLine();
        List<String> textoLista = new ArrayList<String>(Arrays.asList(texto.split(",")));
        escreverNoArquivo(arquivo, textoLista);
    }

    public static void escreverNoArquivo(String arquivo, List texto) {
        String extensao = arquivo.substring(arquivo.lastIndexOf("."), arquivo.length());
        File file = new File(arquivo);
        if (file.exists() && file.isFile()) {
            if (extensao.equalsIgnoreCase(".txt")) {
                try (
                    FileWriter fileWriter = new FileWriter(file);
                    PrintWriter printWriter = new PrintWriter(fileWriter);
                    ) {
                    printWriter.println(texto);
                    System.out.println("Texto salvo.");
                    printWriter.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Arquivo incompatível.");
            }
        } else {
            System.out.println("Arquivo não encontrado.");
        }
    }
}
