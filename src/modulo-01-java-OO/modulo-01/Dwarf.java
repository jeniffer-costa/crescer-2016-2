
public class Dwarf
{
    private int quantVida = 110;
    private DataTerceiraEra dataNascimento;
    private String nome;
    private int experiencia;

    public Dwarf()
    {
        dataNascimento = new DataTerceiraEra(1,1,1);
    }

    public Dwarf(String nome, int dia, int mes, int ano)
    {
        this.nome = nome;
        dataNascimento = new DataTerceiraEra(dia,mes,ano);
    }

    public void perdeVida(){
        if (getNumeroSorte() < 0){
            experiencia++;
        }
        if (getNumeroSorte() > 100){
            quantVida -= 10;
        }

    }
    public int getQuantVida(){
        return quantVida;
    }

    public double getNumeroSorte(){
        double valorInicial = 101.0;

        if ((this.dataNascimento.ehBissexto()) && (this.getQuantVida() >= 80 && this.getQuantVida() <= 90)){
            valorInicial *= -33;
        }
        if ((this.dataNascimento.ehBissexto() == false) && (this.nome == "Seixas" || this.nome == "Meireles")){
            valorInicial = (valorInicial * 33) % 100;
        }
        return valorInicial;

        //Se o campo dataNascimento do objeto Dwarf não for bissexto e o nome do Dwarf for "Seixas" ou "Meireles",
        //multiplique o número a ser retornado por 33 e faça operador mod 100 com o resultado da multiplicação.
    }
}
