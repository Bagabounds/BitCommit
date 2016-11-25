package org.hackathon.bitcommit.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.Viewport;
import org.hackathon.bitcommit.game.Game;
import org.hackathon.bitcommit.gameobjects.Spaceship;
import org.hackathon.bitcommit.helpers.InputHandler;

/**
 * Created by codecadet on 24/11/16.
 */
public class PlayState extends State{

    private Texture background;
    private Viewport viewport;
    private Spaceship spaceship;
    private final Spaceship opponent;
    private ScrollHandler scroller;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("core/assets/background_1024.png");
        opponent = new Spaceship(40,150, this);
        spaceship = new Spaceship(20,50,this);
        System.out.println("PS: " + opponent);
        System.out.println(Thread.currentThread().getName());
        //background = new Texture("core/assets/background_1024.png");
        spaceship = new Spaceship(20,50);
        scroller = new ScrollHandler();
        //super.getCam().setToOrtho(false, Game.WIDTH / 2, Game.HEIGHT / 2);
        Gdx.input.setInputProcessor(new InputHandler(spaceship));
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float delta) {
        handleInput();
        spaceship.update(delta);
        scroller.update(delta);
        opponent.update(delta);
        try {
            spaceship.sendPosition();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void render(SpriteBatch spriteBatch) {

        //spriteBatch.setProjectionMatrix(super.getCam().combined);

        spriteBatch.begin();
        //spriteBatch.draw(background, 0, 0, Game.WIDTH, Game.HEIGHT);
        drawBackgroundImages(spriteBatch);
        spriteBatch.draw(spaceship.getTexture(), spaceship.getPosition().x, spaceship.getPosition().y);
        spriteBatch.draw(opponent.getTexture(), opponent.getPosition().x, opponent.getPosition().y);
        spriteBatch.end();

    }

    @Override
    public void dispose() {

    }

    public Spaceship getSpaceship() {
        return spaceship;
    }


    public Spaceship getOpponent() {
        return opponent;
    }

    public void drawBackgroundImages(SpriteBatch spriteBatch) {
        spriteBatch.draw(scroller.getBg1().getTexture(), scroller.getBg1().getPosition().x, scroller.getBg1().getPosition().y, Game.WIDTH, Game.HEIGHT);
        spriteBatch.draw(scroller.getBg2().getTexture(), scroller.getBg2().getPosition().x, scroller.getBg2().getPosition().y, Game.WIDTH, Game.HEIGHT);
        spriteBatch.draw(scroller.getBg3().getTexture(), scroller.getBg3().getPosition().x, scroller.getBg3().getPosition().y, Game.WIDTH, Game.HEIGHT);

        spriteBatch.draw(scroller.getAsteroid1().getTexture(), scroller.getAsteroid1().getPosition().x, scroller.getAsteroid1().getPosition().y, scroller.getAsteroid1().getTexture().getWidth() / 4, scroller.getAsteroid1().getTexture().getHeight() / 4);
        spriteBatch.draw(scroller.getAsteroid2().getTexture(), scroller.getAsteroid2().getPosition().x, scroller.getAsteroid2().getPosition().y, scroller.getAsteroid2().getTexture().getWidth() / 4, scroller.getAsteroid2().getTexture().getHeight() / 4);
    }

    public boolean collides(){
        //return scroller.getAsteroid1().
        return false;
    }
}
