package com.mygdx.uspace1.gamedraw;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import static com.mygdx.uspace1.MainMenuScreen.*;

public class GameDrawFuncs {

    // Draw button
    public static void drawEmptyButton (float x, float y, float w, float h, boolean sel) {
        int but_bord = 4;
        batch.end();
        sr.begin(ShapeRenderer.ShapeType.Filled);
        // Selected button
        if (sel) {
            sr.setColor(Color.WHITE);
            sr.rect(x - but_bord, y - but_bord, w + but_bord * 2, h + but_bord * 2);
            sr.setColor(Color.GRAY);
            sr.rect(x, y, w, h);
        }
        else { // Standard
            sr.setColor(Color.LIGHT_GRAY);
            sr.rect(x - but_bord, y - but_bord, w + but_bord * 2, h + but_bord * 2);
            sr.setColor(Color.DARK_GRAY);
            sr.rect(x, y - but_bord, w + but_bord, h + but_bord);
            sr.setColor(Color.GRAY);
            sr.rect(x, y, w, h);
        }
        sr.end();
        batch.begin();
    }

    // Draw button
    public static void drawButton (float x, float y, float w, float h, String title, BitmapFont f, boolean sel) {
        int but_bord = 4;
        batch.end();
        sr.begin(ShapeRenderer.ShapeType.Filled);
        // Selected button
        if (sel) {
            sr.setColor(Color.WHITE);
            sr.rect(x - but_bord, y - but_bord, w + but_bord * 2, h + but_bord * 2);
            sr.setColor(Color.GRAY);
            sr.rect(x, y, w, h);
        }
        else { // Standard
            sr.setColor(Color.LIGHT_GRAY);
            sr.rect(x - but_bord, y - but_bord, w + but_bord * 2, h + but_bord * 2);
            sr.setColor(Color.DARK_GRAY);
            sr.rect(x, y - but_bord, w + but_bord, h + but_bord);
            sr.setColor(Color.GRAY);
            sr.rect(x, y, w, h);
        }
        sr.end();
        batch.begin();
        // Draw button title
        layout1.setText(f, title);
        float t_width = layout1.width;// contains the width of the current set text
        float t_height = layout1.height; // contains the height of the current set text;
        drawString(f, title, x+(w-t_width)/2, y+t_height+(h-t_height)/2, 2);
    }

    // Draw Ico button
    public static void drawIcoButton (float x, float y, float w, float h, Texture ico, int ico_width, int ico_height, boolean sel) {
        int but_bord = 4;
        batch.end();
        sr.begin(ShapeRenderer.ShapeType.Filled);
        // Selected button
        if (sel) {
            sr.setColor(Color.WHITE);
            sr.rect(x - but_bord, y - but_bord, w + but_bord * 2, h + but_bord * 2);
            sr.setColor(Color.GRAY);
            sr.rect(x, y, w, h);
        }
        else { // Standard
            sr.setColor(Color.LIGHT_GRAY);
            sr.rect(x - but_bord, y - but_bord, w + but_bord * 2, h + but_bord * 2);
            sr.setColor(Color.DARK_GRAY);
            sr.rect(x, y - but_bord, w + but_bord, h + but_bord);
            sr.setColor(Color.GRAY);
            sr.rect(x, y, w, h);
        }
        sr.end();
        batch.begin();
        // Draw button ico
        if (ico != null)
            batch.draw (ico, x+(w-ico_width)/2, y, ico_width, ico_height);
    }

    // Draw string
    public static void drawString (BitmapFont f, String text, float x, float y, int sh) {
        // Draw text shadow
        f.setColor(Color.BLACK);
        f.draw(batch, text, x+sh, y-sh);
        f.setColor(Color.WHITE);
        f.draw(batch, text, x, y);
    }
}
