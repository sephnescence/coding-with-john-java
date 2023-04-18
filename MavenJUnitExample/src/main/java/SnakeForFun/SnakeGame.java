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
        public int[][] grid; // Used for calculating snake body parts overlapping
        public int foodPosition = 0;
        public int[][] food; // Use to determine if snake length will increment
        public int snakeLength = 0; // In this example, it's a count of how many pieces of food have been eaten
        public int snakeX = 0;
        public int snakeY = 0;
        public SnakeBodyPart next = null;

        public SnakeHead(int width, int height, int[][] food) {
            this.grid = new int[height][width]; // Not sure if it's generally more common to go with width or height
            // I've just found that it's easier to deal with rows in their entirety
            // The illustration on the left would assume [height][width] as well
            this.food = food;

            // grid[snakeY][snakeX] = 1; // Meaning snake body part. I don't know if it can move backwards, but doubling back is still death

            // for (int foodY = 0; foodY < food.length; foodY++) {
            //     for (int foodX = 0; foodX < food[foodY].length; foodX++) {
            //         grid[snakeY][snakeX] = 2; // Meaning food
            //     }
            // }
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
            if (snakeY < 0 || snakeY >= grid.length || snakeX < 0 || snakeX >= grid[0].length) {
                return -1;
            }

            // If it ate food, make a new SnakeBodyPart
            if (foodPosition < food.length && food[foodPosition][0] == snakeY && food[foodPosition][1] == snakeX) {
                // set its next to where the head was this.snakeY, this.snakeX
                SnakeBodyPart nextChunk = new SnakeBodyPart(headYBeforeMove, headXBeforeMove, this);
                nextChunk.next = this.next;
                this.next = nextChunk;

                foodPosition++; // It seems that there won't always be food left before the game ends

                // It cannot collide with itself at this point
                return ++snakeLength;
            }

            if (this.next == null) {
                return snakeLength;
            }

            next.move(headYBeforeMove, headXBeforeMove); // Recursive call to move all the body parts

            if (grid[this.snakeY][this.snakeX] == 1) {
                return -1;
            }

            grid[this.snakeY][this.snakeX] = 1;

            return snakeLength;
        }
    }

    class SnakeBodyPart { // Literally have no knowledge that the head went. They just dumbly plod along
        int snakeY = 0;
        int snakeX = 0;
        SnakeBodyPart next = null;
        SnakeHead parent = null;

        SnakeBodyPart(int snakeY, int snakeX, SnakeHead parent) {
            this.snakeY = snakeY;
            this.snakeX = snakeX;
            this.parent = parent;
            parent.grid[this.snakeY][this.snakeX] = 1;
        }
        void move(int snakeY, int snakeX) { // Recurse until next is null
            if (next != null) {
                next.move(this.snakeY, this.snakeX);
            } else {
                parent.grid[this.snakeY][this.snakeX] = 0;
            }
            this.snakeY = snakeY;
            this.snakeX = snakeX;
            parent.grid[this.snakeY][this.snakeX] = 1;
        }
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */