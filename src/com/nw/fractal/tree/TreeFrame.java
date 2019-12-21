package com.nw.fractal.tree;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class TreeFrame extends JFrame {

	private int canvasWidth;
	private int canvasHeight;

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

	}

}
