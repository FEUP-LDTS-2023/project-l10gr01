package controllerTest;

import com.ldts.steven.Game;
import com.ldts.steven.controller.game.MonsterController;
import com.ldts.steven.gui.GUI;
import com.ldts.steven.model.Position;
import com.ldts.steven.model.game.arena.Arena;
import com.ldts.steven.model.game.elements.Monster;
import com.ldts.steven.model.game.elements.Steven;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class MonsterControllerTest {
    private Arena arenaMock;
    private MonsterController monsterController;
    @BeforeEach
    public void setUp() {
        arenaMock = mock(Arena.class);
        monsterController = new MonsterController(arenaMock);
    }

    @Test
    public void MoveMonsterTest() {
        Monster monsterMock = mock(Monster.class);
        Position currentPosition = new Position(1, 1);
        Position newPosition = new Position(2, 1);

        when(monsterMock.getPosition()).thenReturn(currentPosition);
        when(arenaMock.getSteven()).thenReturn(mock(Steven.class));
        when(arenaMock.getSteven().getPosition()).thenReturn(newPosition);
        when(arenaMock.isEmpty(newPosition)).thenReturn(true);


        monsterController.moveMonster(monsterMock, newPosition);

        verify(monsterMock).setPosition(newPosition);
        verify(arenaMock.getSteven()).getPosition();
        verify(arenaMock).isEmpty(newPosition);

}}
