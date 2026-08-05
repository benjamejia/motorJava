package scenes;

import java.awt.Graphics2D;

public class SceneManager {
    private Scene currentScene;

    public void setCurrentScene(Scene currentScene){
        this.currentScene = currentScene;
        if(this.currentScene != null){
            this.currentScene.init();
        }
    }

    public Scene getCurrentScene(){
        return currentScene;
    }

    public void update(){
        currentScene.update();
    }   
    
    public void draw(Graphics2D g2){
        currentScene.draw(g2);
    }

}
