package com.machado;

import com.machado.view.MainLoop;
import processing.core.PApplet;

public class Main {

    public static void main(String[] args) {
        MainLoop ml = new MainLoop();
        PApplet.runSketch(new String[]{"Civilization"}, ml);
    }
}