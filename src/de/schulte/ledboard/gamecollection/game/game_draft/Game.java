package de.schulte.ledboard.gamecollection.game.game_draft;

import java.util.ArrayList;

public abstract class Game {

    private ArrayList<GameObject> gameObjects;
    private View view;
    private Input input;

    public Game(View view, Input input, ArrayList<GameObject> gameObjects){
        this(view, input);
        this.gameObjects = gameObjects;
    }

    public Game(View view, Input input){
        this.view = view;
        this.input = input;
        gameObjects = new ArrayList<>();
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

    private boolean updateObjects(ArrayList<Character> input){
        boolean breakCondition = false;
        for(int i = 0; i < gameObjects.size(); ++i){
            if(gameObjects.get(i).update(gameObjects, input)){
                breakCondition = true;
            }
        }
        return breakCondition;
    }

    private ArrayList<Character> getInput(){
        return input.getInput();
    }

    private void drawUpdates(){
        view.drawUpdates(gameObjects);
    }

    public void insertGameObject(GameObject gameObject){
        gameObjects.add(gameObject);
    }

    public void removeGameObject(GameObject object){
        gameObjects.remove(object);
    }
}
