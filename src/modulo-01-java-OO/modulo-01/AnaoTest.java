import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AnaoTest
{
    @Test
    public void AnaoNasceComQuantVidas(){
        // Arrange
        Anao novoAnao = new Anao("Teste");
        // Act
        novoAnao.getQuantVida();
        // Assert
        assertEquals(110,novoAnao.getQuantVida());
    }
}
