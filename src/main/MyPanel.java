package main;

import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.FlyWheel;
import model.GObject;
import view.FlyWheelView;

public class MyPanel extends JPanel {

	public GObject g;
	private static final long serialVersionUID = 1L;
	public FlyWheel flyWheel = null;
	public FlyWheelView flyWheelView = null;
	public ArrayList<Double> axlelist = new ArrayList<>();

	public MyPanel(FlyWheel flyWheel, FlyWheelView flyWheelView) {
		this.flyWheel=flyWheel;
		this.setSize(2300, 2300);
		this.setLayout(new GridBagLayout());
		g = flyWheelView;
		this.flyWheelView=flyWheelView;
	}

	public void addAxle(double axle){
		axlelist.add(axle);
		if(axlelist.size()>1920) axlelist.remove(0);
	}

	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		if (g != null) {
			g.drawMe(arg0);
		}
	}

}
