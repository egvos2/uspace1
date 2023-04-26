package com.mygdx.uspace1.gamedraw;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.uspace1.Item;
import com.mygdx.uspace1.Monster;
import com.mygdx.uspace1.Player;

import static com.mygdx.uspace1.MainGameScreen.*;
import static com.mygdx.uspace1.MainMenuScreen.*;
import static com.mygdx.uspace1.gamedraw.GameDrawAnim.*;
import static com.mygdx.uspace1.gameres.GameAnim.*;
import static com.mygdx.uspace1.gameres.GameFonts.*;
import static com.mygdx.uspace1.gameres.GameLocale.*;
import static com.mygdx.uspace1.gameres.GamePng.*;

public class GameDraw {

    // Draw Title
    public static void drawTitle () {
        drawFon2 ();
    }

    public static void drawTitleIntrf (int t) {
        float t_width;
        // Draw user panel
        batch.draw(gui_user_panel1, (cameraWidth-271)/2, (cameraHeight-294)/2);
        switch (t) {
            case 0:
                layout1.setText(game_font, s_dialog1);
                t_width = layout1.width;// contains the width of the current set text
                game_font.draw(batch, s_dialog1, (cameraWidth-t_width)/2, (cameraHeight-294)/2+270);
                // Draw description text
                layout1.setText(game_font, s_text0);
                t_width = layout1.width;// contains the width of the current set text
                game_font.draw(batch, s_text0, (cameraWidth-t_width)/2, (cameraHeight-294)/2-10);
                break;
            case 1:
                layout1.setText(game_font, s_dialog2);
                t_width = layout1.width;// contains the width of the current set text
                game_font.draw(batch, s_dialog2, (cameraWidth-t_width)/2, (cameraHeight-294)/2+270);
                // Draw description text
                layout1.setText(game_font, s_text1);
                t_width = layout1.width;// contains the width of the current set text
                game_font.draw(batch, s_text1, (cameraWidth-t_width)/2, (cameraHeight-294)/2-10);
                layout1.setText(game_font, s_text2);
                t_width = layout1.width;// contains the width of the current set text
                game_font.draw(batch, s_text2, (cameraWidth-t_width)/2, (cameraHeight-294)/2-25);
                break;
        }
        // Draw Title
        big_font.draw(batch, "Unstable Space", unit/2, cameraHeight-unit/2);
        // Draw version
        info_font.draw(batch, "v0.01.123", unit/2, cameraHeight-unit*3/4);
    }

    // Main Draw Func
    public static void drawGame () {
        drawFon1 ();
        drawFlyingStars ();
        drawBack();
        drawPlayer(pl, pl.spr_x, pl.spr_y);
    }

    // Draw fon1
    private static void drawFon1 () {
        //batch.draw(img_fon2, fon2_x, fon2_y, gm.map_w_orig/2, gm.map_h_orig/2);
        batch.draw(img_fon1, fon1_x, fon1_y, gm.map_w_orig, gm.map_h_orig);
    }

    // Draw fon2
    private static void drawFon2 () {
        batch.draw(img_fon2, fon2_x, fon2_y, img_fon2.getWidth(), img_fon2.getHeight());
    }

    // Draw background
    private static void drawBack () {
        int i, j, k, l, m;
        int start_y, end_y;
        int start_x, end_x;
        start_y = pl.y_map-screen_h/2-1;
        start_x = pl.x_map-screen_w/2-1;

        k = start_y;
        for (i=-1; i<screen_h+2; i++) {
            l = start_x;
            for (j = -1; j < screen_w+2; j++) {
                if (k>=0 && k< gm.map_h && l>=0 && l< gm.map_w) {
                    // Draw Items
                    for (m=0; m<gm.map[k][l].items.size(); m++) {
                        drawItem (gm.map[k][l].items.get(m), scr_x + j * unit, scr_y + i * unit);
                    }
                    // Draw Monsters
                    for (m=0; m<gm.map[k][l].monsters.size(); m++) {
                        drawMonster (gm.map[k][l].monsters.get(m), scr_x + j * unit, scr_y + i * unit);
                    }
                    // Draw Players
                    for (m=0; m<gm.map[k][l].players.size(); m++) {
                        drawPlayer (gm.map[k][l].players.get(m), scr_x + j * unit, scr_y + i * unit);
                    }
                }
                l++;
            }
            k++;
        }
    }

    // Draw flying stars
    public static void drawFlyingStars() {
        batch.end();
        sr.begin(ShapeRenderer.ShapeType.Filled);
        for (int i=0; i<nFlyingStars; i++) {
            int c = (int) stars[i][2];
            switch (c) {
                case 1:
                    sr.setColor(Color.LIGHT_GRAY);
                    break;
                case 2:
                    sr.setColor(Color.GRAY);
                    break;
                case 3:
                    sr.setColor(Color.DARK_GRAY);
                    break;
            }
            sr.rect(stars[i][0], stars[i][1], stars[i][2], stars[i][2]);
        }
        sr.end();
        batch.begin();
    }

    // Draw player
    private static void drawPlayer (Player player, float x, float y) {
        //batch.draw(txt_ship1, pl.spr_x, pl.spr_y, pl.spr_w/2, pl.spr_h/2, pl.spr_w, pl.spr_h, scl_x, scl_y, pl.rot);
        if (!player.fly)
            drawPlayerAnim (player, player.spr_x, player.spr_y, anim_ship1s);
        else
            drawPlayerAnim (player, player.spr_x, player.spr_y, anim_ship1f);
        // === Draw player life and def frames
        drawPlayerLifeFrame (player, player.spr_x, player.spr_y);
        drawPlayerDefFrame (player, player.spr_x, player.spr_y);
    }

    // === Draw player life frame ===
    private static void drawPlayerLifeFrame (Player player, float x, float y) {
        // Draw life row value
        float t1 = (float)(player.max_life) / 10;
        float t2 = (float)(player.life) / t1;
        if (t2<1) t2 = 1;
        float t0 = unit/10;
        int i;
        for (i = 0; i < t2; i++) {
            if (i<t2)
                batch.draw (img_life_frame2, x+i*t0, y+unit+unit/10, unit/10, 6);
            else
                batch.draw (img_life_frame2_emp, x+i*t0, y+unit+unit/10, unit/10, unit/6);
        }
    }

    // === Draw player defence frame ===
    private static void drawPlayerDefFrame (Player player, float x, float y) {
        // Draw life row value
        float t1 = (float)(player.max_defense) / 10;
        float t2 = (float)(player.defense) / t1;
        if (t2<1) t2 = 1;
        float t0 = unit/10;
        int i;
        for (i = 0; i < t2; i++) {
            if (i<t2)
                batch.draw (img_def_frame2, x+i*t0, y+unit, unit/10, 6);
            else
                batch.draw (img_def_frame2_emp, x+i*t0, y+unit, unit/10, unit/6);
        }
    }

    // Draw Item
    private static void drawItem (Item it, float x, float y) {
        drawItemAnim(it, x, y, anim_ast1);
    }

    // Draw Monster
    private static void drawMonster (Monster mo, float x, float y) {

    }

    // Draw debug info
    public static void drawDebugInfo () {
        font.draw(batch, "FPS: "+ Gdx.graphics.getFramesPerSecond(), 10, cameraHeight-20);
        font.draw(batch, "pl.x: "+ pl.x+" pl.y: "+ pl.y+" pl.x_map: "+ pl.x_map+" pl.y_map: "+ pl.y_map, 10, cameraHeight-40);
        font.draw(batch, "pl.rot: "+ pl.rot+" pl_rot: "+ pl_rot, 10, cameraHeight-60);
    }
}
