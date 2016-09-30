

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
    @Test
    public void dwarfNasceComQuantVidas(){
        // Arrange
        Dwarf novoAnao = new Dwarf();
        // Assert e Act
        assertEquals(110,novoAnao.getQuantVida());
    }
    @Test 
    public void dwarfPerdeQuantVidas(){
        // Arrange
        Dwarf novoAnao = new Dwarf();
        // Act
        novoAnao.perdeVida();
        assertEquals(100,novoAnao.getQuantVida());
    }
    @Test 
    public void dwarfPerdeVinteVidas(){
        // Arrange
        Dwarf novoAnao = new Dwarf();
        // Act
        for(int i=0;i<20;i++)
        novoAnao.perdeVida();
        assertEquals(0,novoAnao.getQuantVida());
    }
    @Test
    public void dwarfNasceAno2016Mes05Dia12(){
        // Arrange
        Dwarf novoAnao = new Dwarf();
        // Act
        //novoAnao.getNumeroSorte();
        assertEquals(101.0,novoAnao.getNumeroSorte(),0.001);
    }
    @Test
    public void dwarfNasceAnoNaoBissextoNomeSeixas(){
        // Arrange
        DataTerceiraEra novaData = new DataTerceiraEra(12,05,2019);
        Dwarf novoAnao = new Dwarf("Seixas",novaData);
        // Act
        //novoAnao.getNumeroSorte();
        assertEquals(33.0,novoAnao.getNumeroSorte(),0.001);
    }
        @Test
    public void dwarfNasceAnoBissextoEQuantVidaEntre80E90(){
        // Arrange
        DataTerceiraEra novaData = new DataTerceiraEra(12,05,2020);
        Dwarf novoAnao = new Dwarf("Batman",novaData);
        novoAnao.perdeVida();
        novoAnao.perdeVida();
        // Act
        //novoAnao.getNumeroSorte();
        assertEquals(-3333,novoAnao.getNumeroSorte(),0.001);
    }
    @Test
    public void dwarfNasceAnoBissextoNomeMeireles(){
        // Arrange
        DataTerceiraEra novaData = new DataTerceiraEra(12,05,2024);
        Dwarf novoAnao = new Dwarf("Meireles",novaData);
        // Act
        //novoAnao.getNumeroSorte();
        assertEquals(101.0,novoAnao.getNumeroSorte(),0.001);
    }
    @Test
    public void dwarfNasceAnoNaoBissextoNomeMeireles(){
        // Arrange
        DataTerceiraEra novaData = new DataTerceiraEra(12,05,2022);
        Dwarf novoAnao = new Dwarf("Meireles",novaData);
        // Act
        //novoAnao.getNumeroSorte();
        assertEquals(33,novoAnao.getNumeroSorte(),0.001);
    }
    @Test
    public void dwarfNasceVivo(){
        Dwarf novoAnao = new Dwarf();
        assertEquals(Status.VIVO,novoAnao.getStatus());
    }
    @Test
    public void dwarfMorre(){
        Dwarf novoAnao = new Dwarf();
        for(int i=0;i<=10;i++)
        novoAnao.perdeVida();
        assertEquals(Status.MORTO,novoAnao.getStatus());
    }
    @Test
    public void dwarfNaoFicaVidaNegativa(){
      Dwarf novoAnao = new Dwarf();
      for(int i=0;i<20;i++)
      novoAnao.perdeVida();
      assertEquals(0,novoAnao.getQuantVida());
    }
    @Test
    public void ElfoMataDwarf(){
      Elfo novoElfo = new Elfo("Jeniffer");
      Dwarf novoAnao = new Dwarf();
      novoElfo.atirarFlecha(novoAnao);
      novoElfo.atirarFlecha(novoAnao);
      novoElfo.atirarFlecha(novoAnao);
      novoElfo.atirarFlecha(novoAnao);
      novoElfo.atirarFlecha(novoAnao);
      novoElfo.atirarFlecha(novoAnao);
      novoElfo.atirarFlecha(novoAnao);
      novoElfo.atirarFlecha(novoAnao);
      novoElfo.atirarFlecha(novoAnao);
      novoElfo.atirarFlecha(novoAnao);
      novoElfo.atirarFlecha(novoAnao);
      assertEquals(0,novoAnao.getQuantVida());
    }
    @Test
    public void dwarfRecebe3Flechadas(){
      Elfo novoElfo = new Elfo("Jeniffer");
      Dwarf novoAnao = new Dwarf();
      novoElfo.atirarFlecha(novoAnao);
      novoElfo.atirarFlecha(novoAnao);
      novoElfo.atirarFlecha(novoAnao);
      assertEquals(80,novoAnao.getQuantVida());
    }
    @Test
    public void dwarfRecebe11Flechadas(){
      Elfo novoElfo = new Elfo("Jeniffer");
      Dwarf novoAnao = new Dwarf();
      novoElfo.atirarFlecha(novoAnao);
      novoElfo.atirarFlecha(novoAnao);
      novoElfo.atirarFlecha(novoAnao);
      novoElfo.atirarFlecha(novoAnao);
      novoElfo.atirarFlecha(novoAnao);
      novoElfo.atirarFlecha(novoAnao);
      novoElfo.atirarFlecha(novoAnao);
      novoElfo.atirarFlecha(novoAnao);
      novoElfo.atirarFlecha(novoAnao);
      novoElfo.atirarFlecha(novoAnao);
      novoElfo.atirarFlecha(novoAnao);
      assertEquals(0,novoAnao.getQuantVida());
    }
    
 }
