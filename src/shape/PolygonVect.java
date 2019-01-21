package shape;

import java.util.*;
import java.awt.geom.Point2D;
import java.lang.Double;
import java.awt.Graphics;
/**
 * Extends from Polygon and holds data as arraylist.
 * @author Tolga Reis
 * @version 1.0
 *
 */
public class PolygonVect extends Polygon {
	private ArrayList<Point2D.Double> arrli;
	public PolygonVect(Shape shape) {
		super(shape);
		arrli = new ArrayList<Point2D.Double>(this._size);
		for(int i = 0; i < this._size; i++)
			arrli.add(this.points[i]);
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
			arrli.get(i).setLocation(arrli.get(i).getX() + 1, arrli.get(i).getY() + 1);
	}
	 /**
	  * Decrements coordinates of polygon by 1.
	  */
	public void decrement() {
		for(int i = 0; i < this._size; i++)
			arrli.get(i).setLocation(arrli.get(i).getX() - 1, arrli.get(i).getY() - 1);
	}
	 /**
	  * Compares this and another Polygon object according to areas.
	  * @param rightSide takes another polygonVect as parameter and compares them respect to their areas.
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
		int[] tempX = new int[this._size];
		int[] tempY = new int[this._size];
		for(int i = 0; i < this._size; i++) {
			tempX[i] = (int)arrli.get(i).getX();
		}
		for(int i = 0; i < this._size; i++) {
			tempY[i] = (int)arrli.get(i).getY();
		}
		graphics.setColor(this._color);
		graphics.drawPolygon(tempX, tempY, this._size);
		return graphics;
	}

}
