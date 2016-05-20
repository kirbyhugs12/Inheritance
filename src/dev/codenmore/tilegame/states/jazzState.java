package dev.codenmore.tilegame.states;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.ImageLoader;

public class jazzState extends State {
	private BufferedImage mapIcon;
	private BufferedImage rightArrow;
	private BufferedImage leftArrow;
	private BufferedImage upArrow;
	private Font fnt0;
	
	public jazzState(Handler handler) {
		super(handler);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		if(handler.getMouseManager().getMouseX() > 10 && handler.getMouseManager().getMouseX() < 70 && handler.getMouseManager().getMouseY() > 10 && handler.getMouseManager().getMouseY() < 60 && handler.getMouseManager().isLeftPressed()) {
			State.setState(handler.getGame().mapState);
		}
		
	}

	@Override
	public void render(Graphics g) {
		fnt0 = new Font("arial", Font.BOLD, 40);
		g.setFont(fnt0);
		g.setColor(Color.black);
		g.drawString("Jazz Club", 30, 720);
		mapIcon = ImageLoader.loadImage("/textures/mapIcon.png");
		mapIcon = resize(mapIcon,90,75);
		g.drawImage(mapIcon, 10, 10, null);
		rightArrow = ImageLoader.loadImage("/textures/rightarrow.png");
		g.drawImage(rightArrow, 850, 300,null);
		leftArrow = ImageLoader.loadImage("/textures/leftarrow.png");
		g.drawImage(leftArrow, 15, 300,null);
		upArrow = ImageLoader.loadImage("/textures/uparrow.png");
		g.drawImage(upArrow, 450, 5,null);
		
		
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
