
package br.com.cwi.crescer.exercicio04;

import java.util.List;

/**
 *
 * @author diiego
 * @param <T>
 * @param <ID>
 */
public interface IDao<T, ID> {

    void insert(T t);
    
    void delete(T t);
    
    T find(ID id);
    
    List<T> findAll();
}
