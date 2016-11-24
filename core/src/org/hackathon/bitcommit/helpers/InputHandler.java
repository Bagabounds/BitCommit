package org.hackathon.bitcommit.helpers;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import org.hackathon.bitcommit.gameobjects.Spaceship;

/**
 * Created by codecadet on 24/11/16.
 */
public class InputHandler implements InputProcessor{

    private Spaceship spaceship;

    public InputHandler(Spaceship spaceship) {
        this.spaceship = spaceship;
    }

    @Override
    public boolean keyDown(int keycode) {

        switch (keycode){
            case Input.Keys.LEFT:
                spaceship.onKeyPressed(Input.Keys.LEFT);
                break;
            case Input.Keys.RIGHT:
                spaceship.onKeyPressed(Input.Keys.RIGHT);
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
