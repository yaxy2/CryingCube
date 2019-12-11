package com.yaxy2.engine;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Window {

	
	private JFrame jf;
	private JPanel jp;
	private BufferedImage img;
	private Canvas cv;
	private Graphics g;
	private BufferStrategy bs;
	private JLabel jl;
	
	public Window()
	{
		img = new BufferedImage(GameAttributes.RESOLUTION_WIDTH, GameAttributes.RESOLUTION_HEIGHT, BufferedImage.TYPE_INT_RGB);
		
		Dimension dm = new Dimension((int)(GameAttributes.RESOLUTION_WIDTH * GameAttributes.RESOLUTION_SCALE), (int)(GameAttributes.RESOLUTION_HEIGHT * GameAttributes.RESOLUTION_SCALE));
		
		jf = new JFrame(GameAttributes.GAME_TITLE);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jl = new JLabel();
		
		jl.setVisible(true);
		
		jp = new JPanel();
		jp.setSize(new Dimension((int)(GameAttributes.RESOLUTION_WIDTH * GameAttributes.RESOLUTION_SCALE),(int)(GameAttributes.RESOLUTION_HEIGHT * GameAttributes.RESOLUTION_SCALE)-((int)(GameAttributes.RESOLUTION_HEIGHT * GameAttributes.RESOLUTION_SCALE)-(int) (300 * GameAttributes.RESOLUTION_SCALE))));
		
		jp.add(jl);
		
		cv = new Canvas();
		cv.setPreferredSize(dm);
		cv.setMaximumSize(dm);
		cv.setMinimumSize(dm);
		
		jf.setLayout(new BorderLayout());
		
		jf.add(jp, BorderLayout.NORTH);
		jf.add(cv, BorderLayout.SOUTH);
		
		jf.pack();	
		
		jf.setLocationRelativeTo(null);
		jf.setResizable(false);
		
		jl.setVisible(true);
		
		jf.setVisible(true);		
		
		cv.createBufferStrategy(2);
		bs = cv.getBufferStrategy();
		g = bs.getDrawGraphics();
		
	}
	
	
	public void update(int[][] p, int framerate) {
		
		for (int x = 0; x < img.getWidth(); x++) {
			for (int y = 0; y < img.getHeight(); y++) {
		
				img.setRGB(x, y, p[y][x]);
				
			}
		}
		g.drawImage(img, 0, 0, cv.getWidth(), cv.getHeight(), null);
		updateFramerate(framerate);
		bs.show();	
		
	}
	private void updateFramerate(int framerate)
	{
		jl.setText("actual framerate: " + Integer.toString(framerate) + "fps");
	}
	
	
	
}
