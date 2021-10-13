


import processing.core.PApplet;
import processing.core.PImage;

public class HomeView {

	private PImage home1, home2, home3, home4;
	private PApplet app;

	public HomeView(PApplet app) {
		this.app = app;

		home1 = app.loadImage("Img/Home1.png");
		home2 = app.loadImage("Img/Home2.png");
		home3 = app.loadImage("Img/Home3.png");
	
		
		home1.resize(1152,700);
		home2.resize(1152,700);
		home3.resize(1152,700);
	}

	public void drawScreen() {

		if (app.mouseX > 346 && 740 > app.mouseX && app.mouseY > 334 && 428 > app.mouseY) {
			app.image(home2, 0, 0);
			
		} else if (app.mouseX > 469 && 741 > app.mouseX && app.mouseY > 406 && 543 > app.mouseY) {
			app.image(home3, 0, 0);
			
		} else {
			app.image(home1, 0, 0);

		}

	}

	// método para pasar de pantalla
	public int switchScreen() {
		int screen = 1;

		if (app.mouseX > 458 && 711 > app.mouseX && app.mouseY > 167 && 428 > app.mouseY) {
			screen = 5;

		}
		if (app.mouseX > 469 && 741 > app.mouseX && app.mouseY > 406 && 543 > app.mouseY) {
			screen = 2;
		}
		
		return screen;
	}

}
