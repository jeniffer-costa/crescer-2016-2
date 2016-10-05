
public class Item{
  private String descricao;
  private int quantidade;
  
  public Item(String descricao,int quantidade){
      this.descricao = descricao;
      this.quantidade = quantidade;
    }
    
    public void setQuantidade(int novaQuantidade){
        quantidade = novaQuantidade;
    }
   
    public int getQuantidade(){
        return quantidade;
    }
   
    public String getDescricao(){
       return descricao;
    }
    
    public void setDescricao(String descricao){
       this.descricao = descricao;
    }
    
    public void aumentarUnidades(int unidadesItens){
      quantidade += unidadesItens;
    } 
    
    @Override
    public boolean equals(Object obj){
      Item outro = (Item)obj;
        return 
         this.descricao.equals(outro.getDescricao()) && 
         this.quantidade == outro.getQuantidade();
    }
}
