package org.hackathon.bitcommit.helpers;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import org.hackathon.bitcommit.gameobjects.Spaceship;

import java.net.UnknownHostException;

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
                try {
                    spaceship.onKeyPressed(Input.Keys.LEFT);
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                break;
            case Input.Keys.RIGHT:
                try {
                    spaceship.onKeyPressed(Input.Keys.RIGHT);
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
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
