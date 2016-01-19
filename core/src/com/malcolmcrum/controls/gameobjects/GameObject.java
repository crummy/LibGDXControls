package com.malcolmcrum.controls.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.malcolmcrum.controls.World;
import com.malcolmcrum.controls.components.GraphicsComponent;
import com.malcolmcrum.controls.components.PhysicsComponent;

/**
 * Created by Crummy on 1/17/2016.
 */
public abstract class GameObject {
    private Vector2 position;
    private Vector2 velocity;
    protected final PhysicsComponent physics;
    protected final GraphicsComponent graphics;

    protected GameObject(PhysicsComponent physics, GraphicsComponent graphics) {
        this.position = new Vector2();
        this.velocity = new Vector2();
        this.physics = physics;
        this.graphics = graphics;
    }

    public void update(World world, SpriteBatch batch) {
        physics.update(this, world);
        graphics.render(this, batch);
    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getVelocity() {
        return velocity;
    }
}
