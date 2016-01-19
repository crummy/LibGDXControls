package com.malcolmcrum.controls.gameobjects.camera;

import com.malcolmcrum.controls.World;
import com.malcolmcrum.controls.components.PhysicsComponent;
import com.malcolmcrum.controls.gameobjects.GameObject;

/**
 * Created by Crummy on 1/18/2016.
 */
public class CameraPhysics extends PhysicsComponent {
    private final static float lerpSpeed = 0.5f;

    @Override
    public void update(GameObject o, World w) {
        Camera c = (Camera)o;
        o.getPosition().lerp(w.player.getPosition(), lerpSpeed);
    }
}
