package com.newlecture.app.prj2;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

import com.newlecture.app.prj2.canvas.ActionCanvas;
import com.newlecture.app.prj2.canvas.PuzzleCanvas;

public class GameFrame extends Frame {

	public GameFrame() {
		//Canvas canvas = new PuzzleCanvas(Color.pink);
		Canvas canvas = new ActionCanvas(Color.pink);
		
		this.setSize(1500, 500);
		this.setVisible(true);
		
		this.add(canvas);
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawLine(0, 0, 10, 10);
	}
	
}
