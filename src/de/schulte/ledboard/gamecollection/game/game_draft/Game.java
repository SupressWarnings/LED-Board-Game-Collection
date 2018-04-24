package de.schulte.ledboard.gamecollection.game.game_draft;

import java.util.List;

public abstract class Game {

    private List<GameObject> gameObjects;
    private View view;
    private Input input;

    public Game(View view, Input input, List<GameObject> gameObjects){
        this(view, input);
        this.gameObjects = gameObjects;
    }

    public Game(View view, Input input){
        this.view = view;
        this.input = input;
    }

    public void init(){
        view.drawWelcomeScreen();
    }

    public void gameLoop(){
        boolean breakCondition = false;
        while(!breakCondition){
            drawUpdates();
            breakCondition = updateObjects(getInput());
        }
    }

    private boolean updateObjects(List<Character> input){
        boolean breakCondition = false;
        for(int i = 0; i < gameObjects.size(); ++i){
            if(gameObjects.get(i).update(gameObjects, input)){
                breakCondition = true;
            }
        }
        return breakCondition;
    }

    private List<Character> getInput(){
        return input.getInput();
    }

    private void drawUpdates(){
        view.drawUpdates(gameObjects);
    }

    public List<GameObject> getGameObjects(){
        return gameObjects;
    }

    public void insertGameObjects(GameObject gameObject){
        gameObjects.add(gameObject);
    }

    public void insertGameObjects(List<GameObject> gameObjects){
        this.gameObjects.addAll(gameObjects);
    }
}
