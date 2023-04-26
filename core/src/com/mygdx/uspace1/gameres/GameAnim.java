package com.mygdx.uspace1.gameres;

import static com.mygdx.uspace1.gameres.GamePng.*;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class GameAnim {
    // Ship 1
    public static Animation<TextureRegion> anim_ship1s;
    // Flame 1
    public static Animation<TextureRegion> anim_ship1f;
    // Asteroid 1
    public static Animation<TextureRegion> anim_ast1;

    GameAnim () {
        loadShip1Anim ();
        loadFlame1Anim ();
        loadAst1Anim ();
    }

    // Ship 1 animation
    private void loadShip1Anim () {
        TextureRegion[] tx_ship1s = new TextureRegion[5];
        tx_ship1s[0] = new TextureRegion(img_ship11s);
        tx_ship1s[1] = new TextureRegion(img_ship11s);
        tx_ship1s[2] = new TextureRegion(img_ship11s);
        tx_ship1s[3] = new TextureRegion(img_ship11s);
        tx_ship1s[4] = new TextureRegion(img_ship12s);
        anim_ship1s = new Animation<TextureRegion>(0.2f, tx_ship1s);
    }

    // Flame 1 animation
    private void loadFlame1Anim () {
        TextureRegion[] tx_ship1f = new TextureRegion[5];
        tx_ship1f[0] = new TextureRegion(img_ship11f);
        tx_ship1f[1] = new TextureRegion(img_ship12f);
        tx_ship1f[2] = new TextureRegion(img_ship13f);
        tx_ship1f[3] = new TextureRegion(img_ship14f);
        tx_ship1f[4] = new TextureRegion(img_ship15f);
        anim_ship1f = new Animation<TextureRegion>(0.2f, tx_ship1f);
    }

    // Asteroid 1 animation
    private void loadAst1Anim () {
        TextureRegion[] tx_ast1 = new TextureRegion[12];
        tx_ast1[0] = new TextureRegion(img_ast11);
        tx_ast1[1] = new TextureRegion(img_ast12);
        tx_ast1[2] = new TextureRegion(img_ast13);
        tx_ast1[3] = new TextureRegion(img_ast14);
        tx_ast1[4] = new TextureRegion(img_ast15);
        tx_ast1[5] = new TextureRegion(img_ast16);
        tx_ast1[6] = new TextureRegion(img_ast17);
        tx_ast1[7] = new TextureRegion(img_ast18);
        tx_ast1[8] = new TextureRegion(img_ast19);
        tx_ast1[9] = new TextureRegion(img_ast110);
        tx_ast1[10] = new TextureRegion(img_ast111);
        tx_ast1[11] = new TextureRegion(img_ast112);
        anim_ast1 = new Animation<TextureRegion>(0.2f, tx_ast1);
    }
}
