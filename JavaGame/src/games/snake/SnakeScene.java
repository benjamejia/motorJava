package games.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Random;

import core.KeyHandler;
import scenes.MenuScene;
import scenes.Scene;
import scenes.SceneManager;

public class SnakeScene extends Scene{

    private final SceneManager sceneManager;
    private final KeyHandler keyHandler;
    private final int sizeWidth;
    private final int sizeHeight;

    Snake snake;
    Fruit fruit;

    Random random = new Random();

    public SnakeScene(SceneManager sm, KeyHandler kh, int sizeWidth, int sizeHeight){
        this.sceneManager = sm;
        this.keyHandler = kh;
        this.sizeWidth = sizeWidth;
        this.sizeHeight = sizeHeight;
    }

    @Override
    public void init() {
        Coordinate initialPositionSnake = new Coordinate(20, 20);
        Coordinate initialPositionFruit = new Coordinate(20, 20);
        
        this.snake = new Snake(initialPositionSnake);
        this.fruit = new Fruit(initialPositionFruit);

        snake.resetScore();
    }

    @Override
    public void update() {
        snake.getCollider();

        switch (keyHandler.getTeclaActual()) {
            case KeyEvent.VK_D -> {
                snake.addBody(new Coordinate(snake.getLastSnakeElement().getX() + snake.getSizeWidth(), snake.getLastSnakeElement().getY()));
                snake.removeHead();
            }

            case KeyEvent.VK_W -> {
                snake.addBody(new Coordinate(snake.getLastSnakeElement().getX(), snake.getLastSnakeElement().getY() - snake.getSizeheigth()));
                snake.removeHead();
            }

            case KeyEvent.VK_S -> {
                snake.addBody(new Coordinate(snake.getLastSnakeElement().getX(), snake.getLastSnakeElement().getY() + snake.getSizeheigth()));
                snake.removeHead();
            }

            case KeyEvent.VK_A -> {
                snake.addBody(new Coordinate(snake.getLastSnakeElement().getX() - snake.getSizeWidth(), snake.getLastSnakeElement().getY()));
                snake.removeHead();
            }

            default -> {
            }
        }

        if(keyHandler.consumeKey(KeyEvent.VK_ESCAPE)){
            sceneManager.setCurrentScene(new MenuScene(sceneManager,keyHandler, sizeWidth, sizeHeight));
        }

        if(snake.getCollider().intersects(fruit.getCollider())){
            grow();
            foodSpawn();
            snake.increaseScore(10);
        }
    }

    @Override
    public void draw(Graphics g2) {
        for(Coordinate coordinate : snake.getBodySnake()) {
            g2.setColor(Color.WHITE);
            g2.fillRect(coordinate.getX(), coordinate.getY(), snake.getSizeWidth(), snake.getSizeheigth());
        }

        g2.drawString("Score: " + snake.getScore(), 500, 20);

        g2.setColor(Color.red);
        g2.fillOval(fruit.getX(), fruit.getY(), fruit.getSize(), fruit.getSize());

    }

    @Override
    public void dispose() {

    }

    public void foodSpawn(){
        fruit.setX(random.nextInt(sizeWidth - fruit.getSize()));
        fruit.setY(random.nextInt(sizeHeight - fruit.getSize()));
    }

    public void grow(){
        switch (keyHandler.getTeclaActual()) {
            case KeyEvent.VK_D -> {
                snake.addBodyLast(new Coordinate(snake.getLastSnakeElement().getX() - snake.getSizeWidth(), snake.getLastSnakeElement().getY()));
            }

            case KeyEvent.VK_W -> {
               snake.addBodyLast(new Coordinate(snake.getLastSnakeElement().getX(), snake.getLastSnakeElement().getY() - snake.getSizeheigth()));
            }

            case KeyEvent.VK_S -> {
                snake.addBodyLast(new Coordinate(snake.getLastSnakeElement().getX(), snake.getLastSnakeElement().getY() + snake.getSizeheigth()));
            }

            case KeyEvent.VK_A -> {
                snake.addBodyLast(new Coordinate(snake.getLastSnakeElement().getX() + snake.getSizeWidth(), snake.getLastSnakeElement().getY()));
            }

            default -> {
            }
        }
    }

}
