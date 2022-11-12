package main;

import java.awt.Graphics;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import model.GObject;
import model.Manipulator;

public class MyPanel extends JPanel {

	public GObject g;
	private static final long serialVersionUID = 1L;

	/**
	 * This is the default constructor
	 */
	public MyPanel() {
		this.setSize(2300, 2300);
		this.setLayout(new GridBagLayout());
		g = new Manipulator();
		// g = new Wheel();
	}

	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);

		if (g != null) {
			g.drawMe(arg0);
		}
	}

}
