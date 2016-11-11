
import static org.junit.Assert.*; 
import org.junit.After; 
import org.junit.Before; 
import org.junit.Test; 
import java.util.*; 

public class BatalhaoEspecialDeElfosTest 
{ 
    @Test 
    public void alistarUmElfoVerdeNoBatalhaoEspecial() { 
        BatalhaoEspecialDeElfos novoBatalhao = new BatalhaoEspecialDeElfos(); 
        ElfoVerde elfoVerde = new ElfoVerde("Elfo Verde"); 
        novoBatalhao.alistar(elfoVerde); 
        assertEquals(elfoVerde, novoBatalhao.getAlistados()[0]); 
    } 

    @Test
    public void alistarUmElfoNoturno() {
        BatalhaoEspecialDeElfos novoBatalhao = new BatalhaoEspecialDeElfos(); 
        ElfoNoturno elfoNoturno = new ElfoNoturno("Elfo Noturno"); 
        novoBatalhao.alistar(elfoNoturno);
        assertEquals(elfoNoturno, novoBatalhao.getAlistados()[0]);
    }

    @Test
    public void alistarUmElfoNormal() {
        BatalhaoEspecialDeElfos novoBatalhao = new BatalhaoEspecialDeElfos(); 
        Elfo elfoNormal = new Elfo("Elfo Normal"); 
        novoBatalhao.alistar(elfoNormal);
        assertEquals(0, novoBatalhao.getAlistados().length);
    }

    @Test 
    public void alistarDoisElfosVerdes(){ 
        BatalhaoEspecialDeElfos novoBatalhao = new BatalhaoEspecialDeElfos(); 
        ElfoVerde novoElfo1 = new ElfoVerde("Elfo1"); 
        ElfoVerde novoElfo2 = new ElfoVerde("Lego"); 
        novoBatalhao.alistar(novoElfo1); 
        novoBatalhao.alistar(novoElfo2); 
        Elfo[] elfos = novoBatalhao.getAlistados();
        assertTrue(contem(elfos, novoElfo1));
        assertTrue(contem(elfos, novoElfo2));

    } 

    @Test
    public void alistarDosTresTiposSoEntramVerdesENoturnos() {
        BatalhaoEspecialDeElfos novoBatalhao = new BatalhaoEspecialDeElfos(); 
        Elfo elfoVerde = new ElfoVerde("Elfo Verde");
        Elfo elfoNormal = new Elfo("Elfo Normal");
        Elfo elfoNoturno = new ElfoNoturno("Night Elf");
        novoBatalhao.alistar(elfoVerde);
        novoBatalhao.alistar(elfoNormal);
        novoBatalhao.alistar(elfoNoturno);
        Elfo[] elfos = novoBatalhao.getAlistados();
        assertTrue(contem(elfos, elfoVerde));
        assertTrue(contem(elfos, elfoNoturno));

    }

    @Test
    public void buscarExercitoVazio() {
        assertNull(new BatalhaoEspecialDeElfos().buscar("Nenhum"));
    }

    @Test
    public void buscarPorNome(){
        BatalhaoEspecialDeElfos novoBatalhao = new BatalhaoEspecialDeElfos();
        Elfo elfoVerde = new ElfoVerde("Elfo Verde");
        novoBatalhao.alistar(elfoVerde);
        assertEquals(elfoVerde, novoBatalhao.buscar("Elfo Verde"));
    }
    
     @Test
    public void buscarPorNomeNaoAlistado(){
        BatalhaoEspecialDeElfos novoBatalhao = new BatalhaoEspecialDeElfos();
        Elfo elfoVerde = new ElfoVerde("Elfo Verde");
        novoBatalhao.alistar(elfoVerde);
        assertNull(novoBatalhao.buscar("Green"));
    }

    private boolean contem(Elfo[] elfos, Elfo elfo){
        for(int i=0;i<elfos.length;i++){
            if(elfos[i].equals(elfo)){
                return true;
            }
        }
        return false;
    }
}
