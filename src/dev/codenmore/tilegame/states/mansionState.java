package dev.codenmore.tilegame.states;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.ImageLoader;

public class mansionState extends State{
	private BufferedImage hall;
	private BufferedImage mapIcon;
	private BufferedImage rightArrow;

	public mansionState(Handler handler) {
		super(handler);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		//System.out.println("hi");
		if(handler.getMouseManager().getMouseX() > 20 && handler.getMouseManager().getMouseX() < 80 && handler.getMouseManager().getMouseY() > 420 && handler.getMouseManager().getMouseY() < 470 && handler.getMouseManager().isLeftPressed()) {
			State.setState(handler.getGame().mapState);
		}
		if(handler.getMouseManager().getMouseX() > 430 && handler.getMouseManager().getMouseX() < 500 && handler.getMouseManager().getMouseY() > 200 && handler.getMouseManager().getMouseY() < 270 && handler.getMouseManager().isLeftPressed()) {
			State.setState(handler.getGame().mansionArcadeState);
		}
	}
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		hall = ImageLoader.loadImage("/textures/photo.JPG");
		hall = resize(hall,handler.getWidth(), handler.getHeight());
		g.drawImage(hall, 0,0, null);
		mapIcon = ImageLoader.loadImage("/textures/mapIcon.png");
		mapIcon = resize(mapIcon,60,50);
		g.drawImage(mapIcon, 20, 420,null);
		rightArrow = ImageLoader.loadImage("/textures/rightarrow.png");
		rightArrow = resize(rightArrow,70,70);
		g.drawImage(rightArrow, 430, 200,null);
	}
	
	public BufferedImage resize(BufferedImage img, int newW, int newH) { 
	    Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
	    BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2d = dimg.createGraphics();
	    g2d.drawImage(tmp, 0, 0, null);
	    g2d.dispose();

	    return dimg;
	}

}
