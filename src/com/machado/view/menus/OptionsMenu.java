package com.machado.view.menus;

import com.machado.controller.MenuController;
import g4p_controls.G4P;
import g4p_controls.GButton;
import g4p_controls.GControlMode;
import g4p_controls.GEvent;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.event.KeyEvent;

public class OptionsMenu extends Menu {

    public OptionsMenu(PApplet view, MenuController controller) {
        super(view, controller);
    }

    @Override
    protected String initId() {
        return "OptionsMenu";
    }

    @Override
    protected void addButtons() {
        float w = view.width;
        float h = view.height;

        G4P.setCtrlMode(GControlMode.CORNER);

        GButton resumeBtn = new GButton(view, 40, h - 40 - btnHeight, btnWidth, btnHeight, "Resume");
        resumeBtn.addEventHandler(this, "resumeBtn");
        buttons.add(resumeBtn);
    }

    @Override
    public void keyPressed(KeyEvent event) {
        if (event.getKey() == 27 || event.getKey() == '\'') {
            controller.changeMenu("MainMenu");
        }
    }

    @Override
    public void draw() {
        super.draw();

        if (isVisible()) {
            view.rectMode(PConstants.CORNERS);
            view.fill(0, 120, 200, 20);
            view.rect(30, 30, view.width-30, view.height-30);
        }
    }

    public void resumeBtn(GButton button, GEvent event) {
        controller.changeMenu("MainMenu");
    }
}
