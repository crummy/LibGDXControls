package com.malcolmcrum.controls.gameobjects.camera;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.malcolmcrum.controls.World;
import com.malcolmcrum.controls.components.GraphicsComponent;
import com.malcolmcrum.controls.components.InputComponent;
import com.malcolmcrum.controls.components.PhysicsComponent;
import com.malcolmcrum.controls.gameobjects.Actor;

/**
 * Created by Crummy on 1/18/2016.
 */
public class Camera extends Actor {
    public final com.badlogic.gdx.graphics.Camera camera;
    public final Actor target;
    private static final float lerpSpeed = 0.2f;

    public Camera(InputComponent input, PhysicsComponent physics, GraphicsComponent graphics, Actor target) {
        super(input, physics, graphics);
        this.target = target;
        this.camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    @Override
    public void update(World world, SpriteBatch batch) {
        physics.update(this, world);
        camera.update();
        graphics.render(this, batch);
    }

    @Override
    public void moveTowards(Vector2 v) {
        getPosition().lerp(v, lerpSpeed);
    }
}
