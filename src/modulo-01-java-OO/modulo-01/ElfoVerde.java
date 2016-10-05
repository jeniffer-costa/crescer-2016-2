import java.util.ArrayList;
import java.util.Arrays;
public class ElfoVerde extends Elfo
{

    public ElfoVerde(String nome){
        super(nome);
    }

    public ElfoVerde(String nome, int quantidadeFlechas){
        super(nome, quantidadeFlechas);
    }

    public void atirarFlecha(Dwarf dwarf){
        boolean temFlecha = inventario.getItem(0).getQuantidade() > 0;
        if (temFlecha){
            inventario.getItem(1).setQuantidade(inventario.getItem(1).getQuantidade()-1);
            experiencia+=2;
            dwarf.perdeVida();
        }
    }

    public void alistarElfo(ElfoVerde elfo){
        super.alistarElfo(elfo);
    }
    
    @Override
    protected void inicializarInventario(int quantidadeFlechas) {
        this.adicionarItem(new Item("Arco de Vidro", 1));
        this.adicionarItem(new Item("Flecha de Vidro", quantidadeFlechas >= 0 ? quantidadeFlechas : 42));
    }

    public void adicionarItem(Item item) {        
        String[] validas = getNomesValidos();
        boolean podeAdicionar = item != null && new ArrayList<>(Arrays.asList(validas)).contains(item.getDescricao());

        if (podeAdicionar) {
            super.adicionarItem(item);
        }
    }

    private String[] getNomesValidos() {
        return new String[] { 
            "Espada de aço valiriano", 
            "Arco de Vidro",
            "Flecha de Vidro"
        };
    }

}

