package com.mygdx.uspace1.gamedraw;

import static com.mygdx.uspace1.MainMenuScreen.*;
import static com.mygdx.uspace1.gameres.GamePng.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.uspace1.Item;
import com.mygdx.uspace1.Monster;
import com.mygdx.uspace1.Player;

public class GameDrawAnim {

    // Draw player animation
    public static void drawPlayerAnim (Player player, float x, float y, Animation anim) {
        player.frame_anim_state += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time
        // Get current frame of animation for the current stateTime
        TextureRegion currentFrame = (TextureRegion) anim.getKeyFrame(player.frame_anim_state, true);
        batch.draw(currentFrame, player.spr_x, player.spr_y, player.spr_w/2, player.spr_h/2, player.spr_w, player.spr_h, scl, scl, player.rot);
    }

    // Draw item animation
    public static void drawItemAnim (Item it, float x, float y, Animation anim) {
        it.frame_anim_state += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time
        // Get current frame of animation for the current stateTime
        TextureRegion currentFrame = (TextureRegion) anim.getKeyFrame(it.frame_anim_state, true);
        batch.draw(currentFrame, x, y, x+it.spr_w/2, y+it.spr_h/2, it.spr_w, it.spr_h, scl, scl, it.rot);
    }

    // Draw monster animation
    public static void drawMonsterAnim (Monster mo, float x, float y, Animation anim) {
        mo.frame_anim_state += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time
        // Get current frame of animation for the current stateTime
        TextureRegion currentFrame = (TextureRegion) anim.getKeyFrame(mo.frame_anim_state, true);
        batch.draw(currentFrame, x, y, x+mo.spr_w/2, y+mo.spr_h/2, mo.spr_w, mo.spr_h, scl, scl, mo.rot);
    }
}
