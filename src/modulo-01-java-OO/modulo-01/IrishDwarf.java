import java.util.ArrayList;

public class IrishDwarf
{
    private int quantVida = 110;
    private DataTerceiraEra dataNascimento;
    private String nome;
    private int experiencia;
    private Status status;
    private Inventario inventario;

    public IrishDwarf()
    {
        // this.dataNascimento = new DataTerceiraEra(1,1,1);
        // this.status = Status.VIVO;
        this(null,new DataTerceiraEra(1,1,1));
        inventario = new Inventario();
    }

    public IrishDwarf(String nome, DataTerceiraEra dataNascimento)
    {
        inventario = new Inventario();
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.status = Status.VIVO;
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
            if (getQuantVida() == 0){
                status = Status.MORTO;
            }
        }
    }

    public int getQuantVida(){
        return quantVida;
    }

    public Status getStatus(){
        return status;
    }
    
    public Inventario getInventario(){
        return inventario;
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

    public void adicionarItem(Item item){
        inventario.adicionarItem(item);
    }

    public void removerItem(Item item){
        inventario.removerItem(item);
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
