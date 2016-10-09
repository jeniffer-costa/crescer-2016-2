import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class AtaqueNoturnoPorUltimoTest
{
    @Test
    public void testarOrdemDeAtaqueNoturnoPorUltimoTresElfosVerdesEumElfoNoturno(){
      AtaqueNoturnoPorUltimo novoAtaque = new AtaqueNoturnoPorUltimo();
      ArrayList listaDeElfos = new ArrayList();
     
      listaDeElfos.add(new ElfoVerde("Green1"));
      listaDeElfos.add(new ElfoVerde("Green2"));
      listaDeElfos.add(new ElfoNoturno("Black1"));
      listaDeElfos.add(new ElfoVerde("Green3"));
    
      List<Elfo> lista = novoAtaque.getOrdemDeAtaque(listaDeElfos);
     
      assertTrue(lista.size() == 4);
      assertEquals("Green1", lista.get(0).getNome());
      assertEquals("Green2", lista.get(1).getNome());
      assertEquals("Green3", lista.get(2).getNome());
      assertEquals("Black1", lista.get(3).getNome());
    
    }
    
        @Test
    public void testarOrdemDeAtaqueNoturnoPorUltimoJaOrdenado(){
      AtaqueNoturnoPorUltimo novoAtaque = new AtaqueNoturnoPorUltimo();
      ArrayList listaDeElfos = new ArrayList();
     
      listaDeElfos.add(new ElfoVerde("Green1"));
      listaDeElfos.add(new ElfoVerde("Green2"));
      listaDeElfos.add(new ElfoVerde("Green3"));
      listaDeElfos.add(new ElfoNoturno("Black1"));
    
      List<Elfo> lista = novoAtaque.getOrdemDeAtaque(listaDeElfos);
     
      assertTrue(lista.size() == 4);
      assertEquals("Green1", lista.get(0).getNome());
      assertEquals("Green2", lista.get(1).getNome());
      assertEquals("Green3", lista.get(2).getNome());
      assertEquals("Black1", lista.get(3).getNome());
    
    }
    
    @Test
    public void testarOrdemDeAtaqueNoturnoPorUltimoTresNoturnosUmVerde(){
      AtaqueNoturnoPorUltimo novoAtaque = new AtaqueNoturnoPorUltimo();
      ArrayList listaDeElfos = new ArrayList();
     
      listaDeElfos.add(new ElfoNoturno("Black1"));
      listaDeElfos.add(new ElfoNoturno("Black2"));
      listaDeElfos.add(new ElfoNoturno("Black3"));
      listaDeElfos.add(new ElfoVerde("Green1"));
         
      List<Elfo> lista = novoAtaque.getOrdemDeAtaque(listaDeElfos);
     
      assertTrue(lista.size() == 4);
      assertEquals("Green1", lista.get(0).getNome());
      assertEquals("Black1", lista.get(1).getNome());
      assertEquals("Black2", lista.get(2).getNome());
      assertEquals("Black3", lista.get(3).getNome());
    
    }
}
