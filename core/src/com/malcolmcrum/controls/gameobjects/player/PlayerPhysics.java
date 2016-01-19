package com.malcolmcrum.controls.gameobjects.player;

import com.badlogic.gdx.math.Vector2;
import com.malcolmcrum.controls.World;
import com.malcolmcrum.controls.components.PhysicsComponent;
import com.malcolmcrum.controls.gameobjects.GameObject;

/**
 * Created by Crummy on 1/18/2016.
 */
public class PlayerPhysics extends PhysicsComponent {
    float maxVelocity = 10;
    float slowing = 0.9f;

    @Override
    public void update(GameObject o, World w) {
        Vector2 velocity = o.getVelocity().clamp(0, maxVelocity);
        o.getPosition().add(velocity);
        o.getVelocity().scl(slowing);
    }
}
