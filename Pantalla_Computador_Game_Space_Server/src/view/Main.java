package view;

import processing.core.PApplet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;

import com.google.gson.Gson;

import model.Session;
import model.SpaceRacers;

public class Main extends PApplet {

	private int screen;
	private HomeView homeview;
	private InstructionsView instructionsview;
	private Map mapview;
	private BufferedReader reader;
	private BufferedWriter writer;
	
	public static void main(String[] args) {
		PApplet.main(Main.class.getName());
	}

	public void settings() {
		size(1152, 700);
	}

	public void setup() {
		
		screen = 1;
		homeview = new HomeView(this);
		instructionsview = new InstructionsView(this);
		mapview = new Map(this);

	}

	public void draw() {
		background(0);

		// Metodos para pasar pantallas
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
			mapview.drawScreen(screen);
			new Thread(mapview).start();
			screen = mapview.drawScreen(screen);
			break;

		case 6:
			mapview.drawScreen(screen);
			screen = mapview.drawScreen(screen);
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
			// screen = mapview.switchScreen(screen);
			break;
		default:
			break;
		}
	}

	public void keyPressed() {
		switch (screen) {
		case 5:
			mapview.moveOvni(screen);
			break;

		default:
			break;
		}
	}

	public void keyReleased() {
		switch (screen) {
		case 5:
			mapview.stopOvni(screen);
			break;

		default:
			break;
		}
	}
}
