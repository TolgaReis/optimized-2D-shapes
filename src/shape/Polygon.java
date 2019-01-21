package shape;

import java.awt.geom.Point2D;
import java.lang.Double;
import java.lang.Math;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Implements shape objects helps to draw polygon.
 * @author Tolga Reis
 * @version 1.0
 */

public abstract class Polygon implements Shape{
	protected Point2D.Double[] points;
	protected int _size;
	protected double _area;
	protected double _perimeter;
	protected Color _color;
	/**
	 * Initializes points array with Shape object. According to shape type it casts.
	 * @param shape casted according to its type.
	 */
	public Polygon(Shape shape) {
		if(shape instanceof Rectangle) {
			Rectangle rectangle = (Rectangle)shape;
			points = new Point2D.Double[4];
			points[0] = new Point2D.Double(rectangle.getX(), rectangle.getY());
	        points[1] = new Point2D.Double(rectangle.getX() + rectangle.getWidth(), rectangle.getY());
	        points[2] = new Point2D.Double(rectangle.getX() + rectangle.getWidth(), rectangle.getY() + rectangle.getHeight());
	        points[3] = new Point2D.Double(rectangle.getX(), rectangle.getY() + rectangle.getHeight());
	        this._size = 4;
	        this._area = rectangle.area();
	        this._perimeter = rectangle.perimeter();
	        this._color = rectangle.getColor();
		}
		else if(shape instanceof Triangle) {
			Triangle triangle = (Triangle)shape;
			points = new Point2D.Double[3];
			points[0] = new Point2D.Double(triangle.getP1X(), triangle.getP1Y());
	        points[1] = new Point2D.Double(triangle.getP2X(), triangle.getP2Y());
	        points[2] = new Point2D.Double(triangle.getP3X(), triangle.getP3Y());
	        this._size = 3;
	        this._area = triangle.area();
	        this._perimeter = triangle.perimeter();
	        this._color = triangle.getColor();
		}
		else if(shape instanceof Circle) {
			Circle circle = (Circle)shape;
			points = new Point2D.Double[100];
			for(int i = 0; i < 100; i++)
	               points[i] = new Point2D.Double(circle.getX() + circle.getR()*Math.cos(5.625*i*Math.PI/180),
	                                              circle.getY() + circle.getR()*Math.sin(5.625*i*Math.PI/180));
	           //created with circle formula x = h + rcos(t), y = h + rsin(t)
			this._size = 100;
	        this._area = circle.area();
	        this._perimeter = circle.perimeter();
	        this._color = circle.getColor();
		}
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
		 int[] tempX = new int[this._size];
		 int[] tempY = new int[this._size];
		 for(int i = 0; i < this._size; i++) {
			 tempX[i] = (int)this.points[i].getX();
		 }
		 for(int i = 0; i < this._size; i++) {
			 tempY[i] = (int)this.points[i].getY();
		 }
		 graphics.setColor(this._color);
		 graphics.drawPolygon(tempX, tempY, this._size);
		 return graphics;
	 }
}
