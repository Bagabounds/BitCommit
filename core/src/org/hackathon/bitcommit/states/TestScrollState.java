package org.hackathon.bitcommit.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.hackathon.bitcommit.game.Game;
import org.hackathon.bitcommit.scrollable.Background;
import org.hackathon.bitcommit.scrollable.ScrollHandler;

/**
 * Created by codecadet on 24/11/16.
 */
public class TestScrollState extends State {

    private ScrollHandler scroller;

    public TestScrollState(GameStateManager gsm) {
        super(gsm);
        scroller = new ScrollHandler();
    }

    @Override
    public void handleInput() {


    }

    @Override
    public void update(float delta) {

        scroller.update(delta);
    }

    @Override
    public void render(SpriteBatch spriteBatch) {

        spriteBatch.begin();
        drawBackgroundImages(spriteBatch);
        spriteBatch.end();

    }

    @Override
    public void dispose() {

    }

    public void drawBackgroundImages(SpriteBatch spriteBatch) {
/*        spriteBatch.draw(scroller.getBg1().getTexture(), scroller.getBg1().getPosition().x, scroller.getBg1().getPosition().y, Game.WIDTH, Game.HEIGHT);
        spriteBatch.draw(scroller.getBg2().getTexture(), scroller.getBg2().getPosition().x, scroller.getBg2().getPosition().y, Game.WIDTH, Game.HEIGHT);
        spriteBatch.draw(scroller.getBg3().getTexture(), scroller.getBg3().getPosition().x, scroller.getBg3().getPosition().y, Game.WIDTH, Game.HEIGHT);

        spriteBatch.draw(scroller.getAsteroid().getTexture(), scroller.getAsteroid().getPosition().x, scroller.getAsteroid().getPosition().y, scroller.getAsteroid().getTexture().getWidth() / 4, scroller.getAsteroid().getTexture().getHeight() / 4);
        spriteBatch.draw(scroller.getAsteroid2().getTexture(), scroller.getAsteroid2().getPosition().x, scroller.getAsteroid2().getPosition().y, scroller.getAsteroid2().getTexture().getWidth() / 4, scroller.getAsteroid2().getTexture().getHeight() / 4);*/
    }
}
