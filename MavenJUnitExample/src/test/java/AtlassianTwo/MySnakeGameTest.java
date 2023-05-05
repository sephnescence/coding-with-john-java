package AtlassianTwo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SnakeGameTest {
    @Test
    void testInstantiationAndQuickLoss() {
        MySnakeGame mySnakeGame = new MySnakeGame(100, 100);

        assertEquals(mySnakeGame.boardX, 100);
        assertEquals(mySnakeGame.boardY, 100);

        assertEquals(mySnakeGame.getSnakeHead().getSnakeY(), 0);
        assertEquals(mySnakeGame.getSnakeHead().getSnakeX(), 2);

        SnakePart snakePart = mySnakeGame.getSnakeHead().getBody();
        assertEquals(snakePart.getSnakeY(), 0);
        assertEquals(snakePart.getSnakeX(), 1);

        snakePart = snakePart.next;
        assertEquals(snakePart.getSnakeY(), 0);
        assertEquals(snakePart.getSnakeX(), 0);

        mySnakeGame.moveSnake('U');
        assertTrue(mySnakeGame.isGameOver());

//        List<SnakePart> body = mySnakeGame.getSnakeHead().getBody();
//        SnakePart = body.
//        assertEquals(body);
    }

    @Test
    void testSnakeMoves() {
        MySnakeGame mySnakeGame = new MySnakeGame(100, 100);

        assertEquals(mySnakeGame.boardX, 100);
        assertEquals(mySnakeGame.boardY, 100);

        assertEquals(mySnakeGame.getSnakeHead().getSnakeY(), 0);
        assertEquals(mySnakeGame.getSnakeHead().getSnakeX(), 2);

        SnakePart snakePart = mySnakeGame.getSnakeHead().getBody();

        mySnakeGame.moveSnake('R');
        mySnakeGame.moveSnake('R');
//        mySnakeGame.moveSnake('R');
        mySnakeGame.moveSnake('D');
//        mySnakeGame.moveSnake('L');
        mySnakeGame.moveSnake('L');

//        assertEquals(mySnakeGame.getSnakeHead().getSnakeY(), 1);
//        assertEquals(mySnakeGame.getSnakeHead().getSnakeX(), 3);

        mySnakeGame.moveSnake('U');
        assertTrue(mySnakeGame.isGameOver()); // Should be true
    }
}