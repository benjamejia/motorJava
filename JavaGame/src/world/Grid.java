package world;

public class Grid {
    private final int sizeWidth;
    private final int sizeHeight;
    private int col;
    private int row;
    private int tileSize;
    private int[][] map;

    public Grid(int sizeWidth, int sizeHeight, int tileSize){
        this.sizeWidth = sizeWidth;
        this.sizeHeight = sizeHeight;
        this.col = sizeWidth / tileSize;
        this.row = sizeHeight / tileSize;
        
        this.tileSize = tileSize;
    }
    
    public void initializedMap(){
        map = new int[col][row];
    }

    public boolean getOutOfBoundsWidth(int col){
        if(col * getTileSize() >= sizeWidth || col * getTileSize() < 0){
            return true;
        }
        return false;
    }

    public boolean getOutOfBoundsHeight(int row){
        if(row * getTileSize() >= sizeHeight || row * getTileSize() < 0){
            return true;
        }
        return false;
    }

    public int[][] getMap(){
        return map;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getTileSize() {
        return tileSize;
    }

    public void setTileSize(int tileSize) {
        this.tileSize = tileSize;
    }

    

}
