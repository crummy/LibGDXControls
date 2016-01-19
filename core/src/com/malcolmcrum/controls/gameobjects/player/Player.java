package com.malcolmcrum.controls.gameobjects.player;

import com.badlogic.gdx.math.Vector2;
import com.malcolmcrum.controls.components.GraphicsComponent;
import com.malcolmcrum.controls.components.InputComponent;
import com.malcolmcrum.controls.components.PhysicsComponent;
import com.malcolmcrum.controls.gameobjects.Actor;

/**
 * Created by Crummy on 1/18/2016.
 */
public class Player extends Actor {
    private final static float speed = 0.1f;
    public final Vector2 cursorPosition;

    public Player(InputComponent input, PhysicsComponent physics, GraphicsComponent graphics) {
        super(input, physics, graphics);
        cursorPosition = new Vector2();
    }

    @Override
    public void moveForwards() {
        getVelocity().add(0, speed);
    }

    @Override
    public void moveBackwards() {
        getVelocity().add(0, -speed);
    }

    @Override
    public void moveLeft() {
        getVelocity().add(-speed, 0);
    }

    @Override
    public void moveRight() {
        getVelocity().add(speed, 0);
    }
}
