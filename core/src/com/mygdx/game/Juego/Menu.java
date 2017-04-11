package com.mygdx.game.Juego;

import com.badlogic.gdx.Game;
import com.mygdx.game.Screens.SplashScreen;

import Helpers.AssetManager;

/**
 * Created by Alejandro on 10/04/2017.
 */

public class Menu extends Game {

    private AssetManager am;
/*
    public Menu(long record) {
        am.load();
        setScreen(new SplashScreen(this,record));

    }*/

    @Override
    public void create() {
        am.load();
        setScreen(new SplashScreen(this, 0));
    }


}
