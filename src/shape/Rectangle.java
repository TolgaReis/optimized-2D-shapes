package shape;

import java.lang.Double;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Implements Shape interface as Rectangle shape.
 * @author Tolga Reis
 * @version 1.0
 */

public class Rectangle implements Shape{
    private double _width;
    private double _height;
    private double _x;
    private double _y;
    private Color _color;
    /**
     * A constructor that initializes all fields by parameters.
     * @param x the x coordinate of Rectangle.
     * @param y the y coordinate of Rectangle.
     * @param width the width of Rectangle.
     * @param height the height of Rectangle.
     * @param color the color of Rectangle.
     * @throws ShapeException throws negative length exception.
     */
    public Rectangle(double x, double y, double width, double height, Color color) throws ShapeException{
    	if(width < 0 | height < 0)
    		throw new ShapeException("Negative length!");
    	else {
    		this._x = x;
            this._y = y;
            this._width = width;
            this._height = height;
            this._color = color;
    	}
    }
    /**
     * A constructor that initializes _width, _height and _color with parameters and
     * initializes _x and _y to 0 with delegation.
     * @param width the width of Rectangle
     * @param height the height of Rectangle
     * @param color the color of Rectangle
     * @throws ShapeException throws negative length exception
     *
     */
    public Rectangle(double width, double height, Color color) throws ShapeException{
    	this(0, 0, width, height, color);
    }
    /**
     * No parameter constructor that takes no parameter and initializes fields
     * with delegation.
     *@throws ShapeException throws negative length exception.
     */
    public Rectangle() throws ShapeException{
        this(0, 0, 0, 0, Color.red);
    }
    /**
     * Sets _x, _y, _width, _height and _color fields.
     * @param x the x coordinate of Rectangle.
     * @param y the y coordinate of Rectangle.
     * @param width the width of Rectangle.
     * @param height the height of Rectangle.
     * @param color the color of Rectangle.
     * @throws ShapeException throws negative length exception.
     */
    public void set(double x, double y, double width, double height, Color color) throws ShapeException{
        if(width < 0 | height < 0)
        	throw new ShapeException("Negative length");
        else {
        	this._x = x;
        	this._y = y;
        	this._width = width;
        	this._height = height;
        	this._color = color;
        }
    }
    /**
     * Sets _width, _height and _color fields.
     * @param width the width of Rectangle.
     * @param height the height of Rectangle.
     * @param color the color of Rectangle.
     * @throws ShapeException throws negative length exception.
     */
    public void set(double width, double height, Color color) throws ShapeException{
    	if(width < 0 | height < 0)
    		throw new ShapeException("Negative length!");
    	else{
    		this._width = width;
            this._height = height;
            this._color = color;
    	}
    }
    /**
     * Getter that returns x coordinate of Rectangle.
     * @return this._x x coordinate of Rectangle.
     */
    public double getX(){
        return this._x;
    }
    /**
     * Getter that returns y coordinate of Rectangle.
     * @return this._y y coordinate of Rectangle.
     */
    public double getY(){
        return  this._y;
    }
    /**
     * Getter that returns with of Rectangle.
     * @return this._width width of Rectangle
     */
    public double getWidth(){
        return this._width;
    }
    /**
     * Getter that returns height of Rectangle.
     * @return this._height height of Rectangle
     */
    public double getHeight(){
        return this._height;
    }
    /**
     * Getter that returns color of Rectangle.
     * @return this._color color of Rectangle
     */
    public Color getColor(){
        return this._color;
    }
    /**
     * Returns area of Rectangle.
     * @return this._height*this._width area of Rectangle.
     */
    public double area(){
        return this._height*this._width;
    }

    /**
     * Returns perimeter of Rectangle.
     * @return (this._height+this._width)*2 perimeter of rectangle.
     */
    public double perimeter(){
        return  (this._height+this._width)*2;
    }
    /**
     * Increments coordinates of Rectangle.
     */
    public void increment(){
        ++this._x;
        ++this._y;
    }

    /**
     * Decrements coordinates of Rectangle.
     */
    public void decrement(){
        --this._x;
        --this._y;
    }

    /**
     * Compares two Rectangles respect to their areas.
     * @param shape comparable rectangle object
     * @return result of the comparing. If this is greater, then returns 1.
     * if this is less, then returns -1.
     * if they are equal, then returns 0.
     */
    public int compareTo(Shape shape){
        return Double.compare(this.area(), shape.area());
    }

    /**
     * Takes Graphics as object and draws a rectangle to it.
     * @param graphics to set Graphics to rectangle
     */
    public Graphics draw(Graphics graphics){
    	graphics.setColor(this._color);
        graphics.drawRect((int)this.getX(), (int)this.getY(), (int)this.getWidth(), (int)this.getHeight());
        return graphics;
    }
    /**
     * overrides toString for Rectangle.
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