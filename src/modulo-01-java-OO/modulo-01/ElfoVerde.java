import java.util.ArrayList;

public class ElfoVerde extends Elfo
{

    public ElfoVerde(String nome){
        super(nome);

    }

    public ElfoVerde(String n, int quantFlechas){
        super(n);
        this.inventario.adicionarItem(new Item("Arco de Vidro", 1));
        this.inventario.adicionarItem(new Item("Flecha de Vidro", quantFlechas >= 0 ? quantFlechas : 42));
        quantVida = 100;
    }

    public void atirarFlecha(Dwarf dwarf){
        super.atirarFlecha(dwarf);
        experiencia++;
    }
    
}

