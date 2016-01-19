package com.malcolmcrum.controls.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.malcolmcrum.controls.World;
import com.malcolmcrum.controls.components.GraphicsComponent;
import com.malcolmcrum.controls.components.InputComponent;
import com.malcolmcrum.controls.components.PhysicsComponent;

/**
 * Created by Crummy on 1/17/2016.
 */
public abstract class Actor extends GameObject {
    final private InputComponent input;

    protected Actor(InputComponent input, PhysicsComponent physics, GraphicsComponent graphics) {
        super(physics, graphics);
        this.input = input;
    }

    @Override
    public void update(World world, SpriteBatch batch) {
        input.update(this);
        super.update(world, batch);
    }

    public void moveLeft() {
    }

    public void moveRight() {
    }

    public void moveForwards() {
    }

    public void moveBackwards() {
    }

    public void moveTowards(Vector2 v) {
    }

}
