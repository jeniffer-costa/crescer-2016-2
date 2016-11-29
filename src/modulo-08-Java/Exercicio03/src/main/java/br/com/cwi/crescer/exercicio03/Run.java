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
        client.setDsEmail("jenifferkosta@gmail.com");
        client.setDsPassword("12345");
        client.setDsPreferredCoin("Euro");
        client.setDsState("RS");
        client.setDsUserName("jeniffer.costa");
        client.setNmClient("Jeniffer");
        client.setTpPermission("Admin");
        clientDao.update(client);
        
    }
}
