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
import com.malcolmcrum.controls.gameobjects.player.Player;

/**
 * Created by Crummy on 1/18/2016.
 */
public class Camera extends Actor {
    private final com.badlogic.gdx.graphics.Camera camera;
    public final Player player;
    private static final float lerpSpeed = 0.2f;

    public Camera(InputComponent input, PhysicsComponent physics, GraphicsComponent graphics, Player player) {
        super(input, physics, graphics);
        this.player = player;
        this.camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    @Override
    public void update(World world, SpriteBatch batch) {
        input.update(this);
        camera.update();
        graphics.render(this, batch);

        camera.position.x = position.x;
        camera.position.y = position.y;
        batch.setProjectionMatrix(camera.combined);
    }

    @Override
    public void moveTowards(Vector2 v) {
        position.lerp(v, lerpSpeed);
    }
}
