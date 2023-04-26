package com.mygdx.uspace1;

import static com.mygdx.uspace1.MainMenuScreen.*;
import static com.mygdx.uspace1.gameres.GameFonts.*;
import static com.mygdx.uspace1.gameres.GameLocale.*;
import static com.mygdx.uspace1.gameres.GamePng.*;
import static com.mygdx.uspace1.USpace1.*;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.uspace1.gamenet.LGq;
import com.mygdx.uspace1.gamenet.SRq;

public class GameInterface {
    TextButton but1;
    TextButton but11;
    TextButton but2;
    TextButton.TextButtonStyle  tb_style;
    TextButton.TextButtonStyle tb_style_2;
    TextButton but_ico1; // Instagram
    TextButton but_ico2; // Tik-Tok
    TextButton but_ico3; // FB
    TextButton but_ico4; // Twitter
    TextButton but_ico5; // YouTube
    TextButton but_ico6; // Telegram

    public void createLoginPanel (Table tab) {
        TextField.TextFieldStyle tf_style = new TextField.TextFieldStyle();
        tf_style.font = game_font;
        tf_style.fontColor = Color.LIGHT_GRAY;
        //NinePatch np = new NinePatch(img_edit_field1, 8, 8, 8, 8);
        tf_style.background = new Image(gui_edit_field1).getDrawable();
        // Login
        final TextField field1 = new TextField("", tf_style);
        field1.setText("Login");
        field1.setWidth(209);
        field1.setHeight(35);
        tab.add(field1).expandX().padTop(10);
        tab.row();
        // Password
        final TextField field2 = new TextField("", tf_style);
        field2.setText("");
        field2.setPasswordMode(true);
        field2.setWidth(209);
        field2.setHeight(35);
        tab.add(field2).expandX().padTop(10);
        // Login button
        tab.row();
        tb_style = new TextButton.TextButtonStyle();
        tb_style.font = game_font;
        tb_style.fontColor = Color.LIGHT_GRAY;
        tb_style.up = new Image(gui_but1).getDrawable();
        tb_style.down = new Image(gui_but1).getDrawable();
        tb_style.checked = new Image(gui_but1).getDrawable();
        but1 = new TextButton("", tb_style);
        if (login_type == 1)
            but1.setText(s_but3);
        else
            but1.setText(s_but1);
        but1.setWidth(80);
        but1.setHeight(35);
        tab.add(but1).expandX().padTop(10);
        but1.addListener(new ChangeListener() {
            public void changed (ChangeListener.ChangeEvent event, Actor actor) {
                /*LGq lgq = new LGq();
                lgq.name = field1.getText();
                lgq.pass = field2.getText();
                if (login_type == 0) {
                    lgq.type = 0;
                } else {
                    lgq.type = 1;
                }
                gameNet.client.sendTCP(lgq);*/
                game.setScreen(new MainGameScreen(game));
            }
        });
        tab.row();
        but11 = new TextButton("", tb_style);
        if (login_type == 1)
            but11.setText(s_but4);
        else
            but11.setText(s_but2);
        but11.setWidth(80);
        but11.setHeight(35);
        tab.add(but11).expandX().padTop(10);
        but11.addListener(new ChangeListener() {
            public void changed (ChangeListener.ChangeEvent event, Actor actor) {
                if (login_type == 0) {
                    login_type = 1;
                    but1.setText(s_but3);
                    but11.setText(s_but4);
                } else {
                    login_type = 0;
                    but1.setText(s_but1);
                    but11.setText(s_but2);
                }
            }
        });

    }

    // Create language panel
    public void createLanguagePanel (Table tab) {
        // Button left
        TextButton.TextButtonStyle tb_style_l = new TextButton.TextButtonStyle();
        tb_style_l.font = game_font;
        tb_style_l.fontColor = Color.LIGHT_GRAY;
        tb_style_l.up = new Image(gui_but_l).getDrawable();
        tb_style_l.down = new Image(gui_but_l).getDrawable();
        tb_style_l.checked = new Image(gui_but_l).getDrawable();
        final TextButton but_l = new TextButton("", tb_style_l);
        but_l.setText("");
        but_l.setWidth(46);
        but_l.setHeight(45);
        tab.add(but_l);
        // Button language
        tb_style_2 = new TextButton.TextButtonStyle();
        tb_style_2.font = game_font;
        tb_style_2.fontColor = Color.LIGHT_GRAY;
        tb_style_2.up = new Image(gui_but2).getDrawable();
        tb_style_2.down = new Image(gui_but2).getDrawable();
        tb_style_2.checked = new Image(gui_but2).getDrawable();
        but2 = new TextButton("", tb_style_2);
        switch (lang) {
            case 0:
                but2.setText(s_lang1);
                break;
            case 1:
                but2.setText(s_lang2);
                break;
            case 2:
                but2.setText(s_lang3);
                break;
        }
        but2.setWidth(150);
        but2.setHeight(53);
        tab.add(but2);
        // Button right
        TextButton.TextButtonStyle tb_style_r = new TextButton.TextButtonStyle();
        tb_style_r.font = game_font;
        tb_style_r.fontColor = Color.LIGHT_GRAY;
        tb_style_r.up = new Image(gui_but_r).getDrawable();
        tb_style_r.down = new Image(gui_but_r).getDrawable();
        tb_style_r.checked = new Image(gui_but_r).getDrawable();
        final TextButton but_r = new TextButton("", tb_style_r);
        but_r.setText("");
        but_r.setWidth(46);
        but_r.setHeight(45);
        tab.add(but_r);
        // Add left but listener
        but_l.addListener(new ChangeListener() {
            public void changed (ChangeListener.ChangeEvent event, Actor actor) {
                lang--;
                if (lang<0) lang = 2;
                gr.gameLocale.loadLocale(lang);
                changeLocale();
            }
        });
        // Add left but listener
        but_r.addListener(new ChangeListener() {
            public void changed (ChangeListener.ChangeEvent event, Actor actor) {
                lang++;
                if (lang>2) lang = 0;
                changeLocale();
            }
        });
    }

