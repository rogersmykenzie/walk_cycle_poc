package com.kencho.walk_cycle_test;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

// Contains the images for the walk cycle of a given cardinal direction
// as well as api to add or remove frames
public class CardinalDirection {
    private Array<Texture> cycle;

    public CardinalDirection(Array<Texture> frames) {
        cycle = frames;
    }

    public void addFrame(Texture frame) {
        cycle.add(frame);
    }

    public void removeFrame(int index) {
        cycle.removeIndex(index);
    }

    public Array<Texture> getFrames() {
        return cycle;
    }
}
