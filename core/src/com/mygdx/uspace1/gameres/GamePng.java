package com.mygdx.uspace1.gameres;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class GamePng {

    GamePng () {
        loadPng();
    }

    // Load Png
    private void loadPng () {
        loadFons ();
        loadShip1Png();
        loadShip1Flame ();
        loadAstPng();
        loadGameInterface ();
        loadMonstersPng ();
        loadGUI ();
        loadIcons ();
    }

    // Fons
    public static Texture img_fon1; // Fon 1
    public static Texture img_fon2; // Fon 1

    // Load fons
    private void loadFons () {
        img_fon1 = new Texture("png/fons/1_50.png");
        img_fon2 = new Texture("png/fons/4.png");
    }

    // Ship 1 stop
    public static Texture img_ship11s; // Ship 1
    public static Texture img_ship12s; // Ship 1

    // Load ship png
    private void loadShip1Png () {
        img_ship11s = new Texture("png/ship1/ship11s.png");
        img_ship12s = new Texture("png/ship1/ship12s.png");
    }

    // Ship flame1
    public static Texture img_ship11f;
    public static Texture img_ship12f;
    public static Texture img_ship13f;
    public static Texture img_ship14f;
    public static Texture img_ship15f;

    private void loadShip1Flame () {
        img_ship11f = new Texture("png/ship1/ship11f.png");
        img_ship12f = new Texture("png/ship1/ship12f.png");
        img_ship13f = new Texture("png/ship1/ship13f.png");
        img_ship14f = new Texture("png/ship1/ship14f.png");
        img_ship15f = new Texture("png/ship1/ship15f.png");
    }

    // Asteroid 1
    public static Texture img_ast11;
    public static Texture img_ast12;
    public static Texture img_ast13;
    public static Texture img_ast14;
    public static Texture img_ast15;
    public static Texture img_ast16;
    public static Texture img_ast17;
    public static Texture img_ast18;
    public static Texture img_ast19;
    public static Texture img_ast110;
    public static Texture img_ast111;
    public static Texture img_ast112;

    // Load asteroid 1
    private void loadAstPng() {
        img_ast11 = new Texture("png/asteroid1/ast11.png");
        img_ast12 = new Texture("png/asteroid1/ast12.png");
        img_ast13 = new Texture("png/asteroid1/ast13.png");
        img_ast14 = new Texture("png/asteroid1/ast14.png");
        img_ast15 = new Texture("png/asteroid1/ast15.png");
        img_ast16 = new Texture("png/asteroid1/ast16.png");
        img_ast17 = new Texture("png/asteroid1/ast17.png");
        img_ast18 = new Texture("png/asteroid1/ast18.png");
        img_ast19 = new Texture("png/asteroid1/ast19.png");
        img_ast110 = new Texture("png/asteroid1/ast110.png");
        img_ast111 = new Texture("png/asteroid1/ast111.png");
        img_ast112 = new Texture("png/asteroid1/ast112.png");
    }

    // Life frame
    public static Texture img_life_frame2;
    public static Texture img_life_frame2_emp;
    public static Texture img_def_frame2;
    public static Texture img_def_frame2_emp;

    // Load game interface
    private void loadGameInterface () {
        img_life_frame2 = new Texture("png/intrf/life_frame10_6.png");
        img_life_frame2_emp = new Texture("png/intrf/life_frame10_6_emp.png");
        img_def_frame2 = new Texture("png/intrf/def_frame10_6.png");
        img_def_frame2_emp = new Texture("png/intrf/def_frame10_6_emp.png");
    }

    public static Texture img_mon1; // Mon 1

    // Load monsters
    private void loadMonstersPng () {
        img_mon1 = new Texture("png/mons/mon1.png");
    }

    public static Texture gui_edit_field1; //
    public static Texture gui_but1; //
    public static Texture gui_but2; //
    public static Texture gui_but_l; //
    public static Texture gui_but_r; //
    public static Texture gui_user_panel1; //

    private void loadGUI () {
        gui_edit_field1 = new Texture("png/gui/editfield1.png");
        gui_but1 = new Texture("png/gui/but1.png");
        gui_but2 = new Texture("png/gui/but2.png");
        gui_but_l = new Texture("png/gui/but_l.png");
        gui_but_r = new Texture("png/gui/but_r.png");
        gui_user_panel1 = new Texture("png/gui/userpanel2.png");
    }

    // Load icons
    public static Texture ico_fb1; //
    public static Texture ico_inst1; //
    public static Texture ico_tg1; //
    public static Texture ico_tt1; //
    public static Texture ico_tw1; //
    public static Texture ico_yt1; //

    private void loadIcons () {
        ico_fb1 = new Texture("png/icons/fb1.png");
        ico_inst1 = new Texture("png/icons/inst1.png");
        ico_tg1 = new Texture("png/icons/tg1.png");
        ico_tt1 = new Texture("png/icons/tt1.png");
        ico_tw1 = new Texture("png/icons/tw1.png");
        ico_yt1 = new Texture("png/icons/yt1.png");
    }
}
