package com.kencho.walk_cycle_test;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class Character {
    public Animation<TextureRegion> standing_south;
    public Character(Array<String> urls) {
        String standing_south_path = urls.get(0);
    }
}
