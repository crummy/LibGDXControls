package com.malcolmcrum.controls.gameobjects.camera;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.malcolmcrum.controls.components.GraphicsComponent;
import com.malcolmcrum.controls.components.PhysicsComponent;
import com.malcolmcrum.controls.gameobjects.GameObject;
import com.malcolmcrum.controls.gameobjects.player.Player;

/**
 * Created by Crummy on 1/18/2016.
 */
public class Camera extends GameObject {
    public final com.badlogic.gdx.graphics.Camera camera;

    public Camera(PhysicsComponent physics, GraphicsComponent graphics, float width, float height) {
        super(physics, graphics);
        this.camera = new OrthographicCamera(width, height);
    }

    public void update(Player player) {

    }
}
