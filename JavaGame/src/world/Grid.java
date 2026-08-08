package world;

public class Grid {
    private final int sizeWidth;
    private final int sizeHeight;
    private int col;
    private int row;
    public static final int TILE_SIZE = 20;
    private int[][] map;

    public Grid(int sizeWidth, int sizeHeight){
        this.sizeWidth = sizeWidth;
        this.sizeHeight = sizeHeight;
        this.col = sizeWidth / TILE_SIZE;
        this.row = sizeHeight / TILE_SIZE;
    }
    
    public void initializedMap(){
        map = new int[col][row];
    }

    public boolean getOutOfBoundsWidth(int col){
        return col * TILE_SIZE >= sizeWidth || col * TILE_SIZE < 0;
    }

    public boolean getOutOfBoundsHeight(int row){
        return row * TILE_SIZE <= sizeHeight && row * TILE_SIZE >= 0;
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
}
