package br.com.cwi.crescer.aula1;

import java.text.DateFormatSymbols;
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
public class StringRun {

    public static void main(String[] args){
        
        System.out.println("" + contaVogais("banana"));
        System.out.println("" + inverterString("amor"));
        concatenar();
        retornarDiaDaSemana();
        MeuStringUtil meuStringUtil = new MeuStringUtil();
        System.out.println("" + meuStringUtil.validarStringVazia("   "));

    }

    public static void retornarDiaDaSemana(){
        Date d = new Date();
		Calendar c = new GregorianCalendar();
		c.setTime(d);
		String nome = "";
		int dia = c.get(c.DAY_OF_WEEK);
		switch(dia){
		  case Calendar.SUNDAY: nome = "Domingo";break;
		  case Calendar.MONDAY: nome = "Segunda";break;
		  case Calendar.TUESDAY: nome = "Terça";break;
		  case Calendar.WEDNESDAY: nome = "Quarta";break;
		  case Calendar.THURSDAY: nome = "Quinta";break;
		  case Calendar.FRIDAY: nome = "Sexta";break;
		  case Calendar.SATURDAY: nome = "sábado";break;
		}
		System.out.println(nome);
    }

    public static int contaVogais(String quantidade) {
        int quant = 0;

        for (int i = 0; i < quantidade.length(); i++) {
            if (quantidade.charAt(i) == 'a' || quantidade.charAt(i) == 'e' || quantidade.charAt(i) == 'i' || quantidade.charAt(i) == 'o' || quantidade.charAt(i) == 'u' || quantidade.charAt(i) == 'A' || quantidade.charAt(i) == 'E' || quantidade.charAt(i) == 'I' || quantidade.charAt(i) == 'O' || quantidade.charAt(i) == 'U') {
                quant += 1;
            }
        }
        return quant;
    }

    public static String inverterString(String palavra) {
        String invertida = new StringBuilder(palavra).reverse().toString();
        return invertida;
    }

    public static void concatenar() {
        StringBuffer sb = new StringBuffer();
        for (Estados e : Estados.values()) {
            sb.append(e.getNome()).append(", ");
        }
        System.out.println(sb);
    }

    enum Estados {
        AC("Acre"), AL("Alagoas"), ES("EspíritoSanto"), AP("Amapá"),
        BA("Bahia"), CE("Ceará"), DF("DistritoFederal"), GO("Goiás"),
        MA("Maranhão"), SC("SantaCatarina"), MG("MinasGerais"),
        MT("MatoGrosso"), MS("MatoGrossodoSul"), PA("Pará"),
        RS("RioGrandedoSul"), PE("Pernambuco"), PI("Piauí"),
        AM("Amazonas"), PR("Paraná"), RJ("RiodeJaneiro"),
        RN("RioGrandedoNorte"), PB("Paraíba"), RO("Rondônia"),
        RR("Roraima"), SE("Sergipe"), SP("SãoPaulo"), TO("Tocantins");

        private String nome;

        private Estados(String nome) {
            this.nome = nome;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

    }
}
