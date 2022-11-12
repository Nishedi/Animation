package main;

import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MyPanel mp;

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainFrame thisClass = new MainFrame();
				thisClass.setTitle("Manipulator");
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
				thisClass.animate();
			}
		});

	}
	public void animate() {
		Thread t = new Thread(new Runnable() {
			public void run() {
				int i = 3600;
				while (i>0) {
					mp.g.rotate();
					mp.repaint();
					i--;
					try {
						Thread.sleep(10);
					} catch (Exception e) {
					}
				}
				System.out.println("Animation stopped");
			}
		});
		t.start();
	}
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 1200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		mp = new MyPanel();
		contentPane.add(mp, BorderLayout.CENTER);
	}
}
