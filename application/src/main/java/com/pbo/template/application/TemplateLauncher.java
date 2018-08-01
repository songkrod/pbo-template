package com.pbo.template.application;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.pbo.template.core.PBOTemplate;

public class TemplateLauncher {

    public static void main(String[] args) {
        new LwjglApplication(new PBOTemplate());
    }
}
