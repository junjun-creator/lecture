package com.newlecture.app.prj3;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

import com.newlecture.app.prj3.canvas.ActionCanvas;
import com.newlecture.app.prj3.canvas.PuzzleCanvas;

public class GameFrame extends Frame {

	public GameFrame() {
		//Canvas canvas = new PuzzleCanvas(Color.pink);
		ActionCanvas canvas = new ActionCanvas(Color.pink);
		canvas.start();
		
		this.setSize(1500, 500);
		this.setVisible(true);
		
		this.add(canvas);
	}
	
}
