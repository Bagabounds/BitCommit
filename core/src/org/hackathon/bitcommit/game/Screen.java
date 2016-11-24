package org.hackathon.bitcommit.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by codecadet on 24/11/16.
 */
public class Screen {

    private Vector3 position;
    private Vector3 velocity;

    private Texture image1;
    private Texture image2;
    private Texture image3;

    public Screen(int x, int y) {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        image1 = new Texture("core/assets/ship1.gif");
        image2 = new Texture("core/assets/ship1.gif");
        image3 = new Texture("core/assets/ship1.gif");
    }

    public void update(float delta){

        velocity.scl(delta);
        position.add(10, 0, 0);
        velocity.scl(1/delta);

    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getImage1() {
        return image1;
    }

    public Texture getImage2(){
        return image2;
    }

    public Texture getImage3(){
        return image3;
    }
}
