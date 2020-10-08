package com.newlecture.app.prj3.canvas;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

import com.newlecture.app.prj3.service.PuzzleService;

public class PuzzleCanvas extends Canvas {
	public static Canvas instance;
	
	private Image img;
	
	PuzzleService service;
	
	public PuzzleCanvas(Color color) {
		
		//imgCount = 6;
		instance = this;
		
		service = new PuzzleService();
		
		service.shuffle();
		
		//Toolkit tk = Toolkit.getDefaultToolkit();//�˾Ƽ� ���� ȯ�濡 �°� ��Ŷ�� �����
					//����ƽ �Լ�. �� �Լ����� return new Toolkit();�� ����
		//img = tk.getImage("res/�ٴ�.jpg");
		
		this.setBackground(color);
	}
	
	@Override
	public boolean mouseDown(Event evt, int x, int y) {
	      
	      service.shuffle();
	      
	      repaint();
	      
	      return super.mouseDown(evt, x, y);
	}

	
	@Override
	public void paint(Graphics g) {
		
		for(int i=0;i<6;i++) {
			service.get(i).paint(g);
		}
		
	}
}
