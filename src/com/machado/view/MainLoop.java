package com.machado.view;

import com.machado.controller.MenuController;
import g4p_controls.G4P;
import processing.core.PApplet;
import processing.event.KeyEvent;

public class MainLoop extends PApplet {

    private MenuController menuController;

    public void settings() {
        size(1366, 768);
        G4P.messagesEnabled(false);
    }

    @Override
    public void setup() {
        background(255);
        frameRate(60);

        menuController = new MenuController(this);
    }

    @Override
    public void draw() {
        menuController.draw();

        line(0, height/2F, width, height/2F);
        line(width/2F, 0, width/2F, height);
    }

    @Override
    public void keyPressed(KeyEvent event) {
        super.keyPressed(event);

        menuController.keyPressed(event);
    }
}
