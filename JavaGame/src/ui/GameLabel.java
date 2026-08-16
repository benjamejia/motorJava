package ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;

public class GameLabel {

    private final Rectangle bounds;
    private final String text;
    private boolean border; 
    private int fontSize;
    private Font font;
    private Stroke borderStroke;

    
    public GameLabel(int x, int y, int width, int height, String text, boolean borde, int fontSize){
        this.bounds = new Rectangle(x,y,width,height);
        this.text = text;
        this.border = borde;
        this.fontSize = fontSize;
        
        this.font = new Font("Arial", Font.BOLD, fontSize);
        this.borderStroke = new BasicStroke(2);
    }

    public void setFont(Font font) {
        this.font = new Font("Arial", Font.BOLD, fontSize);
    }

    public void setBorderStroke(Stroke borderStroke) {
        this.borderStroke = borderStroke;
    }
    
    public void draw(Graphics2D g2){
       g2.setColor(Color.WHITE);

        if (border) {
            g2.setStroke(borderStroke);
            g2.drawRoundRect(bounds.x, bounds.y, bounds.width, bounds.height, 15, 15);
        }

        g2.setFont(font);
        FontMetrics fm = g2.getFontMetrics(font);
        int textX = bounds.x + (bounds.width - fm.stringWidth(text)) / 2;
        int textY = bounds.y + (bounds.height - fm.getHeight()) / 2 + fm.getAscent();
        
        g2.drawString(text, textX, textY);
    }
}
