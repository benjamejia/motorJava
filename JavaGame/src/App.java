import javax.swing.JFrame;

import core.GamePanel;

import java.awt.FlowLayout;

public class App {
    public static void main(String[] args) throws Exception {
        GamePanel gamePanel = new GamePanel();
        
        JFrame frame = new JFrame("My Application");
        frame.setLayout(new FlowLayout());
        frame.setResizable(false);
        frame.add(gamePanel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        gamePanel.startGameThread();
    }
}
