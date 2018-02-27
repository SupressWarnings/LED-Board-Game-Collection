package de.schulte.ledboard.gamecollection.game.spaceinvader;

import de.schulte.ledboard.gamecollection.util.Location;
import ledControl.BoardController;

import java.util.ArrayList;
import java.util.Random;

public class Game {

    private BoardController controller;
    private Random r;
    private Player player;
    private Enemies enemies;
    private ArrayList<Shot> shots, enemyShots;
    private View view;
    private Input input;
    private long enemiesMoved = System.currentTimeMillis();
    private int enemyShooting = 0;
    private int shootingReset = 10;

    private char curInput = 'N';

    public Game(BoardController controller){
        this.controller = controller;
        r = new Random();
        view = new View(controller);
        input = new Input(controller);
        player = new Player(new Location(5, 11));
        enemies = new Enemies();
        shots = new ArrayList<>();
        enemyShots = new ArrayList<>();
        play();
    }

    public void play(){
        boolean dead = false;
        while(!dead){
            curInput = input.getInput();
            if(curInput == 'L' || curInput == 'R' || curInput-1 == 'L' || curInput-1 == 'R'){
                player.move(curInput);
            }
            if(checkCollisions()){
                player.reduceLife();
                if(player.getLifes() == 0){
                    dead = true;
                }
            }
            if(curInput == 'N'+1 || curInput == 'R'+1 || curInput == 'L'+1){
                Shot shot = player.shoot();
                if(shot != null){
                    shots.add(shot);
                }
            }
            if(enemiesMoved + 1000 <= System.currentTimeMillis()){
                enemiesMoved = System.currentTimeMillis();
                enemies.move();
            }
            view.drawPlayer(player.getLocation());
            view.drawEnemies(enemies.getAlive(), enemies.getLocation().getX(), enemies.getLocation().getY());
            for(int i = 0; i < shots.size(); ++i){
                shots.get(i).move();
                view.drawShot(shots.get(i).getLocation(), shots.get(i).getDirection());
                if(shots.get(i).getLocation().getY() == 1){
                    shots.remove(i);
                }
            }
            for(int i = 0; i < enemyShots.size(); ++i){
                if(enemyShots.get(i).getLocation().getY() == 11){
                    enemyShots.remove(i);
                }else{
                    enemyShots.get(i).move();
                    view.drawShot(enemyShots.get(i).getLocation(), enemyShots.get(i).getDirection());
                }
            }
            if(enemyShooting == shootingReset){
                enemyShooting = 0;
                int loc = r.nextInt(8);
                enemyShots.add(new Shot(new Location(loc + enemies.getLocation().getX(), enemies.getLocation().getY()), false));
            }
            if(!enemies.stillAlive()){
                enemies = new Enemies();
                --shootingReset;
            }
            ++enemyShooting;
            view.drawLifes(player.getLifes());
            view.update();
            controller.sleep(100);
        }
    }

    private boolean checkCollisions(){
        Location loc = enemies.getLocation();
        for(int i = 0; i < shots.size(); ++i){
            if(shots.get(i).getLocation().getX() >= loc.getX() && shots.get(i).getLocation().getX() < loc.getX()+8
                    && shots.get(i).getLocation().getY() >= loc.getY() && shots.get(i).getLocation().getY() < loc.getY()+3
                    && enemies.getAlive(shots.get(i).getLocation().getX() - loc.getX(), shots.get(i).getLocation().getY() - loc.getY())){
                enemies.kill(shots.get(i).getLocation().getX() - loc.getX(), shots.get(i).getLocation().getY() - loc.getY());
                shots.remove(i);
            }
        }
        boolean beenShot = false;
        for(Shot shot : enemyShots){
            if(shot.getLocation().getY() == 11){
                if(shot.getLocation().equals(player.getLocation())){
                    beenShot = true;
                }
            }
        }
        return beenShot;
    }
}
