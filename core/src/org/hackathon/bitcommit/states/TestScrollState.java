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
    private Texture texture1;
    private Texture texture2;
    private Texture texture3;


    public TestScrollState(GameStateManager gsm) {
        super(gsm);
        scroller = new ScrollHandler();

        texture1 = new Texture("core/assets/backgroundslice3.jpg");
        texture2 = new Texture("core/assets/backgroundslice2.jpg");
        texture3 = new Texture("core/assets/backgroundslice1.jpg");
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
        spriteBatch.draw(texture1, scroller.getBg1().getPosition().x, scroller.getBg1().getPosition().y, Game.WIDTH, Game.HEIGHT);
        spriteBatch.draw(texture2, scroller.getBg2().getPosition().x, scroller.getBg2().getPosition().y, Game.WIDTH, Game.HEIGHT);
        spriteBatch.draw(texture3, scroller.getBg3().getPosition().x, scroller.getBg3().getPosition().y, Game.WIDTH, Game.HEIGHT);
    }
}
