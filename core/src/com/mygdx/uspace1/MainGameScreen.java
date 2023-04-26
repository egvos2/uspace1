package com.mygdx.uspace1;

import static com.mygdx.uspace1.GameLogic.*;
import static com.mygdx.uspace1.MainMenuScreen.*;
import static com.mygdx.uspace1.USpace1.getRandomNumberInRange;
import static com.mygdx.uspace1.gamedraw.GameDraw.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MainGameScreen implements Screen, InputProcessor {
    final USpace1 game;
    private OrthographicCamera camera;
    private Viewport viewport;

    // Player rotation
    public static float pl_rot;
    public static boolean pl_rotation = false;
    public static int pl_rot_iter = 0;
    public static float pl_rot_delta;

    public MainGameScreen(final USpace1 game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, cameraWidth, cameraHeight);
        viewport = new FitViewport(cameraWidth, cameraHeight, camera);
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.1f, 1);
        batch.begin();
        drawGame ();
        drawDebugInfo ();
        batch.end();

        // Game logic
        logic ();
    }

    // Game logic
    private void logic () {
        //
        if (pl.x_targ != 99999) {
            movePlayer ();

        }
        // Move flying stars
        for (int i=0; i<nFlyingStars; i++) {
            stars[i][0] += 1/stars[i][3];
            stars[i][1] -= 1/stars[i][3];
            if (stars[i][0]>cameraWidth || stars[i][1]<=0) {
                if (stars[i][4] == 1) {
                    stars[i][0] = getRandomNumberInRange(10, (int) (cameraWidth - 10)); // x coord
                    stars[i][1] = (int) cameraHeight; // y coord
                } else {
                    stars[i][0] = 0; // x coord
                    stars[i][1] = getRandomNumberInRange(10, (int) (cameraHeight - 10)); // y coord
                }
            }
        }
        // Rotate player ship
        if (pl_rot != -pl.rot) {
            if (!pl_rotation) {
                pl_rotation = true;
                pl_rot_iter = 15;
                float norm_pl_rot = -pl.rot;
                float d;
                if (pl_rot>norm_pl_rot) {
                    d = pl_rot-norm_pl_rot;
                    if (d>180) {
                        //pl.rot += pl_rot_delta;
                        pl_rot_delta = (360-d)/pl_rot_iter;
                    } else {
                        pl_rot_delta = d/pl_rot_iter;
                        pl_rot_delta = -pl_rot_delta;
                    }
                } else {
                    d = norm_pl_rot-pl_rot;
                    pl_rot_delta = d/pl_rot_iter;
                    if (d>180) {
                        pl_rot_delta = (360-d)/pl_rot_iter;
                        pl_rot_delta = -pl_rot_delta;
                    } else {
                        pl_rot_delta = d/pl_rot_iter;
                        //pl.rot += pl_rot_delta;
                    }
                }
                pl.rot += pl_rot_delta;
                pl_rot_iter--;
            } else {
                if (pl_rot_iter<=0) {
                    pl.rot = -pl_rot;
                    pl_rotation = false;
                    pl_rot_delta = 0;
                } else {
                    pl.rot += pl_rot_delta;
                    if (pl.rot>0)
                        pl.rot -= 360;
                    pl_rot_iter--;
                }
            }
        }
        // Anim stoped ship
        /*if (!pl.b_fly) {
            pl.spr_y_delta += pl.spr_y_iter;
            if (pl.spr_y_delta>2 || pl.spr_y_delta<-2)
                pl.spr_y_iter = -pl.spr_y_iter;
        }*/
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

    @Override
    public boolean keyDown(int keycode) {
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
        // Convert to camera coordinates
        Vector3 touch = new Vector3();
        touch.set((float)(screenX), (float)(screenY), 0);
        camera.unproject(touch);
        // Set target point
        pl.x_targ = touch.x;
        pl.y_targ = touch.y;
        // Calculate player ship rotation
        Vector2 center = new Vector2(pl.spr_cx, pl.spr_cy);
        Vector2 point1 = new Vector2(center.x, center.y + unit);
        Vector2 point2 = new Vector2(touch.x, touch.y);

        point1.sub(center).nor();
        point2.sub(center).nor();

        pl_rot = (MathUtils.atan2(point1.y, point1.x) - MathUtils.atan2(point2.y, point2.x));
        pl_rot *= MathUtils.radiansToDegrees;
        if (pl_rot<0)
            pl_rot = 360+pl_rot;

        pl.fly = true;
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
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
