

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemTest
{
 @Test
 public void itemNasceDescricao(){
        // Arrange
        String nomeEsperado = "Flecha";
        // Act
        Item flecha = new Item(nomeEsperado,1);
        // Assert
        assertEquals(nomeEsperado, flecha.getDescricao());
    }
 @Test
 public void itemNasceQuant(){
        // Arrange
        int quantEsperada = 1;
        // Act
        Item flecha = new Item("Flecha",1);
        // Assert
        assertEquals(quantEsperada, flecha.getQuantidade());
    }
 
}
