package com.malcolmcrum.controls.components;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.malcolmcrum.controls.gameobjects.GameObject;

/**
 * Created by Crummy on 1/18/2016.
 */
public abstract class GraphicsComponent {
    public abstract void render(GameObject o, SpriteBatch batch);
}
