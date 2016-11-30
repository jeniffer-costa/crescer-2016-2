package dao;

import entity.Usuario;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author jeniffer.costa
 */
public class UsuarioDao implements IDao<Usuario>{
    
    final EntityManager entityManager;
    
    public UsuarioDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List list() {
        return entityManager.createQuery("Select u from Usuario u").getResultList();
    }
    @Override
    public void insert(Usuario t) {
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(t);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void update(Usuario t) {
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(t);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Usuario t) {
        try{
            entityManager.getTransaction().begin();
            entityManager.remove(t);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            entityManager.getTransaction().rollback();
        }
    }
}
