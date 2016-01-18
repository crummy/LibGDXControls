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

    Vector2 cursor;

    public PlayerInput() {
        cursor = new Vector2();
    }

    @Override
    public void update(Actor player) {
        cursor.set(Gdx.input.getX(), Gdx.input.getY());
        if (Gdx.input.isButtonPressed(Input.Keys.A)) {
            player.moveLeft();
        } else if (Gdx.input.isButtonPressed(Input.Keys.D)) {
            player.moveRight();
        }
        if (Gdx.input.isButtonPressed(Input.Keys.W)) {
            player.moveForwards();
        } else if (Gdx.input.isButtonPressed(Input.Keys.S)) {
            player.moveBackwards();
        }
    }
}
