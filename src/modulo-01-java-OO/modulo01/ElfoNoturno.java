import java.util.ArrayList;

public class ElfoNoturno extends Elfo
{

    public ElfoNoturno(String nome){
        super(nome);
    }

    public void atirarFlecha(Dwarf dwarf){
        super.atirarFlecha(dwarf);
        experiencia = experiencia + 2;
        double ValorPercentual = getQuantVida() * 0.05;
        
        quantVida = getQuantVida() - ValorPercentual;
        if (Math.abs(quantVida) == 0){
           status = Status.MORTO;
        }
    }
}
    