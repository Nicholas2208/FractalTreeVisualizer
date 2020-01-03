package com.nw.fractal.tree;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class VisUtil {
	
	public static final Color Indigo = new Color(0x3F51B5);
	private Graphics2D g2d;

	private VisUtil(Graphics2D g2d) {
		this.g2d = g2d;
	}
	
	public static VisUtil getInstance(Graphics g) {
		return new VisUtil((Graphics2D) g);
	}
	
	public void drawLine(double x1, double y1, double x2, double y2) {
		Line2D line = new Line2D.Double(x1, y1, x2, y2);
		g2d.draw(line);
	}
	
	public void setColor(Color color) {
		this.g2d.setColor(color);
	}

}
