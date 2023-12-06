package controllerTest;
import com.ldts.steven.Game;
import com.ldts.steven.controller.menu.MenuController;
import com.ldts.steven.gui.GUI;
import com.ldts.steven.model.menu.Menu;
import com.ldts.steven.states.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;
public class MenuControllerTest {
    private MenuController menuController;
    private Menu menu;
    private Game game;

    @BeforeEach
    void setUp() {
        menu = mock(Menu.class);
        game = mock(Game.class);
        menuController = new MenuController(menu);
    }

    @Test
    void testStepUp() throws IOException {
        menuController.step(game, GUI.ACTION.UP, 100L);
        verify(menu, times(1)).previousEntry();
    }

    @Test
    void testStepDown() throws IOException {
        menuController.step(game, GUI.ACTION.DOWN, 100L);
        verify(menu, times(1)).nextEntry();
    }
    @Test
    public void testStepSelectStart() throws IOException {
        menuController.step(game, GUI.ACTION.SELECT, 0);
        verify(menu, times(1)).isSelectedStart();
    }
    @Test
    public void testStepSelectExit() throws IOException {
        menuController.step(game, GUI.ACTION.SELECT, 0);
        verify(menu, times(1)).isSelectedExit();
    }

}

