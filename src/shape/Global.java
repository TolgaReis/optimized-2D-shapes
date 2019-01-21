package shape;

import java.awt.Graphics;

/**
 * There are three global functions that are used in mainapp.
 * @author Tolga Reis
 * @version 1.0
 *
 */
public class Global {
	/**
	 * Draws all elements in shape array to JPanel
	 * @param array shape array to draw
	 * @param graphics graphics object to draw JPanel
	 * @return returns graphics object
	 */
	public static Graphics drawAll(Shape[] array, Graphics graphics) {
		for(Shape i: array) {
			if(i instanceof Rectangle) {
				Rectangle temp = (Rectangle)i;
				graphics.setColor(temp.getColor());
				graphics = temp.draw(graphics);
			}
			else if(i instanceof Triangle) {
				Triangle temp = (Triangle)i;
				graphics.setColor(temp.getColor());
				graphics = temp.draw(graphics);
			}
			else if(i instanceof Circle) {
				Circle temp = (Circle)i;
				graphics.setColor(temp.getColor());
				graphics = temp.draw(graphics);
			}
		}
			return graphics;
	}
	/**
	 * Takes shape array and converts all elements to polygon.
	 * @param array shape array that are converted to polygon.
	 * @return return polygon array.
	 */
	public static Polygon[] convertAll(Shape[] array) {
		Polygon[] polygon = new Polygon[array.length];
		for(int i = 0; i < array.length; i++) {
			if(array[i] instanceof Rectangle) {
				Rectangle temp = (Rectangle)array[i];
				polygon[i] = new PolygonDyn(temp);
			}
			else if(array[i] instanceof Triangle) {
				Triangle temp = (Triangle)array[i];
				polygon[i] = new PolygonDyn(temp);
			}
			else if(array[i] instanceof Circle) {
				Circle temp = (Circle)array[i];
				polygon[i] = new PolygonDyn(temp);
			}
		}
		return polygon;
	}
	/**
	 * Sorts shape array according to areas of shapes.
	 * @param array takes array to sort it.
	 */
	public static void sortShapes(Shape[] array) {
		int n = array.length; 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (array[j].area() > array[j+1].area()) 
                { 
                    Shape temp = array[j]; 
                    array[j] = array[j+1]; 
                    array[j+1] = temp; 
                } 

	}
	public Global() {
		// TODO Auto-generated constructor stub
	}

}
