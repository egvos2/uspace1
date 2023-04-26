package com.mygdx.uspace1;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.utils.ScreenUtils;

import com.mygdx.uspace1.gamenet.GameNet;
import com.mygdx.uspace1.gameres.GameRes;
import static com.mygdx.uspace1.MainMenuScreen.*;

import java.util.Random;

public class USpace1 extends Game {
	public static GameRes gr;
	public static GameNet gameNet;

	// Game prefs
	public static Preferences prefs;
	public static String pref_login;
	public static String pref_password;

	@Override
	public void create () {

		// Load Game Resources
		gr = new GameRes();
		// Init game networking
		gameNet = new GameNet();
		//gameNet.initNet();
		// Load prefs
		prefs = Gdx.app.getPreferences("USpace1"); // Game preferences
		loadPrefs ();

		// Run Main menu screen
		this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0.2f, 1);
		super.render(); // important!
	}
	
	@Override
	public void dispose () {

	}

	// Load prefs
	private void loadPrefs () {
		// Get player Login
		if (prefs.contains("pref_login")) {
			pref_login = prefs.getString("pref_login");
			login_type = 0;
		} else {
			login_type = 1;
		}
		// Get player Password
		if (prefs.contains("pref_password")) {
			pref_password = prefs.getString("pref_password");
			login_type = 0;
		} else {
			login_type = 1;
		}
	}

	// Random number in range
	public static int getRandomNumberInRange(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
}
