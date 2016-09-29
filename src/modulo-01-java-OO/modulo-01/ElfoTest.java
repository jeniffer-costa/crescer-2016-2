
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
       novoElfo.atirarFlecha(new Dwarf("Teste",2,5,2016));
       // Assert
       assertEquals(41,novoElfo.getFlechas().getQuantidade());
       assertEquals(1, novoElfo.getExperiencia());
    }
    @Test
    public void atirarDezFlechas(){
       // Arrange
       Elfo novoElfo = new Elfo("Jeniffer");
       // Act
       novoElfo.atirarFlecha(new Dwarf("Teste",2,5,2016));
       novoElfo.atirarFlecha(new Dwarf("Teste",2,5,2016));
       novoElfo.atirarFlecha(new Dwarf("Teste",2,5,2016));
       novoElfo.atirarFlecha(new Dwarf("Teste",2,5,2016));
       novoElfo.atirarFlecha(new Dwarf("Teste",2,5,2016));
       novoElfo.atirarFlecha(new Dwarf("Teste",2,5,2016));
       novoElfo.atirarFlecha(new Dwarf("Teste",2,5,2016));
       novoElfo.atirarFlecha(new Dwarf("Teste",2,5,2016));
       novoElfo.atirarFlecha(new Dwarf("Teste",2,5,2016));
       novoElfo.atirarFlecha(new Dwarf("Teste",2,5,2016));
       // Assert
       assertEquals(32,novoElfo.getFlechas().getQuantidade());
       assertEquals(10, novoElfo.getExperiencia());
    }
    @Test
    public void atirar42Flechas(){
       // Arrange
       Elfo novoElfo = new Elfo("Batman");
       // Act
       for (int i=0;i<=42;i++)
       novoElfo.atirarFlecha(new Dwarf("Teste",2,5,2016));
       // Assert
       assertEquals(0,novoElfo.getFlechas().getQuantidade());
       assertEquals(42, novoElfo.getExperiencia());
    }
    @Test       
    public void DwarfPerdeQuantVida(){
        // Arrange
        Dwarf dwarf = new Dwarf("Teste",2,5,2016);
        Elfo novoElfo = new Elfo("Arnold");
        // Act
        novoElfo.atirarFlecha(dwarf);
        // Assert
        assertEquals(100,dwarf.getQuantVida());
    }
    @Test       
    public void atirarDuasFlechasAnao(){
        // Arrange
        Dwarf dwarf = new Dwarf("Teste",2,5,2016);
        Elfo novoElfo = new Elfo("Arnold");
        // Act
        novoElfo.atirarFlecha(dwarf);
        novoElfo.atirarFlecha(dwarf);
        // Assert
        assertEquals(90,dwarf.getQuantVida());
    }
    @Test       
    public void atirarFlechaDoisAnoes(){
        // Arrange
        Dwarf dwarf = new Dwarf("Teste",2,5,2016);
        Dwarf novoAnao = new Dwarf("Teste",2,5,2016);
        Elfo novoElfo = new Elfo("Arnold");
        Elfo novoElfo2 = new Elfo("bbbb");
        // Act
        novoElfo.atirarFlecha(dwarf);
        novoElfo2.atirarFlecha(novoAnao);
        // Assert
        assertEquals(100,dwarf.getQuantVida());
        assertEquals(100,novoAnao.getQuantVida());
    }
    @Test       
    public void atirarQuantDiferentesFlechasAnoes(){
        // Arrange
        Dwarf dwarf = new Dwarf("Teste",2,5,2016);
        Dwarf novoAnao = new Dwarf("Teste",2,5,2016);
        Elfo novoElfo = new Elfo("Elfo1");
        Elfo novoElfo2 = new Elfo("Elfo2");
        // Act
        novoElfo.atirarFlecha(dwarf);
        novoElfo.atirarFlecha(dwarf);
        novoElfo.atirarFlecha(dwarf);
        novoElfo2.atirarFlecha(novoAnao);
        // Assert
        assertEquals(90,dwarf.getQuantVida());
        assertEquals(100,novoAnao.getQuantVida());
    }
    @Test 
    public void elfoToString(){
       Elfo novoElfo = new Elfo("Jeniffer");
       assertEquals("Jeniffer possui 42 flechas e 0 nível de experiência.",novoElfo.toString());
    }
    @Test 
    public void elfoAtiraFlechaToString(){
       Elfo novoElfo = new Elfo("Jeniffer");
       novoElfo.atirarFlecha(new Dwarf("Teste",2,5,2016));
       assertEquals("Jeniffer possui 41 flechas e 1 nível de experiência.",novoElfo.toString());
    }
    @Test
    public void testaConstrutor(){
       Elfo novoElfo = new Elfo("Batman",34);
       assertEquals(34,novoElfo.getFlechas().getQuantidade());
       assertEquals("Batman",novoElfo.getNome());
    }
    @Test
     public void criarElfoComFlechasNegativas(){
       Elfo novoElfo = new Elfo("Batman",-34);
       assertEquals(42,novoElfo.getFlechas().getQuantidade());
    }
}
