package dev.codenmore.tilegame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.gfx.GameCamera;
import dev.codenmore.tilegame.input.KeyManager;
import dev.codenmore.tilegame.input.MouseManager;
import dev.codenmore.tilegame.states.GameState;
import dev.codenmore.tilegame.states.MenuState;
import dev.codenmore.tilegame.states.SettingState;
import dev.codenmore.tilegame.states.State;
import dev.codenmore.tilegame.states.jazzPRoomState;
import dev.codenmore.tilegame.states.jazzState;
import dev.codenmore.tilegame.states.mansionArcadeState;
import dev.codenmore.tilegame.states.mansionGardenState;
import dev.codenmore.tilegame.states.mansionState;
import dev.codenmore.tilegame.states.mansionStudyState;
import dev.codenmore.tilegame.states.mapState;
import dev.codenmore.tilegame.states.parkState;

public class Game implements Runnable {

	private Display display;
	private boolean running = false;
	private int width, height;
	public String title;

	private Thread thread;

	private BufferStrategy bs;
	private Graphics g; // magical paintbrush

	// States
	public State gameState;
	public State menuState;
	public State settingState;
	public State mapState;
	public State mansionState;
	public State parkState;
	public State jazzState;
	public State mansionArcadeState;
	public State mansionStudyState;
	public State mansionGardenState;
	public State jazzPRoomState;
	
	//Input
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	//Camera
	private GameCamera gameCamera;
	
	//Handler
	private Handler handler;
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}

	private void init() { // only called once, initializes all graphics
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager); //lets us access keyboard
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init();
		
		gameCamera = new GameCamera(this, 0,0);
		handler = new Handler(this);
		
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		settingState = new SettingState(handler);
		mapState = new mapState(handler);
		mansionState = new mansionState(handler);
		parkState = new parkState(handler);
		jazzState = new jazzState(handler);
		mansionGardenState = new mansionGardenState(handler);
		mansionArcadeState = new mansionArcadeState(handler);
		mansionStudyState = new mansionStudyState(handler);
		jazzPRoomState = new jazzPRoomState(handler);
		State.setState(menuState);
	}

	private void update() {
		keyManager.tick();
		
		if (State.getState() != null) {
			State.getState().tick();
		}
	}

	private void render() {
		bs = display.getCanvas().getBufferStrategy(); // bs = a way for computer
														// to draw things to the
														// screenand uses
														// buffers(hidden
														// computer screen) to
														// do that
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		// Clear Screen
		g.clearRect(0, 0, width, height);
		// Draw Here!
		if (State.getState() != null) {
			State.getState().render(g);
		}

		// End Drawing!
		bs.show();
		g.dispose();
	}

	public void run() {
		init();

		int fps = 60; // how many times per seconds that update is called
		double timePerTick = 1000000000 / fps; // one billion/fps
		double delta = 0;
		long now;
		long lastTime = System.nanoTime(); // returns current time of computer
											// in nanosec
		long timer = 0;
		int ticks = 0;

		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {
				update();
				render();
				ticks++;
				delta--;
			}
			if (timer >= 1000000000) {
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}

		stop();
	}
	
	public KeyManager getKeyManager(){
		return keyManager;
	}
	public MouseManager getMouseManager() {
		return mouseManager;
	}

	public GameCamera getGameCamera(){
		return gameCamera;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public synchronized void start() { // synchronized only used to start/stop a
		if (running) {
			return;
		}
		running = true; // thread
		thread = new Thread(this);
		thread.start(); // calls run method, where majority of game code wil go
	}

	public synchronized void stop() {
		if (!running) { // acting like safety
			return;
		}
		running = false;

		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
