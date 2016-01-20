package com.malcolmcrum.controls.gameobjects.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.malcolmcrum.controls.components.InputComponent;
import com.malcolmcrum.controls.gameobjects.Actor;

/**
 * Created by Crummy on 1/18/2016.
 */
public class PlayerInput extends InputComponent {

    @Override
    public void update(Actor actor) {
        Player player = (Player)actor;
        player.cursorPosition.set(Gdx.input.getX(), -Gdx.input.getY());
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            player.moveLeft();
        } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            player.moveRight();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            player.moveForwards();
        } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            player.moveBackwards();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
            player.boost();
        }
    }
}
