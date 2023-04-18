package SnakeForFun;

import java.util.Objects;

public class SnakeForFun {
    public static void main(String[] args) {
        SnakeGame snaaaake = new SnakeGame(3, 2, new int[][] {{1,2}, {0,1}});
        snaaaake.move("R"); // return 0
        snaaaake.move("D"); // return 0
        snaaaake.move("R"); // return 1 after eating food
        snaaaake.move("U"); // return 1
        snaaaake.move("L"); // return 2 after eating food
        snaaaake.move("U"); // return -1 after snake hits its head on the roof
    }
}