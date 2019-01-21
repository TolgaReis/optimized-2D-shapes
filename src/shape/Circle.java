package shape;

import java.lang.Double;
import java.lang.Math;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Implements Shape interface as Circle shape.
 * @author Tolga Reis
 * @version 1.0
 *
 */
public class Circle implements Shape{
	private double _x;
	private double _y;
	private double _radius;
	private Color _color;
	
	/**
	 * Constructor of Circle that initializes all fields by parameters.
	 * @param x initializes x coordinate of Circle.
	 * @param y initializes y coordinate of Circle.
	 * @param radius initializes radius of Circle.
	 * @param color initializes color of Circle.
	 * @throws ShapeException throws negative length exception.
	 */
	public Circle(double x, double y, double radius, Color color) throws ShapeException{
		if(radius < 0)
			throw new ShapeException("Negative length!");
		else {
			this._x = x;
			this._y = y;
			this._radius = radius;
			this._color = color;
		}
	}
	/**
	 * Initializes all double fields by 0 and color by Color.RED.
	 * @throws ShapeException throws negative length exception.
	 */
	public Circle() throws ShapeException{
		this(0, 0, 0, Color.RED);
	}
	/**
	 * Setter of Circle that sets all fields by parameters.
	 * @param x sets x coordinate of Circle.
	 * @param y sets y coordinate of Circle.
	 * @param radius sets radius of Circle.
	 * @param color sets color of Circle.
	 * @throws ShapeException throws negative length exception.
	 */
	public void set(double x, double y, double radius, Color color) throws ShapeException{
		if(radius < 0)
			throw new ShapeException("Negative length!");
		this._x = x;
		this._y = y;
		this._radius = radius;
		this._color = color;
	}
	/**
	 * Getter of x coordinate of Circle.
	 * @return this._x
	 */
	public double getX() { return this._x; } 
	/**
	 * Getter of y coordinate of Circle.
	 * @return this._x 
	 */
	public double getY() { return this._y; }
	/**
	 * Getter of radius of Circle.
	 * @return this._radius
	 */
	public double getR() { return this._radius; }
	/**
	 * Getter of color of Circle.
	 * @return this._color
	 */
	public Color getColor() { return this._color; }
	/**
	 * @return area of Circle
	 */
	public double area() { return (Math.PI*Math.pow(this._radius, 2)); }
	/**
	 * @return perimeter of Circle
	 */
	public double perimeter() { return (2 * Math.PI * this._radius); }
	/**
	 * Increments coordinates of Circle by 1.
	 */
	public void increment() {
		++this._x;
		++this._y;
	}
	/**
	 * Devrements coordinates of Circle by 1.
	 */
	public void decrement() {
		--this._x;
		--this._y;
	}
	/**
	 * Compares this and another Circle object according to areas.
	 * @param circle takes another triangle as parameter and compares them respect to their areas.
	 * @return result of the comparing. If this is greater, then returns 1.
     * if this is less, then returns -1.
     * if they are equal, then returns 0.
	 */
	public int compareTo(Shape circle) {
		return Double.compare(this.area(), circle.area());
	}
	/**
	  * Takes a Graphics object as parameter, converts it a Circle then returns it.
	 * @param graphics graphics takes Graphics object to convert it to Circle.
	 * @return graphics
	 */
	public Graphics draw(Graphics graphics) {
		graphics.setColor(this.getColor());
		graphics.drawOval((int)this.getX(), (int)this.getY(), (int)this.getR(), (int)this.getR());
		return graphics;
	}
	/**
	 * Creates and return a string that includes general information about Circle.
	 */
	public String toString() {
    	String temp = "Area = " + Double.toString(this.area()) + 
    				  ", Perimeter = " + Double.toString(this.perimeter()) + 
    				  "\nCoordinates = (" + Double.toString(this._x) + 
    				  ", " + Double.toString(this._y) + ")" + "\nAfter increment, coordinates = (";
    	this.increment();
    	temp += Double.toString(this._x) + 
      			", " + Double.toString(this._y) + ")\nAfter decrement, coordinates = (";
    	this.decrement();
    	temp += Double.toString(this._x) + 
				  ", " + Double.toString(this._y) + ")";
    	return temp;
    }
}
