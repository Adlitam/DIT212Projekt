package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.screens.Play;

public class MazeTest extends Game{

	
	@Override
	public void create () {
        setScreen(new Play());
    }
    @Override
    public void resize(int width, int height) {
super.resize(width,height);
    }

    @Override
	public void render () {
        super.render();

	}

    @Override
    public void pause() {
super.pause();
    }

    @Override
    public void resume() {
super.resume();
    }

    @Override
    public void dispose() {
        super.dispose();

    }
}
