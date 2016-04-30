package com.infiniterefactor.src;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by Nigs on 2016-04-30.
 */
public class Game {

    private Board board;

    public Game() {
        Box[][] boxArr = new Box[5][5];
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                boxArr[x][y] = new Box();
            }
        }
        this.board = new Board(boxArr, 0);

    }

    public static void main(String[] args) throws Exception {
        Game game = new Game();

        game.board.move(0, 0, 0, 1);
        game.board.move(0, 0, 2, 1);
        game.board.move(0, 0, 3, 1);

        game.board.move(1, 0, 0, 1);
        game.board.move(1, 0, 1, 1);
        game.board.move(1, 0, 2, 1);

        game.board.move(1, 0, 3, 1);
        game.renderConsole();


    }

    public void renderConsole() {
        for (int x = 0; x < board.getBoxArr().length; x++) {
            for (int y = 0; y < board.getBoxArr()[x].length; y++) {
                Box box = board.getBoxArr()[x][y];
                int code = intFromBooleanArray(new boolean[]{box.isTop(), box.isLeft(), box.isBottom(), box.isRight()});
                System.out.print(code == 15 ? "o:" + board.getBoxArr()[x][y].getOwner() : code);
                System.out.print("\t");
            }
            System.out.println("");
        }
    }

    static int intFromBooleanArray(boolean[] array) {
        return new BigInteger(Arrays.toString(array)
                .replace("true", "1")
                .replace("false", "0")
                .replaceAll("[^01]", ""), 2).intValue();
    }


}
