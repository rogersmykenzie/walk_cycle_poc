package com.kencho.walk_cycle_test.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.kencho.walk_cycle_test.WalkCycle;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Walk Cycle";
		config.width = 1920;
		config.height = 1080;
		new LwjglApplication(new WalkCycle(), config);
	}
}
