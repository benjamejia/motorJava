package scenes;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public abstract class Scene {

    public abstract void init();

    public abstract void update(double deltaTime);

    public abstract void draw(Graphics2D g2);

    public abstract void onMouseMove(MouseEvent e);

    public abstract void onMousePressed(MouseEvent e);

    public abstract void onMouseReleased(MouseEvent e);

    public abstract void dispose();

}
