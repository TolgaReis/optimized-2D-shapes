package shape;

import java.awt.Graphics;

/**
 * Extends from Polygon holds data as array.
 * @author Tolga Reis
 * @version 1.0
 */
public class PolygonDyn extends Polygon {

	public PolygonDyn(Shape shape) {
		super(shape);
	}
	/**
	  * @return returns area of polygon.
	  */
	public double area() {
		 return this._area;
	}
	/**
	  * @return returns perimeter of polygon.
	  */
	public double perimeter() {
		return this._perimeter;
	}
	/**
	  * Increments coordinates of polygon by 1.
	  */
	public void increment() {
		for(int i = 0; i < this._size; i++)
			points[i].setLocation(points[i].getX() + 1, points[i].getY() + 1);
	}
	/**
	  * Decrements coordinates of polygon by 1.
	  */
	public void decrement() {
		for(int i = 0; i < this._size; i++)
			points[i].setLocation(points[i].getX() - 1, points[i].getY() - 1);
	}
	/**
	  * Compares this and another Polygon object according to areas.
	  * @param rightSide takes another polygon as parameter and compares them respect to their areas.
	  * @return result of the comparing. If this is greater, then returns 1.
	  * if this is less, then returns -1.
	  * if they are equal, then returns 0.
	  */
	public int compareTo(Shape rightSide) {
		return Double.compare(this.area(), rightSide.area());
	}
	 /**
	  * Takes a Graphics object as parameter, converts it a Polygon then returns it.
	 * @param graphics graphics takes Graphics object to convert it to Circle.
	 * @return graphics
	 */
	public Graphics draw(Graphics graphics) {
		return super.draw(graphics);
	}
}
