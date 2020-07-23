package com.machado.view;

import processing.core.PApplet;

public class MainLoop extends PApplet {

    public void settings() {
        size(1366, 768);
    }

    @Override
    public void setup() {
        background(255);
        frameRate(60);
    }

    @Override
    public void draw() {
        fill(0);
        rect(0, 0, 100, 100);
    }
}
