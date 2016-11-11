import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventarioTest
{
    @Test
    public void adicionarUmItem(){
        Inventario inventario = new Inventario();
        Item arco = new Item("Arco",2);
        inventario.adicionarItem(arco);
        assertEquals("Arco", inventario.getItem(0).getDescricao());
    }

    @Test
    public void adicionarDoisItens(){
        Inventario inventario = new Inventario();
        Item arco = new Item("Arco",2);
        Item flecha = new Item("Flecha",42);
        inventario.adicionarItem(arco);
        inventario.adicionarItem(flecha);
        assertEquals("Arco", inventario.getItem(0).getDescricao());
        assertEquals("Flecha", inventario.getItem(1).getDescricao());
    }

    @Test
    public void adicionarDoisItensInventariosDiferentes(){
        Inventario inventario1 = new Inventario();
        Inventario inventario2 = new Inventario();
        Item arco = new Item("Arco",2);
        Item flecha = new Item("Flecha",42);
        inventario1.adicionarItem(arco);
        inventario1.adicionarItem(flecha);
        inventario2.adicionarItem(arco);
        inventario2.adicionarItem(flecha);
        assertEquals("Arco", inventario1.getItem(0).getDescricao());
        assertEquals("Flecha", inventario1.getItem(1).getDescricao());
        assertEquals("Arco", inventario2.getItem(0).getDescricao());
        assertEquals("Flecha", inventario2.getItem(1).getDescricao());
    }

    @Test
    public void removerUmItemDoInventario(){
        Inventario inventario = new Inventario();
        Item arco = new Item("Arco",2);
        inventario.adicionarItem(arco);
        inventario.removerItem(arco);
        assertFalse(inventario.getItens().contains(arco));
    }

    @Test
    public void removerUmItemDoInventarioVazio(){
        Inventario inventario = new Inventario();
        Item arco = new Item("Arco",2);
        inventario.adicionarItem(arco);
        inventario.removerItem(arco);
        assertFalse(inventario.getItens().contains(arco));
    }

    @Test
    public void AdicionarDoisItensRemoverUmItem(){
        Inventario inventario = new Inventario();
        Item arco = new Item("Arco",2);
        Item flecha = new Item("Flecha",42);
        inventario.adicionarItem(arco);
        inventario.adicionarItem(flecha);
        inventario.removerItem(arco);
        assertFalse(inventario.getItens().contains(arco));
        assertTrue(inventario.getItens().contains(flecha));
    }

    @Test
    public void removerItemSemAdicionaloAntes() {
        Inventario inventario = new Inventario();
        Item espadaZ = new Item("Espada Z", 1);
        inventario.removerItem(espadaZ);
        assertFalse(inventario.getItens().contains(espadaZ));
    }

    @Test
    public void getDescricoesItensComVariosItens() {
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Adaga", 14));
        inventario.adicionarItem(new Item("Escudo", 2));
        inventario.adicionarItem(new Item("Bracelete", 56));
        assertEquals("Adaga,Escudo,Bracelete", inventario.getDescricoesItens());
    }

    @Test
    public void getDescricoesItensComApenasUmItem() {
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Bracelete", 56));
        assertEquals("Bracelete", inventario.getDescricoesItens());
    }

    @Test
    public void aumentar1000UnidadesDosItens() {
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Espada de aço", 2));
        inventario.adicionarItem(new Item("Poção polissuco", 45));
        inventario.adicionarItem(new Item("Lucky egg", 3));
        inventario.aumentarUnidadesDosItens(1000);
        assertEquals(1002, inventario.getItens().get(0).getQuantidade());
        assertEquals(1045, inventario.getItens().get(1).getQuantidade());
        assertEquals(1003, inventario.getItens().get(2).getQuantidade());
    }

    @Test
    public void aumentar1UnidadeDosItens() {
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Espada de aço", 2));
        inventario.adicionarItem(new Item("Poção polissuco", 45));
        inventario.adicionarItem(new Item("Lucky egg", 3));
        inventario.aumentarUnidadesDosItens(1);
        assertEquals(3, inventario.getItens().get(0).getQuantidade());
        assertEquals(46, inventario.getItens().get(1).getQuantidade());
        assertEquals(4, inventario.getItens().get(2).getQuantidade());
    }

    @Test
    public void aumentar0UnidadeDosItens() {
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Espada de aço", 2));
        inventario.adicionarItem(new Item("Poção polissuco", 45));
        inventario.adicionarItem(new Item("Lucky egg", 3));
        inventario.aumentarUnidadesDosItens(0);
        assertEquals(2, inventario.getItens().get(0).getQuantidade());
        assertEquals(45, inventario.getItens().get(1).getQuantidade());
        assertEquals(3, inventario.getItens().get(2).getQuantidade());

    }

    @Test
    public void aumentarUnidadeSemItens() {
        Inventario inventario = new Inventario();
        inventario.aumentarUnidadesDosItens(1000);
        assertEquals(0, inventario.getItens().size());
    }

    @Test
    public void itemComMaiorQuantidadeCom3Itens() {
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Espada de aço", 2));
        inventario.adicionarItem(new Item("Poção polissuco", 45));
        inventario.adicionarItem(new Item("Lucky egg", 3));
        Item item = inventario.itemMaiorQuantidade();
        assertEquals("Poção polissuco", item.getDescricao());
        assertEquals(45, item.getQuantidade());
    }

    @Test
    public void itemComMaiorQuantidadeCom3ItensDeQuantidadesIguais() {
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item("Espada de aço", 2));
        inventario.adicionarItem(new Item("Poção polissuco", 2));
        inventario.adicionarItem(new Item("Lucky egg", 2));
        Item item = inventario.itemMaiorQuantidade();
        assertEquals("Espada de aço", item.getDescricao());
        assertEquals(2, item.getQuantidade());
    }

    @Test
    public void ordenarItensQuantidadeAscendente(){
     Inventario inventario = new Inventario();
     inventario.adicionarItem(new Item("Espada de aço", 23));
     inventario.adicionarItem(new Item("Poção polissuco", 2));
     inventario.adicionarItem(new Item("Lucky egg", 12));
     inventario.ordenarItensAscendentes();
     assertEquals(2, inventario.getItem(0).getQuantidade());
     assertEquals(12, inventario.getItem(1).getQuantidade());
     assertEquals(23, inventario.getItem(2).getQuantidade());
    }
    
    @Test
    public void ordenarItensQuantidadeAscendenteJaOrdenada(){
     Inventario inventario = new Inventario();
     inventario.adicionarItem(new Item("Espada de aço", 2));
     inventario.adicionarItem(new Item("Poção polissuco", 23));
     inventario.adicionarItem(new Item("Lucky egg", 42));
     inventario.ordenarItensAscendentes();
     assertEquals(2, inventario.getItem(0).getQuantidade());
     assertEquals(23, inventario.getItem(1).getQuantidade());
     assertEquals(42, inventario.getItem(2).getQuantidade());
    }
    

}
