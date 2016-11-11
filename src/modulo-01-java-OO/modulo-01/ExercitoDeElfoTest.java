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
    public void alistarUmElfoVerde() throws NaoPodeAlistarException{
        ExercitoDeElfos novoExercito = new ExercitoDeElfos();
        ElfoVerde novoElfo = new ElfoVerde("Legolas");
        novoExercito.alistar(novoElfo);
        assertEquals(novoElfo, novoExercito.getAlistados()[0]);

    }

    @Test
    public void alistarDoisElfosVerdes() throws NaoPodeAlistarException{
        ExercitoDeElfos novoExercito = new ExercitoDeElfos();
        ElfoVerde novoElfo1 = new ElfoVerde("Legolas");
        ElfoVerde novoElfo2 = new ElfoVerde("Legolas");
        novoExercito.alistar(novoElfo1);
        novoExercito.alistar(novoElfo2);
        assertEquals(novoElfo1,novoExercito.getAlistados()[0]);
        assertEquals(novoElfo2,novoExercito.getAlistados()[1]);

    }

    @Test(expected=NaoPodeAlistarException.class)
    public void alistarUmElfoNormal() throws NaoPodeAlistarException {
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo elfoNormal = new Elfo("Elfo Normal");
        exercito.alistar(elfoNormal);
        assertEquals(0, exercito.getAlistados().length);
    }

    @Test
    public void alistarUmElfoNoturno()throws NaoPodeAlistarException{
        ExercitoDeElfos novoExercito = new ExercitoDeElfos();
        ElfoVerde novoElfoNoturno = new ElfoVerde("Legolas");
        novoExercito.alistar(novoElfoNoturno);
        assertEquals(novoElfoNoturno,novoExercito.getAlistados()[0]);

    }

    @Test
    public void alistarDoisElfosNoturnos()throws NaoPodeAlistarException{
        ExercitoDeElfos novoExercito = new ExercitoDeElfos();
        ElfoNoturno novoElfo1 = new ElfoNoturno("Legolas Noturno");
        ElfoNoturno novoElfo2 = new ElfoNoturno("Legolas Black");
        novoExercito.alistar(novoElfo1);
        novoExercito.alistar(novoElfo2);
        assertEquals(novoElfo1,novoExercito.getAlistados()[0]);
        assertEquals(novoElfo2,novoExercito.getAlistados()[1]);

    }

    @Test
    public void alistarDoisElfosNoturnosEumElfoVerde()throws NaoPodeAlistarException{
        ExercitoDeElfos novoExercito = new ExercitoDeElfos();
        ElfoNoturno novoElfoNoturno1 = new ElfoNoturno("Legolas Noturno");
        ElfoNoturno novoElfoNoturno2 = new ElfoNoturno("Legolas Black");
        ElfoVerde novoElfoVerde = new ElfoVerde("Legolas Green");
        novoExercito.alistar(novoElfoNoturno1);
        novoExercito.alistar(novoElfoNoturno2);
        novoExercito.alistar(novoElfoVerde);
        assertEquals(novoElfoNoturno1,novoExercito.getAlistados()[0]);
        assertEquals(novoElfoNoturno2,novoExercito.getAlistados()[1]);
        assertEquals(novoElfoVerde,novoExercito.getAlistados()[2]);

    }

    @Test
    public void buscarExercitoVazio(){
        assertNull(new ExercitoDeElfos().buscar("Nenhum"));
    }

    @Test
    public void buscarPorNomeTendoApenasUmComAqueleNome()throws NaoPodeAlistarException{
        ExercitoDeElfos novoExercito = new ExercitoDeElfos();
        Elfo recruta1 = new ElfoVerde("Elfo Recruta 1");
        Elfo recruta2 = new ElfoVerde("Elfo Recruta 2");
        Elfo recruta3 = new ElfoVerde("Elfo Recruta 3");
        novoExercito.alistar(recruta1);
        novoExercito.alistar(recruta2);
        novoExercito.alistar(recruta3);
        assertEquals(recruta2,novoExercito.buscar("Elfo Recruta 2"));
    }

    @Test
    public void buscarPorNomeTendoVariosComAqueleNome() throws NaoPodeAlistarException{
        ExercitoDeElfos novoExercito = new ExercitoDeElfos();
        Elfo recruta1 = new ElfoVerde("Elfo Recruta 1");
        Elfo recruta2 = new ElfoVerde("Elfo Recruta 2");
        Elfo recruta3 = new ElfoVerde("Elfo Recruta 2");
        novoExercito.alistar(recruta1);
        novoExercito.alistar(recruta2);
        novoExercito.alistar(recruta3);
        assertEquals(recruta2,novoExercito.buscar("Elfo Recruta 2"));
    }

    @Test
    public void buscarPorStatusVivo()throws NaoPodeAlistarException {
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo recruta1 = new ElfoVerde("Elfo Recruta");
        Elfo recruta2 = new ElfoNoturno("Elfo Recruta 2");
        Elfo recruta3 = new ElfoVerde("Elfo Recruta");
        exercito.alistar(recruta1);
        exercito.alistar(recruta2);
        exercito.alistar(recruta3);
        ArrayList<Elfo> elfoStatus = exercito.buscar(Status.VIVO);
        assertEquals(3, elfoStatus.size());
        assertEquals(recruta1, elfoStatus.get(0));
        assertEquals(recruta2, elfoStatus.get(1));
        assertEquals(recruta3, elfoStatus.get(2));
    }

    @Test
    public void buscarPorStatusMorto()throws NaoPodeAlistarException {
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo recruta1 = new ElfoVerde("Elfo Recruta");
        Elfo recruta2 = criarElfoNoturnoEMatalo();
        Elfo recruta3 = new ElfoVerde("Elfo Recruta");
        exercito.alistar(recruta1);
        exercito.alistar(recruta2);
        exercito.alistar(recruta3);
        ArrayList<Elfo> resultado = exercito.buscar(Status.MORTO);
        assertEquals(1, resultado.size());
        assertEquals(recruta2, resultado.get(0));
    }

    @Test
    public void buscarPorStatusMortoNenhumMorto()throws NaoPodeAlistarException {
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo recruta1 = new ElfoVerde("Elfo Recruta");
        Elfo recruta2 = new ElfoNoturno("Elfo Recruta 2");
        Elfo recruta3 = new ElfoVerde("Elfo Recruta");
        exercito.alistar(recruta1);
        exercito.alistar(recruta2);
        exercito.alistar(recruta3);
        assertTrue(exercito.buscar(Status.MORTO).isEmpty());
    }

    private ElfoNoturno criarElfoNoturnoEMatalo() {
        ElfoNoturno suicida = new ElfoNoturno("Elfo kamikaze", 90);
        for (int i = 0; i < 90; i++)
            suicida.atirarFlecha(new Dwarf());
        return suicida;
    }
}
