package ui;
import games.towerDefense.towers.Turret;
import java.awt.*;

public class TowerUpgradePanel {

    private int x = 50, y = 50;
    private final int width = 540;
    private final int height = 250;
    private Turret selectedTower;

    // Valores máximos de referencia para las barras de progreso
    private final float maxDamage = 50.0f;
    private final float maxRange = 10.0f;

    public TowerUpgradePanel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setTower(Turret tower) {
        this.selectedTower = tower;
    }

    public void draw(Graphics2D g2) {
        if (selectedTower == null) return;

        // 1. Activar Anti-Aliasing para bordes limpios
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // 2. Fondo Negro y Borde Blanco del Panel
        g2.setColor(Color.BLACK);
        g2.fillRoundRect(x, y, width, height, 35, 35);
        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(3));
        g2.drawRoundRect(x, y, width, height, 35, 35);

        // 3. Recuadro del Icono (Izquierda)
        int iconBoxX = x + 25;
        int iconBoxY = y + 30;
        int iconBoxSize = 190;
        
        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(2));
        g2.drawRoundRect(iconBoxX, iconBoxY, iconBoxSize, iconBoxSize, 25, 25);

        // Icono de la Torreta: Cuadrado centrado
        int squareSize = 100;
        int squareX = iconBoxX + (iconBoxSize - squareSize) / 2;
        int squareY = iconBoxY + (iconBoxSize - squareSize) / 2;
        
        g2.setColor(Color.WHITE);
        g2.fillRect(squareX, squareY, squareSize, squareSize);

        // 4. Textos y Atributos de la Torre
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("SansSerif", Font.BOLD, 22));
        g2.drawString(selectedTower.getName(), x + 240, y + 50);

        g2.setFont(new Font("SansSerif", Font.PLAIN, 16));

        // Obtener valores reales de la torre
        // (Ajusta los getters según los métodos reales de tu clase base Tower)
        float currentDamage = 10.0f; // Si tienes getDamage(), colócalo aquí
        float currentRange = (float) selectedTower.getRange();
        float currentFireRate = (float) selectedTower.getShootInterval(); // o 0.80

        // Fila 1: Damage
        drawStatRow(g2, "Damage ->", currentDamage, maxDamage, String.valueOf((int)currentDamage), x + 240, y + 85);

        // Fila 2: Range
        drawStatRow(g2, "Range ->", currentRange, maxRange, String.valueOf((int)currentRange), x + 240, y + 135);

        // Fila 3: Rate of fire
        drawStatRow(g2, "Rate of fire ->", currentFireRate, 1.5f, String.valueOf(currentFireRate), x + 240, y + 185);

        // 5. Botones Upgrade (Fondo negro con borde y texto blanco)
        int btnX = x + 405;
        drawButton(g2, "Upgrade", btnX, y + 70, 110, 36);
        drawButton(g2, "Upgrade", btnX, y + 120, 110, 36);
        drawButton(g2, "Upgrade", btnX, y + 170, 110, 36);
    }

    private void drawStatRow(Graphics2D g2, String label, float current, float max, String valueText, int rowX, int rowY) {
        g2.setColor(Color.WHITE);
        g2.drawString(label, rowX, rowY);

        int barX = rowX;
        int barY = rowY + 12;
        int barWidth = 90;
        
        float progress = Math.min(1.0f, Math.max(0.0f, current / max));
        int filledWidth = (int) (progress * barWidth);

        // Barra: Fondo gris oscuro
        g2.setColor(new Color(90, 90, 90));
        g2.setStroke(new BasicStroke(4));
        g2.drawLine(barX, barY, barX + barWidth, barY);

        // Barra: Progreso en blanco
        g2.setColor(Color.WHITE);
        g2.drawLine(barX, barY, barX + filledWidth, barY);

        // Extremos verticales de la barra
        g2.drawLine(barX, barY - 4, barX, barY + 4);
        g2.drawLine(barX + barWidth, barY - 4, barX + barWidth, barY + 4);

        // Texto del valor numérico
        g2.setColor(new Color(200, 200, 200));
        g2.drawString(valueText, barX + barWidth + 12, barY + 5);
    }

    private void drawButton(Graphics2D g2, String text, int bx, int by, int bw, int bh) {
        // Fondo y borde
        g2.setColor(Color.BLACK);
        g2.fillRoundRect(bx, by, bw, bh, 15, 15);
        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(2));
        g2.drawRoundRect(bx, by, bw, bh, 15, 15);

        // Centrado de texto
        FontMetrics fm = g2.getFontMetrics();
        int textX = bx + (bw - fm.stringWidth(text)) / 2;
        int textY = by + (bh - fm.getHeight()) / 2 + fm.getAscent();
        g2.drawString(text, textX, textY);
    }
}