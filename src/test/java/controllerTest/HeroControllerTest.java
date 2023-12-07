package controllerTest;

import com.ldts.steven.Game;
import com.ldts.steven.controller.game.BombController;
import com.ldts.steven.controller.game.HeroController;
import com.ldts.steven.gui.GUI;
import com.ldts.steven.model.Position;
import com.ldts.steven.model.game.arena.Arena;
import com.ldts.steven.model.game.elements.Steven;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class HeroControllerTest {
    private Arena arenaMock;
    private BombController bombControllerMock;
    private HeroController heroController;
    @BeforeEach
    public void setup() {
        arenaMock = mock(Arena.class);
        bombControllerMock = mock(BombController.class);
        heroController = new HeroController(arenaMock, bombControllerMock);

    }
    @Test
    public void moverHeroUpTest() {
        GUI.ACTION action = GUI.ACTION.UP;

        Game gameMock = mock(Game.class);

        Position heroPosition = new Position(5, 5);

        when(arenaMock.isEmpty(heroPosition.getUp())).thenReturn(true);

        Steven heroMock = mock(Steven.class);
        when(heroMock.getPosition()).thenReturn(heroPosition);
        when(arenaMock.getSteven()).thenReturn(heroMock);

        heroController.step(gameMock, action, 0);

        verify(heroMock).setPosition(heroPosition.getUp());
        verify(bombControllerMock, never()).plantBomb(any(), anyInt());
        verify(gameMock, never()).setState(null);
    }

    @Test
    public void moveHeroDownTest() {
        GUI.ACTION action = GUI.ACTION.DOWN;

        Game gameMock = mock(Game.class);

        Position heroPosition = new Position(6, 5);

        when(arenaMock.isEmpty(heroPosition.getDown())).thenReturn(true);

        Steven heroMock = mock(Steven.class);
        when(heroMock.getPosition()).thenReturn(heroPosition);
        when(arenaMock.getSteven()).thenReturn(heroMock);

        heroController.step(gameMock, action, 0);

        verify(heroMock).setPosition(heroPosition.getDown());
        verify(bombControllerMock, never()).plantBomb(any(), anyInt());
        verify(gameMock, never()).setState(null);
    }

    @Test
    public void moveHeroLeftTest() {
        GUI.ACTION action = GUI.ACTION.LEFT;

        Game gameMock = mock(Game.class);

        Position heroPosition = new Position(10, 10);

        when(arenaMock.isEmpty(heroPosition.getLeft())).thenReturn(true);

        Steven heroMock = mock(Steven.class);
        when(heroMock.getPosition()).thenReturn(heroPosition);
        when(arenaMock.getSteven()).thenReturn(heroMock);

        heroController.step(gameMock, action, 0);

        verify(heroMock).setPosition(heroPosition.getLeft());
        verify(bombControllerMock, never()).plantBomb(any(), anyInt());
        verify(gameMock, never()).setState(null);
    }
    @Test
    public void moveHeroRightTest() {
        GUI.ACTION action = GUI.ACTION.RIGHT;

        Game gameMock = mock(Game.class);

        Position heroPosition = new Position(11, 11);

        when(arenaMock.isEmpty(heroPosition.getRight())).thenReturn(true);

        Steven heroMock = mock(Steven.class);
        when(heroMock.getPosition()).thenReturn(heroPosition);
        when(arenaMock.getSteven()).thenReturn(heroMock);

        heroController.step(gameMock, action, 0);

        verify(heroMock).setPosition(heroPosition.getRight());
        verify(bombControllerMock, never()).plantBomb(any(), anyInt());
        verify(gameMock, never()).setState(null);
    }
    @Test
    public void heroDropsBombTest() {
        GUI.ACTION action = GUI.ACTION.SPACE;

        Game gameMock = mock(Game.class);

        Position stevenPosition = new Position(1, 2);

        when(arenaMock.isEmpty(stevenPosition)).thenReturn(true);

        Steven stevenMock = mock(Steven.class);
        when(stevenMock.getPosition()).thenReturn(stevenPosition);
        when(arenaMock.getSteven()).thenReturn(stevenMock);

        when(arenaMock.getUpgrade()).thenReturn(true);

        heroController.step(gameMock, action, 0);

        verify(stevenMock, never()).setPosition(any());
        verify(bombControllerMock).plantBomb(stevenPosition, 5);
        verify(gameMock, never()).setState(null);
    }
    @Test
    public void moveHeroUpBombUpgradeCollisionTest() {
        GUI.ACTION action = GUI.ACTION.UP;

        Game gameMock = mock(Game.class);

        Position heroPosition = new Position(5, 5);

        when(arenaMock.isEmpty(heroPosition.getUp())).thenReturn(true);
        when(arenaMock.isBombUpgrade(heroPosition.getUp())).thenReturn(true);

        Steven heroMock = mock(Steven.class);
        when(heroMock.getPosition()).thenReturn(heroPosition);
        when(arenaMock.getSteven()).thenReturn(heroMock);

        heroController.step(gameMock, action, 0);

        verify(heroMock).setPosition(heroPosition.getUp());
        verify(arenaMock).setUpgrade(true);
        verify(arenaMock).removeBombUpgrade(heroPosition.getUp());
        verify(gameMock, never()).setState(null);
    }
}
