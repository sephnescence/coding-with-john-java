package SnakeForFun;

import java.util.Objects;

class SnakeGame {
    public SnakeHead snakeHead;

    // I had thought of whether I should have an array of straight snake parts that would auto remove
    // themselves from existence if there were no snake parts left, but I don't think that's good
    // Instead, we could just use a linked list of body parts or something
    // The body parts just follow the head, and move to where the head was, then the previous body part ... to infinity

    public SnakeGame(int width, int height, int[][] food) {
        snakeHead = new SnakeHead(width, height, food);
    }

    public int move(String direction) {
        return snakeHead.move(direction);
    }

    class SnakeHead {
        public int gridY = 0;
        public int gridX = 0;
        public int foodPosition = 0;
        public int[][] food; // Use to determine if snake length will increment
        public int snakeLength = 0; // In this example, it's a count of how many pieces of food have been eaten
        public int snakeX = 0;
        public int snakeY = 0;
        public SnakeBodyPart next = null;

        public SnakeHead(int width, int height, int[][] food) {
            this.gridY = height;
            this.gridX = width;
            this.food = food;
        }

        public int move(String direction) {
            // Make note of where the head was
            int headYBeforeMove = snakeY;
            int headXBeforeMove = snakeX;

            // Move the head. Moving the rest of the body might come later
            if (Objects.equals(direction, "U")) {
                snakeY -= 1;
            } else if (Objects.equals(direction, "R")) {
                snakeX += 1;
            } else if (Objects.equals(direction, "D")) {
                snakeY += 1;
            } else if (Objects.equals(direction, "L")) {
                snakeX -= 1;
            }

            // If the head is now out of bounds, return -1
            if (snakeY < 0 || snakeY >= gridY || snakeX < 0 || snakeX >= gridX) {
                return -1;
            }

            // If it ate food, make a new SnakeBodyPart
            if (foodPosition < food.length && food[foodPosition][0] == snakeY && food[foodPosition][1] == snakeX) {
                // set its next to where the head was this.snakeY, this.snakeX
                SnakeBodyPart nextChunk = new SnakeBodyPart(headYBeforeMove, headXBeforeMove);
                nextChunk.next = this.next;
                this.next = nextChunk;

                foodPosition++; // It seems that there won't always be food left before the game ends

                // It cannot collide with itself at this point
                return ++snakeLength;
            }

            if (this.next == null) {
                return snakeLength;
            }

            SnakeBodyPart n = this.next;
            while (n != null) {
                int tempY = n.snakeY;
                int tempX = n.snakeX;
                n.snakeY = headYBeforeMove;
                n.snakeX = headXBeforeMove;
                headYBeforeMove = tempY;
                headXBeforeMove = tempX;
                if (n.snakeY == this.snakeY && n.snakeX == this.snakeX) {
                    return -1;
                }
                n = n.next;
            }

            return snakeLength;
        }
    }

    class SnakeBodyPart { // Literally have no knowledge where the head went. They just dumbly plod along
        int snakeY = 0;
        int snakeX = 0;
        public SnakeBodyPart next = null;

        SnakeBodyPart(int snakeY, int snakeX) {
            this.snakeY = snakeY;
            this.snakeX = snakeX;
        }
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */