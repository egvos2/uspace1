package com.mygdx.uspace1.gameres;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.I18NBundle;

import java.util.Locale;

public class GameLocale {
    public static String s_dialog1; //
    public static String s_dialog2; //
    public static String s_but1; //
    public static String s_but2; //
    public static String s_but3; //
    public static String s_but4; //
    public static String s_text0; //
    public static String s_text1; //
    public static String s_text2; //
    // Languages
    public static String s_lang; //
    public static String s_lang1; //
    public static String s_lang2; //
    public static String s_lang3; //

    GameLocale () {
        loadLocale(0);
    }

    // Load locale
    public void loadLocale (int l) {
        Locale locale =new Locale("en");
        I18NBundle languageStrings = I18NBundle.createBundle(Gdx.files.internal("strings/strings"), locale);
        switch (l) {
            case 0:
                locale = new Locale("en");
                languageStrings = I18NBundle.createBundle(Gdx.files.internal("strings/strings"), locale);
                break;
            case 1:
                locale = new Locale("ru");
                languageStrings = I18NBundle.createBundle(Gdx.files.internal("strings/strings"), locale);
                break;
            case 2:
                locale = new Locale("jp");
                languageStrings = I18NBundle.createBundle(Gdx.files.internal("strings/strings"), locale);
                break;
        }
        s_dialog1 = languageStrings.get("dialog1");
        s_dialog2 = languageStrings.get("dialog2");
        s_but1 = languageStrings.get("but1");
        s_but2 = languageStrings.get("but2");
        s_but3 = languageStrings.get("but3");
        s_but4 = languageStrings.get("but4");
        s_text0 = languageStrings.get("text0");
        s_text1 = languageStrings.get("text1");
        s_text2 = languageStrings.get("text2");
        // Languages
        s_lang = languageStrings.get("lang");
        s_lang1 = languageStrings.get("lang1");
        s_lang2 = languageStrings.get("lang2");
        s_lang3 = languageStrings.get("lang3");
    }
}
