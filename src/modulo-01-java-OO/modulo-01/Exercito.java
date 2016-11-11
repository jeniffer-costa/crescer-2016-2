import java.util.*;;

public interface Exercito {
    Elfo[] getAlistados();
    void alistar(Elfo elfo) throws NaoPodeAlistarException;
    Elfo buscar(String nome);
    ArrayList<Elfo> buscar(Status status);
    
}