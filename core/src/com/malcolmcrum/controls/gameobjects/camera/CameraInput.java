package com.malcolmcrum.controls.gameobjects.camera;

import com.malcolmcrum.controls.components.InputComponent;
import com.malcolmcrum.controls.gameobjects.Actor;

/**
 * Created by crummy on 19.01.16.
 */
public class CameraInput extends InputComponent {
	@Override
	public void update(Actor actor) {
		Camera camera = (Camera)actor;
		camera.moveTowards(camera.target.getPosition());
	}
}
