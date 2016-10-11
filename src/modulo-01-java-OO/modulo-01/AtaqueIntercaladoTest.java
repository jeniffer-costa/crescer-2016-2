import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class AtaqueIntercaladoTest
{
    @Test
    public void testarAtaqueIntercalado()throws ContingenteDesproporcionalException{
      AtaqueIntercalado novoAtaque = new AtaqueIntercalado();
      ArrayList listaDeElfos = new ArrayList();
     
      listaDeElfos.add(new ElfoVerde("Green1"));
      listaDeElfos.add(new ElfoVerde("Green2"));
      listaDeElfos.add(new ElfoNoturno("Black1"));
      listaDeElfos.add(new ElfoNoturno("Black2"));
    
      List<Elfo> lista = novoAtaque.getOrdemDeAtaque(listaDeElfos);
     
      assertEquals("Green1", lista.get(0).getNome());
      assertEquals("Black1", lista.get(1).getNome());
      assertEquals("Green2", lista.get(2).getNome());
      assertEquals("Black2", lista.get(3).getNome());
    
    }
    
    @Test
    public void batalhaoEhProporcionalDoisElfosVerdesEdoisNoturnos(){
      AtaqueIntercalado novoAtaque = new AtaqueIntercalado();
      ArrayList listaDeElfos = new ArrayList();
     
      listaDeElfos.add(new ElfoVerde("Green1"));
      listaDeElfos.add(new ElfoVerde("Green2"));
      listaDeElfos.add(new ElfoNoturno("Black1"));
      listaDeElfos.add(new ElfoNoturno("Black2"));
     
      assertTrue(novoAtaque.verificarSeBatalhaoEhProporcional(listaDeElfos));
    }
    
    @Test
    public void batalhaoEhProporcionalTresElfosVerdesEdoisNoturnos()throws ContingenteDesproporcionalException{
      AtaqueIntercalado novoAtaque = new AtaqueIntercalado();
      ArrayList listaDeElfos = new ArrayList();
     
      listaDeElfos.add(new ElfoVerde("Green1"));
      listaDeElfos.add(new ElfoVerde("Green2"));
      listaDeElfos.add(new ElfoVerde("Green3"));
      listaDeElfos.add(new ElfoNoturno("Black1"));
      listaDeElfos.add(new ElfoNoturno("Black2"));
      
      List<Elfo> lista = novoAtaque.getOrdemDeAtaque(listaDeElfos);

     // novoAtaque.verificarSeBatalhaoEhProporcional(listaDeElfos);
      assertFalse(novoAtaque.verificarSeBatalhaoEhProporcional(listaDeElfos));
    }
    
        @Test
    public void ordenarIntercaladoQuatroVerdesQuatroNoturnos(){
      AtaqueIntercalado novoAtaque = new AtaqueIntercalado();
      ArrayList listaDeElfos = new ArrayList();
     
      listaDeElfos.add(new ElfoVerde("Green1"));
      listaDeElfos.add(new ElfoVerde("Green2"));
      listaDeElfos.add(new ElfoVerde("Green3"));
      listaDeElfos.add(new ElfoNoturno("Black1"));
      listaDeElfos.add(new ElfoNoturno("Black2"));
      listaDeElfos.add(new ElfoVerde("Green4"));
      listaDeElfos.add(new ElfoNoturno("Black3"));
      listaDeElfos.add(new ElfoNoturno("Black4"));
     
      List<Elfo> lista = novoAtaque.ordenarIntercalado(listaDeElfos);
     
      assertEquals("Green1", lista.get(0).getNome());
      assertEquals("Black1", lista.get(1).getNome());
      assertEquals("Green2", lista.get(2).getNome());
      assertEquals("Black2", lista.get(3).getNome());
      assertEquals("Green3", lista.get(4).getNome());
      assertEquals("Black3", lista.get(5).getNome());
      assertEquals("Green4", lista.get(6).getNome());
      assertEquals("Black4", lista.get(7).getNome());
    }
    }