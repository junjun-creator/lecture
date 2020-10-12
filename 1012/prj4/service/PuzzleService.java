package com.newlecture.app.prj4.service;

import java.awt.Toolkit;
import java.util.Random;

import com.newlecture.app.prj4.entity.Puzzle;

public class PuzzleService {
	private int imgCount;
	private Puzzle[] puzzles;
	private int[] dIndex;
	private int[] sIndex;
	
	public PuzzleService() {
		dIndex = new int[]{1,2,3,4,5,6};
		sIndex = new int[]{1,2,3,4,5,6};
		imgCount = 6;
		puzzles = new Puzzle[imgCount];
		
		for(int i=0;i<imgCount;i++) {
			puzzles[i] = new Puzzle(dIndex[i],sIndex[i]);
		}
	}
	
	public void shuffle() {
		
		Random rd = new Random();
		for(int i=0;i<100;i++) {
			int a = rd.nextInt(imgCount);
			int b = rd.nextInt(imgCount);
			int temp = dIndex[a];
			dIndex[a] = dIndex[b];
			dIndex[b] = temp;
		}
		
		for(int i=0;i<imgCount;i++) {
			puzzles[i].setDi(dIndex[i]);
			puzzles[i].setSi(sIndex[i]);
		}
		
	}
	
	public Puzzle get(int i) {
		return puzzles[i];
	}
}
