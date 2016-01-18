package com.malcolmcrum.controls.components;

import com.malcolmcrum.controls.World;
import com.malcolmcrum.controls.gameobjects.GameObject;

/**
 * Created by Crummy on 1/18/2016.
 */
public abstract class PhysicsComponent {
    public abstract void update(GameObject o, World w);
}
