package org.hackathon.bitcommit.scrollable;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import org.hackathon.bitcommit.game.Game;

/**
 * Created by codecadet on 24/11/16.
 */
public class ScrollHandler {

    private Background bg1, bg2, bg3;

    private Asteroid asteroid1;
    private Asteroid asteroid2;
    private Asteroid asteroid3;
    private Asteroid asteroid4;
    private Asteroid asteroid5;
    private Asteroid asteroid6;
    private Asteroid asteroid7;
    private Asteroid asteroid8;
    private Asteroid asteroid9;


    private Circle circle1;
    private Circle circle2;
    private Circle circle3;
    private Circle circle4;
    private Circle circle5;
    private Circle circle6;
    private Circle circle7;
    private Circle circle8;
    private Circle circle9;



    public static final int PADDING = 256; // asteroid diameter
    public static final int BG_SCROLL_SPEED = -50;
    //public static final int AST_SCROLL_SPEED = -500;
    public static final int AST_SCROLL_SPEED = -300;

    public ScrollHandler() {

        bg1 = new Background(0, 0, BG_SCROLL_SPEED, "core/assets/backgroundslice3.jpg", "core/assets/easterggbackground.png");
        bg2 = new Background(0, (int) (bg1.getPosition().y + Game.HEIGHT), BG_SCROLL_SPEED, "core/assets/backgroundslice2.jpg", "core/assets/easterggbackground.png");
        bg3 = new Background(0, (int) (bg2.getPosition().y + Game.HEIGHT), BG_SCROLL_SPEED, "core/assets/backgroundslice1.jpg", "core/assets/easterggbackground.png");

        int[] asteroidX = getRandoms();

        // todo: change pathToEasterEggTexture on the asteroids
        asteroid1 = new Asteroid(asteroidX[0], Game.HEIGHT + 100, AST_SCROLL_SPEED, "core/assets/muchasteroidresize.png", "core/assets/eastereggobstacles.png");
        asteroid2 = new Asteroid(asteroidX[1], Game.HEIGHT - 200, AST_SCROLL_SPEED, "core/assets/muchasteroidresize.png", "core/assets/eastereggobstacles.png");
        asteroid3 = new Asteroid(asteroidX[2], Game.HEIGHT + 100, AST_SCROLL_SPEED, "core/assets/muchasteroidresize.png", "core/assets/eastereggobstacles.png");
        asteroid4 = new Asteroid(asteroidX[3], Game.HEIGHT - 200, AST_SCROLL_SPEED, "core/assets/muchasteroidresize.png", "core/assets/eastereggobstacles.png");
        asteroid5 = new Asteroid(asteroidX[4], Game.HEIGHT + 100, AST_SCROLL_SPEED, "core/assets/muchasteroidresize.png", "core/assets/eastereggobstacles.png");
        asteroid6 = new Asteroid(asteroidX[5], Game.HEIGHT - 200, AST_SCROLL_SPEED, "core/assets/muchasteroidresize.png", "core/assets/eastereggobstacles.png");
        asteroid7 = new Asteroid(asteroidX[6], Game.HEIGHT + 100, AST_SCROLL_SPEED, "core/assets/muchasteroidresize.png", "core/assets/eastereggobstacles.png");
        asteroid8 = new Asteroid(asteroidX[7], Game.HEIGHT - 200, AST_SCROLL_SPEED, "core/assets/muchasteroidresize.png", "core/assets/eastereggobstacles.png");
        asteroid9 = new Asteroid(asteroidX[8], Game.HEIGHT + 100, AST_SCROLL_SPEED, "core/assets/muchasteroidresize.png", "core/assets/eastereggobstacles.png");

        //System.out.println("Raio da textura do asteroide = " + asteroid1.getTexture().getWidth()/5);

        circle1 = new Circle(asteroidX[0], Game.HEIGHT + 100, asteroid1.getTexture().getWidth()/5);
        circle2 = new Circle(asteroidX[1], Game.HEIGHT - 200, asteroid2.getTexture().getWidth()/5);
        circle3 = new Circle(asteroidX[2], Game.HEIGHT + 100, asteroid3.getTexture().getWidth()/5);
        circle4 = new Circle(asteroidX[3], Game.HEIGHT - 200, asteroid4.getTexture().getWidth()/5);
        circle5 = new Circle(asteroidX[4], Game.HEIGHT + 100, asteroid5.getTexture().getWidth()/5);
        circle6 = new Circle(asteroidX[5], Game.HEIGHT - 200, asteroid6.getTexture().getWidth()/5);
        circle7 = new Circle(asteroidX[6], Game.HEIGHT + 100, asteroid7.getTexture().getWidth()/5);
        circle8 = new Circle(asteroidX[7], Game.HEIGHT - 200, asteroid8.getTexture().getWidth()/5);
        circle9 = new Circle(asteroidX[8], Game.HEIGHT + 100, asteroid9.getTexture().getWidth()/5);

    }

