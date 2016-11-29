package dao;

import java.util.List;

/**
 *
 * @author jeniffer.costa
 * @param <T>
 */
public interface IDao<T> {
    void insert(T t);
    
    void update(T t);
    
    void delete(T t);
    
    List<T> list();
}
