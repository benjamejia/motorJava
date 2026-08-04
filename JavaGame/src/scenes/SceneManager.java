package scenes;

import java.util.Stack;

public class SceneManager {
    Stack<Scene> stackScenes = new Stack<>();
    private Scene currentScene;

    public Scene getCurrentScene(){
        return currentScene;
    }

    public void setCurrenScene(){
        if(stackScenes.peek() != null){
            currentScene = stackScenes.peek();
        }
        else
        { 
            System.out.print("No hay escenas.");
        }
    }

    public void addEscene(Scene scene){
        stackScenes.add(scene);
    }

}