    public void changeSprites(){
        Texture tempTexture = bg1.getTexture();
        bg1.setTexture(bg1.getEasterEggTexture()); //texture = easterEggTexture;
        bg1.setEasterEggTexture(tempTexture); //easterEggTexture = tempTexture;

        tempTexture = bg2.getTexture();
        bg2.setTexture(bg2.getEasterEggTexture()); //texture = easterEggTexture;
        bg2.setEasterEggTexture(tempTexture); //easterEggTexture = tempTexture;

        tempTexture = bg3.getTexture();
        bg3.setTexture(bg3.getEasterEggTexture()); //texture = easterEggTexture;
        bg3.setEasterEggTexture(tempTexture); //easterEggTexture = tempTexture;

        tempTexture = asteroid1.getTexture();
        asteroid1.setTexture(asteroid1.getEasterEggTexture());
        asteroid1.setEasterEggTexture(tempTexture);

        tempTexture = asteroid2.getTexture();
        asteroid2.setTexture(asteroid2.getEasterEggTexture());
        asteroid2.setEasterEggTexture(tempTexture);

        tempTexture = asteroid3.getTexture();
        asteroid3.setTexture(asteroid3.getEasterEggTexture());
        asteroid3.setEasterEggTexture(tempTexture);

        tempTexture = asteroid4.getTexture();
        asteroid4.setTexture(asteroid4.getEasterEggTexture());
        asteroid4.setEasterEggTexture(tempTexture);

        tempTexture = asteroid5.getTexture();
        asteroid5.setTexture(asteroid5.getEasterEggTexture());
        asteroid5.setEasterEggTexture(tempTexture);

        tempTexture = asteroid6.getTexture();
        asteroid6.setTexture(asteroid6.getEasterEggTexture());
        asteroid6.setEasterEggTexture(tempTexture);

        tempTexture = asteroid7.getTexture();
        asteroid7.setTexture(asteroid7.getEasterEggTexture());
        asteroid7.setEasterEggTexture(tempTexture);

        tempTexture = asteroid8.getTexture();
        asteroid8.setTexture(asteroid8.getEasterEggTexture());
        asteroid8.setEasterEggTexture(tempTexture);

        tempTexture = asteroid9.getTexture();
        asteroid9.setTexture(asteroid9.getEasterEggTexture());
        asteroid9.setEasterEggTexture(tempTexture);





    }

