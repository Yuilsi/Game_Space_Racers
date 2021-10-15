package view;



import model.SpaceRacers;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Map implements Runnable {

	private PApplet app;
	private SpaceRacers spaceRacers;
	private PImage map;

//--------------------------------------------------------------------------------------------------------------------------------

	public Map(PApplet app) {
		this.app = app;
		map = app.loadImage("Img/Map.png");
		map.resize(1152,16233);
		spaceRacers = new SpaceRacers (app);
	}
	
	public int drawScreen(int screen) {
	
		if (screen == 5) {
			app.imageMode(PApplet.CORNER);
			app.image(map,0,spaceRacers.getPosYbg());            //por el momento el fondo se ve raro porque no se ha puesto a mover el fondo
			app.imageMode(PApplet.CENTER);
			spaceRacers.drawObstacles();
		}

		return screen;

	}

	

	public void moveCaveman(int screen) {
		if (screen != 6) {
			spaceRacers.moveOvni();
		}


	}

	public void stopCaveman(int screen) {

		if (screen != 6) {
			spaceRacers.releasedKey();
		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {

			Thread.sleep(10);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//--------------------------------------------------------------------------------------------------------------------------

	
	/*
	 * if (s >= 59) { m = 0; s = 0; app.text(m + ":" + s + ":" + mil, 1110, 42); }
	 */

	

	// --------------------------------------------------------------------------------------------------------------------------

}