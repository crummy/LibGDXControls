package com.malcolmcrum.controls.gameobjects.player;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.malcolmcrum.controls.Utils;
import com.malcolmcrum.controls.World;
import com.malcolmcrum.controls.components.GraphicsComponent;
import com.malcolmcrum.controls.components.InputComponent;
import com.malcolmcrum.controls.components.PhysicsComponent;
import com.malcolmcrum.controls.gameobjects.Actor;
import com.malcolmcrum.controls.gameobjects.trail.Trail;
import com.malcolmcrum.controls.gameobjects.trail.TrailGraphics;
import com.malcolmcrum.controls.gameobjects.trail.TrailPhysics;

/**
 * Created by Crummy on 1/18/2016.
 */
public class Player extends Actor {
    private final static float acceleration = 0.1f;
    private final float boostSpeed = 20f;
    private final Vector2 direction;
    public final Vector2 cursorPosition;
    private long stoppedBoostingTime;
    private final Trail trail;

    public Player(InputComponent input, PhysicsComponent physics, GraphicsComponent graphics) {
        super(input, physics, graphics);
        trail = new Trail(this, 8, new TrailPhysics(), new TrailGraphics());
        cursorPosition = new Vector2();
        direction = Vector2.Y.setLength(acceleration);
        stoppedBoostingTime = 0;
    }

    @Override
    public void update(World world, SpriteBatch batch) {
        super.update(world, batch);
        trail.update(world, batch);
    }

    // TODO: consider moving these to physics?
    @Override
    public void moveForwards() {
        Vector2 forwards = getDirectionVector().setLength(acceleration);
        getVelocity().add(forwards);
    }

    @Override
    public void moveBackwards() {
        getVelocity().add(getDirectionVector().setLength(-acceleration));
    }

    @Override
    public void moveLeft() {
        direction.rotate(getTurnRate());
    }

    @Override
    public void moveRight() {
        direction.rotate(-getTurnRate());
    }

    private float getTurnRate() {
        if (getVelocity().x == 0 && getVelocity().y == 0) {
            return 10;
        }
        return Utils.clamp(1, boostSpeed / getVelocity().len2(), 10); // TODO: lerp it
    }

    public float getDirectionAngle() {
        return direction.angle();
    }

    private Vector2 getDirectionVector() {
        return direction;
    }

    public void boost() {
        Vector2 boostVelocity = getDirectionVector().setLength(boostSpeed);
        getVelocity().lerp(boostVelocity, 0.1f);
        stoppedBoostingTime = System.currentTimeMillis();
    }

    public int msSinceBoosting() {
        return (int)(System.currentTimeMillis() - stoppedBoostingTime);
    }
}
