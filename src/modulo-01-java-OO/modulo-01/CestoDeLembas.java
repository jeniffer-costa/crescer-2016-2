public class CestoDeLembas
{
   private Item numLembas;
   
    public CestoDeLembas()
    {
        numLembas = new Item("Lemba",1);
    }
    public boolean podeDividirEmPares(int num){
        boolean resultado = false;
        numLembas.setQuantidade(num);
       if((numLembas.getQuantidade() % 2 == 0)&&(numLembas.getQuantidade() > 2)){
           if((numLembas.getQuantidade() >= 1) && (numLembas.getQuantidade() <= 100)){
         resultado = true;
        }else{
            resultado = false;
        }
     }
     return resultado;
    }
}
