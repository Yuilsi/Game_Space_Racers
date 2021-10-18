package model;

import java.util.ArrayList;

import com.google.gson.Gson;
import model.Session;
import processing.core.PApplet;
import processing.core.PConstants;
import model.TCPLauncher;

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
		gridSize = 150;                              //TAMAÑO DE LA CUADRICULA
		obstaclesList = new ArrayList<>();
		
		//caracteristicas de personaje (Poscion inicial y tamaño de la imagen del personaje)
        ovni1 = new Ovni1("Img/Character.png", 101, 20, app);
		
        ovni1.centerX = 101;
        ovni1.centerY = 500;
		rightMargin = 300;
		leftMargin = 0;
		posXbg = 0;
		posYbg = -15506;
		
		createObstacles("Data/GridMap.csv");
		tcplauncher = TCPLauncher.getInstance();
		tcplauncher.setServidor(this);
		tcplauncher.start();
		
		
	}
	
	public static SpaceRacers getInstance(PApplet app) {
		if (onlyInstance == null) {
			onlyInstance = new SpaceRacers(app);
		}
		return onlyInstance;
	}
	
	private TCPLauncher tcplauncher;
	
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
			boolean VNoverlap = c.getBottom(46) <= o1.getTop(150) || c.getTop(71) >= o1.getBottom(150);
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
			c.centerY += c.changeY;
			ArrayList<Obstacles> col_list = checkCollisionList(c, walls);
			//AQUI SI CHOCO CON LOS OBTACULOS EJE Y ,GAME OVER
			if (col_list.size() > 0) {
				System.out.println("PERDISTE");
				app.text("GAME OVER",500, 350);
			//GAME OVER //AQUI SE SUPONE QUE TENGO QUE PONERLE PERDER
			}

			c.centerX += c.changeX;
			col_list = checkCollisionList(c, walls);

			if (col_list.size() > 0) {
				System.out.println("PERDISTE");
				app.text("GAME OVER", 500, 350);
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
		if ((ovni1.getCenterX() > leftMargin && ovni1.getCenterX() < rightMargin)|| (posYbg <= 0)) {
			new Thread(ovni1).start();
		}
	}
	
	public void releasedKey() {
		ovni1.releasedKey();
	}
	
	public void scrollMap() {

		if (app.keyPressed == true ) {
			if (ovni1.getCenterY() > leftMargin && app.keyCode == PConstants.UP && posYbg <= 700 && posYbg >= -16233) {
				for (int i = 0; i < obstaclesList.size(); i++) {
					obstaclesList.get(i).advanceMap();
				}
				posYbg += 8;
			}
		}
		
		System.out.println(posYbg);
		System.out.println(posXbg);
	}
	public void mensaje(Session session, String mensaje) {
		System.out.println("Mensaje recibido de: " + mensaje);
		Gson gson = new Gson();
		//Movimiento jugadorReader = gson.fromJson(mensaje, Movimiento.class);
		

		//session.setMovimiento(jugadorReader);
	}
	public float getPosXbg() {
		return posXbg;
	}

	public void setPosXbg(float posXbg) {
		this.posXbg = posXbg;
	}
	public float getPosYbg() {
		return posYbg;
	}

	public void setPosYbg(float posYbg) {
		this.posYbg = posYbg;
	}	
	
}