    public void update(float delta){

        bg1.update(delta);
        bg2.update(delta);
        bg3.update(delta);

        asteroid1.update(delta);
        asteroid2.update(delta);
        asteroid3.update(delta);
        asteroid4.update(delta);
        asteroid5.update(delta);
        asteroid6.update(delta);
        asteroid7.update(delta);
        asteroid8.update(delta);
        asteroid9.update(delta);

        if(bg1.isScrolledDown()){
            bg1.reset(bg3.getPosition().y + Game.HEIGHT);
        } else if(bg2.isScrolledDown()){
            bg2.reset(bg1.getPosition().y + Game.HEIGHT);
        } else if(bg3.isScrolledDown()){
            bg3.reset(bg2.getPosition().x + Game.HEIGHT);
        }

        if(asteroid1.isScrolledDown()){
            int randomPos = (int) (Math.random() * Game.WIDTH);
            System.out.println("random: " + randomPos);
            asteroid1.reset(randomPos, Game.HEIGHT + 100);
        } else if(asteroid2.isScrolledDown()){
            asteroid2.reset((int) (Math.random() * Game.WIDTH), Game.HEIGHT+10);
        } else if(asteroid3.isScrolledDown()){
            asteroid3.reset((int) (Math.random() * Game.WIDTH), Game.HEIGHT+10);
        } else if(asteroid4.isScrolledDown()){
            asteroid4.reset((int) (Math.random() * Game.WIDTH), Game.HEIGHT+10);
        } else if(asteroid5.isScrolledDown()){
            asteroid5.reset((int) (Math.random() * Game.WIDTH), Game.HEIGHT+10);
        } else if(asteroid6.isScrolledDown()){
            asteroid6.reset((int) (Math.random() * Game.WIDTH), Game.HEIGHT+10);
        } else if(asteroid7.isScrolledDown()){
            asteroid7.reset((int) (Math.random() * Game.WIDTH), Game.HEIGHT+10);
        } else if(asteroid8.isScrolledDown()){
            asteroid8.reset((int) (Math.random() * Game.WIDTH), Game.HEIGHT+10);
        } else if(asteroid9.isScrolledDown()){
            asteroid9.reset((int) (Math.random() * Game.WIDTH), Game.HEIGHT+10);
        }

        repositionCircles();

    }

    public void repositionCircles(){
        circle1.setPosition(asteroid1.getPosition().x, asteroid1.getPosition().y);
        circle2.setPosition(asteroid2.getPosition().x, asteroid2.getPosition().y);
        circle3.setPosition(asteroid3.getPosition().x, asteroid3.getPosition().y);
        circle4.setPosition(asteroid4.getPosition().x, asteroid4.getPosition().y);
        circle5.setPosition(asteroid5.getPosition().x, asteroid5.getPosition().y);
        circle6.setPosition(asteroid6.getPosition().x, asteroid6.getPosition().y);
        circle7.setPosition(asteroid7.getPosition().x, asteroid7.getPosition().y);
        circle8.setPosition(asteroid8.getPosition().x, asteroid8.getPosition().y);
        circle9.setPosition(asteroid9.getPosition().x, asteroid9.getPosition().y);
    }

    public void dispose(){
        bg1.dispose();
        bg2.dispose();
        bg3.dispose();

        asteroid1.dispose();
        asteroid2.dispose();
        asteroid3.dispose();
        asteroid4.dispose();
        asteroid5.dispose();
        asteroid6.dispose();
        asteroid7.dispose();
        asteroid8.dispose();
        asteroid9.dispose();



    }

    public int[] getRandoms(){
        int[] array = new int[9];

        for(int i = 0; i < 9; i++)
            array[i] = (int) (Math.random() * Game.WIDTH) - PADDING;

        return array;
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

    public Asteroid getAsteroid3() {
        return asteroid3;
    }

    public Asteroid getAsteroid4() {
        return asteroid4;
    }

    public Asteroid getAsteroid5() {
        return asteroid5;
    }

    public Asteroid getAsteroid6() {
        return asteroid6;
    }

    public Asteroid getAsteroid7() {
        return asteroid7;
    }

    public Asteroid getAsteroid8() {
        return asteroid8;
    }

    public Asteroid getAsteroid9() {
        return asteroid9;
    }

    public Circle getCircle3() {
        return circle3;
    }

    public Circle getCircle4() {
        return circle4;
    }

    public Circle getCircle5() {
        return circle5;
    }

    public Circle getCircle6() {
        return circle6;
    }

    public Circle getCircle7() {
        return circle7;
    }

    public Circle getCircle8() {
        return circle8;
    }

    public Circle getCircle9() {
        return circle9;
    }

    public Circle getCircle1() {
        return circle1;
    }

    public Circle getCircle2() {
        return circle2;
    }
}
