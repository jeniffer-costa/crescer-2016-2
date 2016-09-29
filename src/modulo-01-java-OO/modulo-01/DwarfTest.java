

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
    @Test
    public void dwarfNasceComQuantVidas(){
        // Arrange
        Dwarf novoAnao = new Dwarf("Teste",2,5,2016);
        // Assert e Act
        assertEquals(110,novoAnao.getQuantVida());
    }
    @Test 
    public void dwarfPerdeQuantVidas(){
        // Arrange
        Dwarf novoAnao = new Dwarf("Teste",2,5,2016);
        // Act
        novoAnao.perdeVida();
        assertEquals(100,novoAnao.getQuantVida());
    }
    @Test 
    public void dwarfPerdeVinteVidas(){
        // Arrange
        Dwarf novoAnao = new Dwarf("Teste",2,5,2016);
        // Act
        for(int i=0;i<=20;i++)
        novoAnao.perdeVida();
        assertEquals(90,novoAnao.getQuantVida());
    }
    @Test
    public void dwarfNasceAno2016Mes05Dia12(){
        // Arrange
        Dwarf novoAnao = new Dwarf("Teste",12,05,2016);
        // Act
        //novoAnao.getNumeroSorte();
        assertEquals(101.0,novoAnao.getNumeroSorte(),0.001);
    }
    @Test
    public void dwarfNasceAnoNaoBissextoNomeSeixas(){
        // Arrange
        Dwarf novoAnao = new Dwarf("Seixas",12,05,2019);
        // Act
        //novoAnao.getNumeroSorte();
        assertEquals(33.0,novoAnao.getNumeroSorte(),0.001);
    }
        @Test
    public void dwarfNasceAnoBissextoEQuantVidaEntre80E90(){
        // Arrange
        Dwarf novoAnao = new Dwarf("Batman",12,05,2020);
        novoAnao.perdeVida();
        novoAnao.perdeVida();
        // Act
        //novoAnao.getNumeroSorte();
        assertEquals(-3333,novoAnao.getNumeroSorte(),0.001);
    }
    @Test
    public void dwarfNasceAnoBissextoNomeMeireles(){
        // Arrange
        Dwarf novoAnao = new Dwarf("Meireles",12,05,2024);
        // Act
        //novoAnao.getNumeroSorte();
        assertEquals(101.0,novoAnao.getNumeroSorte(),0.001);
    }
    @Test
    public void dwarfNasceAnoNaoBissextoNomeMeireles(){
        // Arrange
        Dwarf novoAnao = new Dwarf("Meireles",12,05,2022);
        // Act
        //novoAnao.getNumeroSorte();
        assertEquals(33,novoAnao.getNumeroSorte(),0.001);
    }

}
