package model;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class Wheel extends GObject {
	public double alpha;
	
	@Override
	public void rotate(){
		alpha += Math.PI/100.0;
	}
	@Override
	public void drawMe(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		
		int dx0 = g2d.getClipBounds().width/2;
		int dy0 = g2d.getClipBounds().height/2;
        int minxy = (dx0>=dy0) ? dy0/2:dx0/2;
  		AffineTransform saveAT = g2d.getTransform();  		
  		t = new AffineTransform();  		
  		
  		t.translate(dx0,dy0);
  		t.scale(1, -1);		
		t.rotate(-alpha);
		//t.translate(30, 0);
		g2d.setTransform(t);
		
		
		g2d.drawLine(-30, 0, 30, 0);
		g2d.drawLine( 0, -30, 0, 30);
		g2d.drawOval(-minxy, -minxy, minxy*2+100, minxy*2);
		
		g2d.setTransform(saveAT);

	}

}
