package shape;

import java.lang.Double;
import java.lang.Math;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Implements Shape interface as Triangle shape.
 * @author Tolga Reis
 * @version 1.0
 */

public class Triangle implements Shape{
	private double[] xPoints = new double[3];
	private double[] yPoints = new double[3];
	private double _side;
	private Color _color;
	
	/**
	 * Constructor of Triangle that initializes all fields by parameters.
	 * @param p1x initializes first point x.
	 * @param p1y initializes first point y.
	 * @param p2x initializes second point x.
	 * @param p2y initializes second point y.
	 * @param p3x initializes third point x.
	 * @param p3y initializes third point y.
	 * @param color initializes triangle color.
	 * @param side initializes triangle side.
	 * @throws ShapeException throws negative side length exception.
	 */
	
	public Triangle(double p1x, double p1y,
                    double p2x, double p2y,
                    double p3x, double p3y,
                    Color color, double side) throws ShapeException{
		if(side < 0.0)
			throw new ShapeException("Negative length!");
		else {
			this.xPoints[0] = p1x;
			this.xPoints[1] = p2x;
			this.xPoints[2] = p3x;
			this.yPoints[0] = p1y;
			this.yPoints[1] = p2y;
			this.yPoints[2] = p2y;
			this._side = side;
			this._color = color;
		}
	}
	/** No parameter constructor of Triangle that initializes all double type fields by 0 and initializes color to Color.RED.
	 * @throws ShapeException throws negative length exception
	 */
	public Triangle() throws ShapeException{
		this(0, 0, 0, 0, 0, 0, Color.RED, 0);
	}
	
	/**
	 * Setter of Triangle that sets all fields by parameters.
	 * @param p1x initialize first x coordinate of triangle.
	 * @param p1y initialize first y coordinate of triangle.
	 * @param p2x initialize second x coordinate of triangle.
	 * @param p2y initialize second y coordinate of triangle.
	 * @param p3x initialize third x coordinate of triangle.
	 * @param p3y initialize third y coordinate of triangle.
	 * @param color initialize color of triangle.
	 * @param side initialize side of triangle.
	 * @throws ShapeException throws negative length.
	 */
	public void set(double p1x, double p1y,
                          double p2x, double p2y,
		                  double p3x, double p3y,
		                  Color color, double side) throws ShapeException{
		if(side < 0)
			throw new ShapeException("Negative length!");
		else {
			this.xPoints[0] = p1x;
			this.xPoints[1] = p2x;
			this.xPoints[2] = p3x;
			this.yPoints[0] = p1y;
			this.yPoints[1] = p2y;
			this.yPoints[2] = p3y;
		}
		
	}
	
	/**
	 * Setter of Triangle that sets coordinates of triangle.
	 * @param p1x initialize first x coordinate of triangle.
	 * @param p1y initialize first y coordinate of triangle.
	 * @param p2x initialize second x coordinate of triangle.
	 * @param p2y initialize second y coordinate of triangle.
	 * @param p3x initialize third x coordinate of triangle.
	 * @param p3y initialize third y coordinate of triangle.
	 * @throws ShapeException throws negative length exception.
	 */
	public void setPoints(double p1x, double p1y,
                    	  double p2x, double p2y,
                    	  double p3x, double p3y) throws ShapeException{
		this.set(p1x, p1y, p2x, p2y, p3x, p3y, this._color, this._side);
	}
	/**
	 * Returns first x coordinate of Triangle.
	 * @return first x coordinate
	 */
	public double getP1X(){ return xPoints[0]; }
	
