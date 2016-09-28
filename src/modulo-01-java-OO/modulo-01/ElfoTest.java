import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    @Test
    public void elfoNasceComNome(){
        // Arrange
        String nomeEsperado = "Bruce Wayne";
        // Act
        Elfo bruceWayne = new Elfo(nomeEsperado);
        // Assert
        assertEquals(nomeEsperado, bruceWayne.getNome());
    }
    @Test
    public void elfoNasceComArco(){
        //Arrange
        Item arco = new Item("Arco", 1);
        // Act
        Elfo novoElfo = new Elfo("Elrond");
        // Assert
        assertEquals(arco.getDescricao(), novoElfo.getArco().getDescricao());
        assertEquals(1, novoElfo.getArco().getQuantidade());
    }
    @Test
    public void elfoNasceComFlechas(){
       // Arrange
       Item flechas = new Item("Flechas",42);
       // Act
       Elfo novoElfo = new Elfo("Legolas");
       // Assert
       assertEquals(flechas.getDescricao(), novoElfo.getFlechas().getDescricao());
       assertEquals(42, novoElfo.getFlechas().getQuantidade());
    }
    @Test
    public void atirarUmaFlecha(){
       // Arrange
       Elfo novoElfo = new Elfo("Legolas");
       // Act
       novoElfo.atirarFlecha();
       // Assert
       assertEquals(41,novoElfo.getFlechas().getQuantidade());
    }
    @Test
    public void atirarDezFlechas(){
       // Arrange
       Elfo novoElfo = new Elfo("Jeniffer");
       // Act
       novoElfo.atirarFlecha();
       novoElfo.atirarFlecha();
       novoElfo.atirarFlecha();
       novoElfo.atirarFlecha();
       novoElfo.atirarFlecha();
       novoElfo.atirarFlecha();
       novoElfo.atirarFlecha();
       novoElfo.atirarFlecha();
       novoElfo.atirarFlecha();
       novoElfo.atirarFlecha();
       // Assert
       assertEquals(32,novoElfo.getFlechas().getQuantidade());
    }
    @Test       
    public void AnaoPerdeQuantVida(){
        // Arrange
        Anao dwarf = new Anao("Dwarf");
        Elfo novoElfo = new Elfo("Arnold");
        // Act
        novoElfo.atirarFlecha();
        // Assert
        assertEquals(100,novoElfo.getDwarf().getQuantVida());
    }
    @Test       
    public void atirarDuasFlechasAnao(){
        // Arrange
        Anao dwarf = new Anao("teste1");
        Elfo novoElfo = new Elfo("Arnold");
        // Act
        novoElfo.atirarFlecha();
        novoElfo.atirarFlecha();
        // Assert
        assertEquals(90,novoElfo.getDwarf().getQuantVida());
    }
    @Test       
    public void atirarFlechaDoisAnoes(){
        // Arrange
        Anao dwarf = new Anao("Dwarf");
        Anao novoAnao = new Anao("kkkkk");
        Elfo novoElfo = new Elfo("Arnold");
        Elfo novoElfo2 = new Elfo("bbbb");
        // Act
        novoElfo.atirarFlecha();
        novoElfo2.atirarFlecha();
        // Assert
        assertEquals(100,novoElfo.getDwarf().getQuantVida());
        assertEquals(100,novoElfo.getDwarf().getQuantVida());
    }
    @Test       
    public void atirarQuantDiferentesFlechasAnoes(){
        // Arrange
        Anao dwarf = new Anao("Batman");
        Anao novoAnao = new Anao("Superman");
        Elfo novoElfo = new Elfo("Elfo1");
        Elfo novoElfo2 = new Elfo("Elfo2");
        // Act
        novoElfo.atirarFlecha();
        novoElfo.atirarFlecha();
        novoElfo.atirarFlecha();
        novoElfo2.atirarFlecha();
        // Assert
        assertEquals(80,novoElfo.getDwarf().getQuantVida());
        assertEquals(100,novoElfo2.getDwarf().getQuantVida());
    }
    

}
