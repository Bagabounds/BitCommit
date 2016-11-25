package org.hackathon.bitcommit.states;

/**
 * Created by codecadet on 24/11/16.
 */

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import org.hackathon.bitcommit.game.Game;


public class Hud implements Disposable{

    public static int score;
    //Scene2D.ui Stage and its own Viewport for HUD
    public Stage stage;
    private Viewport viewport;

     //time Tracking Variables
    private int worldTimer;
    private boolean isDead; // true when the one player dies;

    //score variables
    private int scoreP1 = 1;
    private int scoreP2 = 1;

    //Scene2D widgets
    private Label countdownLabel;
    private Label timeLabel;
    //private Label levelLabel;
    //private Label worldLabel;
    private Label player1Label;
    private Label player2Label;
    private static Label scoreP1Label;
    private Label scoreP2Label;
    private float timeCount;
    private boolean timeUp;


    public Hud(SpriteBatch sb){
        //define our tracking variables
        worldTimer = 300;


        //setup the HUD viewport using a new camera seperate from our gamecam
        //define our stage using that viewport and our games spritebatch
        viewport = new FitViewport(Game.WIDTH, Game.HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sb);

        //define a table used to organize our hud's labels
        Table table = new Table();
        //Top-Align table
        table.top();
        //make the table fill the entire stage
        table.setFillParent(true);

        //define our labels using the String, and a Label style consisting of a font and color
        countdownLabel = new Label(String.format("%03d", worldTimer), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        timeLabel = new Label("TIME", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        player1Label = new Label("Score", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        player2Label = new Label("Opponent Score", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        scoreP1Label = new Label(String.format("%03d", score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
//


        //add our labels to our table, padding the top, and giving them all equal width with expandX
        table.add(player1Label).expandX().padTop(10);
        table.add(timeLabel).expandX().padTop(10);
        table.add(player2Label).expandX().padTop(10);
        //table.add(worldLabel).expandX().padTop(10);


        //add a second row to our table
        table.row();
        table.add(scoreP1Label).expandX();
        table.add(countdownLabel).expandX();
        table.add(scoreP2Label).expandX();

        //add our table to the stage
        stage.addActor(table);

    }

    public void update(float dt){
       timeCount += dt;
        if(timeCount >= 1){
            if (worldTimer > 0) {
               worldTimer--;
           } else {
               timeUp = true;
           }
            countdownLabel.setText(String.format("%03d", worldTimer));
           timeCount = 0;
        }
   }

    public static void addScore(int value){
        score += value;
        scoreP1Label.setText(String.format("%03d", score));
    }

    @Override
    public void dispose() { stage.dispose(); }}


