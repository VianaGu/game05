package com.gcstudios.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.gcstudios.world.World;

public class Enemy extends Entity{
	
	public boolean right = true,left = false;
	
	public int vida = 3;

	public Enemy(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
	}
	
	public void tick() {
		if(World.isFree((int)(x+speed),(int)(y))) {
			x+=speed;
		}else if(World.isFree(getX(), getY()+(int)speed)) {
			y+=speed;
		}else if(World.isFree(getX(), getY()-(int)speed)) {
			y-=speed;
		}
	}
	
	public void render(Graphics g) {
		if(right)
		sprite = Entity.ENEMY1_RIGHT;
		else if(left)
		sprite = Entity.ENEMY1_LEFT;
		
		super.render(g);
	}

}
