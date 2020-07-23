package com.machado.model;

import processing.core.PApplet;
import processing.core.PConstants;

public class Tile {

    public static final int SIZE = 100;

    private final PApplet view;
    private final int x;
    private final int y;

    private final float r = (float) (Math.random() * 255), g = (float) (Math.random() * 255), b = (float) (Math.random() * 255);

    public Tile(PApplet view, int x, int y) {
        this.view = view;
        this.x = x;
        this.y = y;
    }

    public void draw() {
        view.rectMode(PConstants.CORNER);
        view.fill(r, g, b);
        view.rect(x, y, SIZE, SIZE);
    }
}
