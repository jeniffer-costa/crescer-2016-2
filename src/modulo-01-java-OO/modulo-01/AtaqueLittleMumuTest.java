import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class AtaqueLittleMumuTest
{
    @Test
    public void elfosAptosDoisNoturnosEDoisVerdesComFlechas(){
      AtaqueLittleMumu novoAtaque = new AtaqueLittleMumu();
      ArrayList listaDeElfos = new ArrayList();
     
      listaDeElfos.add(new ElfoVerde("Green1",23));
      listaDeElfos.add(new ElfoVerde("Green2",12));
      listaDeElfos.add(new ElfoNoturno("Black1",3));
      listaDeElfos.add(new ElfoNoturno("Black2",6));
    
      List<Elfo> lista = novoAtaque.verificarElfosAptos(listaDeElfos);
     
      assertTrue(lista.size() == 4);
      assertEquals("Green1", lista.get(0).getNome());
      assertEquals("Green2", lista.get(1).getNome());
      assertEquals("Black1", lista.get(2).getNome());
      assertEquals("Black2", lista.get(3).getNome());
    }
    
    @Test
    public void elfosAptosUmNormalDoisNoturnosTresVerdesUmSemFlecha(){
      AtaqueLittleMumu novoAtaque = new AtaqueLittleMumu();
      ArrayList listaDeElfos = new ArrayList();
     
      listaDeElfos.add(new Elfo("Normal1",23));
      listaDeElfos.add(new ElfoVerde("Green1",23));
      listaDeElfos.add(new ElfoVerde("Green2",12));
      listaDeElfos.add(new ElfoVerde("Green3",0));
      listaDeElfos.add(new ElfoNoturno("Black1",3));
      listaDeElfos.add(new ElfoNoturno("Black2",6));
    
      List<Elfo> lista = novoAtaque.verificarElfosAptos(listaDeElfos);
     
      assertTrue(lista.size() == 4);
      assertEquals("Green1", lista.get(0).getNome());
      assertEquals("Green2", lista.get(1).getNome());
      assertEquals("Black1", lista.get(2).getNome());
      assertEquals("Black2", lista.get(3).getNome());
    }
        
    @Test
    public void elfosAptosTresNormais(){
      AtaqueLittleMumu novoAtaque = new AtaqueLittleMumu();
      ArrayList listaDeElfos = new ArrayList();
     
      listaDeElfos.add(new Elfo("Normal1",23));
      listaDeElfos.add(new Elfo("Normal2",22));
      listaDeElfos.add(new Elfo("Normal3",21));
    
      List<Elfo> lista = novoAtaque.verificarElfosAptos(listaDeElfos);
     
      assertTrue(lista.size() == 0);
    }
    
    @Test
    public void elfosAptosTresVerdesUmComFlecha(){
      AtaqueLittleMumu novoAtaque = new AtaqueLittleMumu();
      ArrayList listaDeElfos = new ArrayList();
      
      listaDeElfos.add(new ElfoVerde("Green1",23));
      listaDeElfos.add(new ElfoVerde("Green2",0));
      listaDeElfos.add(new ElfoVerde("Green3",0));
    
      List<Elfo> lista = novoAtaque.verificarElfosAptos(listaDeElfos);
     
      assertTrue(lista.size() == 1);
      assertEquals("Green1", lista.get(0).getNome());
    }
    
    @Test
    public void elfosAptosCincoVerdesUmComFlechaUmNormalDoisNoturnosComFlecha(){
      AtaqueLittleMumu novoAtaque = new AtaqueLittleMumu();
      ArrayList listaDeElfos = new ArrayList();
      
      listaDeElfos.add(new ElfoVerde("Green1",23));
      listaDeElfos.add(new ElfoVerde("Green2",0));
      listaDeElfos.add(new ElfoVerde("Green3",0));
      listaDeElfos.add(new ElfoVerde("Green4",0));
      listaDeElfos.add(new ElfoVerde("Green5",0));
      listaDeElfos.add(new Elfo("Normal",5));
      listaDeElfos.add(new ElfoNoturno("Black1",6));
      listaDeElfos.add(new ElfoNoturno("Black2",6));

      List<Elfo> lista = novoAtaque.verificarElfosAptos(listaDeElfos);
     
      assertTrue(lista.size() == 3);
      assertEquals("Green1", lista.get(0).getNome());
      assertEquals("Black1", lista.get(1).getNome());
      assertEquals("Black2", lista.get(2).getNome());
    }
    
    @Test
    public void elfosAptosListaVazia(){
      AtaqueLittleMumu novoAtaque = new AtaqueLittleMumu();
      ArrayList listaDeElfos = new ArrayList();
    
      List<Elfo> lista = novoAtaque.verificarElfosAptos(listaDeElfos);
     
      assertTrue(lista.size() == 0);
    }
}
