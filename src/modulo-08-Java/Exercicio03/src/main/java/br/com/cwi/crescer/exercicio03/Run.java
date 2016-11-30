package br.com.cwi.crescer.exercicio03;

import dao.ClientDao;
import dao.ContractDao;
import dao.ContractValueDao;
import dao.CotacaoDao;
import entity.Client;
import entity.Contract;
import entity.ContractValue;
import entity.Cotacao;
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

        CotacaoDao cotacaoDao = new CotacaoDao(em);
        final Cotacao cotacao = new Cotacao();
        cotacao.setDsCotacaoDollarAustraliano(89.8);
        cotacao.setDsCotacaoDollarCanadense(58.6);
        cotacao.setDsCotacaoEuro(89.4);
        cotacao.setDsCotacaoFrancoSuico(87.6);
        cotacao.setDsCotacaoLibra(56.4);
        cotacao.setDsCotacaoReal(3.65);
        cotacao.setDsCotacaoYen(8.5);
        cotacao.setDsCotacaoYuan(3.2);
        cotacao.setDtCotacao("04/12/1991");
        
        cotacaoDao.insert(cotacao);
        
        em.close();
        emf.close();
    }
}
