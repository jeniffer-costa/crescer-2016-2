import java.util.*;

public class AtaqueIntercalado implements EstrategiaDeAtaque
{
    public List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes)throws ContingenteDesproporcionalException{
        // Verifico se o batalhao é proporcional, caso não seja, cai no Exception.
        if(!verificarSeBatalhaoEhProporcional(atacantes)){
            throw new ContingenteDesproporcionalException();
            // Se for proporcional, faço a ordenação intercalada.
        }else{
           return ordenarIntercalado(atacantes);
    }
}

    public boolean verificarSeBatalhaoEhProporcional(List<Elfo> atacantes){
        int elfosVerdes=0;
        int elfosNoturnos=0;
        boolean ehProporcional = false;

        for(int i=0;i<atacantes.size();i++){
            boolean ehVivo = atacantes.get(i).getStatus().equals(Status.VIVO);
            boolean ehElfoVerde = atacantes.get(i) instanceof ElfoVerde;
            boolean ehElfoNoturno = atacantes.get(i) instanceof ElfoNoturno;

            if(ehVivo && ehElfoVerde){
                elfosVerdes++;
            }
            if(ehVivo && ehElfoNoturno){
                elfosNoturnos++;
            }
        }
        if (elfosVerdes == elfosNoturnos ){
            ehProporcional = true;
        }
        return ehProporcional;
    }

    public List<Elfo> ordenarIntercalado(List<Elfo> atacantes){
        ArrayList<Elfo> sohElfosVerdes = new ArrayList();
        ArrayList<Elfo> sohElfosNoturnos = new ArrayList();
        ArrayList<Elfo> ordemIntercalado = new ArrayList();
        
        for(int i=0;i<atacantes.size();i++){
            boolean ehVivo = atacantes.get(i).getStatus().equals(Status.VIVO);
            if(ehVivo && atacantes.get(i) instanceof ElfoVerde ){
                sohElfosVerdes.add(atacantes.get(i));
            }
            else if (ehVivo && atacantes.get(i) instanceof ElfoNoturno){
                sohElfosNoturnos.add(atacantes.get(i));
            }
        }
        while(ordemIntercalado.size() != atacantes.size()){
            for(int i=0;i<atacantes.size();i++){
                ordemIntercalado.add(sohElfosVerdes.get(i));
                ordemIntercalado.add(sohElfosNoturnos.get(i));
            }
       }
        return ordemIntercalado;
    }
}