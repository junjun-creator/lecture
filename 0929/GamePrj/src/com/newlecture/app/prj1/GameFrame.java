package com.newlecture.app.prj1;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

public class GameFrame extends Frame {

	public GameFrame() {
		Canvas canvas = new GameCanvas(Color.pink);
		this.setSize(500, 700);
		this.setVisible(true);
		
		this.add(canvas);
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawLine(0, 0, 10, 10);
	}
	
}
