package com.malcolmcrum.controls.gameobjects.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.malcolmcrum.controls.components.GraphicsComponent;
import com.malcolmcrum.controls.gameobjects.GameObject;

/**
 * Created by Crummy on 1/18/2016.
 */
public class PlayerGraphics extends GraphicsComponent {
    private Sprite sprite;

    public PlayerGraphics() {
        Texture texture = new Texture("ship.png");
        sprite = new Sprite(texture);
    }

    @Override
    public void render(GameObject o, SpriteBatch batch) {
        sprite.setPosition(o.getPosition().x, o.getPosition().y);
        sprite.setRotation(o.getPosition().angle(o.getVelocity()));
        sprite.draw(batch);
    }
}
