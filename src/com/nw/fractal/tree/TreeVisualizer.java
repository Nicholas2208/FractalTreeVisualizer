package com.nw.fractal.tree;

public class TreeVisualizer {
	
TreeFrame frame;
	
	public TreeVisualizer(int sceneWidth, int sceneHeight) {
		frame = new TreeFrame("Tree Fractal", sceneWidth, sceneHeight);
	}

	public static void main(String[] args) {
		new TreeVisualizer(800, 800);
	}

}
