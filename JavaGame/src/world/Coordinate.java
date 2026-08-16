package world;

public class Coordinate {
    private int col;
    private int row;

    public Coordinate(int col,int row){
        this.col = col;
        this.row = row;
    }

    public static Coordinate[] fromArray(int[][] path){
        Coordinate[] result = new Coordinate[path.length];

        for(int i = 0; i < path.length; i++){
            result[i] = new Coordinate(path[i][0], path[i][1]);
        }

        return result;
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
