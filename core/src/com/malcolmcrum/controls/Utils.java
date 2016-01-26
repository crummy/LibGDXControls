package com.malcolmcrum.controls;

/**
 * Created by crummy on 25.01.16.
 */
public class Utils {
	public static float clamp(float min, float number, float max) {
		return Math.max(Math.min(max, number), min);
	}
}
