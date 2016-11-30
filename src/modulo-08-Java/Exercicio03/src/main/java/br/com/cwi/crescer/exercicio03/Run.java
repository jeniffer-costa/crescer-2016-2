package br.com.cwi.crescer.exercicio03;

import dao.ClientDao;
import dao.ContractDao;
import dao.ContractValueDao;
import entity.Client;
import entity.Contract;
import entity.ContractValue;
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

        ContractValueDao contractValueDao = new ContractValueDao(em);
        final ContractValue contractValue = new ContractValue();
        contractValue.setDsCoin("xxxx");
        contractValue.setDsPeriodicity("dddd");
        contractValue.setVlAmountContractValue(15l);
        contractValue.setVlMonthlyUsd(14l);
        
        contractValueDao.insert(contractValue);
        
        em.close();
        emf.close();
    }
}
