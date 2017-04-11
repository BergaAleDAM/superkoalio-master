package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.game.Juego.Menu;
import com.mygdx.game.Juego.Superkoalio;

import Helpers.AssetManager;


public class SplashScreen implements Screen {

    private Stage stage;
    private Label.LabelStyle textStyle;


    private TextButton jugar;
    private TextButton.TextButtonStyle boton;
    private OrthographicCamera camara;
    private final Menu game;

    private long recordActual =0;


    public SplashScreen(final Menu game, long mensaje) {

        this.game =  game;

        camara = new OrthographicCamera();
        camara.setToOrtho(false, 30, 20);
        camara.update();

        stage = new Stage();


        stage.addActor(new Image(Helpers.AssetManager.background));
        boton = new TextButton.TextButtonStyle();
        boton.font = AssetManager.font;

        textStyle = new Label.LabelStyle(AssetManager.font, null);


        Container container = new Container();
        container.setTransform(true);
        container.center().setPosition(300,300);
        container.addAction(Actions.repeat(RepeatAction.FOREVER, Actions.sequence(Actions.scaleTo(1.5f, 1.5f, 1), Actions.scaleTo(1, 1, 1))));

        String record = String.valueOf(mensaje);

        if(mensaje == 0){
            record = "Iniciar Partida";
        }else{
            record = "Record Actual" + mensaje;
            if(mensaje > recordActual){
                recordActual = mensaje;
            }

        }

        jugar = new TextButton(record, boton);

        Container contJugar = new Container(jugar);
        contJugar.setTransform(true);
        contJugar.center().setPosition(350,250);


        stage.addActor(container);
        stage.addActor(contJugar);


        jugar.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                SplashScreen.this.game.setScreen(new Superkoalio(game));
            }
        });

        Gdx.input.setInputProcessor(stage);


    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        stage.draw();
        stage.act(delta);
        if (Gdx.input.isTouched()) {

        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }


}
