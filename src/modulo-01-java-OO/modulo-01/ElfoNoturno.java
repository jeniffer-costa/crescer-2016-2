import java.util.ArrayList;

public class ElfoNoturno extends Elfo
{

    public ElfoNoturno(String nome){
        super(nome);
    }

    public void atirarFlecha(Dwarf dwarf){
        super.atirarFlecha(dwarf);
        experiencia = experiencia + 2;
        quantVida = quantVida - (0.05 * 100);
        if (Math.abs(quantVida) == 0){
           status = Status.MORTO;
        }
    }
}
    