	/**
	 * Returns first y coordinate of Triangle.
	 * @return first y coordinate
	 */
	public double getP1Y(){ return this.yPoints[0]; }
	/**
	 * Returns second x coordinate of Triangle.
	 * @return second x coordinate
	 */
	public double getP2X(){ return this.xPoints[1]; }
	/**
	 * Returns second y coordinate of Triangle.
	 * @return second y coordinate
	 */
	public double getP2Y(){ return this.yPoints[1]; }
	/**
	 * Returns third x coordinate of Triangle.
	 * @return third x coordinate.
	 */
	public double getP3X(){ return this.xPoints[2]; }
	/**
	 * Returns third y coordinate of Triangle.
	 * @return third y coordinate.
	 */
	public double getP3Y(){ return this.yPoints[2]; }
	/**
	 * Returns side of Triangle.
	 * @return side of triangle
	 */
	public double getSide(){ return this._side; }
	/**
	 * Returns color of Triangle.
	 * @return color of triangle
	 */
	public Color getColor() { return this._color; }
	/**
	 * Returns area of Triangle.
	 *@return area of triangle 
	 */
	public double area() { return Math.pow(this.getSide(), 2)*Math.sqrt(3)/4; }
	/**
	 * Returns perimeter of Triangle.
	 * @return perimeter of triangle
	 */
	public double perimeter() { return 3 * this.getSide(); }
	
	/**
	 * Increments all coordinates of Triangle by 1.
	 */
	public void increment(){
		++this.xPoints[0];
		++this.xPoints[1];
		++this.xPoints[2];
		++this.yPoints[0];
		++this.yPoints[1];
		++this.yPoints[2];
	}
	/**
	 * Decrements all coordinates of Triangle by 1.
	 */
	public void decrement(){
		--this.xPoints[0];
		--this.xPoints[1];
		--this.xPoints[2];
		--this.yPoints[0];
		--this.yPoints[1];
		--this.yPoints[2];
	}
	/**
	 * Compares this and another Triangle object according to areas.
	 * @param triangle takes another triangle as parameter and compares them respect to their areas.
	 * @return result of the comparing. If this is greater, then returns 1.
     * if this is less, then returns -1.
     * if they are equal, then returns 0.
	 */
	public int compareTo(Shape triangle) {
		return Double.compare(this.area(), triangle.area());
	}
	/**
	 * Takes a Graphics object as parameter, converts it a Triangle then returns it.
	 * @param graphics takes Graphics object to convert it to Triangle.
	 * @return graphics
	 */
	public Graphics draw(Graphics graphics) {
		graphics.setColor(this._color);
		int[] xTemp = new int[3];
		int[] yTemp = new int[3];
		for(int i = 0; i < 3; i++) {
			xTemp[i] = (int)this.xPoints[i];
			yTemp[i] = (int)this.yPoints[i];
		}
		graphics.drawPolygon(xTemp, yTemp, 3);
		return graphics;
	}
	/**
	 * Creates and return a string that includes general information about Triangle.
	 */
	public String toString() {
    	String temp = "Area = " + Double.toString(this.area()) + 
    				  ", Perimeter = " + Double.toString(this.perimeter()) + 
    				  "\nCoordinates = (" + Double.toString(this.xPoints[0]) + 
    				  ", " + Double.toString(this.yPoints[0]) + "," + 
    				  Double.toString(this.xPoints[1]) + 
    				  ", " + Double.toString(this.yPoints[1]) + "," +
    				  Double.toString(this.xPoints[2]) + 
    				  ", " + Double.toString(this.yPoints[2]) +
    				  ")" + "\nAfter increment, coordinates = (";
    	this.increment();
    	temp +=   Double.toString(this.xPoints[0]) + 
				  ", " + Double.toString(this.yPoints[0]) + "," + 
				  Double.toString(this.xPoints[1]) + 
				  ", " + Double.toString(this.yPoints[1]) + "," +
				  Double.toString(this.xPoints[2]) + 
				  ", " + Double.toString(this.yPoints[2]) + ")\nAfter decrement, coordinates = (";
    	this.decrement();
    	temp +=   Double.toString(this.xPoints[0]) + 
				  ", " + Double.toString(this.yPoints[0]) + "," + 
				  Double.toString(this.xPoints[1]) + 
				  ", " + Double.toString(this.yPoints[1]) + "," +
				  Double.toString(this.xPoints[2]) + 
				  ", " + Double.toString(this.yPoints[2]) + ")";
    	return temp;
    }
}
