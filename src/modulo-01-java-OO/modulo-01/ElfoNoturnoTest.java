import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoNoturnoTest
{
    @Test
    public void elfoNoturnoNasceCom100deVida(){
        ElfoNoturno novoElfo = new ElfoNoturno("Superman");
        assertEquals(100,novoElfo.getQuantVida(),0.001);
    }

    @Test
    public void elfoNoturnoAtiraUmaFlechaEGanhaExperiencia(){
        ElfoNoturno novoElfo = new ElfoNoturno("Superman");
        novoElfo.atirarFlecha(new Dwarf());
        assertEquals(3,novoElfo.getExperiencia());
    }

    @Test
    public void elfoNoturnoAtiraDuasFlechasEGanhaExperiencia(){
        ElfoNoturno novoElfo = new ElfoNoturno("Superman");
        novoElfo.atirarFlecha(new Dwarf());
        novoElfo.atirarFlecha(new Dwarf());
        assertEquals(6,novoElfo.getExperiencia());
    }

    @Test
    public void elfoNoturnoAtiraDezFlechasEGanhaExperiencia(){
        ElfoNoturno novoElfo = new ElfoNoturno("Superman");
        for(int i=0;i<10;i++){
            novoElfo.atirarFlecha(new Dwarf());
        }
        assertEquals(30,novoElfo.getExperiencia());
    }

    @Test
    public void elfoNoturnoNaoAtiraFlechaGetExperiencia(){
        ElfoNoturno novoElfo = new ElfoNoturno("Superman");
        assertEquals(0,novoElfo.getExperiencia());
    }

    @Test
    public void elfoNoturnoAtiraUmaFlechaEPerdeVida(){
        ElfoNoturno novoElfo = new ElfoNoturno("Superman");
        novoElfo.atirarFlecha(new Dwarf());
        assertEquals(95,novoElfo.getQuantVida(),0.001);
    }

    @Test
    public void elfoNoturnoAtiraDuasFlechasEPerdeVida(){
        ElfoNoturno novoElfo = new ElfoNoturno("Superman");
        novoElfo.atirarFlecha(new Dwarf());
        novoElfo.atirarFlecha(new Dwarf());
        assertEquals(90,novoElfo.getQuantVida(),0.001);
    }

    @Test
    public void elfoNoturnoXatiraDuasFlechasElfoNoturnoYaTiraCincoFlechasGetVida(){
        ElfoNoturno novoElfoX = new ElfoNoturno("Superman");
        ElfoNoturno novoElfoY = new ElfoNoturno("Superman");
        novoElfoX.atirarFlecha(new Dwarf());
        novoElfoX.atirarFlecha(new Dwarf());
        novoElfoY.atirarFlecha(new Dwarf());
        novoElfoY.atirarFlecha(new Dwarf());
        novoElfoY.atirarFlecha(new Dwarf());
        novoElfoY.atirarFlecha(new Dwarf());
        novoElfoY.atirarFlecha(new Dwarf());
        assertEquals(90,novoElfoX.getQuantVida(),0.001);
        assertEquals(75,novoElfoY.getQuantVida(),0.001);
    }

    @Test
    public void elfoNoturnoMorre(){
        ElfoNoturno novoElfo = new ElfoNoturno("Superman");
        for(int i=0;i<20;i++){
           novoElfo.atirarFlecha(new Dwarf());
        }
        assertEquals(Status.MORTO,novoElfo.getStatus());
    }
    
    @Test
    public void elfoNoturnoAtira13FlechasGetStatus(){
        ElfoNoturno novoElfo = new ElfoNoturno("Superman");
        for(int i=0;i<12;i++){
           novoElfo.atirarFlecha(new Dwarf());
        }
        assertEquals(Status.VIVO,novoElfo.getStatus());
    }
}
