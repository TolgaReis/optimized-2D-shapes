package shape;

import java.awt.Graphics;

/** It is shape interface that Rectangle, Triangle, Circle and Polygon classes implements it.
 * @author Tolga Reis
 * @version 1.0
 */
public interface Shape extends Comparable<Shape> {
    public double area();
    public double perimeter();
    public void increment();
    public void decrement();
    public int compareTo(Shape rightSide);
    public Graphics draw(Graphics graphics);
}