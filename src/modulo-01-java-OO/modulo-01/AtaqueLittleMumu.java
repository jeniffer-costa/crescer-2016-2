import java.util.*;

public class AtaqueLittleMumu implements EstrategiaDeAtaque
{
    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes)throws ContingenteDesproporcionalException{
        return atacantes;
    }

    public List<Elfo> verificarElfosAptos(List<Elfo> atacantes){
        ArrayList<Elfo> elfosAptos = new ArrayList();

        for(int i=0;i<atacantes.size();i++){
            if(atacantes.get(i) instanceof ElfoVerde || atacantes.get(i) instanceof ElfoNoturno){
                if(atacantes.get(i).getStatus().equals(Status.VIVO)){
                    if(atacantes.get(i).getFlecha().getQuantidade() > 0){
                        elfosAptos.add(atacantes.get(i));
                    }
                }
            }
        }
        return elfosAptos;
    }

    public List<Elfo> ordenarQuantidadeFlechasDescendentes(List<Elfo> atacantes){     
        for (int i = 0; i < atacantes.size(); i++) 
        {
            Elfo menorQuantidadeFlecha = atacantes.get(i);
            n
            for (int j = i - 1; j >= 0 && itens.get(j).getQuantidade() > menorQuantidade.getQuantidade(); j--)
            {
                itens.set(j+1,itens.get(j));
                itens.set(j,menorQuantidade);
            }                       
        }               
    }
}
