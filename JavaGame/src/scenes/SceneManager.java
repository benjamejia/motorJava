package scenes;

import java.awt.Graphics2D;
import java.util.ArrayDeque;
import java.util.Deque;

public class SceneManager {

    private final Deque<Scene> stackScenes = new ArrayDeque<>();
    private Scene currentScene;

    public void setCurrentScene(Scene currentScene){
        stackScenes.addFirst(currentScene);
        this.currentScene = stackScenes.peekFirst();
        if(this.currentScene != null){
            this.currentScene.init();
        }
    }

    public void clearStack(){
        stackScenes.clear();
    }

    public Scene getCurrentScene(){
        return currentScene;
    }

    public void deleteCurrentScene(){
        stackScenes.removeFirst();
        if(stackScenes.isEmpty() == false){
            this.currentScene = stackScenes.peekFirst();
        }else{
            System.out.println("No hay escenas en el stack.");
        }
    }

    public void deleteLastScene(){
        stackScenes.removeLast();
    }

    public void update(double deltaTime){
        currentScene.update(deltaTime);
    }   
    
    public void draw(Graphics2D g2){
        for(Scene scene: stackScenes){
            scene.draw(g2);
        }
    }

}
