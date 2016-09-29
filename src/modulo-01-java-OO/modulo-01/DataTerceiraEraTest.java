

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataTerceiraEraTest
{
  @Test
  public void TestaAnoBissexto(){
        //Arrange
        DataTerceiraEra novaData = new DataTerceiraEra(3,11,2016);
        // Act
        novaData.ehBissexto();
        // Assert
        assertEquals(true,novaData.ehBissexto());
    }
  @Test
  public void TestaAnoNaoBissexto(){
        //Arrange
        DataTerceiraEra novaData = new DataTerceiraEra(22,5,2015);
        // Act
        novaData.ehBissexto();
        // Assert
        assertEquals(false,novaData.ehBissexto());
    }
}
