package com.kencho.walk_cycle_test;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.HashMap;

public class WalkCycle extends ApplicationAdapter {
	private SpriteBatch batch;
	private Animation<TextureRegion> standingSouthAnimation;
	private float stateTime;
	private String directionFacing;
	private HashMap<String, Animation<TextureRegion>> animations;
	private TextureAtlas atlas;
	private String movementStatus;
	private Rectangle link;
	private OrthographicCamera camera;

	@Override
	public void create () {
		batch = new SpriteBatch();
		atlas = new TextureAtlas(Gdx.files.internal("link.atlas"));
		directionFacing = "s";
		stateTime = 0f;
		animations = new HashMap<String, Animation<TextureRegion>>();
		movementStatus = "standing";
		loadAnimations();
		link = new Rectangle();
		link.width = 1024;
		link.height = 1024;
		link.x = 1920/2;
		link.y = 1080/2;
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1920, 1080);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 140, 0, 1);
		float deltaTime = Gdx.graphics.getDeltaTime();
		camera.update();
		stateTime += deltaTime;
		TextureRegion currentFrame = animations.get("link_" + movementStatus + "_" + directionFacing).getKeyFrame(stateTime, true);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(currentFrame, link.x, link.y);
		batch.end();

		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			directionFacing = "w";
			movementStatus = "walk";
			link.x -= 200 * deltaTime;
		}  else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			directionFacing = "e";
			movementStatus = "walk";
			link.x += 200 * deltaTime;
		} else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			directionFacing = "s";
			movementStatus = "walk";
			link.y -= 200 * deltaTime;
		} else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			directionFacing = "n";
			movementStatus = "walk";
			link.y += 200 * deltaTime;
		} else {
			movementStatus = "standing";
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}

	private void loadAnimations() {
		Array<String> directions = new Array<String>();
		directions.add("n", "e", "s", "w");

		for (String dir: directions) {
			animations.put("link_standing_" + dir, new Animation<TextureRegion>(.2f, atlas.findRegions("link_standing_" + dir), Animation.PlayMode.LOOP));
			animations.put("link_walk_" + dir, new Animation<TextureRegion>(.1f, atlas.findRegions("link_walk_" + dir), Animation.PlayMode.LOOP));
		}
	}
}
