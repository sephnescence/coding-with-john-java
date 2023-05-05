package AtlassianTwo;

import java.util.ArrayList;
import java.util.List;

public class Interview {
    // We're trying to do a simplified version of snake
    // The snake can move u, d, l, r, in a 2d board of arbitrary size
    // Try to implement the base logic

    // The snake is called
    // Snake's initial size is 3
    // Every 5th step it grows one bigger
    // Game ends when the snake collides with itself

    // 100 x 100. Snake Head is 0,2, the rest of the body is at 0,1, and 0,0
}

interface SnakeGame {
    void moveSnake(char snakeDirection);
    boolean isGameOver();
}

class MySnakeGame implements SnakeGame {
    int boardY;
    int boardX;

    int movedTimes = 0;

    public SnakeHead getSnakeHead() {
        return snakeHead;
    }

    SnakeHead snakeHead;

    public MySnakeGame(int boardY, int boardX) {
        this.boardY = boardY;
        this.boardX = boardX;

        this.snakeHead = new SnakeHead();
    }

    @Override
    public void moveSnake(char snakeDirection) {
        int oldY = this.snakeHead.snakeY;
        int oldX = this.snakeHead.snakeX;

        if (snakeDirection == 'U') {
            this.snakeHead.snakeY--;
        } else if (snakeDirection == 'R') {
            this.snakeHead.snakeX++;
        } else if (snakeDirection == 'D') {
            this.snakeHead.snakeY++;
        } else if (snakeDirection == 'L') {
            this.snakeHead.snakeX--;
        }

        if (++movedTimes % 5 == 0) {
            SnakePart newPart = new SnakePart(oldY,oldX);
            newPart.next = this.snakeHead.firstPart;
            this.snakeHead.firstPart = newPart;

            System.out.println("Grown!");

            return;
        }

        SnakePart snakePart = snakeHead.getBody();
        while (snakePart != null) {
            int tempY = snakePart.snakeY;
            int tempX = snakePart.snakeX;

            snakePart.snakeY = oldY;
            snakePart.snakeX = oldX;

            oldY = tempY;
            oldX = tempX;

            snakePart = snakePart.next;
        }

        // If it's moved out of bounds
        // x < boardx then x = boardX
        // x < boardx then snake head boardx = 1
        // y > boardx then snake head boardx = 1

        // if it's moved five times we'll make it bigger
    }

    @Override
    public boolean isGameOver() {
        if (snakeHead.snakeX < 0 || snakeHead.snakeX > this.boardX || this.snakeHead.snakeY < 0 || this.snakeHead.snakeY > this.boardY) {
            return true;
        }

        SnakePart snakePart = snakeHead.firstPart;
        while (snakePart != null) {
            if (snakePart.getSnakeY() == snakeHead.snakeY && snakePart.getSnakeX() == snakeHead.snakeX) {
                return true;
            }

            snakePart = snakePart.next;
        }

        return false;
    }
}

class SnakeHead {
    int snakeY = 0;
    int snakeX = 2;

    SnakePart firstPart;

    public SnakeHead() {
        SnakePart secondPart = new SnakePart(0,0);
        this.firstPart = new SnakePart(0,1);
        this.firstPart.next = secondPart;
    }

    public int getSnakeY() {
        return snakeY;
    }

    public int getSnakeX() {
        return snakeX;
    }
    public SnakePart getBody() {
        return firstPart;
    }
}

class SnakePart {
    int snakeY;
    int snakeX;

    SnakePart next;

    public SnakePart(int snakeY, int snakeX) {
        this.snakeY = snakeY;
        this.snakeX = snakeX;
    }

    public int getSnakeY() {
        return snakeY;
    }

    public int getSnakeX() {
        return snakeX;
    }
}

