package dev.codenmore.tilegame.states;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.Handler;

public class MenuState extends State{
	private Font fnt0;
	private Font fnt1;
	public MenuState(Handler handler){
		super(handler);
	}
	
	public Rectangle playButton = new Rectangle(435,300,130,65);
	public Rectangle instructionsButton = new Rectangle(435,450,130,65);
	@Override
	
	public void tick() {
		if(handler.getMouseManager().getMouseX() >= 435 && handler.getMouseManager().getMouseX() <= 565 && handler.getMouseManager().getMouseY() >=300 && handler.getMouseManager().getMouseY() <=365 && handler.getMouseManager().isLeftPressed()) {
			State.setState(handler.getGame().mapState);
		}
		
		System.out.println(handler.getMouseManager().getMouseX() + "   " + handler.getMouseManager().getMouseY());
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.draw(instructionsButton);
		g2d.draw(playButton);
		fnt0 = new Font("arial", Font.BOLD, 80);
		fnt1 = new Font("arial",Font.BOLD, 45);
		
		g.setFont(fnt0);
		g.setColor(Color.black);
		g.drawString("Inheritance", 290, 200);
		g.setFont(fnt1);
		g.drawString("Play", playButton.x +20, playButton.y + 50);
		g.drawString("Rules", instructionsButton.x +6, instructionsButton.y + 50);
		
		
	}

}
