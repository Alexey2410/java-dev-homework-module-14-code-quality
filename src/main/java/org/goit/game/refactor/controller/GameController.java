package org.goit.game.refactor.controller;

import org.goit.game.refactor.model.GameModel;
import org.goit.game.refactor.model.state.GameState;
import org.goit.game.refactor.view.GameView;

import java.util.Scanner;

public class GameController {

    private GameModel model;
    private GameView view;

    private boolean running = true;
    private GameState state;

    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        Scanner in = new Scanner(System.in);

        while (running) {
            state.info(view);
            if(state.isHandleInput())
                state.handleInput(in.nextByte());
            state.execute();
        }
//        view.message("До побачення!");
    }

    public void setState(GameState s) {
        this.state = s;
    }

    public GameModel getModel() {
        return model;
    }

    public GameView getView() {
        return view;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
