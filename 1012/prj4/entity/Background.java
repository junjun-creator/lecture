package com.newlecture.app.prj4.entity;

import java.awt.Graphics;
import java.awt.Image;

import com.newlecture.app.prj4.canvas.ActionCanvas;

public class Background extends Item {
	
	private int width = 360;
	private int height = 1200;
	
	public Background() {
		this(0, 0, "res/space.jpg");
		System.out.println(ActionCanvas.instance.getHeight());
	}

	public Background(double x, double y, String imgSrc) {
		super(x, y, imgSrc);
	}

	@Override
	public void paint(Graphics g) {
		Image img = this.getImg();
		double x = this.getX();
		double y = this.getY() + (ActionCanvas.instance.getHeight() - height);
		
		g.drawImage(img, (int)x, (int)y, ActionCanvas.instance);
		g.drawImage(img, (int)x, (int)y-(height), ActionCanvas.instance);
	}

	@Override
	public void update() {
		double vy = this.getVy();
		double y = this.getY();
		
		this.move(0, height);
		y += vy;
		this.setY(y);
		
		double dy = this.getDy();
		if(dy-1<=y&&y<=dy+1)
			this.setY(0);	
	}
	
	
}
