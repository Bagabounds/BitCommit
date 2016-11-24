package org.hackathon.bitcommit.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by codecadet on 24/11/16.
 */
public class PlayState extends State{

    private Texture ship;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        ship = new Texture("core/assets/ship1.gif");
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

        spriteBatch.draw(ship, 50, 50);

        spriteBatch.end();

    }

    @Override
    public void dispose() {

    }
}
