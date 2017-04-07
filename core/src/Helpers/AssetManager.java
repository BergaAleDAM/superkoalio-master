package Helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Superkoalio;

public  class AssetManager {


    private static  Texture koalaTexture;
    public static Animation<TextureRegion> stand, jump,walk;


    public static void load(){

        koalaTexture = new Texture("koalio.png");
        TextureRegion[] regions = TextureRegion.split(koalaTexture, 18, 26)[0];
        stand = new Animation(0, regions[0]);
        jump = new Animation(0, regions[1]);
        walk = new Animation(0.15f, regions[2], regions[3], regions[4]);
        walk.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);


        Superkoalio.Koala.WIDTH = 1 / 16f * regions[0].getRegionWidth();
        Superkoalio.Koala.HEIGHT = 1 / 16f * regions[0].getRegionHeight();

    }
    }
