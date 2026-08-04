package scenes;

public abstract class Scene {

    public abstract void init();

    public abstract void update();

    public abstract void draw(java.awt.Graphics g);

    public abstract void dispose();
}
