package dev.codenmore.tilegame.states;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.ImageLoader;

public class mapState extends State {
	private BufferedImage map;

	public mapState(Handler handler) {
		super(handler);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		System.out.println(handler.getMouseManager().getMouseX() + "  " + handler.getMouseManager().getMouseY());
		if (handler.getMouseManager().getMouseX() >725 && handler.getMouseManager().getMouseX()<745 && handler.getMouseManager().getMouseY()>718 && handler.getMouseManager().getMouseY()<738 && handler.getMouseManager().isLeftPressed()) {
			State.setState(handler.getGame().mansionState);
		}
		if (handler.getMouseManager().getMouseX() >70 && handler.getMouseManager().getMouseX()<90 && handler.getMouseManager().getMouseY()>220 && handler.getMouseManager().getMouseY()<240 && handler.getMouseManager().isLeftPressed()) {
			State.setState(handler.getGame().parkState);
		}
		if (handler.getMouseManager().getMouseX() >443 && handler.getMouseManager().getMouseX()<463 && handler.getMouseManager().getMouseY()>471 && handler.getMouseManager().getMouseY()<491 && handler.getMouseManager().isLeftPressed()) {
			State.setState(handler.getGame().jazzState);
		}
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		map = ImageLoader.loadImage("/textures/map.jpg");
		//map = resize(map,handler.getWidth(), handler.getHeight());
		//map = map.getSubimage(0, 0, handler.getWidth(), handler.getHeight()-50);
		//map = resize(map,handler.getWidth(), handler.getHeight());
		g.drawImage(map, 0,0, null);
		g.setColor(Color.red);
		g.fillOval(725, 718, 20, 20);
		g.fillOval(70, 220, 20, 20);
		g.fillOval(443, 471, 20, 20);
		Font fnt0 = new Font("arial",Font.PLAIN,15);
		g.setFont(fnt0);
		g.drawString("Park", 65, 253);
		g.drawString("Mansion", 710, 750);
		g.drawString("Jazz Club", 428, 505);
		
	}
	
	/*public BufferedImage resize(BufferedImage img, int newW, int newH) { 
	    Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
	    BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2d = dimg.createGraphics();
	    g2d.drawImage(tmp, 0, 0, null);
	    g2d.dispose();
	    return dimg;
	} 
	*/ 

}
