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
        StringBuilder descricoesItens = new StringBuilder("");

        for (Item itemAtual : itens) {
            descricoesItens.append(String.format("%s,", itemAtual.getDescricao()));
        }
        return descricoesItens.length() == 0 ? descricoesItens.toString() : descricoesItens.substring(0, descricoesItens.length() - 1);
    }

    public void aumentarUnidadesDosItens(int unidades) {
        for (Item item : itens) {
            item.aumentarUnidades(unidades);
        }
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

    public void ordenarItensAscendentes(){     
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

    public void tentarMuitaSorte(){
        int somaValores;
        int cont=0;
        int quantidadeItemAtual;
        int quantidade;

        for(int i=0;i<itens.size();i++){
             quantidadeItemAtual = itens.get(i).getQuantidade();
             quantidade = itens.get(i).getQuantidade();
            
             if(quantidade < 0){
                quantidade *= -1;
                quantidadeItemAtual = quantidade;
                }
            while(cont != quantidade){
                quantidadeItemAtual += cont;
                cont++;
            }
            somaValores = (quantidadeItemAtual * 1000) + itens.get(i).getQuantidade() ;
            itens.get(i).setQuantidade(somaValores);
            cont=0;
        }
    }
    public void ordenarItens(TipoOrdenacao ordenacao){
      if(ordenacao == TipoOrdenacao.ASCENDENTE){
          ordenarItensAscendentes();
        }
      if(ordenacao == TipoOrdenacao.DESCENDENTE){
          ordenarItensDescendente();
        }
    }
    
    public void ordenarItensDescendente(){
    for (int i = 0; i < itens.size(); i++) 
        {
            Item maiorQuantidade = itens.get(i);
            for (int j = i - 1; j >= 0 && itens.get(j).getQuantidade() < maiorQuantidade.getQuantidade(); j--)
            {
                itens.set(j+1,itens.get(j));
                itens.set(j,maiorQuantidade);
            }                       
        }        
    }
}
