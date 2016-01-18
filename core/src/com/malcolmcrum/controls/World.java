package com.malcolmcrum.controls;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.malcolmcrum.controls.gameobjects.camera.Camera;
import com.malcolmcrum.controls.gameobjects.camera.CameraGraphics;
import com.malcolmcrum.controls.gameobjects.camera.CameraPhysics;
import com.malcolmcrum.controls.gameobjects.player.Player;
import com.malcolmcrum.controls.gameobjects.player.PlayerGraphics;
import com.malcolmcrum.controls.gameobjects.player.PlayerInput;
import com.malcolmcrum.controls.gameobjects.player.PlayerPhysics;

/**
 * Created by Crummy on 1/18/2016.
 */
public class World {
    final Player player;
    final Camera camera;

    World(int width, int height) {
        player = new Player(new PlayerInput(), new PlayerPhysics(), new PlayerGraphics());
        camera = new Camera(new CameraPhysics(), new CameraGraphics(), width, height);
    }

    public void update(SpriteBatch batch) {
        player.update(this, batch);
        camera.update(player);
    }
}
