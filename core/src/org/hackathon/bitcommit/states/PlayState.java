package org.hackathon.bitcommit.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.utils.viewport.Viewport;
import org.hackathon.bitcommit.game.Game;
import org.hackathon.bitcommit.gameobjects.Spaceship;
import org.hackathon.bitcommit.helpers.InputHandler;
import org.hackathon.bitcommit.scrollable.ScrollHandler;

import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Created by codecadet on 24/11/16.
 */
public class PlayState extends State {

    private Texture background;
    private Viewport viewport;
    private Spaceship spaceship;
    private final Spaceship opponent;
    private ScrollHandler scroller;
    private Hud hud;

    public PlayState(GameStateManager gsm) throws SocketException {
        super(gsm);
        //background = new Texture("core/assets/background_1024.png");
        opponent = new Spaceship(40, 150, this);
        spaceship = new Spaceship(20, 50, this);
        System.out.println("PS: " + opponent);
        System.out.println(Thread.currentThread().getName());
        //background = new Texture("core/assets/background_1024.png");
        spaceship = new Spaceship(20, 50, this);
        scroller = new ScrollHandler();
        //super.getCam().setToOrtho(false, Game.WIDTH / 2, Game.HEIGHT / 2);
        Gdx.input.setInputProcessor(new InputHandler(spaceship));
        hud = new Hud(Game.spriteBatch);
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
        hud.update(delta);
        hud.addScore(1);


        try {
            spaceship.sendPosition();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        if (collides(scroller.getCircle1())) {
            gsm.set(new GameOverState(gsm));
            dispose();
        }
        if (collides(scroller.getCircle2())) {
            gsm.set(new GameOverState(gsm));
            dispose();
        }
        if (collides(scroller.getCircle3())) {
            gsm.set(new GameOverState(gsm));
            dispose();
        }
        if (collides(scroller.getCircle4())) {
            gsm.set(new GameOverState(gsm));
            dispose();
        }
        if (collides(scroller.getCircle5())) {
            gsm.set(new GameOverState(gsm));
            dispose();
        }
        if (collides(scroller.getCircle6())) {
            gsm.set(new GameOverState(gsm));
            dispose();
        }
        if (collides(scroller.getCircle7())) {
            gsm.set(new GameOverState(gsm));
            dispose();
        }
        if (collides(scroller.getCircle8())) {
            gsm.set(new GameOverState(gsm));
            dispose();
        }
        if (collides(scroller.getCircle9())) {
            gsm.set(new GameOverState(gsm));
            dispose();
        }
    }

    @Override
    public void render(SpriteBatch spriteBatch) {

        //spriteBatch.setProjectionMatrix(super.getCam().combined);


        spriteBatch.begin();
        //spriteBatch.draw(background, 0, 0, Game.WIDTH, Game.HEIGHT);
        drawBackgroundImages(spriteBatch);
        spriteBatch.draw(spaceship.getTexture(), spaceship.getPosition().x, spaceship.getPosition().y);
        spriteBatch.draw(opponent.getOpponentTexture(), opponent.getPosition().x, opponent.getPosition().y);
        spriteBatch.setProjectionMatrix(hud.stage.getCamera().combined);
        spriteBatch.end();
        hud.stage.draw();

    }

    @Override
    public void dispose() {

        spaceship.dispose();
        scroller.dispose();

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
        spriteBatch.draw(scroller.getAsteroid3().getTexture(), scroller.getAsteroid3().getPosition().x, scroller.getAsteroid3().getPosition().y, scroller.getAsteroid3().getTexture().getWidth() / 4, scroller.getAsteroid3().getTexture().getHeight() / 4);
        spriteBatch.draw(scroller.getAsteroid4().getTexture(), scroller.getAsteroid4().getPosition().x, scroller.getAsteroid4().getPosition().y, scroller.getAsteroid4().getTexture().getWidth() / 4, scroller.getAsteroid4().getTexture().getHeight() / 4);
        spriteBatch.draw(scroller.getAsteroid5().getTexture(), scroller.getAsteroid5().getPosition().x, scroller.getAsteroid5().getPosition().y, scroller.getAsteroid5().getTexture().getWidth() / 4, scroller.getAsteroid5().getTexture().getHeight() / 4);
        spriteBatch.draw(scroller.getAsteroid6().getTexture(), scroller.getAsteroid6().getPosition().x, scroller.getAsteroid6().getPosition().y, scroller.getAsteroid6().getTexture().getWidth() / 4, scroller.getAsteroid6().getTexture().getHeight() / 4);
        spriteBatch.draw(scroller.getAsteroid7().getTexture(), scroller.getAsteroid7().getPosition().x, scroller.getAsteroid7().getPosition().y, scroller.getAsteroid7().getTexture().getWidth() / 4, scroller.getAsteroid7().getTexture().getHeight() / 4);
        spriteBatch.draw(scroller.getAsteroid8().getTexture(), scroller.getAsteroid8().getPosition().x, scroller.getAsteroid8().getPosition().y, scroller.getAsteroid8().getTexture().getWidth() / 4, scroller.getAsteroid8().getTexture().getHeight() / 4);
        spriteBatch.draw(scroller.getAsteroid9().getTexture(), scroller.getAsteroid9().getPosition().x, scroller.getAsteroid9().getPosition().y, scroller.getAsteroid9().getTexture().getWidth() / 4, scroller.getAsteroid9().getTexture().getHeight() / 4);
    }

    public boolean collides(Circle circle) {
        return spaceship.getCircle().overlaps(circle);
    }
}
