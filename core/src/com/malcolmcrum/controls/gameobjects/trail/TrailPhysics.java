package com.malcolmcrum.controls.gameobjects.trail;

import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
import com.malcolmcrum.controls.World;
import com.malcolmcrum.controls.components.PhysicsComponent;
import com.malcolmcrum.controls.gameobjects.GameObject;

/**
 * Created by crummy on 26.01.16.
 */
public class TrailPhysics extends PhysicsComponent {
	@Override
	public void update(GameObject o, World w) {
		Trail trail = (Trail)o;
		for (ParticleEmitter.Particle particle : trail.getParticles()) {
			particle.setScale(particle.getScaleX() * 0.9f);
		}
	}
}
