package br.com.cwi.crescer.aula1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
/**
 *
 * @author jeniffer.costa
 */
public class MeuCalendarioUtil {

    public static void main(String[] args) throws ParseException {
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("##MENU## \n"
                           + " 1- Retornar dia da semana \n" 
                           + " 2- Calcular tempo decorrido \n");
        String opcao = teclado.nextLine();

        switch (opcao) {
            case "1": 
                System.out.println("Entre com a data");
                String data = teclado.nextLine();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");  
	        Date dt = df.parse(data);
                retornarDiaDaSemana(dt);
                break;
            case "2":
                System.out.println("Entre com a data");
                data = teclado.nextLine();
                df = new SimpleDateFormat("dd/MM/yyyy");  
	        dt = df.parse(data);
                calcularTempoDecorrido(dt);

                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    //Deve possuir um metodo que recebe a data de nascimento e retorne o dia da semana que a pessoa nasceu. (Segunda, Terça ...)
    public static void retornarDiaDaSemana(Date data) {
        Date d = data;
        Calendar c = new GregorianCalendar();
        c.setTime(d);
        String nome = "";
        int dia = c.get(c.DAY_OF_WEEK);
        switch (dia) {
            case Calendar.SUNDAY:
                nome = "Domingo";
                break;
            case Calendar.MONDAY:
                nome = "Segunda";
                break;
            case Calendar.TUESDAY:
                nome = "Terça";
                break;
            case Calendar.WEDNESDAY:
                nome = "Quarta";
                break;
            case Calendar.THURSDAY:
                nome = "Quinta";
                break;
            case Calendar.FRIDAY:
                nome = "Sexta";
                break;
            case Calendar.SATURDAY:
                nome = "sábado";
                break;
        }
        System.out.println(nome);
    }

    //Deve possuir um metodo que recebe uma data e informe o tempo decorrido até a data atual. 30 ano(s), 3 messe(s) e 12 dia(s)
    public static void calcularTempoDecorrido(Date dataDe) throws ParseException {
    Date dataAte = new Date();
    
    long diferencaDias = (dataAte.getTime() - dataDe.getTime()) / (1000*60*60*24);
    long diferencaMeses = (dataAte.getTime() - dataDe.getTime()) / (1000*60*60*24) / 30;
    long diferencaAnos = ((dataAte.getTime() - dataDe.getTime()) / (1000*60*60*24) / 30) / 12;

    System.out.println(String.format("Diferença em Dias: ", diferencaDias));
    System.out.println(String.format("Diferença em Meses: ", diferencaMeses));
    System.out.println(String.format("Diferença em Anos: ", diferencaAnos));
    }
    
    
}
