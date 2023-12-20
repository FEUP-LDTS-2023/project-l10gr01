package com.ldts.steven.model;

import com.ldts.steven.model.game.elements.NormalBomb;
import com.ldts.steven.model.game.elements.UpgradedBomb;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BombTest {

    @Test
    public void testBombInitialization() {
        // Normal Bomb
        NormalBomb normalBomb = new NormalBomb(1, 2);
        assertNotNull(normalBomb);
        assertEquals(1, normalBomb.getPosition().getX());
        assertEquals(2, normalBomb.getPosition().getY());
        assertFalse(normalBomb.hasExploded());
        assertFalse(normalBomb.getDisappear());
        assertEquals(2, normalBomb.getExplosionRadius());
        assertNotNull(normalBomb.getCanBombExplode());
        assertTrue(normalBomb.getCanBombExplode().isEmpty());

        // Upgraded Bomb
        UpgradedBomb upgradedBomb = new UpgradedBomb(3, 4);
        assertNotNull(upgradedBomb);
        assertEquals(3, upgradedBomb.getPosition().getX());
        assertEquals(4, upgradedBomb.getPosition().getY());
        assertFalse(upgradedBomb.hasExploded());
        assertFalse(upgradedBomb.getDisappear());
        assertEquals(5, upgradedBomb.getExplosionRadius());
        assertNotNull(upgradedBomb.getCanBombExplode());
        assertTrue(upgradedBomb.getCanBombExplode().isEmpty());
    }

    @Test
    public void testBombExplode() {
        // Normal Bomb
        NormalBomb normalBomb = new NormalBomb(1, 2);
        normalBomb.explode();
        assertTrue(normalBomb.hasExploded());

        // Upgraded Bomb
        UpgradedBomb upgradedBomb = new UpgradedBomb(3, 4);
        upgradedBomb.explode();
        assertTrue(upgradedBomb.hasExploded());
    }

    @Test
    public void testBombDisappear() {
        // Normal Bomb
        NormalBomb normalBomb = new NormalBomb(1, 2);
        normalBomb.disappear();
        assertTrue(normalBomb.getDisappear());

        // Upgraded Bomb
        UpgradedBomb upgradedBomb = new UpgradedBomb(3, 4);
        upgradedBomb.disappear();
        assertTrue(upgradedBomb.getDisappear());
    }

    @Test
    public void testBombAddCanBombExplode() {
        // Normal Bomb
        NormalBomb normalBomb = new NormalBomb(1, 2);
        Position normalPosition = new Position(3, 4);
        normalBomb.addCanBombExplode(normalPosition);
        assertTrue(normalBomb.getCanBombExplode().contains(normalPosition));

        // Upgraded Bomb
        UpgradedBomb upgradedBomb = new UpgradedBomb(5, 6);
        Position upgradedPosition = new Position(7, 8);
        upgradedBomb.addCanBombExplode(upgradedPosition);
        assertTrue(upgradedBomb.getCanBombExplode().contains(upgradedPosition));
    }

    @Test
    public void testBombGetCanBombExplode() {
        // Normal Bomb
        NormalBomb normalBomb = new NormalBomb(1, 2);
        assertNotNull(normalBomb.getCanBombExplode());

        // Upgraded Bomb
        UpgradedBomb upgradedBomb = new UpgradedBomb(3, 4);
        assertNotNull(upgradedBomb.getCanBombExplode());
    }

    // Add more tests as needed
}
