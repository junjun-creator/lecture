package com.newlecture.app.prj2.canvas;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;

import com.newlecture.app.prj2.entity.Boy;
import com.newlecture.app.prj2.entity.Tree;
import com.newlecture.app.prj2.service.BoyService;

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
		firstClicked=0;
		//boy = new Boy(100,200);
		
		boys = new BoyService();
		tree = new Tree(100,100);
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
	/*
	@Override
	public boolean mouseDown(Event evt, int x, int y) {
		
		boys.move(boys.get(0),x, y);
	      
		repaint();
	      
		return super.mouseDown(evt, x, y);
	}*/
	
	public boolean mouseDown(Event evt, int x, int y) {
		//boys.get(0).move(x,y);
		
		for(int i=0;i<3;i++) {
			if(boys.get(i).isSelected(x, y)) {
				curBoy = boys.get(i);
				firstClicked = 0;
			}
		}
		
		if(firstClicked == 0) {
			firstClicked = 1;
		}
		else if(firstClicked != 0 && curBoy != null)
			curBoy.move(x, y);
		
		repaint();
	      
		return super.mouseDown(evt, x, y);
	}

}
