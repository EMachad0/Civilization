package com.machado.view.menus;

import com.machado.controller.MenuController;
import g4p_controls.G4P;
import g4p_controls.GButton;
import g4p_controls.GControlMode;
import g4p_controls.GEvent;
import processing.core.PApplet;

public class MainMenu extends Menu {

    private static final String bgpath = "./images/atlasgod.jpg";

    public MainMenu(PApplet view, MenuController controller) {
        super(view, controller);
    }

    @Override
    protected String initId() {
        return "MainMenu";
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

        G4P.setCtrlMode(GControlMode.CENTER);

        GButton playBtn = new GButton(view, w/2, h/2 - btnHeight - 20, btnWidth, btnHeight, "Play");
        playBtn.addEventHandler(this, "playBtn");
        buttons.add(playBtn);

        GButton optionBtn = new GButton(view, w/2, h/2, btnWidth, btnHeight, "OptionsMenu");
        optionBtn.addEventHandler(this, "optionBtn");
        buttons.add(optionBtn);
    }

    public void playBtn(GButton button, GEvent event) {
        controller.changeMenu("GameMenu");
    }

    public void optionBtn(GButton button, GEvent event) {
        controller.changeMenu("OptionsMenu");
    }

}
