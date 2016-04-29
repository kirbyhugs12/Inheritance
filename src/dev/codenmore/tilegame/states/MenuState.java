package dev.codenmore.tilegame.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.Handler;

public class MenuState extends State{

	public MenuState(Handler handler){
		super(handler);
	}
	
	public Rectangle playButton = new Rectangle(200,200,100,50);
	public Rectangle instructionsButton = new Rectangle(200,300,100,50);
	@Override
	
	public void tick() {
		if(handler.getMouseManager().getMouseX() >= 200 && handler.getMouseManager().getMouseX() <= 300 && handler.getMouseManager().getMouseY() >=200 && handler.getMouseManager().getMouseY() <=250 && handler.getMouseManager().isLeftPressed()) {
			State.setState(handler.getGame().mapState);
		}
		
		//System.out.println(handler.getMouseManager().getMouseX() + "   " + handler.getMouseManager().getMouseY());
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Font fnt0 = new Font(Font.MONOSPACED, Font.PLAIN, 50);
		g.setFont(fnt0);
		g.setColor(Color.black);
		g.drawString("Inheritance", 90, 100);
		Font fnt1 = new Font("arial",Font.BOLD, 30);
		g.setFont(fnt1);
		g.drawString("Play", playButton.x +20, playButton.y + 36);
		g2d.draw(playButton);
		g.drawString("Rules", instructionsButton.x +10, instructionsButton.y + 36);
		g2d.draw(instructionsButton);
		
	}

}
