package org.hackathon.bitcommit.scrollable;

import org.hackathon.bitcommit.game.Game;

/**
 * Created by codecadet on 24/11/16.
 */
public class ScrollHandler {

    private Background bg1, bg2, bg3;

    public static final int SCROLL_SPEED = -100;


    public ScrollHandler() {
        bg1 = new Background(0,0, SCROLL_SPEED, "core/assets/backgroundslice1.jpg");
        bg2 = new Background(0, (int) (bg1.getPosition().y + Game.HEIGHT), SCROLL_SPEED, "core/assets/backgroundslice2.jpg");
        bg3 = new Background(0, (int) (bg2.getPosition().y + Game.HEIGHT), SCROLL_SPEED, "core/assets/backgroundslice3.jpg");
    }

    public void update(float delta){

        bg1.update(delta);
        bg2.update(delta);
        bg3.update(delta);

        if(bg1.isScrolledDown()){
            bg1.reset(bg3.getPosition().y + Game.HEIGHT);
        } else if(bg2.isScrolledDown()){
            bg2.reset(bg1.getPosition().y + Game.HEIGHT);
        } else if(bg3.isScrolledDown()){
            bg3.reset(bg2.getPosition().x + Game.HEIGHT);
        }

    }

    public Background getBg1() {
        return bg1;
    }

    public Background getBg2() {
        return bg2;
    }

    public Background getBg3() {
        return bg3;
    }
}
