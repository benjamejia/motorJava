package entities;

public class Entity {
    private int col;
    private int row;

    private float x;
    private float y;

    public float getX() {
        return x * col;
    }

    public void setX(float x) {
        this.x = x;

    }

    public float getY() {
        return row * y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Entity(){
        col = 0;
        row = 0;
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
