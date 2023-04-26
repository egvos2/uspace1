package com.mygdx.uspace1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import static com.mygdx.uspace1.GameLogic.movePlayer;
import static com.mygdx.uspace1.USpace1.*;
import static com.mygdx.uspace1.gamedraw.GameDraw.*;
import static com.mygdx.uspace1.gameres.GameFonts.*;
import static com.mygdx.uspace1.gameres.GamePng.*;

import java.util.LinkedList;

public class MainMenuScreen implements Screen, InputProcessor {

    public static USpace1 game;
    private OrthographicCamera camera;
    private Viewport viewport;
    public static SpriteBatch batch;
    public static ShapeRenderer sr;

    private Stage stage;
    private Table table;
    private Table table2;
    private Table table3;

    public static GameMap gm;
    public static Player pl;

    static LinkedList<Player> players = new LinkedList<Player>();
    static LinkedList<Monster> monsters = new LinkedList<Monster>();
    static LinkedList<Item> items = new LinkedList<Item>();

    public static float cameraWidth, cameraHeight;
    public static float unit, unit2;
    public static float scl;
    public static float scr_x, scr_y;
    public static float fon1_x, fon1_y, fon1_w, fon1_h;
    public static float fon2_x, fon2_y;

    public static int screen_w, screen_h; //

    public static BitmapFont font;
    public static GlyphLayout layout1;

    // Language
    public static int lang = 0; // Eng
    // Interface login type
    public static int login_type;

    // Flying stars
    public static int nFlyingStars = 30;
    public static float stars [][];

    public MainMenuScreen(final USpace1 game) {
        this.game = game;

        camera = new OrthographicCamera();
        batch = new SpriteBatch();
        sr = new ShapeRenderer();

        font = new BitmapFont();
        layout1 = new GlyphLayout();
        layout1.setText(font, "999/999");

        // Calculate common game params
        calcScreenParams();

        camera.setToOrtho(false, cameraWidth, cameraHeight);
        viewport = new FitViewport(cameraWidth, cameraHeight, camera);
        stage = new Stage(new ScreenViewport());
        //Gdx.input.setInputProcessor(this);
        Gdx.input.setInputProcessor(stage);

        // User panel table
        table = new Table();
        table.setFillParent(true);
        stage.addActor(table);
        //table.setDebug(true); // This is optional, but enables debug lines for tables.
        GameInterface gameInterface = new GameInterface();
        gameInterface.createLoginPanel(table);
        stage.addActor(table);

        // Language table
        table2 = new Table();
        //table2.setFillParent(true);
        //table2.setDebug(true); // This is optional, but enables debug lines for tables.
        table2.setPosition(150,50);
        gameInterface.createLanguagePanel(table2);
        stage.addActor(table2);
        // Social network table
        table3 = new Table();
        table3.setPosition(50,450);
        gameInterface.createSocialPanel (table3);
        stage.addActor(table3);

        // Create Map
        gm = new GameMap();
        gm.getMapStartParams();
        gm.createMap ();

        // Init player
        pl = new Player();
        pl.setPlayerStartParams();
        pl.calcPlayerScreenParams();

        // Calc fon params
        fon1_x = -pl.x_map*unit/4;//(gm.map_w_orig-cameraWidth)/-2;
        fon1_y = -pl.y_map*unit/4;//(gm.map_h_orig-cameraHeight)/-2;
        fon2_x = -unit;//(gm.map_w_orig-cameraWidth)/-2;
        fon2_y = -unit;

        // Init flying stars
        stars = new float[nFlyingStars][5];
        for (int i=0; i<nFlyingStars; i++) {
            stars[i][0] = getRandomNumberInRange(10, (int) (cameraWidth-10)); // x coord
            stars[i][1] = getRandomNumberInRange(10, (int) (cameraHeight-10)); // y coord
            stars[i][2] = getRandomNumberInRange(1, 3); // color
            stars[i][3] = getRandomNumberInRange(3, 4); // speed
            stars[i][4] = getRandomNumberInRange(1, 2); // side
        }
    }

    // Calc screen params
    private void calcScreenParams () {
        cameraWidth = Gdx.graphics.getWidth(); // 13
        cameraHeight = Gdx.graphics.getHeight(); // 9
        unit = 100;
        scl = 1;
        unit2 = unit*2;
        screen_w = (int)(cameraWidth/unit);
        screen_h = (int)(cameraHeight/unit);
        scr_x = unit/2;
        scr_y = unit/2;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.5f, 1);
        batch.begin();
        drawTitle ();
        drawFlyingStars ();
        drawTitleIntrf (login_type);
        //drawDebugInfo ();
        batch.end();
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
        // Game logic
        logic ();
    }

    // Game logic
    private void logic () {
        // Move flying stars
        for (int i = 0; i < nFlyingStars; i++) {
            stars[i][0] += 1 / stars[i][3];
            stars[i][1] -= 1 / stars[i][3];
            if (stars[i][0] > cameraWidth || stars[i][1] <= 0) {
                if (stars[i][4] == 1) {
                    stars[i][0] = getRandomNumberInRange(10, (int) (cameraWidth - 10)); // x coord
                    stars[i][1] = (int) cameraHeight; // y coord
                } else {
                    stars[i][0] = 0; // x coord
                    stars[i][1] = getRandomNumberInRange(10, (int) (cameraHeight - 10)); // y coord
                }
            }
        }
    }

    @Override
    public void resize(int width, int height) {
        // See below for what true means.
        //calcScreenParams();
        stage.getViewport().update(width, height, true);
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
        stage.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.ENTER:
                game.setScreen(new MainGameScreen(game));
                dispose();
                break;
            case Input.Keys.S:
                break;
            case Input.Keys.A:
                break;
            case Input.Keys.D:
                break;
        }
        return false;
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
        // Convert to camera coordinates
        Vector3 touch = new Vector3();
        touch.set((float)(screenX), (float)(screenY), 0);
        camera.unproject(touch);
        //
        if (touch.x<cameraWidth/2) {
            if (fon2_x<0)
                fon2_x += 1;
        }
        if (touch.x>cameraWidth/2) {
            if (fon2_x>-unit*2)
                fon2_x -= 1;
        }
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        /*if (amountY == -1) {
            scl += 0.1f;
            if (scl >= 2)
                scl = 2;
        }
        if (amountY == 1) {
            scl -= 0.1f;
            if (scl <= 0.5f)
                scl = 0.5f;
        }
        recalcScreenParams ();*/
        return false;
    }
}
