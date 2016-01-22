package com.malcolmcrum.controls.gameobjects.player;

import com.badlogic.gdx.math.Vector2;
import com.malcolmcrum.controls.components.GraphicsComponent;
import com.malcolmcrum.controls.components.InputComponent;
import com.malcolmcrum.controls.components.PhysicsComponent;
import com.malcolmcrum.controls.gameobjects.Actor;

import java.sql.Time;
import java.time.Instant;
import java.util.Date;

/**
 * Created by Crummy on 1/18/2016.
 */
public class Player extends Actor {
    private final static float acceleration = 0.1f;
    private final float boostSpeed = 20f;
    public final Vector2 cursorPosition;
    private long stoppedBoostingTime;

    public Player(InputComponent input, PhysicsComponent physics, GraphicsComponent graphics) {
        super(input, physics, graphics);
        cursorPosition = new Vector2();
        stoppedBoostingTime = 0;
    }

    // TODO: consider moving these to physics?
    @Override
    public void moveForwards() {
        getVelocity().add(0, acceleration);
    }

    @Override
    public void moveBackwards() {
        getVelocity().add(0, -acceleration);
    }

    @Override
    public void moveLeft() {
        getVelocity().add(-acceleration, 0);
    }

    @Override
    public void moveRight() {
        getVelocity().add(acceleration, 0);
    }

    public float getDirection() {
        return getVelocity().angle() - 90;
    }

    public void boost() {
        Vector2 boostVelocity = getVelocity().cpy().setLength(boostSpeed);
        getVelocity().lerp(boostVelocity, 0.1f);
        stoppedBoostingTime = System.currentTimeMillis();
    }

    public int msSinceBoosting() {
        return (int)(System.currentTimeMillis() - stoppedBoostingTime);
    }
}
