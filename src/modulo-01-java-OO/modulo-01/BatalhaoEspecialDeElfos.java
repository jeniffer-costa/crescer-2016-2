import java.util.*; 
 
public class BatalhaoEspecialDeElfos 
{ 
     private Map<Elfo,Elfo> elfosBatalhaoEspecial = new HashMap<Elfo,Elfo>(); 
 
    public BatalhaoEspecialDeElfos(){ 
    } 
 
    public void alistar(Elfo elfo){ 
        boolean podeAlistar = elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno; 
        if(podeAlistar){ 
            elfosBatalhaoEspecial.put(elfo,elfo); 
        } 
    } 
     
    public Elfo[] getAlistados() { 
        return elfosBatalhaoEspecial.values().toArray(new Elfo[elfosBatalhaoEspecial.size()]); 
         
    } 
     
    public Elfo buscar(String nome){ 
      return elfosBatalhaoEspecial.get(nome); 
    } 
} 