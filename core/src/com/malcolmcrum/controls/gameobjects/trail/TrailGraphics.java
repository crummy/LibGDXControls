package com.malcolmcrum.controls.gameobjects.trail;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.malcolmcrum.controls.components.GraphicsComponent;
import com.malcolmcrum.controls.gameobjects.GameObject;

/**
 * Created by crummy on 26.01.16.
 */
public class TrailGraphics extends GraphicsComponent {
	@Override
	public void render(GameObject o, SpriteBatch batch) {
		Trail trail = (Trail)o;
		for (TrailParticle particle : trail.getParticles()) {
			particle.sprite.draw(batch);
		}
	}
}
