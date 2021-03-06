package com.malcolmcrum.controls;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Controls extends ApplicationAdapter {
	SpriteBatch batch;
	World world;
	Texture texture;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		texture = new Texture("badlogic.jpg");
		world = new World(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(texture, 0, 0, 4096, 4096);
		world.update(batch);
		batch.end();
	}
}
