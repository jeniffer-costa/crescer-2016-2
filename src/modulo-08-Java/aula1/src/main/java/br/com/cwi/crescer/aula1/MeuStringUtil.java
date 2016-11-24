package br.com.cwi.crescer.aula1;

/**
 *
 * @author jeniffer.costa
 */
public class MeuStringUtil {
    
    public boolean validarStringVazia(String string){
        boolean ehVazia = true;
        if(string.trim().length() == 0){
            ehVazia = true;
        }
        else{
            ehVazia = false;
        }
        return ehVazia;
    }
}
