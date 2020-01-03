package com.nw.fractal.tree;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class TreeFrame extends JFrame {

	private int canvasWidth;
	private int canvasHeight;
	private TreeData data;

	public TreeFrame(String title, int canvasWidth, int canvasHeight) {
		super(title);
		this.canvasWidth = canvasWidth;
		this.canvasHeight = canvasHeight;
		
		TreeCanvas canvas = new TreeCanvas();
        this.setContentPane(canvas);

		this.setResizable(false);
		this.pack();
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	private class TreeCanvas extends JPanel {

		@Override
		public Dimension getPreferredSize() {
			return new Dimension(canvasWidth, canvasHeight);
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			VisUtil util = VisUtil.getInstance(g);
			if(data != null) {
				TreeFrame.this.drawFractal(util, 
						                   getCanvasWidth() / 2, 
						                   getCanvasHeight(), 
						                   getCanvasHeight(), 0, 0);
			}
		}

	}
	
	public int getCanvasWidth() {
		return canvasWidth;
	}

	public int getCanvasHeight() {
		return canvasHeight;
	}

	public void drawFractal(VisUtil g,
			                double x1, 
			                double y1, 
			                double len,
			                double angle, 
			                int depth) {
		System.out.println(this.data.depth);
		if(this.data.depth == depth) {
			double x2 = x1 - Math.sin(angle * Math.PI / 180.0) * len;
			double y2 = y1 - Math.cos(angle * Math.PI / 180.0) * len;
			g.setColor(VisUtil.Indigo);
			g.drawLine(x1, y1, x2, y2);
			return;
		}
		
		double s = len / 2;
		double x2 = x1 - Math.sin(angle * Math.PI / 180.0) * s;
		double y2 = y1 - Math.cos(angle * Math.PI / 180.0) * s;
		g.setColor(VisUtil.Indigo);
		g.drawLine(x1, y1, x2, y2);
		
		drawFractal(g, x2, y2, s, angle + this.data.splitAngle / 2, depth + 1);
		drawFractal(g, x2, y2, s, angle - this.data.splitAngle / 2, depth + 1);
	}
	
	public void render(TreeData data) {
		this.data = data;
		repaint();
	}

}
