/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.exercicio04;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author diiego
 */
@ManagedBean
@ViewScoped
public class ElencoCadastro {
    
    @EJB
    private ElencoBean elencoBean;
    
    private Elenco elenco;
    private List<Elenco> elencos;
    
    @PostConstruct
    public void init() {
        this.elenco = new Elenco();
        this.elencos = elencoBean.findAll();

    }
    
    public Elenco getElenco() {
        return elenco;
    }

    public void setElenco(Elenco elenco) {
        this.elenco = elenco;
    }

    public List<Elenco> getElencos() {
        return elencos;
    }

    public void setElencos(List<Elenco> elencos) {
        this.elencos = elencos;
    }

    public void adicionar() {
        elencoBean.insert(elenco);
        this.init();
    }
}
