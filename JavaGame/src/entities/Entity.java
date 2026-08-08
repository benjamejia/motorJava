package entities;

import world.Grid;

public class Entity {
    private int col;
    private int row;

    private float x;
    private float y;

    public float getX() {
        return x * col;
    }

    public void setX() {
        this.x = col * Grid.TILE_SIZE;
    }

    public float getY() {
        return row * y;
    }

    public void setY() {
        this.y = row * Grid.TILE_SIZE;
    }

    public int getCol(){
        return col;
    }

    public int getRow(){
        return row;
    }

    public void setCol(int col){
        this.col = col;
    }

    public void setRow(int row){
        this.row = row;
    }
}
