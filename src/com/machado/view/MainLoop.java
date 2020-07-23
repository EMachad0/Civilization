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
        menuController.draw();

        line(0, height/2F, width, height/2F);
        line(width/2F, 0, width/2F, height);
    }
}
