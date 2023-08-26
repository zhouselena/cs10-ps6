import java.awt.Color;
import java.awt.Graphics;

/**
 * A rectangle-shaped Shape
 * Defined by an upper-left corner (x1,y1) and a lower-right corner (x2,y2)
 * with x1<=x2 and y1<=y2
 * 
 * @author Selena Zhou, CS10 23W, PS6
 */
public class RectangleEC implements ShapeEC {
	private int x1, y1, x2, y2;		// upper left and lower right
	private Color color;

	/**
	 * An "empty" rectangle, with only one point set so far
	 */
	public RectangleEC(int x1, int y1, Color color) {
		this.x1 = x1; this.x2 = x1;
		this.y1 = y1; this.y2 = y1;
		this.color = color;
	}
	public RectangleEC(int x1, int y1, int x2, int y2, Color color) {
		this.x1 = x1; this.x2 = x2;
		this.y1 = y1; this.y2 = y2;
		this.color = color;
	}
	public void setCorners(int x1, int y1, int x2, int y2) {
		// Ensure correct upper left and lower right
		this.x1 = Math.min(x1, x2);
		this.y1 = Math.min(y1, y2);
		this.x2 = Math.max(x1, x2);
		this.y2 = Math.max(y1, y2);
	}
	@Override
	public void moveBy(int dx, int dy) {
		x1 += dx; y1 += dy;
		x2 += dx; y2 += dy;
	}

	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
	}
		
	@Override
	public boolean contains(int x, int y) {
		return (this.x1 <= x && x <= this.x2 && this.y1 <= y && y <= this.y2);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(this.color);
		g.fillRect(this.x1, this.y1, x2-x1, y2-y1);
	}

	public String toString() {
		return "rectangle " +x1+" "+y1+" "+x2+" "+y2+" "+color.getRGB();
	}
}
