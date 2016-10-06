import java.util.ArrayList;

public class ExercitoDeElfos
{
    private ArrayList<Elfo> elfosAlistados = new ArrayList<>();

    public ExercitoDeElfos(){
    }

    public void alistarElfo(Elfo elfo){
        boolean podeAlistar = elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno;
        if(podeAlistar){
            elfosAlistados.add(elfo);
        }
    }

    public ArrayList<Elfo> getElfosAlistados(){
        return elfosAlistados;
    }

    public Elfo getElfoAlistado(int index){
        return elfosAlistados.get(index);
    }

    public Elfo buscarElfoPeloNome(String buscaNome){
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