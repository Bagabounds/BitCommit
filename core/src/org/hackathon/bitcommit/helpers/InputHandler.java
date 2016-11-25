package org.hackathon.bitcommit.helpers;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import org.hackathon.bitcommit.gameobjects.Spaceship;
import org.hackathon.bitcommit.scrollable.ScrollHandler;

/**
 * Created by codecadet on 24/11/16.
 */
public class InputHandler implements InputProcessor {

    private Spaceship spaceship;
    private ScrollHandler scroller;

    public InputHandler(Spaceship spaceship, ScrollHandler scroller) {
        this.spaceship = spaceship;
        this.scroller = scroller;
    }

    @Override
    public boolean keyDown(int keycode) {

        switch (keycode) {
            case Input.Keys.LEFT:
                spaceship.onKeyPressed(Input.Keys.LEFT);
                if(!spaceship.isGameMode())
                    spaceship.changeTexture(new Texture("core/assets/shipleft.png"));
                break;
            case Input.Keys.RIGHT:
                spaceship.onKeyPressed(Input.Keys.RIGHT);
                if(!spaceship.isGameMode())
                    spaceship.changeTexture(new Texture("core/assets/shipright.png"));
                break;
            case Input.Keys.UP:
                spaceship.onKeyPressed(Input.Keys.UP);
                break;
            case Input.Keys.DOWN:
                spaceship.onKeyPressed(Input.Keys.DOWN);
                break;
            case Input.Keys.ENTER:
                spaceship.changeSprites();
                spaceship.changeOpponentForReal();
                scroller.changeSprites();
                if(spaceship.isGameMode())
                    spaceship.setGameMode(false);
                else
                    spaceship.setGameMode(true);
                break;
            case Input.Keys.ESCAPE:
                System.exit(0);
                break;
        }
        return true;
    }


    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
