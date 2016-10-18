import java.util.ArrayList;

public class Dwarf extends Personagem
{
    protected DataTerceiraEra dataNascimento;

    public Dwarf()
    {
        // this.dataNascimento = new DataTerceiraEra(1,1,1);
        // this.status = Status.VIVO;
        this(null,new DataTerceiraEra(1,1,1));
    }

    public Dwarf(String nome, DataTerceiraEra dataNascimento)
    {
        super (nome);
        this.dataNascimento = dataNascimento;
        this.quantVida = 110;
    }

    public void perdeVida(){
        boolean estaMorto = status.equals(Status.MORTO);
        if(!estaMorto){
            double numeroSorte = getNumeroSorte();
            if (numeroSorte < 0){
                experiencia++;
            }
            if (numeroSorte > 100){
                quantVida -= 10;
                if (getQuantVida() < 0){
                    quantVida = 0;
                }
            }
            if ((int)this.getQuantVida() == 0){
                status = Status.MORTO;
            }
        }
    }

    public double getNumeroSorte(){
        double valorInicial = 101.0;
        boolean ehBissexto = dataNascimento.ehBissexto();
        if (dataNascimento.ehBissexto() && this.getQuantVida() >= 80 && this.getQuantVida() <= 90){
            valorInicial *= -33;
        }
        if (!dataNascimento.ehBissexto() && ("Seixas".equals(this.nome) || "Meireles".equals(this.nome))){
            valorInicial = (valorInicial * 33) % 100;
        }
        return valorInicial;
    }
    
    public void tentarSorte(){
        boolean temSorte = getNumeroSorte() == -3333;

        if(temSorte){
            inventario.aumentarUnidadesDosItens(1000);
        }
    }
    
}
