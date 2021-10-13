

import processing.core.PApplet;

public class Main extends PApplet {

	private int screen;
	private HomeView homeview;
	private InstructionsView instructionsview;
	

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());
		// TODO Auto-generated method stub

	}

	public void settings() {
		size(1152,700);
	}

	public void setup() {
		screen = 1;
		homeview = new HomeView(this);
		instructionsview = new InstructionsView(this);

	}

	public void draw() {
		background(0);

		switch (screen) {
		case 1:
			homeview.drawScreen();
			break;
		case 2:
			instructionsview.drawScreen();
			break;
		case 3:
			
			break;
		case 4:
		

			break;
		case 5:
			//	mapview.drawScreen(screen);
			//	new Thread (mapview).start();
			//screen = mapview.switchScreen();
			//	screen = mapview.drawScreen(screen);
			break;
			
			
		case 6:
			//	mapview.drawScreen(screen);
			//	screen = mapview.drawScreen(screen);
			//mapview.time();
			//screen = mapview.switchScreen();
			break;
			
		case 7:
			//	mapview.drawScreen(screen);
			//	screen = mapview.drawScreen(screen);
			//	nicknameview.hideCp5();
			//mapview.kilometros();
			//screen = mapview.switchScreen();
			break;

		default:
			break;
		}

		text("x:" + mouseX + "y:" + mouseY, mouseX, mouseY);
	}

	public void mousePressed() {

		switch (screen) {
		case 1:
			screen = homeview.switchScreen();
			break;
		case 2:
			screen = instructionsview.switchScreen();
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		case 5:
			
			break;
			
		case 6:
			//	screen = mapview.switchScreen(screen);
			break;
		default:
			break;
		}
	}
	
	
	
	

	

}
