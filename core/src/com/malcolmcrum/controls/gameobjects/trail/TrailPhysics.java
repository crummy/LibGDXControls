package com.malcolmcrum.controls.gameobjects.trail;

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
		for (TrailParticle particle : trail.getParticles()) {
			particle.update(0.1f);
		}
	}
}
