package model;

import processing.core.PApplet;

public class SpaceRacers {
	private PApplet app;
	private Ovni1 ovni1;
	
//	private final float gridSize;
	private final float rightMargin;
	private final float leftMargin;
	
	public SpaceRacers(PApplet app) {
		this.app = app;
		
        ovni1 = new Ovni1("Img/Character.png", 101, 20, app);
		
        ovni1.centerX = 101;
        ovni1.centerY = 100;
		
		rightMargin = 300;
		leftMargin = 0;
	//	posXbg = 0;
		
	}
	
	public void moveCaveman() {
		if ((ovni1.getCenterX() > leftMargin && ovni1.getCenterX() < rightMargin)) {

			new Thread(ovni1).start();
		}

	

	}
}
