import java.util.*;

public class AtaqueNoturnoPorUltimo implements EstrategiaDeAtaque
{
    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes){
        ArrayList<Elfo> elfosVerdes = new ArrayList();
        ArrayList<Elfo> elfosNoturnos = new ArrayList();
        ArrayList<Elfo> ordemDeAtaque = new ArrayList();
        
        for(int i=0;i<atacantes.size();i++){
           boolean ehVivo = atacantes.get(i).getStatus().equals(Status.VIVO);
            if(ehVivo && atacantes.get(i) instanceof ElfoVerde ){
              elfosVerdes.add(atacantes.get(i));
            }
           else if (ehVivo && atacantes.get(i) instanceof ElfoNoturno){
             elfosNoturnos.add(atacantes.get(i));
            }
        }
        ordemDeAtaque.addAll(elfosVerdes);
        ordemDeAtaque.addAll(elfosNoturnos);
        return ordemDeAtaque;
    }
}
