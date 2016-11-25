package org.hackathon.bitcommit.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.hackathon.bitcommit.game.Game;

import java.net.SocketException;

/**
 * Created by codecadet on 24/11/16.
 */
public class MenuState extends State {

    private final Music music2;
    private Texture background;
    private Texture playButton;
    private Sound music;
    private Sound sfx;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("core/assets/menuStateScreenFinal.png");
        playButton = new Texture("core/assets/play.png");
        music2 = Game.assetManager.get("core/assets/audio/music/menusound.mp3",Music.class);
        music2.play();

    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            //TODO: check this line
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
        spriteBatch.draw(playButton, (Game.WIDTH/2) - (playButton.getWidth()/2), (float)(Game.HEIGHT/3.5));
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        music = Game.assetManager.get("core/assets/audio/sfx/clicktostart.wav",Sound.class);
        music.play();
        background.dispose();
        playButton.dispose();
        music2.dispose();
    }


}
