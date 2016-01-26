package com.malcolmcrum.controls.gameobjects.trail;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.malcolmcrum.controls.World;
import com.malcolmcrum.controls.components.GraphicsComponent;
import com.malcolmcrum.controls.components.PhysicsComponent;
import com.malcolmcrum.controls.gameobjects.Actor;
import com.malcolmcrum.controls.gameobjects.GameObject;

import java.time.Instant;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by crummy on 26.01.16.
 */
public class Trail extends GameObject {
	private final Queue<TrailParticle> particles;
	private Actor attachment;
	private static final int msBetweenEmissions = 500;
	private Instant lastEmission;
	private final int maxParticles;
	private final Sprite sprite;

	public Trail(Actor attachment, int particleCount, PhysicsComponent physics, GraphicsComponent graphics) {
		super(physics, graphics);
		this.attachment = attachment;
		this.particles = new ArrayBlockingQueue<>(particleCount);
		Texture texture = new Texture("ship.png");
		this.sprite = new Sprite(texture);
		this.maxParticles = particleCount;
		lastEmission = Instant.now();
	}

	@Override
	public void update(World world, SpriteBatch batch) {
		super.update(world, batch);

		spawnNewParticles();

		particles.forEach(p -> {
			p.scale(0.9f);
			p.fade(0.9f);
		});
	}

	private void spawnNewParticles() {
		if (lastEmission.plusMillis(msBetweenEmissions).isAfter(Instant.now())) {
			if (particles.size() >= maxParticles) {
				particles.remove();
			}
			TrailParticle p = new TrailParticle(sprite, attachment.getPosition(), attachment.getVelocity().cpy().scl(-1));
			particles.add(p);
		}
	}

	public Queue<TrailParticle> getParticles() {
		return particles;
	}
}
