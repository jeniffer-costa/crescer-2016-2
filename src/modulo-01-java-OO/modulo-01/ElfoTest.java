
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
        Elfo novoElfo = new Elfo("Elrond");
        // Assert
        assertEquals("Arco",novoElfo.getInventario().getItem(0).getDescricao());
        assertEquals(1, novoElfo.getInventario().getItem(0).getQuantidade());
    }
    @Test
    public void elfoNasceComFlechas(){
       Elfo novoElfo = new Elfo("Legolas");
       // Assert
       assertEquals("Flechas",novoElfo.getInventario().getItem(1).getDescricao());
       assertEquals(42, novoElfo.getInventario().getItem(1).getQuantidade());
    }
    @Test
    public void atirarUmaFlecha(){
       // Arrange
       Elfo novoElfo = new Elfo("Legolas");
       // Act
       novoElfo.atirarFlecha(new Dwarf());
       // Assert
       assertEquals(41,novoElfo.getInventario().getItem(1).getQuantidade());
       assertEquals(1, novoElfo.getExperiencia());
    }
    @Test
    public void atirarDezFlechas(){
       // Arrange
       Elfo novoElfo = new Elfo("Jeniffer");
       // Act
       novoElfo.atirarFlecha(new Dwarf());
       novoElfo.atirarFlecha(new Dwarf());
       novoElfo.atirarFlecha(new Dwarf());
       novoElfo.atirarFlecha(new Dwarf());
       novoElfo.atirarFlecha(new Dwarf());
       novoElfo.atirarFlecha(new Dwarf());
       novoElfo.atirarFlecha(new Dwarf());
       novoElfo.atirarFlecha(new Dwarf());
       novoElfo.atirarFlecha(new Dwarf());
       novoElfo.atirarFlecha(new Dwarf());
       // Assert
       assertEquals(32,novoElfo.getInventario().getItem(1).getQuantidade());
       assertEquals(10, novoElfo.getExperiencia());
    }
    @Test
    public void atirar42Flechas(){
       // Arrange
       Elfo novoElfo = new Elfo("Batman");
       // Act
       for (int i=0;i<42;i++)
       novoElfo.atirarFlecha(new Dwarf());
       // Assert
       assertEquals(0,novoElfo.getInventario().getItem(1).getQuantidade());
       assertEquals(42, novoElfo.getExperiencia());
    }
    @Test       
    public void DwarfPerdeQuantVida(){
        // Arrange
        Dwarf dwarf = new Dwarf();
        Elfo novoElfo = new Elfo("Arnold");
        // Act
        novoElfo.atirarFlecha(dwarf);
        // Assert
        assertEquals(100,dwarf.getQuantVida());
    }
    @Test       
    public void atirarDuasFlechasAnao(){
        // Arrange
        Dwarf dwarf = new Dwarf();
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
        Dwarf dwarf = new Dwarf();
        Dwarf novoAnao = new Dwarf();
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
        DataTerceiraEra novaData = new DataTerceiraEra(12,12,2015);
        Dwarf dwarf = new Dwarf("Pedro",novaData);
        Dwarf novoAnao = new Dwarf("Batman",novaData);
        Elfo novoElfo1 = new Elfo("Elfo1");
        Elfo novoElfo2 = new Elfo("Elfo1");
        Elfo novoElfo3 = new Elfo("Elfo1");
        // Act
        novoElfo1.atirarFlecha(dwarf);
        novoElfo2.atirarFlecha(dwarf);
        novoElfo3.atirarFlecha(novoAnao);
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
       novoElfo.atirarFlecha(new Dwarf());
       assertEquals("Jeniffer possui 41 flechas e 1 nível de experiência.",novoElfo.toString());
    }
    @Test
    public void testaConstrutor(){
       Elfo novoElfo = new Elfo("Batman",34);
       assertEquals(34,novoElfo.getInventario().getItem(1).getQuantidade());
       assertEquals("Batman",novoElfo.getNome());
    }
    @Test
     public void criarElfoComFlechasNegativas(){
       Elfo novoElfo = new Elfo("Batman",-34);
       assertEquals(42,novoElfo.getInventario().getItem(1).getQuantidade());
    }
    @Test
    public void elfoNasceVivo(){
      Elfo novoElfo = new Elfo("Batman");
      assertEquals(Status.VIVO,novoElfo.getStatus());
    }

}
