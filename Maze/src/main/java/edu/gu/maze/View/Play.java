package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mygdx.game.entities.Player;

/**
 * Created by Johan on 2015-05-05.
 */
public class Play implements Screen {
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;

    private Player player;

    @Override
    public void show() {
        map = new TmxMapLoader().load("C:\\Users\\Johan\\Desktop\\Programmering\\Java\\MazeTest\\desktop\\assets\\Maze4.tmx");

        renderer = new OrthogonalTiledMapRenderer(map);

        camera = new OrthographicCamera();

        player = new Player(new Sprite(new Texture("C:\\Users\\Johan\\Desktop\\Programmering\\Java\\MazeTest\\desktop\\assets\\lion.png")),(TiledMapTileLayer) map.getLayers().get(0));
        player.setPosition(22*player.getCollisionLayer().getTileWidth(),(player.getCollisionLayer().getHeight()-47) * player.getCollisionLayer().getTileHeight());
        Gdx.input.setInputProcessor(player);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        camera.position.set(player.getX() + player.getWidth() / 2, player.getY() + player.getHeight() / 2, 0);
        camera.update();
        renderer.setView(camera);
        renderer.render();

        renderer.getBatch().begin();
        player.draw(renderer.getBatch());
        renderer.getBatch().end();
    }

    @Override
    public void resize(int width, int height) {
        camera.viewportWidth = width/5;
        camera.viewportHeight = height/5;


    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        dispose();

    }

    @Override
    public void dispose() {

        map.dispose();
        renderer.dispose();
        player.getTexture().dispose();
    }
}
