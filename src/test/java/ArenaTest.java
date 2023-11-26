import com.ldts.steven.model.game.arena.Arena;
import com.ldts.steven.model.game.elements.BreakableWall;
import com.ldts.steven.model.game.elements.Monster;
import com.ldts.steven.model.game.elements.Steven;
import com.ldts.steven.model.game.elements.Wall;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import org.mockito.Mockito;

public class ArenaTest {
    @Test
    void testArenaMethods() {
        // Criando instâncias de objetos mock
        Steven mockSteven = mock(Steven.class);
        List<Monster> mockMonsters = new ArrayList<>();
        List<Wall> mockWalls = new ArrayList<>();
        List<BreakableWall> mockBreakableWalls = new ArrayList<>();

        // Configurando objetos mock conforme necessário

        // Criando uma instância de Arena
        Arena arena = new Arena(10, 10);

        // Configurando a Arena com objetos mock
        arena.setSteven(mockSteven);
        arena.setMonsters(mockMonsters);
        arena.setWalls(mockWalls);
        arena.setBreakableWalls(mockBreakableWalls);

        // Testando métodos de acesso
        assertEquals(10, arena.getWidth());
        assertEquals(10, arena.getHeight());
        assertEquals(mockSteven, arena.getSteven());
        assertEquals(mockMonsters, arena.getMonsters());
        assertEquals(mockWalls, arena.getWalls());
        assertEquals(mockBreakableWalls, arena.getBreakableWalls());

        // Testando métodos de configuração
        arena.setWidth(20);
        arena.setHeight(15);

        assertEquals(20, arena.getWidth());
        assertEquals(15, arena.getHeight());
    }
}
