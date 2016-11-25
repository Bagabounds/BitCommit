package org.hackathon.bitcommit.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import org.hackathon.bitcommit.FileManager.FileManager;
import org.hackathon.bitcommit.game.Game;

import java.net.SocketException;

/**
 * Created by codecadet on 25/11/16.
 */
public class GameOverState extends State{

    private Texture background;
    private Texture resetButton;
    private Label highScoreLabel;


    public GameOverState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("core/assets/GAMEOVERPLACEHOLDER.png");
        resetButton = new Texture("core/assets/play.png");
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
        spriteBatch.draw(resetButton, (Game.WIDTH/2) - (resetButton.getWidth()/2), (float)(Game.HEIGHT/4));


        highScoreLabel = new Label(String.format("%03d", Hud.score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        highScoreLabel.setText("Highscore: " + FileManager.readFile("core/assets/scores.txt"));
        highScoreLabel.setSize(60, 60);
        highScoreLabel.setFontScale(2,2);
        highScoreLabel.setX(Game.WIDTH/2 - highScoreLabel.getWidth()-40);
        highScoreLabel.setY(Game.HEIGHT/6);
        highScoreLabel.draw(spriteBatch, 1);

        spriteBatch.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        resetButton.dispose();
    }
}
