import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
public class ExercitoDeElfoTest
{

        @After
    public void tearDown(){
      System.gc();
    }
    
    @Test
    public void alistarUmElfoVerde(){
      ExercitoDeElfos novoExercito = new ExercitoDeElfos();
      novoExercito.alistarElfo(new ElfoVerde("Legolas"));
      assertEquals(1,novoExercito.getElfosAlistados().size());
    
    }
    
    @Test
    public void alistarDoisElfosVerdes(){
      ExercitoDeElfos novoExercito = new ExercitoDeElfos();
      novoExercito.alistarElfo(new ElfoVerde("Legolas"));
      novoExercito.alistarElfo(new ElfoVerde("Batman"));
      assertEquals(2,novoExercito.getElfosAlistados().size());
    
    }
    
    @Test
    public void alistarUmElfoNormal(){
      ExercitoDeElfos novoExercito = new ExercitoDeElfos();
      novoExercito.alistarElfo(new Elfo("ElfoNormal"));
      assertEquals(0,novoExercito.getElfosAlistados().size());
    
    }
    
    @Test
    public void alistarUmElfoNoturno(){
      ExercitoDeElfos novoExercito = new ExercitoDeElfos();
      novoExercito.alistarElfo(new ElfoNoturno("Dark"));
      assertEquals(1,novoExercito.getElfosAlistados().size());
    
    }
    
    @Test
    public void alistarDoisElfosNoturnos(){
      ExercitoDeElfos novoExercito = new ExercitoDeElfos();
      novoExercito.alistarElfo(new ElfoNoturno("Legolas"));
      novoExercito.alistarElfo(new ElfoNoturno("Batman"));
      assertEquals(2,novoExercito.getElfosAlistados().size());
    
    }
    
    @Test
    public void alistarDoisElfosNoturnosEumElfoVerde(){
      ExercitoDeElfos novoExercito = new ExercitoDeElfos();
      novoExercito.alistarElfo(new ElfoNoturno("Legolas"));
      novoExercito.alistarElfo(new ElfoNoturno("Batman"));
      novoExercito.alistarElfo(new ElfoVerde("Green"));
      assertEquals(3,novoExercito.getElfosAlistados().size());
    
    }
    
    @Test
    public void buscarExercitoVazio(){
          assertNull(new ExercitoDeElfos().buscarElfoPeloNome("Nenhum"));
    }
    
    @Test
    public void buscarPorNomeTendoApenasUmComAqueleNome(){
        ExercitoDeElfos novoExercito = new ExercitoDeElfos();
        Elfo recruta1 = new ElfoVerde("Elfo Recruta 1");
        Elfo recruta2 = new ElfoVerde("Elfo Recruta 2");
        Elfo recruta3 = new ElfoVerde("Elfo Recruta 3");
        novoExercito.alistarElfo(recruta1);
        novoExercito.alistarElfo(recruta2);
        novoExercito.alistarElfo(recruta3);
        assertEquals(recruta2,novoExercito.buscarElfoPeloNome("Elfo Recruta 2"));
    }
    
    @Test
    public void buscarPorNomeTendoVariosComAqueleNome(){
        ExercitoDeElfos novoExercito = new ExercitoDeElfos();
        Elfo recruta1 = new ElfoVerde("Elfo Recruta 1");
        Elfo recruta2 = new ElfoVerde("Elfo Recruta 2");
        Elfo recruta3 = new ElfoVerde("Elfo Recruta 2");
        novoExercito.alistarElfo(recruta1);
        novoExercito.alistarElfo(recruta2);
        novoExercito.alistarElfo(recruta3);
        assertEquals(recruta2,novoExercito.buscarElfoPeloNome("Elfo Recruta 2"));
    }
    
    @Test
    public void buscarPorStatusVivo() {
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo recruta1 = new ElfoVerde("Elfo Recruta");
        Elfo recruta2 = new ElfoNoturno("Elfo Recruta 2");
        Elfo recruta3 = new ElfoVerde("Elfo Recruta");
        exercito.alistarElfo(recruta1);
        exercito.alistarElfo(recruta2);
        exercito.alistarElfo(recruta3);
        ArrayList<Elfo> elfoStatus = exercito.buscar(Status.VIVO);
        assertEquals(3, elfoStatus.size());
        assertEquals(recruta1, elfoStatus.get(0));
        assertEquals(recruta2, elfoStatus.get(1));
        assertEquals(recruta3, elfoStatus.get(2));
    }
    
    @Test
    public void buscarPorStatusMorto() {
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo recruta1 = new ElfoVerde("Elfo Recruta");
        Elfo recruta2 = criarElfoNoturnoEMatalo();
        Elfo recruta3 = new ElfoVerde("Elfo Recruta");
        exercito.alistarElfo(recruta1);
        exercito.alistarElfo(recruta2);
        exercito.alistarElfo(recruta3);
        ArrayList<Elfo> resultado = exercito.buscar(Status.MORTO);
        assertEquals(1, resultado.size());
        assertEquals(recruta2, resultado.get(0));
    }
    
    @Test
    public void buscarPorStatusMortoNenhumMorto() {
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo recruta1 = new ElfoVerde("Elfo Recruta");
        Elfo recruta2 = new ElfoNoturno("Elfo Recruta 2");
        Elfo recruta3 = new ElfoVerde("Elfo Recruta");
        exercito.alistarElfo(recruta1);
        exercito.alistarElfo(recruta2);
        exercito.alistarElfo(recruta3);
        assertTrue(exercito.buscar(Status.MORTO).isEmpty());
    }
    
        private ElfoNoturno criarElfoNoturnoEMatalo() {
        ElfoNoturno suicida = new ElfoNoturno("Elfo kamikaze", 90);
        for (int i = 0; i < 90; i++)
            suicida.atirarFlecha(new Dwarf());
        return suicida;
    }
}
