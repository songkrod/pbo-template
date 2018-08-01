package com.pbo.template.core;

import com.badlogic.gdx.Game;

public class PBOTemplate extends Game {

    @Override
    public void create() {
        setScreen(new TestScreen());
    }
}
