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
		//System.out.println(handler.getMouseManager().getMouseX() + "  " + handler.getMouseManager().getMouseY());
		if (handler.getMouseManager().getMouseX() >357 && handler.getMouseManager().getMouseX()<372 && handler.getMouseManager().getMouseY()>370 && handler.getMouseManager().getMouseY()<385 && handler.getMouseManager().isLeftPressed()) {
			State.setState(handler.getGame().mansionState);
		}
		if (handler.getMouseManager().getMouseX() >45 && handler.getMouseManager().getMouseX()<60 && handler.getMouseManager().getMouseY()>105 && handler.getMouseManager().getMouseY()<120 && handler.getMouseManager().isLeftPressed()) {
			State.setState(handler.getGame().parkState);
		}
		if (handler.getMouseManager().getMouseX() >220 && handler.getMouseManager().getMouseX()<235 && handler.getMouseManager().getMouseY()>250 && handler.getMouseManager().getMouseY()<265 && handler.getMouseManager().isLeftPressed()) {
			State.setState(handler.getGame().jazzState);
		}
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		map = ImageLoader.loadImage("/textures/map.jpg");
		map = resize(map,handler.getWidth(), handler.getHeight());
		map = map.getSubimage(0, 0, handler.getWidth(), handler.getHeight()-50);
		map = resize(map,handler.getWidth(), handler.getHeight());
		g.drawImage(map, 0,0, null);
		g.setColor(Color.red);
		g.fillOval(357, 370, 15, 15);
		g.fillOval(45, 105, 15, 15);
		g.fillOval(220, 250, 15, 15);
		Font fnt0 = new Font("arial",Font.PLAIN,10);
		g.setFont(fnt0);
		g.drawString("Park", 42, 130);
		g.drawString("Mansion", 347, 395);
		g.drawString("Jazz Club", 208, 275);
		
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
