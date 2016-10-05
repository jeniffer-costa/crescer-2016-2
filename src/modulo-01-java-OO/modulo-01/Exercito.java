import java.util.ArrayList;

public abstract class Exercito
{
    private ArrayList<Elfo> elfos = new ArrayList<>();

    public void alistarElfo(ElfoVerde elfo){
        elfos.add(elfo);
    }
    
    public void alistarElfo(ElfoNoturno elfo){
        elfos.add(elfo);
    }

    public Status getStatus(){
        return this.getStatus();
    }
    
    public ArrayList<Elfo> getElfos(){
        return elfos;
    }
    
    public Elfo getElfo(int index){
        return elfos.get(index);
    }
    
    public Elfo buscarElfoPeloNome(String buscaNome){
        Elfo encontrouNome = null;
        for(int i=0;i<elfos.size();i++){
             if (elfos.get(i).getNome().equals(buscaNome)){
              encontrouNome = elfos.get(i);
            }
        }
        return encontrouNome;
    }
    
    public ArrayList<Elfo> buscarElfoPeloStatus(Status status){
        ArrayList<Elfo> elfosStatus = new ArrayList<>();
        
        for(int i=0;i<elfos.size();i++){
            if(getStatus().equals(status)){
                elfosStatus.add(elfos.get(i));
            }
        }
        return elfosStatus;
    }
   
}