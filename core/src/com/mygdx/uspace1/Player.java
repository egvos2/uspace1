package com.mygdx.uspace1;

import static com.mygdx.uspace1.MainMenuScreen.*;

import com.badlogic.gdx.math.MathUtils;

public class Player {
    int id;
    public float spr_w; // Ship sprite width
    public float spr_h; // Ship sprite height
    public float spr_x;
    public float spr_y;
    public float spr_cx; // Sprite center x coord
    public float spr_cy; // Sprite center y coord

    public float rot;

    public float frame_anim_state;

    public float x, y; // Global Map coordinates
    public int x_map, y_map; // Array Map coordinates
    public float x_targ, y_targ; // Target coords

    public float speed;

    public int max_life;
    public int life;
    public int max_defense;
    public int defense;
    public int strength;

    public boolean fly;

    /*public boolean b_fly;
    public float spr_y_delta;
    public float spr_y_iter;*/

    Player () {
        spr_w = 100;
        spr_h = 100;

        rot = 0;

        frame_anim_state = 0;

        fly = false;

        x_targ = y_targ = 99999;

        max_life = MathUtils.random(1000, 1500);
        life = max_life;
        max_defense = MathUtils.random(500, 1000);
        defense = max_defense;
        strength = MathUtils.random(100, 300);
    }

    // Player start parameters
    public void setPlayerStartParams () {
        x = gm.map_w_orig/2-unit/2;
        y = gm.map_h_orig/2-unit/2;
        x_map = (int) (x/unit);
        y_map = (int) (y/unit);
        speed = unit;
    }

    // Calculate player screen params
    public void calcPlayerScreenParams () {
        spr_cx = cameraWidth/2; // 750
        spr_cy = cameraHeight/2; // 450
        spr_x = spr_cx-spr_w/2;
        spr_y = spr_cy-spr_h/2;
    }
}
