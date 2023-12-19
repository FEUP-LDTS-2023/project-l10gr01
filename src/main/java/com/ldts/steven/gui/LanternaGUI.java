package com.ldts.steven.gui;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.ldts.steven.model.Position;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;


import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;

public class LanternaGUI implements GUI {
    private final Screen screen;

    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);

    }
    private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/PixelCode.otf");
        File fontFile = new File(Objects.requireNonNull(resource).toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 25);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }
    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height + 1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }
    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        screen.refresh();

        return screen;
    }

    @Override
    public void drawHero(Position position, String color) {
        drawCharacter(position.getX(), position.getY(), 'S', color);
    }

    @Override
    public void drawWall(Position position) {
        {
            drawCharacter(position.getX(), position.getY(), '#', "#F474BF");
        }
    }
    @Override
    public void drawBreakableWall(Position position) {
        {
            drawCharacter(position.getX(), position.getY(), '#', "#6F2DA8");
        }
    }

    @Override
    public void drawLife(Position position){
        {
            drawCharacter(position.getX(), position.getY(), '@',"#E6D4A2");
        }
    }
    public void drawBomb(Position position){
        drawCharacter(position.getX(), position.getY(), 'B',"#F89820");
    }
    public void drawBombExploded(Position position){
        int x = position.getX();
        int y = position.getY();

        drawCharacter(x, y,'*', "#FF0000");

    }

    public void drawBombUpgrade(Position position){
        int x = position.getX();
        int y = position.getY();

        drawCharacter(x, y, 'X', "#FF6700");

    }

    @Override
    public void drawUnlimitedBomb(Position position) {
        int x = position.getX();
        int y = position.getY();

        drawCharacter(x, y, 'U', "#1FC1DB");
    }

    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }


    @Override
    public void drawNormalMonster(Position position) {
        drawCharacter(position.getX(), position.getY(), 'M', "#90FF5D");
    }
    public void drawFollowerMonster(Position position){
        drawCharacter(position.getX(), position.getY(), 'M', "#021EAA");
    }

    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;

        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return ACTION.QUIT;

        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;
        if(keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == ' ') return ACTION.SPACE;
        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;

        return ACTION.NONE;
    }


    private void drawCharacter(int x, int y, char c, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(x, y + 1, "" + c);
    }
    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }
}
