package br.com.cwi.crescer.exercicio03;

import dao.ClientDao;
import dao.ContractDao;
import dao.ContractValueDao;
import dao.CotacaoDao;
import dao.CurrencyExchangeDao;
import entity.Client;
import entity.Contract;
import entity.ContractValue;
import entity.Cotacao;
import entity.CurrencyExchange;
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

        CurrencyExchangeDao currencyExchangeDao = new CurrencyExchangeDao(em);
        CurrencyExchange currencyExchange = new CurrencyExchange();
        
        currencyExchange.setDsCoin("xxxxx");
        currencyExchange.setDtCurrencyExchange("xxxx");
        currencyExchange.setVlRate(18.5);
        
        currencyExchangeDao.insert(currencyExchangeDao);
        
        em.close();
        emf.close();
    }
}
