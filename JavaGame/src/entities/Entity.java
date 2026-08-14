package entities;

import games.snake.Coordinate;
import world.Grid;

public class Entity {
    private int col;
    private int row;

    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
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

    public Coordinate getCoordinate(){
        return new Coordinate(col, row);
    }

    public void setCoordinate(Coordinate coordinate){
        this.col = coordinate.getCol();
        this.row = coordinate.getRow();
    }

}
