package com.pbo.template.core;

import aurelienribon.tweenengine.TweenManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.kotcrab.vis.ui.VisUI;
import com.kotcrab.vis.ui.widget.VisLabel;
import com.kotcrab.vis.ui.widget.VisTable;

public class TestScreen implements Screen {

    private Stage stage;

    private OrthographicCamera camera;

    private Batch spriteBatch;

    private VisLabel label;

    private TweenManager manager;

    private float progress;

    @Override
    public void show() {
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        spriteBatch = new SpriteBatch();
        Viewport viewPort = new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        viewPort.setCamera(camera);
        stage = new Stage(viewPort, spriteBatch);

        VisUI.load();
        VisTable root = new VisTable();
        root.setFillParent(true);

        label = new VisLabel("Loading : " + 0 + " % ");
        VisTable container = new VisTable();
        container.add(label).bottom();


        root.center().top();
        root.add(container).row();

        VisTable stackTable = new VisTable();
        stackTable.setFillParent(true);
        stackTable.center();
        stackTable.padTop(300);

        stage.addActor(root);
        stage.addActor(stackTable);

        Gdx.input.setInputProcessor(stage);

        manager = new TweenManager();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        manager.update(delta);

        stage.act();
        stage.draw();

        label.setText("Loading : " + String.format("%d", (int) (progress * 100)) + " % ");
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
        stage.dispose();
        VisUI.dispose();
        spriteBatch.dispose();
    }
}
