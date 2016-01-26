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
    private final static int fadeTimeMs = 1000;

    public PlayerGraphics() {
        Texture texture = new Texture("ship.png");
        sprite = new Sprite(texture);
    }

    // TODO: consider passing in Player to constructor?
    @Override
    public void render(GameObject o, SpriteBatch batch) {
        Player player = (Player)o;
        if (player.msSinceBoosting() < fadeTimeMs) {
            float fadeAmount = (float)(fadeTimeMs - player.msSinceBoosting())/fadeTimeMs;
            drawBoostTrail(player, batch, fadeAmount);
        }
        sprite.setScale(1);
        sprite.setAlpha(1);
        sprite.setPosition(player.getPosition().x, player.getPosition().y);
        sprite.setRotation(player.getDirectionAngle() - 90);
        sprite.draw(batch);
    }

    private void drawBoostTrail(Player player, SpriteBatch batch, float fadeAmount) {
        for (int i = 0; i < 3; ++i) {
            float x = player.getPosition().x - player.getVelocity().x * (i + 1);
            float y = player.getPosition().y - player.getVelocity().y * (i + 1);
            sprite.setPosition(x, y);
            sprite.setAlpha((float)1/(i+2) * fadeAmount);
            sprite.draw(batch);
        }
    }
}
