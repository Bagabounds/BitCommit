package org.hackathon.bitcommit.scrollable;

import com.badlogic.gdx.math.Circle;
import org.hackathon.bitcommit.game.Game;

/**
 * Created by codecadet on 24/11/16.
 */
public class ScrollHandler {

    private Background bg1, bg2, bg3;

    private Asteroid asteroid1;
    private Asteroid asteroid2;

    private Circle circle1;
    private Circle circle2;

    public static final int PADDING = 256; // asteroid diameter
    public static final int BG_SCROLL_SPEED = -50;
    //public static final int AST_SCROLL_SPEED = -500;
    public static final int AST_SCROLL_SPEED = -300;

    public ScrollHandler() {
        bg1 = new Background(0, 0, BG_SCROLL_SPEED, "core/assets/backgroundslice3.jpg");
        bg2 = new Background(0, (int) (bg1.getPosition().y + Game.HEIGHT), BG_SCROLL_SPEED, "core/assets/backgroundslice2.jpg");
        bg3 = new Background(0, (int) (bg2.getPosition().y + Game.HEIGHT), BG_SCROLL_SPEED, "core/assets/backgroundslice1.jpg");

        int asteroidX = ((int) (Math.random() * Game.WIDTH)) - PADDING;

        asteroid1 = new Asteroid(asteroidX, Game.HEIGHT + 100, AST_SCROLL_SPEED, "core/assets/muchasteroidresize.png");
        asteroid2 = new Asteroid(0, Game.HEIGHT - 200, AST_SCROLL_SPEED, "core/assets/muchasteroidresize.png");

        circle1 = new Circle(asteroidX, Game.HEIGHT + 100, asteroid1.getTexture().getWidth()/2);
        circle2 = new Circle(0, Game.HEIGHT - 200, asteroid2.getTexture().getWidth()/2);
    }

    public void update(float delta){

        bg1.update(delta);
        bg2.update(delta);
        bg3.update(delta);

        asteroid1.update(delta);
        asteroid2.update(delta);

        if(bg1.isScrolledDown()){
            bg1.reset(bg3.getPosition().y + Game.HEIGHT);
        } else if(bg2.isScrolledDown()){
            bg2.reset(bg1.getPosition().y + Game.HEIGHT);
        } else if(bg3.isScrolledDown()){
            bg3.reset(bg2.getPosition().x + Game.HEIGHT);
        }

        if(asteroid1.isScrolledDown()){
            int randomPos = (int) (Math.random() * Game.WIDTH);
            System.out.println(randomPos);
            asteroid1.reset(randomPos, Game.HEIGHT + 100);
        } else if(asteroid2.isScrolledDown()){
            asteroid2.reset((int) (Math.random() * Game.WIDTH), Game.HEIGHT+200);
        }

        repositionCircles();

    }

    public void repositionCircles(){
        circle1.setPosition(asteroid1.getPosition().x, asteroid1.getPosition().y);
        circle2.setPosition(asteroid2.getPosition().x, asteroid2.getPosition().y);
    }

    public Background getBg1() {
        return bg1;
    }

    public Background getBg2() {
        return bg2;
    }

    public Background getBg3() {
        return bg3;
    }

    public Asteroid getAsteroid1() {
        return asteroid1;
    }

    public Asteroid getAsteroid2(){
        return asteroid2;
    }

    public Circle getCircle1() {
        return circle1;
    }

    public Circle getCircle2() {
        return circle2;
    }
}
