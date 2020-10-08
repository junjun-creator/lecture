package com.newlecture.app.prj3.entity;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import com.newlecture.app.prj3.canvas.PuzzleCanvas;

public class Puzzle {
	private int di;
	private int si;
	private Image img;
	
	public Puzzle() {
		this(0,0);
	}
	
	public Puzzle(int di, int si) {
		Toolkit tk = Toolkit.getDefaultToolkit();//알아서 현재 환경에 맞게 툴킷을 얻어줌
		//스태틱 함수. 이 함수에서 return new Toolkit();을 생성
		img = tk.getImage("res/바다.jpg");
		
		this.di = di;
		this.si = si;
	}
	
	public void paint(Graphics g) {
		int dividedWidth = img.getWidth(PuzzleCanvas.instance)/3;
		int dividedHeight = img.getHeight(PuzzleCanvas.instance)/2;
		
		int xOffset_d = (di-1)%3;
		int yOffset_d = (di-1)/3;
			
		int xOffset_s = (si-1)%3;
		int yOffset_s = (si-1)/3;
			
		int dx1 = dividedWidth*xOffset_d;
		int dy1 = dividedHeight*yOffset_d;
		int dx2 = dividedWidth*(xOffset_d+1);
		int dy2 = dividedHeight*(yOffset_d+1);
			
		int sx1 = dividedWidth*xOffset_s;
		int sy1 = dividedHeight*yOffset_s;
		int sx2 = dividedWidth*(xOffset_s+1);
		int sy2 = dividedHeight*(yOffset_s+1);
			
			//g.drawImage(img, 0+dividedWidth*((di-1)%3),0+dividedHeight*((di-1)/3),0+dividedWidth*((di-1)%3+1),0+dividedHeight*((di-1)/3+1), 0+dividedWidth*((si-1)%3),0+dividedHeight*((si-1)/3),0+dividedWidth*((si-1)%3+1),0+dividedHeight*((si-1)/3+1), this);
		g.drawImage(img, dx1/2, dy1/2, dx2/2, dy2/2, sx1, sy1, sx2, sy2, PuzzleCanvas.instance);
		
	}

	public int getDi() {
		return di;
	}

	public void setDi(int di) {
		this.di = di;
	}

	public int getSi() {
		return si;
	}

	public void setSi(int si) {
		this.si = si;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}
	
	
	
}
