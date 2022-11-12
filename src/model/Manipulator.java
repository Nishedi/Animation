package model;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Manipulator extends GObject {

	public double alpha, beta=Math.PI/8;
	int l1=100, l2;
	FlyWheel flyWheel;

	public Manipulator(FlyWheel flyWheel) {
		this.flyWheel=flyWheel;
	}

	@Override
	public void drawMe(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		int dx0 = g2d.getClipBounds().width / 2;
		int dy0 = g2d.getClipBounds().height / 2;
		System.out.println(dx0);
		AffineTransform saveAT = g2d.getTransform();

		t = new AffineTransform();

		t.translate(flyWheel.p0x, flyWheel.p0y);
		t.scale(1, -1);
		
		t.rotate(alpha);
		g2d.setTransform(t);
		g2d.drawLine(0, 0, flyWheel.l1, 0);
		drawBlackCircle(flyWheel.l1, 0,g2d);
		
		t.translate(flyWheel.l1, 0);



		//int p0x = dx0;
		//int p0y = dy0;

		//int psx = dx0+300;
		//int psy = dy0-100;

		//int d = psx - p0x;
		//int h = psy - p0y;


		//double x1 = l1 * Math.cos(alpha);
		//double y1 = l1 * Math.sin(alpha);

		//double d1 = d - x1;
		//double h1 = h - y1;

		//double gamma = Math.atan2(h1,d1);
		beta = flyWheel.computeBeta(alpha);
		t.rotate(-beta);
		g2d.setTransform(t);
		g2d.drawLine(0, 0, flyWheel.l2, 0);
		drawBlackCircle(flyWheel.l2,0,g2d);
		g2d.setTransform(saveAT);
		drawTrianglewithCircle(flyWheel.p0x, flyWheel.p0y, g2d);
		drawTrianglewithCircle(flyWheel.psx, flyWheel.psx, g2d);
	}

	private void drawTrianglewithCircle(int a, int b, Graphics2D g2d){
		int[] xx = new int[3];
		xx[0]=a;
		xx[1]=a+20;
		xx[2]=a-20;

		int[] yy = new int[3];
		yy[0] = b;
		yy[1] = b + 30;
		yy[2] = b + 30;
		Polygon p = new Polygon(xx,yy,3);
		g2d.draw(p);
		g2d.setColor(Color.blue);
		g2d.fill(p);
		drawCircle(a, b, g2d);
	}

	private void drawCircle(int a, int b, Graphics2D g2d){
		g2d.setColor(Color.WHITE);
		g2d.fillOval(a-5,b-5, 10, 10);
		g2d.setColor(Color.black);
		g2d.drawOval(a-5,b-5, 10, 10);
	}

	private void drawBlackCircle(int a, int b, Graphics2D g2d){
		g2d.setColor(Color.black);
		g2d.fillOval(a-5,b-5, 10, 10);
		g2d.setColor(Color.black);
		g2d.drawOval(a-5,b-5, 10, 10);
	}
	@Override
	public void rotate() {
		alpha += Math.PI / 180.0;
		//beta += Math.PI / 180.0;
	}

}
