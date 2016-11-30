package br.com.cwi.crescer.exercicio03;

import dao.ClientDao;
import dao.ContractDao;
import dao.ContractValueDao;
import dao.CotacaoDao;
import dao.CurrencyExchangeDao;
import dao.UsuarioDao;
import entity.Client;
import entity.Contract;
import entity.ContractValue;
import entity.Cotacao;
import entity.CurrencyExchange;
import entity.Usuario;
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

        UsuarioDao usuarioDao = new UsuarioDao(em);
        final Usuario usuario = new Usuario();
        
        usuario.setDsEmail("diego@gmail.com");
        usuario.setDsSituacao("AP");
        usuario.setDsUserName("Diego");
        usuario.setNmUsuario("Diego Barbosa");
        usuario.setTpPermissao("Admin");
        usuarioDao.insert(usuario);
        
        em.close();
        emf.close();
    }
}
