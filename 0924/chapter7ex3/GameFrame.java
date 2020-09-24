package chapter7ex3;

import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Graphics;

public class GameFrame extends Frame{
	Canvas canvas;
	
	public GameFrame() {
		canvas = new GameCanvas();
		add(canvas);
	}
	
	
}
