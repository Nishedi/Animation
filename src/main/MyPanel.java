package main;

import java.awt.Graphics;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import model.FlyWheel;
import model.GObject;
import view.FlyWheelView;

public class MyPanel extends JPanel {

	public GObject g;
	private static final long serialVersionUID = 1L;

	public MyPanel() {
		this.setSize(2300, 2300);
		this.setLayout(new GridBagLayout());
		FlyWheel flyWheel = new FlyWheel(300,300, 500,100,100,500);
		g = new FlyWheelView(flyWheel);
	}

	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		if (g != null) {
			g.drawMe(arg0);
		}
	}

}
