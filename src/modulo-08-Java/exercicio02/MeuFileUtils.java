package br.com.cwi.crescer.exercicio02;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author jeniffer.costa
 */
public class MeuFileUtils {

    public static void main(String a[]) throws IOException {
        Scanner teclado = new Scanner(System.in);

        System.out.print("C:\\Users\\");
        String opcao = teclado.nextLine();

        switch (opcao) {
            case "mk":
                System.out.print("");
                String string = teclado.nextLine();
                criarNovoArquivo(string);
                break;
            case "rm":
                System.out.print("");
                string = teclado.nextLine();
                excluirArquivo(string);
                break;
            case "ls":
                System.out.print("");
                string = teclado.nextLine();
                mostrarCaminhoAbsoluto(string);
                break;
            case "mv":
                System.out.print("");
                String stringOrigem = teclado.nextLine();
                System.out.print("");
                String stringDestino = teclado.nextLine();
                moverArquivo(stringOrigem, stringDestino);
                break;
            default:
                System.out.println("Comando inválido.");
        }
    }

    public static void criarNovoArquivo(String arquivo) throws IOException {
        final File file = new File(arquivo);

        if (!file.getName().contains(".")) {
            if (file.exists()) {
                System.out.println("Diretório já existe");
            } else {
                file.mkdirs();
                System.out.println("Diretório criado com sucesso");
            }
        }
        if (file.getName().endsWith(".txt")) {
            if (file.exists()) {
                System.out.println("O arquivo já existe.");
            } else {
                file.createNewFile();
                System.out.println("Arquivo criado com sucesso!");
            }

        }
    }

    public static void excluirArquivo(String arquivo) {
        final File file = new File(arquivo);

        if (file.exists() && !file.isDirectory()) {
            final boolean b = file.delete();
            System.out.println("Arquivo excluido com sucesso!");
        } else {
            System.out.println("Arquivo inválido");
        }
    }

    public static void mostrarCaminhoAbsoluto(String nome) {
        File file = new File(nome);

        if (file.exists()) {
            if (!file.isDirectory()) {
                System.out.println(file.getAbsolutePath());
            } else {
                File[] arquivos = file.listFiles();
                System.out.println(Arrays.toString(arquivos));
            }
        }
    }

    public static void moverArquivo(String origem, String destino) {
        File fileOrigem = new File(origem);
        File fileDestino = new File(destino);

        if (fileDestino.isDirectory()) {
            System.out.println("Arquivo inválido!");
        } else if (fileOrigem.renameTo(new File(fileDestino + fileOrigem.getName()))) {
            System.out.println("Arquivo movido com sucesso");
        }
    }
}
