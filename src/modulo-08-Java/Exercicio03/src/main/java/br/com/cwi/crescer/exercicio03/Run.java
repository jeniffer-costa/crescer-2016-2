package br.com.cwi.crescer.exercicio03;

import dao.ClientDao;
import entity.Client;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jeniffer.costa
 */
public class Run {

    public static void main(String[] args) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em = emf.createEntityManager();
        
        ClientDao clientDao = new ClientDao(em);
        
        final Client client = new Client();
        client.setDsEmail("spoder@gmail.com");
        client.setDsPassword("98745");
        client.setDsPreferredCoin("Euro");
        client.setDsState("RS");
        client.setDsUserName("spoder.barbosa");
        client.setNmClient("Spoder");
        client.setTpPermission("Admin");
        clientDao.insert(client);
        
        final Client client2 = new Client();
        client2.setDsEmail("diego@gmail.com");
        client2.setDsPassword("456");
        client2.setDsPreferredCoin("Euro");
        client2.setDsState("RS");
        client2.setDsUserName("diego.barbosa");
        client2.setNmClient("Diego");
        client2.setTpPermission("Admin");
        clientDao.insert(client2);
        
        //System.out.println(client.getDsEmail() + client.getDsPassword() + client.getNmClient());
        
        //clientDao.delete(client);
        
        System.out.println(clientDao.list());
        
        em.close();
        emf.close();
    }
}
