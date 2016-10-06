import java.util.ArrayList;

public class ElfoNoturno extends Elfo
{

    public ElfoNoturno(String nome){
        super(nome);
    }
    
    public ElfoNoturno(String nome, int qtdFlechas) {
        super(nome, qtdFlechas);
    }

    public void atirarFlecha(Dwarf dwarf){
        if (status == Status.VIVO && getInventario().getItem(0).getQuantidade() > 0){
            super.atirarFlecha(dwarf);
            experiencia = experiencia + 2;
            double ValorPercentual = getQuantVida() * 0.05;

            quantVida = getQuantVida() - ValorPercentual;
            if ((int)this.quantVida == 0){
                status = Status.MORTO;
            }
        }
    }
}
