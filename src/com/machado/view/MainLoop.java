package com.machado.view;

import com.machado.controller.MenuController;
import com.machado.model.World;
import g4p_controls.G4P;
import processing.core.PApplet;
import processing.event.KeyEvent;

public class MainLoop extends PApplet {

    private MenuController menuController;

    private World world;

    public void settings() {
        size(1300, 800);
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
        pushMatrix();
        // static

        menuController.draw();

        if (world != null) world.draw();
        popMatrix();

        // follow cam
        menuController.postCamDraw();

        line(0, height/2F, width, height/2F);
        line(width/2F, 0, width/2F, height);
    }

    @Override
    public void keyPressed(KeyEvent event) {
        super.keyPressed(event);

        menuController.keyPressed(event);
        if (world != null) world.keyPressed(event);
    }

    public void newWorld() {
        world = new World(this);
    }

    public World getWorld() {
        return world;
    }
}
