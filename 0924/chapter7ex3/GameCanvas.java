package chapter7ex3;

import java.awt.Canvas;
import java.awt.Graphics;

public class GameCanvas extends Canvas {
	@Override
	public void paint(Graphics g) {
		g.drawLine(0, 0, 200, 200);//���� ���� 0,0 ��ǥ���� 200,200 ��ǥ���� �׸�
	}
}
