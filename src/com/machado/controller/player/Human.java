package com.machado.controller.player;

import com.machado.controller.Civilization;

public class Human extends Player {

    public Human(int id, Civilization civ) {
        super(id, civ);
    }

    @Override
    public void play() {
        System.out.println("Human " + id + "jogou");
    }


}
