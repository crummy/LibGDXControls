package com.malcolmcrum.controls.gameobjects.camera;

import com.badlogic.gdx.math.Vector2;
import com.malcolmcrum.controls.components.InputComponent;
import com.malcolmcrum.controls.gameobjects.Actor;

/**
 * Created by crummy on 19.01.16.
 */
public class CameraInput extends InputComponent {
	float distanceToCursor = 0.2f;

	@Override
	public void update(Actor actor) {
		Camera camera = (Camera)actor;
		Vector2 towardsCursor = camera.player.cursorPosition.add(camera.player.getPosition());
		Vector2 target = camera.player.getPosition().cpy().lerp(towardsCursor, distanceToCursor);
		camera.moveTowards(target);
		camera.setZoom(1 + camera.player.getVelocity().len() * 0.01f);
	}
}
