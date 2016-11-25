package org.hackathon.bitcommit.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.hackathon.bitcommit.game.Game;

import java.net.SocketException;

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
    public void handleInput() throws SocketException {
        if(Gdx.input.justTouched()){
<<<<<<< HEAD
            System.out.println("handleionput");
            gsm.set(new PlayState(gsm));
=======
            gsm.set(new TestScrollState(gsm));
>>>>>>> 523d298f77412cbaf150526598f5e88e8c181cdb
            dispose();
        }
    }

    @Override
    public void update(float delta) throws SocketException {
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
