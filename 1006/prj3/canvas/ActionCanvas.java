package com.newlecture.app.prj3.canvas;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;

import com.newlecture.app.prj3.entity.Boy;
import com.newlecture.app.prj3.entity.Tree;
import com.newlecture.app.prj3.service.BoyService;

public class ActionCanvas extends Canvas {
	
	private Boy boy;//캔버스에 일단 개체를 그려놓고 행위를 시킨다.
	public static Canvas instance;
	private BoyService boys;
	private Boy curBoy;
	private int firstClicked;
	private Tree tree;
	
	public ActionCanvas(Color color) {
		instance = this;
		curBoy=null;
		//firstClicked=0;
		//boy = new Boy(100,200);
		
		boys = new BoyService();
		tree = new Tree(200,200);
		this.setBackground(color);
		
	}

	@Override
	public void paint(Graphics g) {
		//boy.paint(g);
		for(int i=0;i<3;i++) {
			boys.get(i).paint(g);
		}
		
		tree.paint(g);
	}
	
	
	public boolean mouseDown(Event evt, int x, int y) {
		
		int isSelected = boys.find(x, y);
		
		if(isSelected != -1) {
			curBoy = boys.get(isSelected);
			firstClicked = 0;
		}
		

		if(firstClicked == 0) {//처음 선택됫을때에는 움직임 없이 선택만 되도록
			firstClicked = 1;
		}
		else if(firstClicked != 0 && curBoy != null)
			curBoy.move(x, y);
		
		System.out.print(x+",,,");
		System.out.println(y);
		
		repaint();
	      
		return super.mouseDown(evt, x, y);
	}

	public void start() {

		Runnable sub = new Runnable() {

			@Override
			public void run() {

				while (true) {
					if(curBoy != null) {
						curBoy.update();
					}
					repaint();
					try {
						Thread.sleep(17);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};

		Thread th = new Thread(sub);
		th.start();
	}

	
}
