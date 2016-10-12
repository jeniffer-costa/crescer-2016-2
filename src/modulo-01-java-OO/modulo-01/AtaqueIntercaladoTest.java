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
    public void batalhaoEhProporcionalDoisElfosVerdesEdoisNoturnos()throws ContingenteDesproporcionalException{
      AtaqueIntercalado novoAtaque = new AtaqueIntercalado();
      ArrayList listaDeElfos = new ArrayList();
     
      listaDeElfos.add(new ElfoVerde("Green1"));
      listaDeElfos.add(new ElfoVerde("Green2"));
      listaDeElfos.add(new ElfoNoturno("Black1"));
      listaDeElfos.add(new ElfoNoturno("Black2"));
     
      assertTrue(novoAtaque.verificarSeBatalhaoEhProporcional(listaDeElfos));
    }
    
    @Test (expected=ContingenteDesproporcionalException.class)
    public void batalhaoNaoEhProporcionalTresElfosVerdesEdoisNoturnos()throws ContingenteDesproporcionalException{
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
    public void ordenarIntercaladoQuatroVerdesQuatroNoturnos()throws ContingenteDesproporcionalException{
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
    
    @Test (expected=ContingenteDesproporcionalException.class)
    public void ordenarIntercaladoCincoVerdesQuatroNoturnos()throws ContingenteDesproporcionalException{
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
      listaDeElfos.add(new ElfoVerde("Green5"));
     
      List<Elfo> lista = novoAtaque.ordenarIntercalado(listaDeElfos);
     
      assertEquals(0, lista.size());
    }
    
    @Test(expected=ContingenteDesproporcionalException.class)
    public void getOrdemDeAtaqueComBatalhaoDesproporcional()throws ContingenteDesproporcionalException {
      AtaqueIntercalado novoAtaque = new AtaqueIntercalado();
      ArrayList listaDeElfos = new ArrayList();
     
      listaDeElfos.add(new ElfoVerde("Green1"));
      listaDeElfos.add(new ElfoVerde("Green2"));
      listaDeElfos.add(new ElfoNoturno("Black1"));
      listaDeElfos.add(new ElfoNoturno("Black2"));
      listaDeElfos.add(new ElfoVerde("Green3"));
      listaDeElfos.add(new ElfoNoturno("Black3"));
      listaDeElfos.add(new ElfoNoturno("Black4"));
     
      List<Elfo> lista = novoAtaque.getOrdemDeAtaque(listaDeElfos);
     
      assertEquals(0, lista.size());
    }
    
    @Test
    public void getOrdemDeAtaqueElfoNoturnoIniciaAtaqueBatalhaoProporcional()throws ContingenteDesproporcionalException {
      AtaqueIntercalado novoAtaque = new AtaqueIntercalado();
      ArrayList listaDeElfos = new ArrayList();
     
      listaDeElfos.add(new ElfoNoturno("Black0"));
      listaDeElfos.add(new ElfoVerde("Green2"));
      listaDeElfos.add(new ElfoNoturno("Black1"));
      listaDeElfos.add(new ElfoNoturno("Black2"));
      listaDeElfos.add(new ElfoVerde("Green3"));
      listaDeElfos.add(new ElfoVerde("Green4"));
      listaDeElfos.add(new ElfoVerde("Green5"));
      listaDeElfos.add(new ElfoNoturno("Black3"));
      listaDeElfos.add(new ElfoNoturno("Black4"));
      listaDeElfos.add(new ElfoVerde("Green6"));
     
      List<Elfo> lista = novoAtaque.getOrdemDeAtaque(listaDeElfos);
     
      assertEquals("Black0", lista.get(0).getNome());
      assertEquals("Green2", lista.get(1).getNome());
      assertEquals("Black1", lista.get(2).getNome());
      assertEquals("Green3", lista.get(3).getNome());
      assertEquals("Black2", lista.get(4).getNome());
      assertEquals("Green4", lista.get(5).getNome());
      assertEquals("Black3", lista.get(6).getNome());
      assertEquals("Green5", lista.get(7).getNome());
      assertEquals("Black4", lista.get(8).getNome());
      assertEquals("Green6", lista.get(9).getNome());
    }
    
        @Test
    public void ordenarIntercaladoQuatroVerdesDoisNormaisQuatroNoturnos()throws ContingenteDesproporcionalException{
      AtaqueIntercalado novoAtaque = new AtaqueIntercalado();
      ArrayList listaDeElfos = new ArrayList();
     
      listaDeElfos.add(new ElfoVerde("Green1"));
      listaDeElfos.add(new ElfoVerde("Green2"));
      listaDeElfos.add(new ElfoVerde("Green3"));
      listaDeElfos.add(new Elfo("Normal1"));
      listaDeElfos.add(new ElfoNoturno("Black1"));
      listaDeElfos.add(new ElfoNoturno("Black2"));
      listaDeElfos.add(new ElfoVerde("Green4"));
      listaDeElfos.add(new Elfo("Normal2"));
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