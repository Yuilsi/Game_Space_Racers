package model;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Elements {

	protected PApplet app;

	protected float posX, posY;
	protected float centerX, centerY;
	protected float changeX, changeY;
	//private float w, h;

	public Elements(String filename, float posX, float posY, PApplet app) {

		this.posX = posX;
		this.posY = posY;
		this.app = app;

		centerX = posX;
		centerY = posY;
		changeX = 0;
		changeY = 0;

	}

//-------------------------------------------------------------------------------------------------------------------
	// LADOS PARA COLISIONES
	
	public void setLeft(float left, float w) {
		centerX = left +(w / 2);
	}
	
	public float getLeft(float w) {
		return centerX - (w / 2);
	}

	public void setRight(float right, float w) {
		centerX = right - (w / 2);
	}

	public float getRight(float w) {
		return centerX + (w / 2);
	}

	public void setTop(float top, float h) {
		centerY = top + (h / 2);
	}

	public float getTop(float h) {
		return centerY - (h / 2);
	}

	public void setBottom(float bottom, float h) {
		centerY = bottom - (h / 2);
	}

	public float getBottom(float h) {
		return centerY + (h / 2);
	}

//-----------------------------------------------------------------------------------------------------------------------------------

	public float getCenterX() {
		return centerX;
	}

	public float getPosX() {
		return posX;
	}

	public void setPosX(float posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(float posY) {
		this.posY = posY;
	}

	public void setCenterX(float centerX) {
		this.centerX = centerX;
	}

	public float getCenterY() {
		return centerY;
	}

	public void setCenterY(float centerY) {
		this.centerY = centerY;
	}

	public float getChangeX() {
		return changeX;
	}

	public void setChangeX(float changeX) {
		this.changeX = changeX;
	}

	public float getChangeY() {
		return changeY;
	}

	public void setChangeY(float changeY) {
		this.changeY = changeY;
	}
}
