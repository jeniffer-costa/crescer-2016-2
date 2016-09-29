

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CestoDeLembasTest
{
   @Test
   public void TestaPodeDividirCestoComQuatroPaes(){
       // Arrange
       CestoDeLembas quatro = new CestoDeLembas(4);
       // Act
       quatro.podeDividirEmPares();
       // Assert
       assertEquals(true, quatro.podeDividirEmPares());
    }
    @Test
    public void TestaPodeDividirCestoComNovePaes(){
       // Arrange
       CestoDeLembas nove = new CestoDeLembas(9);
       // Act
       nove.podeDividirEmPares();
       // Assert
       assertEquals(false, nove.podeDividirEmPares());
    }
    @Test
    public void TestaPodeDividirCestoComUmPao(){
       // Arrange
       CestoDeLembas um = new CestoDeLembas(1);
       // Act e Assert
       assertEquals(false, um.podeDividirEmPares());
    }
    @Test
    public void TestaPodeDividirCestoComCentoUmPao(){
       // Arrange
       CestoDeLembas CentoUm = new CestoDeLembas(101);
       // Act e Assert
       assertEquals(false, CentoUm.podeDividirEmPares());
    }
    
}
