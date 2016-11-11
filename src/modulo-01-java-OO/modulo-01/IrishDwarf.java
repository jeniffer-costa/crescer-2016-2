import java.util.ArrayList;

public class IrishDwarf extends Dwarf
{

    public IrishDwarf()
    {
        // this.dataNascimento = new DataTerceiraEra(1,1,1);
        // this.status = Status.VIVO;
        this(null,new DataTerceiraEra(1,1,1));
        inventario = new Inventario();
    }

    public IrishDwarf(String nome, DataTerceiraEra dataNascimento)
    {
        super(nome,dataNascimento);

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
        int numero;
        int cont=0;
        if(temSorte){
            inventario.tentarMuitaSorte();
            }
        }
    }
