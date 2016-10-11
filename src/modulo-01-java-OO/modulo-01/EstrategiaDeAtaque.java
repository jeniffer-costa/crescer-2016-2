import java.util.*;
public interface EstrategiaDeAtaque
{
    List<Elfo> getOrdemDeAtaque(List<Elfo> atacantes)throws ContingenteDesproporcionalException;
}
