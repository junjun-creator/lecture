package chapter7ex3;

import java.awt.Canvas;
import java.awt.Graphics;

public class GameCanvas extends Canvas {
	@Override
	public void paint(Graphics g) {
		g.drawLine(0, 0, 200, 200);//검은 선을 0,0 좌표에서 200,200 좌표까지 그림
	}
}
