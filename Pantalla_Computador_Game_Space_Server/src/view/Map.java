package view;
import java.io.IOException;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Map  {

	private PApplet app;
	private PImage map;



//--------------------------------------------------------------------------------------------------------------------------------

	public Map(PApplet app) {
		this.app = app;
		map = app.loadImage("Img/Map.png");
		map.resize(1152, 700);
	
	
	}
	
	
	public int drawScreen(int screen) {
	
		if (screen == 5) {
			app.imageMode(PApplet.CORNER);
			app.image(map, 0, 0);            //por el momento el fondo se ve raro porque no se ha puesto a mover el fondo
			app.imageMode(PApplet.CENTER);
		}

		return screen;

	}

	public int switchScreen(int screen) {
		if (screen == 6) {

			if (app.mouseX > 456 && 750 > app.mouseX && app.mouseY > 602 && 651 > app.mouseY) {

				screen = 1;
			}
		}
		return screen;

	}

/*	public void moveCaveman(int screen) {
		if (screen != 6) {
			SpaceRacers.moveCaveman();
		}


	}

	public void stopCaveman(int screen) {

		if (screen != 6) {
			SpaceRacers.releasedKey();
		}

	}
*/
//--------------------------------------------------------------------------------------------------------------------------

	
	/*
	 * if (s >= 59) { m = 0; s = 0; app.text(m + ":" + s + ":" + mil, 1110, 42); }
	 */

	

	// --------------------------------------------------------------------------------------------------------------------------

}