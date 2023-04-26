package com.mygdx.uspace1;

import static com.mygdx.uspace1.MainMenuScreen.*;

import com.badlogic.gdx.Gdx;

public class GameLogic {

    public static void movePlayer () {
        float x2 = pl.x;//pl.spr_cx; //Enemy's new X
        float y2 = pl.y;//pl.spr_cy; //Enemy's new Y
        float angle; // We use a triangle to calculate the new trajectory
        angle = (float) Math.atan2(pl.y_targ - pl.spr_cy, pl.x_targ - pl.spr_cx);
        float dx = (float) Math.cos(angle) * pl.speed * Gdx.graphics.getDeltaTime();
        float dy = (float) Math.sin(angle) * pl.speed * Gdx.graphics.getDeltaTime();
        pl.x_targ -= dx;
        pl.y_targ -= dy;
        scr_x -= dx;
        scr_y -= dy;
        pl.x += dx;
        pl.y += dy;
        if (scr_x>unit) {
            pl.x_map--;
            scr_x -= unit;
        }
        if (scr_x<0) {
            pl.x_map++;
            scr_x += unit;
        }
        if (scr_y>unit) {
            pl.y_map--;
            scr_y -= unit;
        }
        if (scr_y<0) {
            pl.y_map++;
            scr_y += unit;
        }
        // Move fons
        fon1_x -= dx/4;
        fon1_y -= dy/4;
        fon2_x -= dx/8;
        fon2_y -= dy/8;
        //Set enemy's new positions.
        /*pl.spr_cx = x2;
        pl.spr_cy = y2;
        pl.spr_x = pl.spr_cx - pl.spr_w / 2;
        pl.spr_y = pl.spr_cy - pl.spr_h / 2;*/
        if (Math.abs(pl.spr_cx-pl.x_targ)<1 && Math.abs(pl.spr_cy-pl.y_targ)<1) {
            pl.spr_cx = pl.x_targ;
            pl.spr_cy = pl.y_targ;
            pl.x_targ = 99999;
            pl.fly = false;
        }
    }

    public static void moveFons () {

    }
}
