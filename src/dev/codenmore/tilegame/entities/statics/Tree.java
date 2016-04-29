package dev.codenmore.tilegame.entities.statics;

import java.awt.Graphics;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.tile.Tile;

public class Tree extends StaticEntity {
	public Tree(Handler handler, float x, float y) {
		super(handler,x,y,Tile.TILEWIDTH, Tile.TILEHEIGHT*2);
	}
	public void tick() {
		
	}
	public void render(Graphics g) {
		g.drawImage(Assets.tree, (int) (x), (int) (y), width, height, null);
	}
}
