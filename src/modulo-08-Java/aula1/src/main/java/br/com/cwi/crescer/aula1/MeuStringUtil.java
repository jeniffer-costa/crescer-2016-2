package br.com.cwi.crescer.aula1;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author jeniffer.costa
 */
public class MeuStringUtil {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("##MENU## \n"
                           + " 1- Validar String Vazia \n" 
                           + " 2- Contar Numero de Vogais \n"
                           + " 3- Inverter String \n"
                           + " 4- Validar se é palíndromo \n");
        String opcao = teclado.nextLine();

        switch (opcao) {
            case "1": 
                System.out.println("Entre com a String");
                String string = teclado.nextLine();
                validarStringVazia(string);
                break;
            case "2":
                System.out.println("Entre com a String");
                string = teclado.nextLine();
                contarNumeroDeVogais(string);
                break;
            case "3":
                System.out.println("Entre com a String");
                string = teclado.nextLine();
                inverterString(string);
                break;
            case "4":
                System.out.println("Entre com a String");
                string = teclado.nextLine();
                verificarSeEhPalindromo(string);
                break;
            default:
                JOptionPane.showConfirmDialog(null,"Opção inválida!");
        }

    }

    //Deve possuir um metodo que valide se String é vazia
    public static void validarStringVazia(String string) {
        boolean ehVazia = true;
        if (string.trim().length() == 0) {
            ehVazia = true;
        } else {
            ehVazia = false;
        }
        System.out.println("Resultado:" +ehVazia);
    }

    //Deve possuir um metodo que conte o nº de vogais da String (a,e,i,o,u).
    public static void contarNumeroDeVogais(String string) {
        int quant = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == 'a' || string.charAt(i) == 'e' || string.charAt(i) == 'i' || string.charAt(i) == 'o' || string.charAt(i) == 'u' || string.charAt(i) == 'A' || string.charAt(i) == 'E' || string.charAt(i) == 'I' || string.charAt(i) == 'O' || string.charAt(i) == 'U') {
                quant += 1;
            }
        }
        System.out.println("Resultado:" +quant);;
    }

    //Deve possuir um metodo que inverta uma String.
    public static String inverterString(String palavra) {
        String invertida = new StringBuilder(palavra).reverse().toString();
        System.out.println("Resultado:" +invertida);
        return invertida;
    }

    //Deve possuir um metodo que identifique um palíndromo.("ovo", "Ame a ema", "A sogra má e amargosa")
    public static void verificarSeEhPalindromo(String string) {
        String stringInvertida = inverterString(string);
        stringInvertida = stringInvertida.replace(" ", "");
        string = string.replace(" ", "");
        boolean ehPalindromo = stringInvertida.equalsIgnoreCase(string);
        if (ehPalindromo) {
            System.out.println("Resultado: É Palíndromo." );
        }
        else{
        System.out.println("Resultado: Não é Palíndromo." );
        }
    }
}
