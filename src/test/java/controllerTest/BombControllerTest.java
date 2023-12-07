package controllerTest;

import com.ldts.steven.Game;
import com.ldts.steven.controller.game.BombController;
import com.ldts.steven.gui.GUI;
import com.ldts.steven.model.Position;
import com.ldts.steven.model.game.arena.Arena;
import com.ldts.steven.model.game.elements.Bomb;
import com.ldts.steven.model.game.elements.BreakableWall;
import com.ldts.steven.model.game.elements.Steven;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class BombControllerTest {
    private Arena arenaMock;
    private BombController bombController;
    private Bomb bombMock;
    private BreakableWall breakableWallMock;
    private Steven stevenMock;
    private Game gameMock;
    private List<Bomb> bombs;
    private List<BreakableWall> breakableWalls;

    @BeforeEach
    void setUp() {
        arenaMock = mock(Arena.class);
        bombController = new BombController(arenaMock);
        bombMock = mock(Bomb.class);
        gameMock = mock(Game.class);
        breakableWallMock = mock(BreakableWall.class);
        stevenMock = mock(Steven.class);
        bombs = new ArrayList<>();
        breakableWalls = new ArrayList<>();

        when(arenaMock.getSteven()).thenReturn(stevenMock);
    }

    @Test
    void PlantBombTest() {
        Position position = new Position(5, 5);

        bombController.plantBomb(position, 3);

        verify(arenaMock).addBomb(argThat(bomb -> bomb.getPosition().equals(position) && bomb.getExplosionRadius() == 3));
    }
}


