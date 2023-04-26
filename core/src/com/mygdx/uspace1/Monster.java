package com.mygdx.uspace1;

public class Monster {
    int id;
    int type;

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

    float speed;
    int max_life;
    int life;
    int strength;
}
