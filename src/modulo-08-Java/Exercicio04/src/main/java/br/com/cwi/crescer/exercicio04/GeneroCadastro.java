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
public class GeneroCadastro {
    
    @EJB
    private GeneroBean generoBean;
    
    private Genero genero;
    private List<Genero> generos;
    
    @PostConstruct
    public void init() {
        this.genero = new Genero();
        this.generos =  generoBean.findAll();

    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    public void adicionar() {
        generoBean.insert(genero);
        this.init();
    }    
}
