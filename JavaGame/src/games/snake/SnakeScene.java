package games.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Random;

import core.KeyHandler;
import scenes.GameOverScene;
import scenes.Scene;
import scenes.SceneManager;
import world.Grid;

public class SnakeScene extends Scene{

    Random random = new Random();

    private SceneManager sceneManager;
    private KeyHandler keyHandler;
    private Grid grid;
    private final int sizeWidth;
    private final int sizeHeight;
    private final int tileSize = 30;

    Snake snake;
    Fruit fruit;

    private boolean gameOver = false;

    public SnakeScene(SceneManager sm, KeyHandler kh, int sizeWidth, int sizeHeight){
        this.sceneManager = sm;
        this.keyHandler = kh;
        this.sizeWidth = sizeWidth;
        this.sizeHeight = sizeHeight;
        grid = new Grid(sizeWidth, sizeHeight, tileSize);
    }

    @Override
    public void init() {
        Coordinate initialPositionSnake = new Coordinate( 1, 1);
        Coordinate initialPositionFruit = new Coordinate(2, 2);
        
        this.snake = new Snake(initialPositionSnake, tileSize);
        this.fruit = new Fruit(initialPositionFruit, tileSize);

        snake.resetScore();

        grid.initializedMap();
        gameOver = false;
    }
    
   @Override
    public void update() {
        switch (keyHandler.getTeclaActual()) {
            case KeyEvent.VK_D -> moveRigth();
            case KeyEvent.VK_W -> moveUp();
            case KeyEvent.VK_S -> moveDown();
            case KeyEvent.VK_A -> moveLeft();
            default -> {  return; }
        }

        if (snake.getCollider() != null && snake.getCollider().intersects(fruit.getCollider())) {
            foodSpawn();
            snake.increaseScore(10);
        } else {
            snake.removeHead(); 
        }

        if (keyHandler.consumeKey(KeyEvent.VK_ESCAPE)) {
            sceneManager.setCurrentScene(new GameOverScene(sceneManager, keyHandler, sizeWidth, sizeHeight));
        }

        if(gameOver == true){
            init();
        }
    }

    @Override
    public void draw(Graphics g2) {
        for(Coordinate coordinateSnake : snake.getBodySnake()) {
            g2.setColor(Color.WHITE);
            g2.fillRect(coordinateSnake.getCol() * grid.getTileSize(), coordinateSnake.getRow() * grid.getTileSize(), grid.getTileSize(), grid.getTileSize());
        }

        g2.drawString("Score: " + snake.getScore(), 500, 20);

        g2.setColor(Color.red);
        g2.fillOval(fruit.getCol() * tileSize, fruit.getRow() * tileSize, tileSize, tileSize);

    }

    @Override
    public void dispose() {

    }

    public void moveRigth(){
        int nextCol = snake.getLastSnakeElement().getCol() + 1;
        int nextRow = snake.getLastSnakeElement().getRow();

        if (grid.getOutOfBoundsWidth(nextCol)) {
            keyHandler.setTeclaPresionada(0);
            gameOver = true;
            sceneManager.setCurrentScene(new GameOverScene(sceneManager, keyHandler, sizeWidth, sizeHeight));
        } else {
            snake.addBody(new Coordinate(nextCol, nextRow));
            snake.setCol(nextCol);
            snake.setRow(nextRow);
        }
    }

    public void moveLeft(){
        int nextCol = snake.getLastSnakeElement().getCol() - 1;
        int nextRow = snake.getLastSnakeElement().getRow();

        if (grid.getOutOfBoundsWidth(nextCol)) {
            keyHandler.setTeclaPresionada(0);
            gameOver = true;
            sceneManager.setCurrentScene(new GameOverScene(sceneManager, keyHandler, sizeWidth, sizeHeight));
        } else {
            snake.addBody(new Coordinate(nextCol, nextRow));
            snake.setCol(nextCol);
            snake.setRow(nextRow);
        }
    }

    public void moveUp(){
        int nextCol = snake.getLastSnakeElement().getCol();
        int nextRow = snake.getLastSnakeElement().getRow() - 1;

        if (grid.getOutOfBoundsHeight(nextRow)) {
            keyHandler.setTeclaPresionada(0);
            gameOver = true;
            sceneManager.setCurrentScene(new GameOverScene(sceneManager, keyHandler, sizeWidth, sizeHeight));
        } else {
            snake.addBody(new Coordinate(nextCol, nextRow));
            snake.setCol(nextCol);
            snake.setRow(nextRow);
        }
    }

    public void moveDown(){
        int nextCol = snake.getLastSnakeElement().getCol();
        int nextRow = snake.getLastSnakeElement().getRow() + 1;

        if (grid.getOutOfBoundsHeight(nextRow)) {
            keyHandler.setTeclaPresionada(0);
            gameOver = true;
            sceneManager.setCurrentScene(new GameOverScene(sceneManager, keyHandler, sizeWidth, sizeHeight));
        } else {
            snake.addBody(new Coordinate(nextCol, nextRow));
            snake.setCol(nextCol);
            snake.setRow(nextRow);
        }
    }
    
    public void foodSpawn(){
        fruit.setCol(random.nextInt(grid.getCol() - 1)); 
        fruit.setRow(random.nextInt(grid.getRow() - 1)); 
    }

    public void grow(){
        switch (keyHandler.getTeclaActual()) {
            case KeyEvent.VK_D -> {
                snake.addBodyLast(new Coordinate(snake.getLastSnakeElement().getCol() - 1, snake.getLastSnakeElement().getRow()));
            }

            case KeyEvent.VK_W -> {
               snake.addBodyLast(new Coordinate(snake.getLastSnakeElement().getCol(), snake.getLastSnakeElement().getRow() - 1));
            }

            case KeyEvent.VK_S -> {
                snake.addBodyLast(new Coordinate(snake.getLastSnakeElement().getCol(), snake.getLastSnakeElement().getRow() + 1));
            }

            case KeyEvent.VK_A -> {
                snake.addBodyLast(new Coordinate(snake.getLastSnakeElement().getCol() + 1, snake.getLastSnakeElement().getRow()));
            }

            default -> {
            }
        }
    }

}
