package com.malcolmcrum.controls.gameobjects.trail;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by crummy on 26.01.16.
 */
public class TrailParticle {
	public final Sprite sprite;
	private final Vector2 velocity;
	private Vector2 position;
	private float scale;
	private float alpha;
	private int lifetimeMs;

	public TrailParticle(Sprite sprite, Vector2 position, Vector2 velocity) {
		this.sprite = sprite;
		this.position = position;
		this.velocity = velocity;
		this.scale = 1;
		this.alpha = 1;
		this.lifetimeMs = 0;
	}

	public void update(float delta) {
		lifetimeMs += delta;
		position.add(velocity);
	}

	public void scale(float amount) {
		scale *= amount;
	}

	public void fade(float amount) {
		alpha *= amount;
	}

	public Vector2 getPosition() {
		return position;
	}

	public float getAlpha() {
		return alpha;
	}

	public float getScale() {
		return scale;
	}
}
