package com.ldts.steven.model;

import com.ldts.steven.model.game.arena.Arena;
import com.ldts.steven.model.game.elements.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ArenaTest {
    @Test
    void testArenaBasic() {
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
    @Test
    public void testEraseLife() {
        Arena arena = new Arena(15,20);
        Steven stevenMock = mock(Steven.class);
        Life lifeMock = mock(Life.class);
        Position positionToRemove = new Position(1,1);
        List<Life> lifes = new ArrayList<>();
        lifes.add(lifeMock);

        when(stevenMock.getLifes()).thenReturn(2); // Assuming initial lifes count is 2
        when(lifeMock.getPosition()).thenReturn(positionToRemove);
        arena.setLifes(lifes);
        arena.setSteven(stevenMock);

        assertEquals(1, lifes.size());
        arena.eraseLife(positionToRemove);

        assertEquals(0, lifes.size());
}
    @Test
    public void testIsEmpty() {
        Arena arena = new Arena(15,20);

        Wall wallMock = mock(Wall.class);
        BreakableWall breakableWallMock = mock(BreakableWall.class);
        Bomb bombMock = mock(Bomb.class);

        Position emptyPosition = new Position(1,1);
        Position nonEmptyPosition = new Position(1,2);

        List<Wall> walls = new ArrayList<>();
        walls.add(wallMock);

        List<BreakableWall> breakableWalls = new ArrayList<>();
        breakableWalls.add(breakableWallMock);

        List<Bomb> bombs = new ArrayList<>();
        bombs.add(bombMock);

        arena.setWalls(walls);
        arena.setBreakableWalls(breakableWalls);
        arena.setBombs(bombs);

        when(wallMock.getPosition()).thenReturn(nonEmptyPosition);
        when(breakableWallMock.getPosition()).thenReturn(nonEmptyPosition);
        when(bombMock.getPosition()).thenReturn(nonEmptyPosition);
        when(bombMock.hasExploded()).thenReturn(false);

        assertTrue(arena.isEmpty(emptyPosition));
        assertFalse(arena.isEmpty(nonEmptyPosition));
    }
    @Test
    public void testIsMonster() {
        Arena arena = new Arena(15,20);

        Monster monsterMock = mock(Monster.class);

        Position monsterPosition = new Position(1,1);
        Position nonMonsterPosition = new Position(1,2);

        List<Monster> monsters = new ArrayList<>();
        monsters.add(monsterMock);

        arena.setMonsters(monsters);

        when(monsterMock.getPosition()).thenReturn(monsterPosition);

        assertTrue(arena.isMonster(monsterPosition));
        assertFalse(arena.isMonster(nonMonsterPosition));
    }
    @Test
    public void testIsWall() {
        Arena arena = new Arena(15,20);

        Wall wallMock = mock(Wall.class);

        Position wallPosition = new Position(1,1);
        Position nonWallPosition = new Position(1,2);

        List<Wall> walls = new ArrayList<>();
        walls.add(wallMock);

        arena.setWalls(walls);

        when(wallMock.getPosition()).thenReturn(wallPosition);

        assertTrue(arena.isWall(wallPosition));
        assertFalse(arena.isWall(nonWallPosition));
    }
    @Test
    public void testIsLife() {
        Arena arena = new Arena(15, 20);

        Life lifeMock = mock(Life.class);

        Position lifePosition = new Position(1, 1);
        Position nonLifePosition = new Position(1, 2);

        List<Life> lifes = new ArrayList<>();
        lifes.add(lifeMock);

        arena.setLifes(lifes);

        when(lifeMock.getPosition()).thenReturn(lifePosition);

        assertTrue(arena.isLife(lifePosition));
        assertFalse(arena.isLife(nonLifePosition));
    }
    @Test
    public void testIsUpgrade() {
        Arena arena = new Arena(15, 20);

        BombUpgrade bombUpgradeMock = mock(BombUpgrade.class);
        UnlimitedBombs unlimitedBombsMock = mock(UnlimitedBombs.class);

        Position bombUpgradePosition = new Position(1, 1);
        Position unlimitedBombsPosition = new Position(2, 2);
        Position nonUpgradePosition = new Position(3, 3);

        List<BombUpgrade> bombUpgrades = new ArrayList<>();
        bombUpgrades.add(bombUpgradeMock);

        List<UnlimitedBombs> unlimitedBombs = new ArrayList<>();
        unlimitedBombs.add(unlimitedBombsMock);

        arena.setBombUpgrades(bombUpgrades);
        arena.setUnlimitedBombs(unlimitedBombs);

        when(bombUpgradeMock.getPosition()).thenReturn(bombUpgradePosition);
        when(unlimitedBombsMock.getPosition()).thenReturn(unlimitedBombsPosition);

        assertTrue(arena.isBombUpgrade(bombUpgradePosition));
        assertTrue(arena.isUnlimitedBomb(unlimitedBombsPosition));
        assertFalse(arena.isBombUpgrade(nonUpgradePosition));
        assertFalse(arena.isUnlimitedBomb(nonUpgradePosition));
    }
    @Test
    public void testKillMonster() {
        Arena arena = new Arena(15,20);
        Monster monsterMock = mock(Monster.class);
        Position positionToKill = new Position(1,1);
        Position nonKillingPosition = new Position(1,2);
        List<Monster> monsters = new ArrayList<>();
        monsters.add(monsterMock);

        arena.setMonsters(monsters);
        when(monsterMock.getPosition()).thenReturn(positionToKill);
        arena.killMonster(positionToKill);

        assertTrue(arena.getMonsters().isEmpty());

        monsters.add(monsterMock);
        arena.setMonsters(monsters);
        arena.killMonster(nonKillingPosition);

        assertFalse(arena.getMonsters().isEmpty());
    }
    @Test
    public void testAddBomb() {
        Arena arena = new Arena(15,20);
        Bomb bombMock = mock(Bomb.class);
        Wall wallMock = mock(Wall.class);

        Position bombPosition = new Position(1, 1);
        Position wallPosition = new Position(2, 1);

        List<Bomb> bombs = new ArrayList<>();
        List<Wall> walls = new ArrayList<>();

        walls.add(wallMock);

        arena.setBombs(bombs);

        when(wallMock.getPosition()).thenReturn(wallPosition);
        when(bombMock.getPosition()).thenReturn(bombPosition);

        arena.addBomb(bombMock);

        assertEquals(1, arena.getBombs().size());

    }
    @Test
    public void testUnlimitedUp() {
        Arena arena = new Arena(15,20);
        assertFalse(arena.unlimitedUp);

        arena.setUnlimitedUp(true);
        assertTrue(arena.unlimitedUp);
        assertEquals(1000, arena.getMaxBombs());

        arena.checkUnlimitedUp(System.currentTimeMillis() + 10000);
        assertTrue(arena.unlimitedUp);
        assertEquals(1000, arena.getMaxBombs());

        arena.checkUnlimitedUp(System.currentTimeMillis() + 20000);
        assertFalse(arena.unlimitedUp);
        assertEquals(1, arena.getMaxBombs());
    }
}