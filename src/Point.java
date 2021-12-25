import java.awt.Color;
import java.util.Comparator;
import java.util.Random;

public class Point{
	private int x;
	private int y;
	private Random rand;
	private Color col;
	public Point (int x, int y) {
		this.x = x;
		this.y = y;
		rand = new Random();
		col = new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
	}
	
	public Color getColor() {
		return col;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public double dist(int x, int y) {
		return (this.x - x) * (this.x - x) + (this.y - y) * (this.y - y);
	}
	
}
