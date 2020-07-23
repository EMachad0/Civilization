package com.machado.view.menus;

import com.machado.controller.MenuController;
import g4p_controls.G4P;
import g4p_controls.GButton;
import g4p_controls.GControlMode;
import g4p_controls.GEvent;
import processing.core.PApplet;
import processing.event.KeyEvent;

public class GameMenu extends Menu {

    private static final String bgpath = "./images/antiqueatlas.jpg";

    public GameMenu(PApplet view, MenuController controller) {
        super(view, controller);
    }

    @Override
    protected String initId() {
        return "GameMenu";
    }

    @Override
    protected void addBackground() {
        background = view.loadImage(bgpath);
        background.resize(view.width, view.height);
    }

    @Override
    protected void addButtons() {
        float w = view.width;
        float h = view.height;

        G4P.setCtrlMode(GControlMode.CORNERS);

        GButton nextTurnBtn = new GButton(view, w - 100, h - 100, w, h, "Next Turn");
        nextTurnBtn.addEventHandler(this, "nextTurnBtn");
        buttons.add(nextTurnBtn);
    }

    @Override
    public void keyPressed(KeyEvent event) {
        if (event.getKey() == 27 || event.getKey() == '\'') {
            controller.goOutGame("PauseMenu");
        }
    }

    public void nextTurnBtn(GButton button, GEvent event) {
        System.out.println("TODO: NextTurn");
    }
}
