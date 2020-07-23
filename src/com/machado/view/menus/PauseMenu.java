package com.machado.view.menus;

import com.machado.controller.MenuController;
import com.machado.view.MainLoop;
import g4p_controls.G4P;
import g4p_controls.GButton;
import g4p_controls.GControlMode;
import g4p_controls.GEvent;
import processing.core.PConstants;
import processing.event.KeyEvent;

public class PauseMenu extends Menu {

    public PauseMenu(MainLoop view, MenuController controller) {
        super(view, controller);
    }

    @Override
    protected String initId() {
        return "PauseMenu";
    }

    @Override
    protected void addButtons() {
        float w = view.width;
        float h = view.height;

        G4P.setCtrlMode(GControlMode.CENTER);

        GButton resumeBtn = new GButton(view, w/2, h/2 - btnHeight, btnWidth, btnHeight, "Resume");
        resumeBtn.addEventHandler(this, "resumeBtn");
        buttons.add(resumeBtn);

        GButton mainMenuBtn = new GButton(view, w/2, h/2 + btnHeight, btnWidth, btnHeight, "Main Menu");
        mainMenuBtn.addEventHandler(this, "mainMenuBtn");
        buttons.add(mainMenuBtn);
    }

    @Override
    public void keyPressed(KeyEvent event) {
        if (event.getKey() == 27 || event.getKey() == '\'') {
            changeToGame();
        }
    }

    @Override
    public void draw() {
        super.draw();

        if (isVisible()) {
            view.rectMode(PConstants.CENTER);
            view.fill(0, 120, 200, 20);
            view.rect(view.width/2F, view.height/2F, 300, 300);
        }
    }

    public void resumeBtn(GButton button, GEvent event) {
        changeToGame();
    }

    public void mainMenuBtn(GButton button, GEvent event) {
        controller.changeMenu("MainMenu");
    }
}
