
import processing.core.PApplet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;

public class Main extends PApplet {

	private int screen;
	private HomeView homeview;
	private InstructionsView instructionsview;
	private Socket socket;
	private BufferedReader reader;
	private BufferedWriter writer;

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());
		// TODO Auto-generated method stub

	}

	public void settings() {
		size(1152, 700);
	}

	public void setup() {
		initServer();
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
			// mapview.drawScreen(screen);
			// new Thread (mapview).start();
			// screen = mapview.switchScreen();
			// screen = mapview.drawScreen(screen);
			break;

		case 6:
			// mapview.drawScreen(screen);
			// screen = mapview.drawScreen(screen);
			// mapview.time();
			// screen = mapview.switchScreen();
			break;

		case 7:
			// mapview.drawScreen(screen);
			// screen = mapview.drawScreen(screen);
			// nicknameview.hideCp5();
			// mapview.kilometros();
			// screen = mapview.switchScreen();
			break;

		default:
			break;
		}

		text("x:" + mouseX + "y:" + mouseY, mouseX, mouseY);
	}
	



	public void mousePressed() {

		Message("Click desde el cliente");
		
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
			// screen = mapview.switchScreen(screen);
			break;
		default:
			break;
		}
	}

	public void initServer() {

		new Thread(() -> {

			try {
				// 1. Se espera la conexión
				ServerSocket server = new ServerSocket(5000);
				System.out.println("Esperando conexión");
				socket = server.accept();
				// 3.Cliente y server conectados
				System.out.println("Cliente conectado");
				InputStream is = socket.getInputStream();

				InputStreamReader isr = new InputStreamReader(is);

				reader = new BufferedReader(isr);
			    OutputStream out =  socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(out);
				writer = new BufferedWriter(osw);
				while (true) {
					System.out.println("Esperando...");
					String line = reader.readLine();
					System.out.println("Recibid0" + line);
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}).start();
	}
//Error aquí
	public void Message(String msg) {
        new Thread(
                () -> {
                    try {
                        writer.write(msg + "\n");
                        writer.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        ).start();
  
	
	}
	
	public BufferedWriter getWriter() {
		return writer;
	}

}
