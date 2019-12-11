package com.yaxy2.engine;

import java.awt.Color;
import java.util.Random;

public class Renderer {

	int [][] p;
	
	int pixelWidth, pixelHeight = 0;
	
	public Renderer() {
		
		pixelWidth = (int)(GameAttributes.RESOLUTION_WIDTH * GameAttributes.RESOLUTION_SCALE);
		pixelHeight = (int)(GameAttributes.RESOLUTION_HEIGHT * GameAttributes.RESOLUTION_SCALE);
		
		p = new int[pixelHeight][pixelWidth];
		
		
	}
	
	
	public void clearScreenBlack() {
		
		for (int j = 0; j < p.length; j++) {
			for (int i = 0; i < p[0].length; i++) {
				
				p[j][i] = 0xff000000;
				
			}		
		}
		
	}
	
	public int[][] getP() {
		return p;
	}


	public void clearScreenColor(Color color) {
		
		int hexColor = color.getRGB() & 0xffffff;
		
		
		
		for (int i = 0; i < p[0].length; i++) {
			for (int j = 0; j < p.length; j++) {
				
				p[j][i] = hexColor;
				
			}		
		}
		
		
	}
	
	public void randomColoredNoise(){
		
		Random rand = new Random();
		
		
		for (int i = 0; i < p[0].length; i++) {
			for (int j = 0; j < p.length; j++) {
				
				int randRed = rand.nextInt(255) & 0xffffff;
				int randGreen = rand.nextInt(255) & 0xffffff;
				int randBlue = rand.nextInt(255) & 0xffffff;
				
				randRed <<=16;
				randGreen <<=8;
				
				int randomGeneratedColor = randRed | randGreen | randBlue;
			
				p[j][i] = randomGeneratedColor;
				
			}
		}
	}


	public void lsd() {
		
		int count = 0;
		
		for (int i = 0; i < p[0].length; i++) {
			for (int j = 0; j < p.length; j++) {
				
				p[j][i] += count++;
				
			}
		
		}
		
	}
			
			
	
	
}
