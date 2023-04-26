package com.mygdx.uspace1.gameres;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class GameFonts {
    public static BitmapFont big_font;
    public static BitmapFont info_font;
    public static BitmapFont game_font;

    GameFonts () {
        loadGameFont(0);
    }

    public void loadGameFont (int f) {
        big_font = new BitmapFont(Gdx.files.internal("fonts/olney24.fnt"));
        info_font = new BitmapFont(Gdx.files.internal("fonts/olney18.fnt"));
        switch (f) {
            case 0:
                game_font = new BitmapFont(Gdx.files.internal("fonts/arial15.fnt"));
                break;
            case 1:
                game_font = new BitmapFont(Gdx.files.internal("fonts/jp22.fnt"));
                break;
        }
    }
}
