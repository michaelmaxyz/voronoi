import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Window extends JFrame{

	private ArrayList<Point> points;
	private Random rand;
	private Panel panel;
	private final int numPoints = 1;
	private int w;
	private int h;
	class Panel extends JPanel { 
		
		public Panel() {
			rand = new Random();
			points = new ArrayList<Point>();
			setSize(w, h);
			setVisible(true);
			setLayout(null);
			setBounds(0, 0, w, h);
			initialize();
		}

		private void initialize() {
			for (int i = 0; i < numPoints; i++) {
				int x = rand.nextInt(w / 2) + w / 4;
				int y = rand.nextInt(h / 2) + h / 4;
				points.add(new Point(x, y));
			}
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			for (int i = 0; i < w; i++) {
				for (int j = 0; j < h; j++) {
					g.setColor(closest(i, j).getColor());
					g.fillRect(i, j, 1, 1);
				}
			}

		}
		
		//finds closest point given pixel
		private Point closest(int x, int y) {
			double max = Double.MAX_VALUE;
			Point closest = null;
			for(Point p: points) {
				if (p.dist(x, y) < max) {
					max = p.dist(x, y);
					closest = p;
				}
			}
			return closest;
		}

	}

	public Window() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		h = (int) screenSize.getHeight();
		w = (int) screenSize.getWidth();
		setVisible(true);
		setLayout(null);
		setSize(w, h);
		panel = new Panel();
		add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(new KeyListener() {

			public void keyReleased(KeyEvent e) {					
			}
			public void keyTyped(KeyEvent e) {					
			}

			public void keyPressed(KeyEvent e) {
				//A key 
				if (e.getKeyCode() == 68) {
					int x = rand.nextInt(w / 2) + w / 4;
					int y = rand.nextInt(h / 2) + h / 4;
					points.add(new Point(x, y));
				} 
				//D key
				else if (e.getKeyCode() == 65 && points.size() > 2) {
					points.remove(0);
				}
			}


		});
		Timer timer = new Timer(5, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				repaint();
			}

		});
		timer.start();
	}

	public static void main(String[] args) {
		new Window();
	}


}
