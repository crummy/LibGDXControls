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
		trail.getParticles().forEach((particle) -> {
			particle.sprite.setAlpha(particle.getAlpha());
			particle.sprite.setScale(particle.getScale());
			particle.sprite.setPosition(particle.getPosition().x, particle.getPosition().y);
			particle.sprite.draw(batch);
		});
	}
}
