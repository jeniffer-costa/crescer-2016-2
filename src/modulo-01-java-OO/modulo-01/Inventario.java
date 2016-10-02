import java.util.ArrayList;

public class Inventario
{
    private ArrayList<Item> itens = new ArrayList<>();
    
    public void adicionarItem(Item item){
        itens.add(item);
    }
    public void removerItem(Item item){
        itens.remove(item);
    }
    public ArrayList<Item> getItens(){
        return itens;
    }
    public Item getItem(int index){
       return itens.get(index);
    }
    public String getDescricoesItens(){
        String descricoesItens = itens.get(0).getDescricao();

        for(int i=0;i<itens.size();i++){
            descricoesItens = itens.get(i).getDescricao() + ",";
        }
        return descricoesItens;
    }

    public Item itemMaiorQuantidade(){
        Item maiorQuantidade = itens.get(0);

        for(int i=0;i<itens.size();i++){
            if(maiorQuantidade.getQuantidade() < itens.get(i).getQuantidade()){
                maiorQuantidade = itens.get(i);
            }
        }
        return maiorQuantidade;
    }

    public void ordenarItens(){     
        for (int i = 0; i < itens.size(); i++) 
        {
            Item menorQuantidade = itens.get(i);
            for (int j = i - 1; j >= 0 && itens.get(j).getQuantidade() > menorQuantidade.getQuantidade(); j--)
            {
                itens.set(j+1,itens.get(j));
                itens.set(j,menorQuantidade);
            }                       
        }               
    }
}
