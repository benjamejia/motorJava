package world;

import core.GamePanel;

public class Grid {
    private final int col;
    private final int row;
    public static final int TILE_SIZE = 90;
    private Object[][] map;

    public Grid(){
        this.col = GamePanel.SIZE_WIDTH / TILE_SIZE;
        this.row = GamePanel.SIZE_HEIGHT / TILE_SIZE;
    }
    
    public void initializedMap(Object o){
        map = new Object[col][row];
    }

    public void addObject(Object o, Coordinate coords){
        if (emptyField(coords)) return;

        map[coords.getCol()][coords.getRow()] = o;
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

    public Object getObject(Coordinate coords){
        return map[coords.getCol()][coords.getRow()];
    }

    public boolean emptyField(Coordinate coords){
        return map[coords.getCol()][coords.getRow()] != null;
    }

    public Object[][] getMap(){
        return map;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
}
