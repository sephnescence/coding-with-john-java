package SnakeForFun;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SnakeForFunTest {
    private SnakeGame snaaaake;
    @Test
    void testScenario1() {
        // [[3,2,[[1,2],[0,1]]],["R"],["D"],["R"],["U"],["L"],["U"]]
        snaaaake = new SnakeGame(3, 2, new int[][] {{1,2}, {0,1}});

        moveHelper("R", 0, 0, 1); // moved to an empty space
        moveHelper("D", 0, 1, 1); // moved to an empty space
        moveHelper("R", 1, 1, 2); // ate some food
        moveHelper("U", 1, 0, 2); // moved to an empty space
        moveHelper("L", 2, 0, 1); // ate some food
        moveHelper("U", -1, -1, 1); // bonk
    }

    @Test
    void testScenario2() {
        // [[2,1,[[0,1]]],["R"],["R"]]
        snaaaake = new SnakeGame(2, 1, new int[][] {{0,1}});

        moveHelper("R", 1, 0, 1); // ate some food
        moveHelper("R", -1, 0, 2); // slithered straight out of bounds

        // My initial draft of the code went on to check food out of bounds. So there was a bug in the out of bounds check
        // if (snakeY < 0 || snakeY > grid.length || snakeX < 0 || snakeX > grid[0].length) {
        // When comparing to the length, I needed to check = as well. Good catch, test!
    }

    @Test
    void testScenario3() {
        // [[2,2,[[0,1]]],["R"],["D"]]
        snaaaake = new SnakeGame(2, 2, new int[][] {{0,1}});

        moveHelper("R", 1, 0, 1); // ate some food
        moveHelper("D", 1, 1, 1); // moved to an empty space
    }

    @Test
    void testScenario4() {
        // [[3,3,[[2,0],[0,0],[0,2],[0,1],[2,2],[0,1]]],["D"],["D"],["R"],["U"],["U"],["L"],["D"],["R"],["R"],["U"],["L"],["L"],["D"],["R"],["U"]]
        snaaaake = new SnakeGame(3, 3, new int[][] {{2,0}, {0,0}, {0,2}, {0,1}, {2,2}, {0,1}});

        moveHelper("D", 0, 1, 0); // moved to an empty space
        moveHelper("D", 1, 2, 0); // ate some food
        moveHelper("R", 1, 2, 1); // moved to an empty space
        moveHelper("U", 1, 1, 1); // moved to an empty space
        moveHelper("U", 1, 0, 1); // moved to an empty space
        moveHelper("L", 2, 0, 0); // ate some food
        moveHelper("D", 2, 1, 0); // moved to an empty space
        moveHelper("R", 2, 1, 1); // moved to an empty space
        moveHelper("R", 2, 1, 2); // moved to an empty space
        moveHelper("U", 3, 0, 2); // ate some food
        moveHelper("L", 4, 0, 1); // ate some food
        moveHelper("L", 4, 0, 0); // moved to an empty space
        moveHelper("D", 4, 1, 0); // moved to an empty space
        moveHelper("R", 4, 1, 1); // moved to an empty space
        moveHelper("U", -1, 0, 1); // it ate itself. Game over

        // This test failed earlier because the final move evidently should have run into itself and returned -1
        // It turned out to be a bug with not setting an occupied space to 1, so it didn't detect a collision
    }

    void moveHelper(String direction, int expectedMoveReturn, int expectedSnakeY, int expectedSnakeX) {
        assertEquals(snaaaake.move(direction), expectedMoveReturn);
        assertEquals(snaaaake.snakeHead.snakeY, expectedSnakeY);
        assertEquals(snaaaake.snakeHead.snakeX, expectedSnakeX);
    }
}