public class NaoPodeAlistarException extends Exception{

    public NaoPodeAlistarException(){
      super("Não foi possivel alistar o Elfo !");
    }
    
    public NaoPodeAlistarException(String erro){
     super(erro);
    }

}