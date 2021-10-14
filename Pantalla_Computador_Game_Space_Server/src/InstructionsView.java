import processing.core.PApplet;
import processing.core.PImage;

public class InstructionsView {
	//	private ControllerMain controllermain;
	private PImage instruction1, instruction2;
	private PApplet app;

	public InstructionsView(PApplet app) {
		this.app = app;
		
		instruction1 = app.loadImage("Img/Instructions1.png");
		instruction2 = app.loadImage("Img/Instructions2.png");
		
		instruction1.resize(1152,700);
		instruction2.resize(1152,700);	
	}

	// método para pintar la pantalla home
		public void drawScreen() {

			if (app.mouseX > 27 && 64 > app.mouseX && app.mouseY > 33 && 79 > app.mouseY) {
				app.image(instruction2, 0, 0);

			} else {
				app.image(instruction1, 0, 0);
			}
		}

		// método para pasar de pantalla
		public int switchScreen() {
			int screen = 2;

			if (app.mouseX > 27 && 64 > app.mouseX && app.mouseY > 27 && 64 > app.mouseY) {
			
				screen = 1;
			}
			return screen;
		}
		
		
}
