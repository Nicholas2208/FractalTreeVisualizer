package com.nw.fractal.tree;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TreeVisualizer {
	
	public static final int MAX_DEPTH = 6;
	public static final double SPLIT_ANGLE = 60.0;
	
	TreeData data;
    TreeFrame frame;
	
	public TreeVisualizer(int sceneWidth, int sceneHeight) {
		data = new TreeData(MAX_DEPTH, SPLIT_ANGLE);
		frame = new TreeFrame("Tree Fractal", sceneWidth, sceneHeight);
		EventQueue.invokeLater(() -> {
			new Thread(() -> run(data)).start();
		});
	}
	
	public void run(TreeData data) {
		setData(0);
	}
	
	private void setData(int depth) {
		this.data.depth = depth;
		frame.render(data);
		frame.addKeyListener(new TreeKeyListener());
	}
	
	private class TreeKeyListener extends KeyAdapter{

		@Override
		public void keyReleased(KeyEvent event) {
			char keyChar = event.getKeyChar();
			if(keyChar >= '0' && keyChar <= '9') {
				int depth = keyChar - '0';
				setData(depth);
			}
		}
	}
	

	public static void main(String[] args) {
		new TreeVisualizer(800, 800);
	}

}
