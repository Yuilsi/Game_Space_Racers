package model;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Ovni1 extends Elements implements Runnable {

	private float speed;
	private PImage ovniImg;
	private PApplet app;

	public Ovni1(String filename, float posX, float posY, PApplet app) {
		super(filename, posX, posY, app);
		speed = (float) 1;
		ovniImg = app.loadImage(filename);
		this.app = app;
		centerX = 90;
		centerY = 30;
		changeX = 0;
		changeY = 0;
	}

	public void draw() {

		app.imageMode(PConstants.CENTER);
		app.image(ovniImg, centerX, centerY);

	}

	private void directionOvni() {
		
		if (app.keyCode == PConstants.RIGHT) {

			changeX = speed;

		} else if (app.keyCode == PConstants.LEFT) {

			changeX = -speed;
			
		} else if (app.keyCode == PConstants.UP) {

			changeY = -speed;
		}

	}

	public void releasedKey() {
		if (app.keyCode == PConstants.RIGHT) {
			changeX = 0;
		}

		if (app.keyCode == PConstants.LEFT) {
			changeX = 0;
		}
		if (app.keyCode == PConstants.UP) {
			changeY = 0;
		}
	}

	@Override
	public void run() {

		directionOvni();
	
		try {

			Thread.sleep(10);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	


}