    private void changeLocale () {
        gr.gameLocale.loadLocale(lang);
        switch (lang) {
            case 0:
                gr.gameFonts.loadGameFont(0);
                tb_style_2.font = game_font;
                but2.setStyle(tb_style_2);
                but2.setText(s_lang1);
                tb_style.font = game_font;
                but1.setStyle(tb_style);
                but1.setText(s_but1);
                break;
            case 1:
                gr.gameFonts.loadGameFont(0);
                tb_style_2.font = game_font;
                but2.setStyle(tb_style_2);
                but2.setText(s_lang2);
                tb_style.font = game_font;
                but1.setStyle(tb_style);
                but1.setText(s_but1);
                break;
            case 2:
                gr.gameFonts.loadGameFont(1);
                tb_style_2.font = game_font;
                but2.setStyle(tb_style_2);
                but2.setText(s_lang3);
                tb_style.font = game_font;
                but1.setStyle(tb_style);
                but1.setText(s_but1);
                break;
        }
    }

    // Create language panel
    public void createSocialPanel (Table tab) {
        TextButton.TextButtonStyle tb_style1 = new TextButton.TextButtonStyle();
        tb_style1.font = game_font;
        tb_style1.fontColor = Color.LIGHT_GRAY;
        tb_style1.up = new Image(ico_inst1).getDrawable();
        tb_style1.down = new Image(ico_inst1).getDrawable();
        tb_style1.checked = new Image(ico_inst1).getDrawable();
        but_ico1 = new TextButton("", tb_style1);
        but_ico1.setText("");
        but_ico1.setWidth(80);
        but_ico1.setHeight(80);
        tab.add(but_ico1);
        tab.row();
        TextButton.TextButtonStyle tb_style2 = new TextButton.TextButtonStyle();
        tb_style2.font = game_font;
        tb_style2.fontColor = Color.LIGHT_GRAY;
        tb_style2.up = new Image(ico_tt1).getDrawable();
        tb_style2.down = new Image(ico_tt1).getDrawable();
        tb_style2.checked = new Image(ico_tt1).getDrawable();
        but_ico2 = new TextButton("", tb_style2);
        but_ico2.setText("");
        but_ico2.setWidth(80);
        but_ico2.setHeight(80);
        tab.add(but_ico2);
        tab.row();
        TextButton.TextButtonStyle tb_style3 = new TextButton.TextButtonStyle();
        tb_style3.font = game_font;
        tb_style3.fontColor = Color.LIGHT_GRAY;
        tb_style3.up = new Image(ico_fb1).getDrawable();
        tb_style3.down = new Image(ico_fb1).getDrawable();
        tb_style3.checked = new Image(ico_fb1).getDrawable();
        but_ico3 = new TextButton("", tb_style3);
        but_ico3.setText("");
        but_ico3.setWidth(80);
        but_ico3.setHeight(80);
        tab.add(but_ico3);
        tab.row();
        TextButton.TextButtonStyle tb_style4 = new TextButton.TextButtonStyle();
        tb_style4.font = game_font;
        tb_style4.fontColor = Color.LIGHT_GRAY;
        tb_style4.up = new Image(ico_tw1).getDrawable();
        tb_style4.down = new Image(ico_tw1).getDrawable();
        tb_style4.checked = new Image(ico_tw1).getDrawable();
        but_ico4 = new TextButton("", tb_style4);
        but_ico4.setText("");
        but_ico4.setWidth(80);
        but_ico4.setHeight(80);
        tab.add(but_ico4);
        tab.row();
        TextButton.TextButtonStyle tb_style5 = new TextButton.TextButtonStyle();
        tb_style5.font = game_font;
        tb_style5.fontColor = Color.LIGHT_GRAY;
        tb_style5.up = new Image(ico_yt1).getDrawable();
        tb_style5.down = new Image(ico_yt1).getDrawable();
        tb_style5.checked = new Image(ico_yt1).getDrawable();
        but_ico5 = new TextButton("", tb_style5);
        but_ico5.setText("");
        but_ico5.setWidth(80);
        but_ico5.setHeight(80);
        tab.add(but_ico5);
        tab.row();
        TextButton.TextButtonStyle tb_style6 = new TextButton.TextButtonStyle();
        tb_style6.font = game_font;
        tb_style6.fontColor = Color.LIGHT_GRAY;
        tb_style6.up = new Image(ico_tg1).getDrawable();
        tb_style6.down = new Image(ico_tg1).getDrawable();
        tb_style6.checked = new Image(ico_tg1).getDrawable();
        but_ico6 = new TextButton("", tb_style6);
        but_ico6.setText("");
        but_ico6.setWidth(80);
        but_ico6.setHeight(80);
        tab.add(but_ico6);
    }
}
