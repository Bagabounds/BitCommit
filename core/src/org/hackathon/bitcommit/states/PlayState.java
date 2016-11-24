package org.hackathon.bitcommit.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.hackathon.bitcommit.game.Game;

/**
 * Created by codecadet on 24/11/16.
 */
public class PlayState extends State{

    private Texture background;
    private Texture spaceship;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("core/assets/background_1024.png");
        spaceship = new Texture("core/assets/ship1.gif");
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0, Game.WIDTH, Game.HEIGHT);
        spriteBatch.draw(spaceship, 50, 50);
        spriteBatch.end();
    }

    @Override
    public void dispose() {

    }
}
