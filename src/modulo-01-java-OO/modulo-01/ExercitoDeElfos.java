import java.util.ArrayList;

public class ExercitoDeElfos implements Exercito
{
    private ArrayList<Elfo> elfosAlistados = new ArrayList<>();

    public ExercitoDeElfos(){
    }

    public void alistar(Elfo elfo) throws NaoPodeAlistarException{
        boolean podeAlistar = elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno;
        if(!podeAlistar){
            throw new NaoPodeAlistarException();
        }
        elfosAlistados.add(elfo);
    }

    public Elfo[] getAlistados() {
        return elfosAlistados.toArray(new Elfo[elfosAlistados.size()]);
    }

    public Elfo buscar(String buscaNome){
        Elfo encontrouNome = null;
        for(int i=0;i<elfosAlistados.size();i++){
            if (elfosAlistados.get(i).getNome().equals(buscaNome)){
                encontrouNome = elfosAlistados.get(i);
                break;
            }
        }
        return encontrouNome;
    }

    public ArrayList<Elfo> buscar(Status status) {
        // C#: return contingente.Where(x => x.Status == status);
        ArrayList<Elfo> resultado = new ArrayList<>();

        for (Elfo elfo : elfosAlistados) {
            if (elfo.getStatus() == status) {
                resultado.add(elfo);
            }
        }

        return resultado;
    }

}