package org.hackathon.bitcommit.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.hackathon.bitcommit.game.Game;

/**
 * Created by codecadet on 24/11/16.
 */
public class MenuState extends State {

    private Texture background;
    private Texture playButton;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("core/assets/placeholderforbackground1ststate.png");
        playButton = new Texture("core/assets/play.png");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            gsm.set(new TestScrollState(gsm));
            dispose();
        }
    }

    @Override
    public void update(float delta) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0, Game.WIDTH, Game.HEIGHT);
        spriteBatch.draw(playButton, (Game.WIDTH/2) - (playButton.getWidth()/2), (float)(Game.HEIGHT/3.5));
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playButton.dispose();
    }


}
