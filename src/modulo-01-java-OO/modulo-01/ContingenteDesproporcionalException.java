public class ContingenteDesproporcionalException extends Exception{

    public ContingenteDesproporcionalException(){
      super("O Contingente está com um número desproporcional de Elfos!");
    }
    
    public ContingenteDesproporcionalException(String erro){
     super(erro);
    }

}
