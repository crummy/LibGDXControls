package com.malcolmcrum.controls.gameobjects.player;

import com.malcolmcrum.controls.components.GraphicsComponent;
import com.malcolmcrum.controls.components.InputComponent;
import com.malcolmcrum.controls.components.PhysicsComponent;
import com.malcolmcrum.controls.gameobjects.Actor;

/**
 * Created by Crummy on 1/18/2016.
 */
public class Player extends Actor {
    public Player(InputComponent input, PhysicsComponent physics, GraphicsComponent graphics) {
        super(input, physics, graphics);
    }
}
