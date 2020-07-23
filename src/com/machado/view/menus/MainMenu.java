package com.machado.view.menus;

import com.machado.controller.MenuController;
import com.machado.view.MainLoop;
import g4p_controls.G4P;
import g4p_controls.GButton;
import g4p_controls.GControlMode;
import g4p_controls.GEvent;

public class MainMenu extends Menu {

    private static final String bgpath = "./images/atlasgod.jpg";

    public MainMenu(MainLoop view, MenuController controller) {
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

        GButton newGameBtn = new GButton(view, w/2, h/2 - btnHeight - 20, btnWidth, btnHeight, "New Game");
        newGameBtn.addEventHandler(this, "newGameBtn");
        buttons.add(newGameBtn);

        GButton ContinueGameBtn = new GButton(view, w/2, h/2, btnWidth, btnHeight, "Continue Game");
        ContinueGameBtn.addEventHandler(this, "ContinueGameBtn");
        buttons.add(ContinueGameBtn);

        GButton optionBtn = new GButton(view, w/2, h/2 + btnHeight + 20, btnWidth, btnHeight, "OptionsMenu");
        optionBtn.addEventHandler(this, "optionBtn");
        buttons.add(optionBtn);
    }

    public void newGameBtn(GButton button, GEvent event) {
        ((MainLoop) view).newWorld();
        controller.goInGame();
    }

    public void ContinueGameBtn(GButton button, GEvent event) {
        if ( ((MainLoop) view).getWorld() == null)  ((MainLoop) view).newWorld();
        controller.goInGame();
    }

    public void optionBtn(GButton button, GEvent event) {
        controller.changeMenu("OptionsMenu");
    }

}
