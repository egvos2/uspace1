package com.mygdx.uspace1;

import com.badlogic.gdx.math.MathUtils;

import static com.mygdx.uspace1.MainMenuScreen.*;

public class GameMap {
    public float map_w_orig, map_h_orig;
    // Game map
    public MapBlock map [][];

    public int map_w, map_h;
    int n_ast;

    GameMap () {
        n_ast = 10;
    }

    public void getMapStartParams () {
        map_w_orig = 4000;
        map_h_orig = 2000;
        map_w = (int) (map_w_orig/unit);
        map_h = (int) (map_h_orig/unit);
    }

    public void createMap () {
        int i, j;
        boolean colliz = false;

        map = new MapBlock[map_h][map_w];
        for (i=0; i<map_h; i++) {
            for (j = 0; j < map_w; j++) {
                map[i][j] = new MapBlock();
                map[i][j].x = j;
                map[i][j].y = i;
            }
        }

        // Add asteroids
        Item it;
        it = new Item();
        it.x = 1750;
        it.y = 1250;
        it.setStartParams();
        // Add to common list
        items.add(it);
        // Add to MapBlock list
        gm.map[it.y_map][it.x_map].items.add(it);
        it = new Item();
        it.x = 50;
        it.y = 50;
        it.setStartParams();
        // Add to common list
        items.add(it);
        // Add to MapBlock list
        gm.map[it.y_map][it.x_map].items.add(it);
        for (i=0; i<n_ast; i++) {
            // Create asteroid
            it = new Item();
            it.type = 1;
            it.x = MathUtils.random(unit, map_w_orig-unit);
            it.y = MathUtils.random(unit, map_h_orig-unit);
            it.setStartParams();
            // Add to common list
            items.add(it);
            // Add to MapBlock list
            gm.map[it.y_map][it.x_map].items.add(it);
        }
    }
}
