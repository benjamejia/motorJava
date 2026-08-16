package ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;


public class GameButton {
    private final Rectangle bounds;
    private final String text;
    private boolean isHovered;
    private boolean isPressed;
    private Runnable onClick;

    public GameButton(int x, int y, String text, int width, int height, Runnable onClick){
        this.bounds = new Rectangle(x,y,width,height);
        this.text = text;
        this.onClick = onClick;
    }

    public void draw(Graphics2D g2){
        if (isPressed) {
            g2.setColor(new Color(180, 50, 50));
        } else if (isHovered) {
            g2.setColor(new Color(230, 80, 80));
        } else {
            g2.setColor(new Color(200, 60, 60));
        }
        g2.drawRoundRect(bounds.x, bounds.y, bounds.width, bounds.height, 15, 16);

        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(2));
        g2.drawRoundRect(bounds.x, bounds.y, bounds.width, bounds.height, 15, 15);

        g2.setFont(new Font("Arial", Font.BOLD, 32));
        FontMetrics fm = g2.getFontMetrics();
        int textX = bounds.x + (bounds.width - fm.stringWidth(text)) / 2;
        int textY = bounds.y + (bounds.height - fm.getHeight()) / 2 + fm.getAscent();
        g2.drawString(text, textX, textY);
    }

    public void onMouseMove(MouseEvent e) {
        isHovered = bounds.contains(e.getPoint());
    }

    public void onMousePressed(MouseEvent e) {
        if (bounds.contains(e.getPoint())) {
            isPressed = true;
        }
    }

    public void onMouseReleased(MouseEvent e) {
        if (isPressed && bounds.contains(e.getPoint())) {
            if (onClick != null) onClick.run();
        }
        isPressed = false;
    }
}
