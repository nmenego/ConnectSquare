package com.infiniterefactor.src;

/**
 * Created by Nigs on 2016-04-30.
 */
public class Box {
    private int owner;
    private boolean right;
    private boolean left;
    private boolean top;
    private boolean bottom;

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isTop() {
        return top;
    }

    public void setTop(boolean top) {
        this.top = top;
    }

    public boolean isBottom() {
        return bottom;
    }

    public void setBottom(boolean bottom) {
        this.bottom = bottom;
    }

    public boolean getSide(int side) throws Exception {
        switch (side) {
            case 0:
                return top;
            case 1:
                return right;
            case 2:
                return bottom;
            case 3:
                return left;
            default:
                throw new Exception("");
        }
    }

    public void setSide(int side, boolean b, int player) {
        switch (side) {
            case 0:
                top = b;
                break;
            case 1:
                right = b;
                break;
            case 2:
                bottom = b;
                break;
            case 3:
                left = b;
                break;
        }

        // check if complete.
        if(top & bottom & left & right) {
            owner = player;
        }
    }
}
