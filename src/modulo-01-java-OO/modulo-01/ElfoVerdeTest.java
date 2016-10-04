import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoVerdeTest
{
  @Test
  public void elfoVerdeNasceCom100deVida(){
     Elfo novoElfo = new Elfo("Superman");
     assertEquals(100,novoElfo.getQuantVida(),0.001);
    }
    
  @Test
  public void elfoVerdeAtiraUmaFlechaEGanhaExperiencia(){
     ElfoVerde novoElfo = new ElfoVerde("Superman");
     novoElfo.atirarFlecha(new Dwarf());
     assertEquals(2,novoElfo.getExperiencia());
    }
  
    @Test
  public void elfoVerdeAtiraDuasFlechasEGanhaExperiencia(){
     ElfoVerde novoElfo = new ElfoVerde("Superman");
     novoElfo.atirarFlecha(new Dwarf());
     novoElfo.atirarFlecha(new Dwarf());
     assertEquals(4,novoElfo.getExperiencia());
    }
    
  @Test
  public void elfoVerdeAtiraDezFlechasEGanhaExperiencia(){
     ElfoVerde novoElfo = new ElfoVerde("Superman");
     for(int i=0;i<10;i++){
     novoElfo.atirarFlecha(new Dwarf());
    }
     assertEquals(20,novoElfo.getExperiencia());
    }
    
    @Test
  public void elfoVerdeNaoAtiraFlechaGetExperiencia(){
     ElfoVerde novoElfo = new ElfoVerde("Superman");
     assertEquals(0,novoElfo.getExperiencia());
    }
}
