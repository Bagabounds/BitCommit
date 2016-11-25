package org.hackathon.bitcommit.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import org.hackathon.bitcommit.game.Game;

/**
 * Created by codecadet on 24/11/16.
 */
public class Spaceship {

    private Vector3 position;
    private Vector3 velocity;
    private Texture texture;

    private Rectangle rectangle;

    public Spaceship(int x, int y) {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        texture = new Texture("core/assets/resizewithouterglow.png");
        rectangle = new Rectangle(x, y, texture.getWidth(), texture.getHeight());
    }

    public void onKeyPressed(int input) {
        if (input == 21) {
            // LEFT

            if (velocity.x <= -240) {
                return;
            } else {
                velocity.x -= 60;
            }

            Gdx.app.log("velocity.x = ", velocity.x + "");

        } else if (input == 22) {
            // RIGHT

            if (velocity.x >= 240) {
                return;
            } else {
                velocity.x += 60;
            }

            Gdx.app.log("velocity.x = ", velocity.x + "");

            // todo: implementar logica UP para quando recebe power up

        }
    }

/*    public void onKeyPressed(int input) {
        if (input == 21) {
            // LEFT

            if (velocity.x > 0) {
                velocity.x = 0;
            } else if (velocity.x <= -240) {
                return;
            } else {
                velocity.x -= 60;
            }

            Gdx.app.log("velocity.x = ", velocity.x + "");

        } else if (input == 22) {
            // RIGHT

            if (velocity.x < 0) {
                velocity.x = 0;
            } else if (velocity.x >= 240) {
                return;
            } else {
                velocity.x += 60;
            }

            Gdx.app.log("velocity.x = ", velocity.x + "");

        }
    }*/

    public void update(float delta) {

/*        if (velocity.x > 0) {
            velocity.x -= 2;
        } else if (velocity.x < 0) {
            velocity.x += 2;
        }*/

        position.add(velocity.cpy().scl(delta));

        if (position.x >= Game.WIDTH - texture.getWidth()) {
            position.set(Game.WIDTH - texture.getWidth(), 50, 0);
            velocity.x = 0;
        } else if (position.x <= 0) {
            position.set(0, 50, 0);
            velocity.x = 0;
        }

        rectangle.setPosition(position.x, position.y);

    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return texture;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
