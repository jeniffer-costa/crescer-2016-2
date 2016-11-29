package br.com.cwi.crescer.exercicio03;

import dao.ClientDao;
import dao.ContractDao;
import entity.Client;
import entity.Contract;
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
        
        ContractDao contractDao = new ContractDao(em);
        final Contract contract = new Contract();
        contract.setDsDescription("xxx");
        contract.setDsState("RS");
        contract.setDsWebSite("www.teste.com.br");
        contract.setNmContract("Teste");
        contract.setClientIdClient(12l);
        
        contractDao.insert(contract);
        
        em.close();
        emf.close();
    }
}
