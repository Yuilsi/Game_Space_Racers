package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Obstacles extends Elements{
	
	private PImage obstacleImg;
	private int posiX;
	private int posiY;
	
	public Obstacles(String filename, float posX, float posY, PApplet app) {
		
	super(filename, posX, posY, app);
	obstacleImg = app.loadImage(filename);
	posiX = (int)posX;
	posiY = (int)posY;
	
	}
	
	  public void draw(){
		  app.imageMode (PApplet.CENTER);
		  
		     app.image(obstacleImg, centerX, centerY);
		     obstacleImg.resize(50,50);
		  }
	  
	  public void advanceMap(){
	     centerX -= 4;
	     ///centerY += changeY;
	  }
	  
	  public void goBackMap() {
		  centerX += 4;
	  }

	public int getPosiX() {
		return posiX;
	}

	public void setPosiX(int posiX) {
		this.posiX = posiX;
	}

	public int getPosiY() {
		return posiY;
	}

	public void setPosiY(int posiY) {
		this.posiY = posiY;
	}
	  
	  

}
