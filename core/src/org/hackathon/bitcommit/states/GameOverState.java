package org.hackathon.bitcommit.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.hackathon.bitcommit.game.Game;

import java.net.SocketException;

/**
 * Created by codecadet on 25/11/16.
 */
public class GameOverState extends State{

    private final Music music;
    private Texture background;



    public GameOverState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("/Users/codecadet/Desktop/BitCommit/core/assets/gameOverScreen.png");
        music = Game.assetManager.get("core/assets/audio/music/gameoversound(1).ogg",Music.class);
        music.play();


    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            try {
                gsm.set(new PlayState(gsm));
            } catch (SocketException e) {
                e.printStackTrace();
            }
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

        spriteBatch.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        music.dispose();

    }
}
