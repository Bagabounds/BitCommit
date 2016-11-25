package org.hackathon.bitcommit.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.Viewport;
import org.hackathon.bitcommit.game.Game;
import org.hackathon.bitcommit.gameobjects.Spaceship;
import org.hackathon.bitcommit.helpers.InputHandler;

import java.net.SocketException;

/**
 * Created by codecadet on 24/11/16.
 */
public class PlayState extends State{

    private Texture background;
    private Viewport viewport;
    private Spaceship spaceship;
    private final Spaceship opponent;

    public PlayState(GameStateManager gsm) throws SocketException {
        super(gsm);
        background = new Texture("core/assets/background_1024.png");
        opponent = new Spaceship(40,150, this);
        spaceship = new Spaceship(20,50,this);
        System.out.println("PS: " + opponent);
        System.out.println(Thread.currentThread().getName());
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
        opponent.update(delta);
    }

    @Override
    public void render(SpriteBatch spriteBatch) {

        //spriteBatch.setProjectionMatrix(super.getCam().combined);

        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0, Game.WIDTH, Game.HEIGHT);
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
}
