package de.schulte.ledboard.gamecollection.game.spaceinvader;

import de.schulte.ledboard.gamecollection.util.Location;
import ledControl.BoardController;

import java.util.ArrayList;

public class Game {

    private BoardController controller;
    private Player player;
    private ArrayList<Shot> shots;
    private View view;
    private Input input;

    private char curInput = 'N';

    public Game(BoardController controller){
        this.controller = controller;
        view = new View(controller);
        input = new Input(controller);
        player = new Player(new Location(5, 11));
        shots = new ArrayList<>();
        play();
    }

    public void play(){
        boolean dead = false;
        while(!dead){
            curInput = input.getInput();
            if(curInput == 'L' || curInput == 'R'){
                player.move(curInput);
            }else if(curInput == 'S'){
                Shot shot = player.shoot();
                if(shot != null){
                    shots.add(shot);
                }
            }
            view.drawPlayer(player.getLocation());
            for(int i = 0; i < shots.size(); ++i){
                shots.get(i).move();
                view.drawShot(shots.get(i).getLocation());
                if(shots.get(i).getLocation().getY() == 0){
                    shots.remove(i);
                }
            }
            view.update();
            controller.sleep(100);
        }
    }
}
