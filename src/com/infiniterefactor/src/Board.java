package com.infiniterefactor.src;

/**
 * Created by Nigs on 2016-04-30.
 */
public class Board {
    private Box[][] boxArr;
    private int status;

    public Board(Box[][] boxArr, int status) {
        this.boxArr = boxArr;
        this.status = status;
    }

    public void move(int x, int y, int side, int currentPlayer) throws Exception {

        if (boxArr[x][y] == null) {
            // TODO
        }

        if (boxArr[x][y].getSide(side)) {
            throw new Exception("Illegal");
        } else {
            boxArr[x][y].setSide(side, true, currentPlayer);
            switch (side) {
                // top neighbor
                case 0:
                    if (y - 1 >= 0) boxArr[x][y - 1].setSide(2, true, currentPlayer);
                    break;
                // right neighbor
                case 1:
                    if (x + 1 < boxArr.length) boxArr[x + 1][y].setSide(3, true, currentPlayer);
                    break;
                // bottom neighbor
                case 2:
                    if (y + 1 < boxArr[0].length) boxArr[x][y + 1].setSide(0, true, currentPlayer);
                    break;
                // left neighbor
                case 3:
                    if (x - 1 >= 0) boxArr[x - 1][y].setSide(1, true, currentPlayer);
                    break;
            }
        }
    }

    public Box[][] getBoxArr() {
        return boxArr;
    }

    public void setBoxArr(Box[][] boxArr) {
        this.boxArr = boxArr;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
