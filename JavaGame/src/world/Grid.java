package world;

import core.GamePanel;

public class Grid {
    private int col;
    private int row;
    public static final int TILE_SIZE = 90;
    private int[][] map;

    public Grid(){
        this.col = GamePanel.SIZE_WIDTH / TILE_SIZE;
        this.row = GamePanel.SIZE_HEIGHT / TILE_SIZE;
    }
    
    public void initializedMap(){
        map = new int[col][row];
    }

    public boolean getOutOfBounds(int col, int row){
        return col * TILE_SIZE >= GamePanel.SIZE_WIDTH || row * TILE_SIZE >= GamePanel.SIZE_HEIGHT || col * TILE_SIZE < 0 || row * TILE_SIZE < 0;
    }

    public boolean getOutOfBoundsWidth(int col){
        return col * TILE_SIZE >= GamePanel.SIZE_WIDTH || col * TILE_SIZE < 0;
    }

    public boolean getOutOfBoundsHeight(int row){
        return row * TILE_SIZE <= GamePanel.SIZE_HEIGHT && row * TILE_SIZE >= 0;
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
