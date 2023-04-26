package com.mygdx.uspace1.gameres;

public class GameRes {
    GamePng gamePng;
    GameAnim gameAnim;
    public GameFonts gameFonts;
    public GameLocale gameLocale;

    public GameRes () {
        gamePng = new GamePng();
        gameAnim = new GameAnim();
        gameFonts = new GameFonts ();
        gameLocale = new GameLocale();
    }
}
