package model;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;

public class SpaceRacers {
	private PApplet app;
    private final float gridSize; 
    private Ovni1 ovni1;
	private final float rightMargin;
	private final float leftMargin;
	private float posXbg,posYbg;
	
	private ArrayList<Obstacles> obstaclesList;
	
	private static SpaceRacers onlyInstance;
	
	public SpaceRacers(PApplet app) {
		this.app = app;
		gridSize = 150;                              //TAMA�O DE LA CUADRICULA
		obstaclesList = new ArrayList<>();
		
		//caracteristicas de personaje (Poscion inicial y tama�o de la imagen del personaje)
        ovni1 = new Ovni1("Img/Character.png", 110, 20, app);
		
        ovni1.centerX = 133;
        ovni1.centerY = 634;
		rightMargin = 300;
		leftMargin = 0;
		posXbg = 0;
		posYbg = 0;
		
		createObstacles("Data/GridMap.csv");
		
	}
	
	
	public static SpaceRacers getInstance(PApplet app) {
		if (onlyInstance == null) {
			onlyInstance = new SpaceRacers(app);
		}
		return onlyInstance;
	}
	

	
	public void drawObstacles() {

		ovni1.draw();
		scrollMap();

		
		resolvePlatformCollisions(ovni1, obstaclesList);

		for (Obstacles o : obstaclesList) {
			o.draw();
		}

	}
	
	// -------------------------------------------------------------------------------------------------------------------

		// COLISIONES

		public boolean checkCollision(Ovni1 c, Obstacles o1) { // se supone que deben chacer el ovni con el
																	// obstaculo
			boolean hNoverlap = c.getRight(66) <= o1.getLeft(150) || c.getLeft(66) >= o1.getRight(150);
			boolean VNoverlap = c.getBottom(71) <= o1.getTop(150) || c.getTop(71) >= o1.getBottom(150);
			if (hNoverlap || VNoverlap) {
				return false;
			} else {
				return true;
			}
		}

		// metodo para las colisones

		public ArrayList<Obstacles> checkCollisionList(Ovni1 c, ArrayList<Obstacles> list) {
			ArrayList<Obstacles> collision_list = new ArrayList<Obstacles>();
			for (Obstacles p : list) {
				if (checkCollision(c, p))
					collision_list.add(p);
			}

			return collision_list;
		}
	
		
		
		public void resolvePlatformCollisions(Ovni1 c, ArrayList<Obstacles> walls) {

			c.changeY += c.changeY;

			c.centerY += c.changeY;

			ArrayList<Obstacles> col_list = checkCollisionList(c, walls);

			if (col_list.size() > 0) {
				Obstacles collided = col_list.get(0);
				if (c.changeY > 0) {
					c.setBottom(collided.getTop(150), 71);
					
				} else if (c.changeY < 0) {
					c.setTop(collided.getBottom(150), 71);
				}
				c.changeY = 0;
			}

			c.centerX += c.changeX;
			col_list = checkCollisionList(c, walls);

			if (col_list.size() > 0) {
				System.out.println(col_list.size());
				Obstacles collided = col_list.get(0);
				if (c.changeX > 0) {
					c.setRight(collided.getLeft(150), 66);

				} else if (c.changeX < 0) {
					c.setLeft(collided.getRight(150), 66);

				}

			}
			if (col_list.size() == 1) {
				col_list.remove(0);
			}

		}
		
		//-------------------------------------------------------------------------------------------------------------------
		private void createObstacles(String filename) {
			String[] lines = app.loadStrings(filename);
			for (int row = 0; row < lines.length; row++) {
				String[] values = app.split(lines[row], ";");
				for (int col = 0; col < values.length; col++) {
					if (values[col].equals("1")) {
						Obstacles o = new Obstacles("Img/Blocks/Meteorito1.png", 0, 0, app);
						o.setCenterX(gridSize / 2 + col * gridSize);
						o.setCenterY(gridSize / 2 + row * gridSize);
						obstaclesList.add(o);
					} 

				}
			}

		}
		
	//-------------------------------------------------------------------------------------------------------------------	
		
	public void moveOvni() {
		if ((ovni1.getCenterX() > leftMargin && ovni1.getCenterX() < rightMargin)|| (posXbg <= -1152)|| (posYbg <= -700)) {

			new Thread(ovni1).start();
		}


	}
	
	public void releasedKey() {
		
		ovni1.releasedKey();
	}
	
	public void scrollMap() {

		if (app.keyPressed == true ) {
			
			if (ovni1.getCenterY() > leftMargin && app.keyCode == PConstants.UP && posYbg <= -700 && posYbg >= 16233) {
				for (int i = 0; i < obstaclesList.size(); i++) {
					obstaclesList.get(i).goBackMap();
				}

				posYbg += 4;
			}
		}
		
		System.out.println(posYbg);
	}
	
	
	
	
	
	
	
	public float getPosXbg() {
		return posXbg;
	}

	public void setPosXbg(float posXbg) {
		this.posXbg = posXbg;
	}
	public float getPosYbg() {
		return posXbg;
	}

	public void setPosYbg(float posXbg) {
		this.posXbg = posXbg;
	}
}




