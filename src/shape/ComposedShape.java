package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.lang.Double;

/**
 * Fits small shapes inside container shapes.
 * @author Tolga Reis
 * @version 1.0
 */

public class ComposedShape implements Shape{
	private Shape[] shapes = new Shape[2];
	private double _area;
	private double _perimeter;
	
	/**
	 * Constructor that takes container and inner shapes as Shape object.
	 * @param containerShape initializes first shape of shapes array.
	 * @param innerShape initializes second shape of shapes array.
	 */
	public ComposedShape(Shape containerShape, Shape innerShape) {
		shapes[0] = containerShape;
		shapes[1] = innerShape;
		this._area = 0;
		this._perimeter = 0;
	}
	/**
	 * intentionally empty
	 */
	public ComposedShape() {
		this._area = 0;
		this._perimeter = 0;
	}
	/**
	 * Returns total area of composed shapes.
	 */
	public double area() {
		return this._area;
	}
	/**
	 * Returns total perimeter of composed shapes.
	 */
	public double perimeter() {
		return this._perimeter;
	}
	/**
	 * Increments container and inner shapes.
	 */
	public void increment() {
		shapes[0].increment();
		shapes[1].increment();
	}
	/**
	 * Decrements container and inner shapes.
	 */
	public void decrement() {
		shapes[0].decrement();
		shapes[1].decrement();
	}
	/**
	 * Compares this and another ComposedShape according to areas.
	 */
	public int compareTo(Shape composedShape) {
		return Double.compare(this.area(), composedShape.area());
	}
	/**
	 * Takes a Graphics object as parameter, converts it a ComposedShape then returns it.
	 * @param graphics graphics takes Graphics object to convert it to ComposedShape.
	 * @return graphics
	 */
	public Graphics draw(Graphics graphics) {
		int rowNumber, columnNumber;
		if((shapes[0] instanceof Rectangle) && (shapes[1] instanceof Rectangle)) {
			Rectangle containerRectangle = (Rectangle)shapes[0];
			Rectangle smallRectangle = (Rectangle)shapes[1];
			graphics.setColor(Color.RED);
			graphics = containerRectangle.draw(graphics);
			this._area += containerRectangle.area();
			this._perimeter += containerRectangle.perimeter();
			if(((containerRectangle.getHeight() / smallRectangle.getHeight()) * (containerRectangle.getWidth() / smallRectangle.getWidth())) >=
			        ((containerRectangle.getHeight() / smallRectangle.getWidth()) * (containerRectangle.getWidth() / smallRectangle.getHeight()))){
			        rowNumber = (int)(containerRectangle.getHeight() / smallRectangle.getHeight());
			        columnNumber = (int)(containerRectangle.getWidth() / smallRectangle.getWidth());
			        for(int i = 0; i < rowNumber; i++)
			            for(int j = 0; j < columnNumber; j++){
			            	try {
			            		Rectangle temp = new Rectangle(smallRectangle.getWidth() * i, smallRectangle.getHeight() * j,
			            									   smallRectangle.getWidth(), smallRectangle.getHeight(), Color.YELLOW);
			            		this._area += temp.area();
			        			this._perimeter += temp.perimeter();
			            		graphics = temp.draw(graphics); 
			            	}
			            	catch(ShapeException e) {
			            		System.out.println(e.what());
			            	}
			            }
			        if((containerRectangle.getHeight() - smallRectangle.getHeight() * rowNumber) >= smallRectangle.getWidth()){
			            for(int i = 0; i < containerRectangle.getWidth() / smallRectangle.getHeight(); i++){
			            	try {
			            		Rectangle temp = new Rectangle(smallRectangle.getHeight() * i, smallRectangle.getHeight() * rowNumber,
		                                   					   smallRectangle.getHeight(), smallRectangle.getWidth(), Color.YELLOW);
			            		this._area += temp.area();
			        			this._perimeter += temp.perimeter();
			            		graphics = temp.draw(graphics);
			            	}
			            	catch(ShapeException e) {
			            		System.out.println(e.what());
			            	}   			                
			            }
			        }
			        if((containerRectangle.getWidth() - smallRectangle.getWidth() * columnNumber) >= smallRectangle.getHeight()){
			            for(int i = 0; i < containerRectangle.getHeight() / smallRectangle.getWidth(); i++){
			                try {
			                	Rectangle temp = new Rectangle(smallRectangle.getWidth() * columnNumber, smallRectangle.getWidth() * i,
		                                   smallRectangle.getHeight(), smallRectangle.getWidth(), Color.YELLOW);
			                	this._area += temp.area();
			        			this._perimeter += temp.perimeter();
			                	graphics = temp.draw(graphics);
			                }
			                catch(ShapeException e) {
			                	System.out.println(e.what());
			                }
			            }
			        }
			    }
			    else{
			        rowNumber = (int)(containerRectangle.getHeight() / smallRectangle.getWidth());
			        columnNumber = (int)(containerRectangle.getWidth() / smallRectangle.getHeight());

			        for(int i = 0; i < rowNumber; i++)
			            for(int j = 0; j < columnNumber; j++){
			            	try {
				                Rectangle temp = new Rectangle(smallRectangle.getHeight() * j, smallRectangle.getWidth() * i,
				                               smallRectangle.getHeight(), smallRectangle.getWidth(), Color.YELLOW);
				                this._area += temp.area();
				        		this._perimeter += temp.perimeter();
				        		graphics = temp.draw(graphics);
			            	}
				            catch(ShapeException e) {
				            	System.out.println(e.what());
			                }
			            }

			        if((containerRectangle.getHeight() - smallRectangle.getWidth() * rowNumber) >= smallRectangle.getHeight()){
			            for(int i = 0; i < containerRectangle.getWidth() / smallRectangle.getWidth(); i++){
			                try {
			                	Rectangle temp = new Rectangle(smallRectangle.getWidth() * i, smallRectangle.getWidth() * rowNumber,
			                                   smallRectangle.getWidth(), smallRectangle.getHeight(), Color.YELLOW);
			                	this._area += temp.area();
			        			this._perimeter += temp.perimeter();
			                	graphics = temp.draw(graphics);
			                }
			                catch(ShapeException e) {
			                	System.out.println(e.what());
			                	
			            }
			        }
			        if((smallRectangle.getWidth() - smallRectangle.getHeight() * columnNumber) >= smallRectangle.getWidth()){
			            for(int i = 0; i < containerRectangle.getHeight() / smallRectangle.getHeight(); i++){
			                try {
			                	Rectangle temp = new Rectangle(smallRectangle.getHeight() * columnNumber, smallRectangle.getHeight() * i,
			                                   smallRectangle.getWidth(), smallRectangle.getHeight(), Color.YELLOW);
			                	this._area += temp.area();
			        			this._perimeter += temp.perimeter();
			                	graphics = temp.draw(graphics);
			                }
			                catch(ShapeException e) {
			                	System.out.println(e.what());
			                }
			            }
			       }
			    }
			}
		}
		else if((shapes[0] instanceof Rectangle) && (shapes[1] instanceof Triangle)) {
			Rectangle rectangle = (Rectangle)shapes[0];
			Triangle triangle = (Triangle)shapes[1];
			graphics.setColor(Color.RED);
			graphics = rectangle.draw(graphics);
			this._area += rectangle.area();
			this._perimeter += triangle.perimeter();
			int i, j, k,
            columnNumber1 =  (int)(rectangle.getWidth() / triangle.getSide()),
            columnNumber2 = (int)((rectangle.getWidth() - triangle.getSide() / 2) / triangle.getSide());
			rowNumber = (int)(rectangle.getHeight() / (triangle.getSide() * Math.sqrt(3) / 2));
            for(i = 0; i < rowNumber; i++){
                for(j = 0; j < columnNumber1; j++){
                	try {
	                   Triangle temp = new Triangle(triangle.getSide() * j, triangle.getSide() * i * Math.sqrt(3) / 2,
	                                 triangle.getSide() * j + triangle.getSide(), triangle.getSide() * i * Math.sqrt(3) / 2,
	                                 triangle.getSide() * j + triangle.getSide() / 2, 
	                                 (triangle.getSide() / 2) * (i + 1) * Math.sqrt(3), Color.YELLOW, triangle.getSide());
	                    this._area += temp.area();
	        			this._perimeter += temp.perimeter();
	                    graphics = temp.draw(graphics);
                	}
                	catch(ShapeException e) {
                		System.out.println(e.what());
                	}
                }
                for(k = 1; k <= columnNumber2; k++){
                	try {
	                    Triangle temp = new Triangle(triangle.getSide() * k , triangle.getSide() * i * Math.sqrt(3) / 2,
	                                 triangle.getSide() * k - triangle.getSide() / 2, triangle.getSide() * Math.sqrt(3) * (i + 1) / 2,
	                                 triangle.getSide() * k + triangle.getSide() / 2, triangle.getSide() * Math.sqrt(3) * (i + 1) / 2, 
	                                 Color.YELLOW, triangle.getSide());
	                    this._area += temp.area();
	        			this._perimeter += temp.perimeter();
	                    graphics = temp.draw(graphics);
                	}
                    catch(ShapeException e) {
                    		
                    }
                }
          }
        }
		else if((shapes[0] instanceof Rectangle) && (shapes[1] instanceof Circle)) {
			Rectangle rectangle = (Rectangle)shapes[0];
			Circle circle= (Circle)shapes[1];
			graphics = rectangle.draw(graphics);
			this._area += rectangle.area();
			this._perimeter += rectangle.perimeter();
			int i, j;
	        rowNumber = (int)(rectangle.getHeight() / (circle.getR() * 2));
	        columnNumber = (int)(rectangle.getWidth() / (circle.getR() * 2));
	        
	        if(rectangle.getHeight() >= circle.getR() * 2 && rectangle.getWidth() >= circle.getR() * 2){
	            for(i = 0; i < circle.getR() * rowNumber * 2; i += circle.getR() * 2)
	                for(j = 0; j < circle.getR() * columnNumber * 2; j += circle.getR() * 2){
	                	try {
	                		Circle temp = new Circle(circle.getR() + j, circle.getR() + i, circle.getR(), Color.YELLOW);
	                		this._area += temp.area();
		        			this._perimeter += temp.perimeter();
	                		graphics = temp.draw(graphics);
	                	}
	                	catch(ShapeException e) {
	                		System.out.println(e.what());
	                	}
	                }
	        }
	        if((rectangle.getWidth() - (circle.getR() * 2 * columnNumber)) >= circle.getR() * Math.sqrt(3) &&
	            ((rectangle.getHeight() - (circle.getR() * 2 * rowNumber)) < circle.getR() * Math.sqrt(3))){
	            for(i = 1; i <= columnNumber; i++){
	            	try {
	            		Circle temp = new Circle(rectangle.getWidth() - circle.getR(), circle.getR() * i * 2, circle.getR(), Color.YELLOW);
	            		this._area += temp.area();
	        			this._perimeter += temp.perimeter();
	            		graphics = temp.draw(graphics);
	            	}
	            	catch(ShapeException e) {
	            		System.out.println(e.what());
	            	}
	            }
	        }
	        else if((rectangle.getHeight() - (circle.getR() * 2 * rowNumber)) >= circle.getR() * Math.sqrt(3) &&
	            ((rectangle.getWidth() - (circle.getR() * 2 * columnNumber)) < circle.getR() * Math.sqrt(3))){
	            for(i = 1; i <= rowNumber; i++){
	                try {
	                	Circle temp = new Circle(circle.getR() * i * 2, circle.getR() - circle.getR(), circle.getR(), Color.YELLOW);
	                	this._area += temp.area();
	        			this._perimeter += temp.perimeter();
	            		graphics = temp.draw(graphics);
	                }
	                catch(ShapeException e) {
	                	System.out.println(e.what());
	                }
	            }
	        }
	        else if((rectangle.getHeight() - (circle.getR() * 2 * rowNumber)) >= circle.getR() * Math.sqrt(3) &&
	            ((rectangle.getWidth() - (circle.getR() * 2 * columnNumber)) >= circle.getR() * Math.sqrt(3))){
	            for(i = 1; i <= rowNumber; i++){
	            	try {
	            		Circle temp = new Circle(circle.getR() * i * 2, rectangle.getHeight() - circle.getR(), circle.getR(), Color.YELLOW);
	            		this._area += temp.area();
	        			this._perimeter += temp.perimeter();
	            		graphics = temp.draw(graphics);
	            	}
	            	catch(ShapeException e) {
	            		System.out.println(e.what());
	            	}
	            }
	            for(i = 1; i < columnNumber; i++){
	            	try {
	            		Circle temp = new Circle(rectangle.getWidth() - circle.getR(), circle.getR() * i * 2, circle.getR(), Color.YELLOW);
	            		this._area += temp.area();
	        			this._perimeter += temp.perimeter();
	            		graphics = temp.draw(graphics);
	            	}
	            	catch(ShapeException e) {
	            		System.out.println(e.what());
	            	}
	            }
	        }
		}
		else if((shapes[0] instanceof Triangle) && (shapes[1] instanceof Rectangle)) {
			Triangle triangle = (Triangle)shapes[0];
			Rectangle rectangle = (Rectangle)shapes[1];
			graphics = triangle.draw(graphics);
			this._area += triangle.area();
			this._perimeter += triangle.perimeter();
			int temp;
	        if(rectangle.getWidth() < rectangle.getHeight()){
	            temp = (int)rectangle.getWidth();
	            try {
	            	rectangle.set(rectangle.getHeight(), temp, Color.YELLOW);
	            }
	            catch(ShapeException e) {
	            	System.out.println(e.what());
	            }
	        }
	        rowNumber = (int)((triangle.getSide() * Math.sqrt(3) / 2 - rectangle.getWidth() * Math.sqrt(3) / 2) / rectangle.getHeight());
	        double firstHeight = rectangle.getWidth() * Math.sqrt(3) /2;
	        int i, j;
	        for(i = 1; i <= rowNumber; i++){
	            for(j = 0; j < (int)((rectangle.getHeight() * (i - 1) + firstHeight) / firstHeight); j++){
	                try {
	                	Rectangle tempRect = new Rectangle(((triangle.getSide() / 2 ) - (rectangle.getWidth() / 2) - ((i - 1) * rectangle.getHeight() / Math.sqrt(3)))
                                + rectangle.getWidth() * j,
                                rectangle.getWidth() * Math.sqrt(3) / 2 + rectangle.getHeight() * (i - 1),
                                rectangle.getWidth(), rectangle.getHeight(), Color.YELLOW);
	                	this._area += tempRect.area();
	        			this._perimeter += tempRect.perimeter();
	                	graphics = tempRect.draw(graphics);
	                }
	                catch(ShapeException e) {
	                	System.out.println(e.what());
	                }
	            }
	        }
		}
		else if((shapes[0] instanceof Triangle) && (shapes[1] instanceof Triangle)) {
			Triangle containerTriangle = (Triangle)shapes[0];
			Triangle smallTriangle = (Triangle)shapes[1];
			graphics = containerTriangle.draw(graphics);
			int i, j;
            rowNumber = (int)((containerTriangle.getSide() * Math.sqrt(3) / 2) /(smallTriangle.getSide() * Math.sqrt(3) / 2));
            for(i = 0; i < rowNumber; i++){
                for(j = 0; j <= i; j++){
                    try {
                    	Triangle temp = new Triangle((containerTriangle.getSide()/ 2) - (i * smallTriangle.getSide() / 2) + smallTriangle.getSide() * j,
                                       smallTriangle.getSide() * Math.sqrt(3) / 2 * i,
                                       (containerTriangle.getSide() / 2) - (i * smallTriangle.getSide() / 2) + smallTriangle.getSide() * j - smallTriangle.getSide() / 2,
                                       smallTriangle.getSide() * Math.sqrt(3) / 2 * (i + 1),
                                       (containerTriangle.getSide() / 2) - (i * smallTriangle.getSide() / 2) + smallTriangle.getSide() * j + smallTriangle.getSide() / 2,
                                       smallTriangle.getSide() * Math.sqrt(3) / 2 * (i + 1), Color.YELLOW, smallTriangle.getSide());
                    	this._area += temp.area();
	        			this._perimeter += temp.perimeter();
                    	graphics = temp.draw(graphics);
                    }
                    catch(ShapeException e) {
                    	System.out.println(e.what());
                    }
                }
            }
		}
		else if((shapes[0] instanceof Triangle) && (shapes[1] instanceof Circle)) {
			Triangle triangle = (Triangle)shapes[0];
			Circle circle = (Circle)shapes[1];
			graphics = triangle.draw(graphics);
			this._area += triangle.area();
			this._perimeter += triangle.perimeter();
			int i, j;
            rowNumber = (int)((triangle.getSide() - circle.getR() * Math.sqrt(3) * 2) / (circle.getR() * 2) + 1);
            for(i = 0; i < rowNumber; i++)
                for(j = 0; j <= i; j++){
                	try {
                		Circle temp = new Circle(triangle.getSide() / 2 - (circle.getR() * i) + (circle.getR() * 2 * j),
                                (circle.getR() * 2) + (circle.getR() * Math.sqrt(3) * i), circle.getR(), Color.YELLOW);
                		this._area += temp.area();
	        			this._perimeter += temp.perimeter();
                		graphics = temp.draw(graphics);
                	}
                	catch(ShapeException e) {
                		System.out.println(e.what());
                	}
                }
		}
		else if((shapes[0] instanceof Circle) && (shapes[1] instanceof Rectangle)) {
			Circle circle = (Circle)shapes[0];
			Rectangle rectangle = (Rectangle)shapes[1];
			double difference = (circle.getR() - circle.getR()/Math.sqrt(2)) / 2;
            graphics = circle.draw(graphics);
			int i, j;
            try {
            	Rectangle greatRectangle = new Rectangle(circle.getR() / Math.sqrt(2), circle.getR() / Math.sqrt(2), Color.YELLOW);
                Rectangle smallRectangle = rectangle;
                if(((greatRectangle.getHeight() / smallRectangle.getHeight()) * (greatRectangle.getWidth() / smallRectangle.getWidth())) >=
                        ((greatRectangle.getHeight() / smallRectangle.getWidth()) * (greatRectangle.getWidth() / smallRectangle.getHeight()))){
                        rowNumber = (int)(greatRectangle.getHeight() / smallRectangle.getHeight());
                        columnNumber = (int)(greatRectangle.getWidth() / smallRectangle.getWidth());

                        for(i = 0; i < rowNumber; i++)
                            for(j = 0; j < columnNumber; j++){
                                try {
                                	Rectangle temp = new Rectangle(smallRectangle.getWidth() * j + difference, smallRectangle.getHeight() * i + difference,
                                            smallRectangle.getWidth(), smallRectangle.getHeight(), Color.YELLOW);
                                	this._area += temp.area();
    			        			this._perimeter += temp.perimeter();
                                	graphics = temp.draw(graphics);
                                }
                                catch(ShapeException e) {
                                	System.out.println(e.what());
                                }
                            }
                        if((greatRectangle.getHeight() - smallRectangle.getHeight() * rowNumber) >= smallRectangle.getWidth()){
                            for(i = 0; i < greatRectangle.getWidth() / smallRectangle.getHeight(); i++){
                            	try {
                            		Rectangle temp = new Rectangle(smallRectangle.getHeight() * i + difference, smallRectangle.getHeight() * rowNumber + difference,
                                    				   smallRectangle.getHeight(), smallRectangle.getWidth(), Color.YELLOW);
                            		this._area += temp.area();
    			        			this._perimeter += temp.perimeter();
                            		graphics = temp.draw(graphics);
                            	}
                            	catch(ShapeException e) {
                            		System.out.println(e.what());
                            	}
                            }
                        }
                        if((greatRectangle.getWidth() - smallRectangle.getWidth() * columnNumber) >= smallRectangle.getHeight()){
                            for(i = 0; i < greatRectangle.getHeight() / smallRectangle.getWidth(); i++){
                            	try {
                                    Rectangle temp = new Rectangle(smallRectangle.getWidth() * columnNumber + difference, smallRectangle.getWidth() * i + difference,
                                                       smallRectangle.getHeight(), smallRectangle.getWidth(), Color.YELLOW);
                                    this._area += temp.area();
    			        			this._perimeter += temp.perimeter();
                                    graphics = temp.draw(graphics);
                            	}
                            	catch(ShapeException e) {
                            		System.out.println(e.what());
                            	}
                            }
                        }
                    }
                    else{
                        rowNumber = (int)(greatRectangle.getHeight() / smallRectangle.getWidth());
                        columnNumber = (int)(greatRectangle.getWidth() / smallRectangle.getHeight());

                        for(i = 0; i < rowNumber; i++)
                            for(j = 0; j < columnNumber; j++){
                            	try {
                            		Rectangle temp = new Rectangle(smallRectangle.getHeight()* j + difference, smallRectangle.getWidth() * i + difference,
                                            smallRectangle.getHeight(), smallRectangle.getWidth(), Color.YELLOW);
                            		this._area += temp.area();
    			        			this._perimeter += temp.perimeter();
                            		graphics = temp.draw(graphics);
                            	}
                            	catch(ShapeException e) {
                            		System.out.println(e.what());
                            	}
                            }

                        if((greatRectangle.getHeight() - smallRectangle.getWidth() * rowNumber) >= smallRectangle.getHeight()){
                            for(i = 0; i < greatRectangle.getWidth() / smallRectangle.getWidth(); i++){
                                try {
                                	 Rectangle temp= new Rectangle(smallRectangle.getWidth() * i + difference, smallRectangle.getWidth() * rowNumber + difference,
                                            smallRectangle.getWidth(), smallRectangle.getHeight(), Color.YELLOW);
                                	 this._area += temp.area();
     			        			 this._perimeter += temp.perimeter();
                                	 graphics = temp.draw(graphics);
                                }
                                catch(ShapeException e) {
                                	System.out.println(e.what());
                                }
                            }
                        }
                        if((greatRectangle.getWidth() - smallRectangle.getHeight() * columnNumber) >= smallRectangle.getWidth()){
                            for(i = 0; i < greatRectangle.getHeight() / smallRectangle.getHeight(); i++){
                                try {
                                	 Rectangle temp = new Rectangle(smallRectangle.getHeight() * columnNumber + difference, smallRectangle.getHeight() * i + difference,
                                            smallRectangle.getWidth(), smallRectangle.getHeight(), Color.YELLOW);
                                	 this._area += temp.area();
     			        			 this._perimeter += temp.perimeter();
                                	 graphics = temp.draw(graphics);
                                }
                                catch(ShapeException e) {
                                	System.out.println(e.what());
                                }
                            }
                        }
                    }
            }
            catch(ShapeException e) {
            	System.out.println(e.what());
            }
		}
		else if((shapes[0] instanceof Circle) && (shapes[1] instanceof Triangle)) {
			Circle circle = (Circle)shapes[0];
			Triangle triangle = (Triangle)shapes[1];
			this._area += circle.area();
			this._perimeter += circle.perimeter();
			graphics = circle.draw(graphics);
			try {
	            Rectangle rectangle = new Rectangle((circle.getR() - circle.getR()/Math.sqrt(2)) / 2, 
	            									 (circle.getR() - circle.getR()/Math.sqrt(2)) / 2, 
	            									 circle.getR() / Math.sqrt(2), circle.getR() / Math.sqrt(2), Color.YELLOW);
				int i, j, k;
	            rowNumber = (int)(rectangle.getHeight() / (triangle.getSide() * Math.sqrt(3) / 2));
	            int columnNumber1 =  (int)(rectangle.getWidth() / triangle.getSide());
	            int columnNumber2 = (int)((rectangle.getWidth() - triangle.getSide() / 2) / triangle.getSide());
	            for(i = 0; i < rowNumber; i++){
	                for(j = 0; j < columnNumber1; j++){
	                	try {
		                   Triangle temp = new Triangle(triangle.getSide() * j + (circle.getR() - circle.getR()/Math.sqrt(2)) / 2, 
		                		   						triangle.getSide() * i * Math.sqrt(3) / 2 + (circle.getR() - circle.getR()/Math.sqrt(2)) / 2,
		                                 				triangle.getSide() * j + triangle.getSide() + (circle.getR() - circle.getR()/Math.sqrt(2)) / 2, 
		                                 				triangle.getSide() * i * Math.sqrt(3) / 2 + (circle.getR() - circle.getR()/Math.sqrt(2)) / 2,
		                                 				triangle.getSide() * j + triangle.getSide() / 2 + (circle.getR() - circle.getR()/Math.sqrt(2)) / 2, 
		                                 				(triangle.getSide() / 2) * (i + 1) * Math.sqrt(3) + (circle.getR() - circle.getR()/Math.sqrt(2)) / 2, 
		                                 				Color.YELLOW, triangle.getSide());
		                    this._area += temp.area();
		        			this._perimeter += temp.perimeter();
		                    graphics = temp.draw(graphics);
	                	}
	                	catch(ShapeException e) {
	                		System.out.println(e.what());
	                	}
	                }
	                for(k = 1; k <= columnNumber2; k++){
	                	try {
		                    Triangle temp = new Triangle(triangle.getSide() * k + (circle.getR() - circle.getR()/Math.sqrt(2)) / 2, 
		                    							 triangle.getSide() * i * Math.sqrt(3) / 2 + (circle.getR() - circle.getR()/Math.sqrt(2)) / 2,
		                    							 triangle.getSide() * k - triangle.getSide() / 2 + (circle.getR() - circle.getR()/Math.sqrt(2)) / 2, 
		                    							 triangle.getSide() * Math.sqrt(3) * (i + 1) / 2 + (circle.getR() - circle.getR()/Math.sqrt(2)) / 2,
		                    							 triangle.getSide() * k + triangle.getSide() / 2 + (circle.getR() - circle.getR()/Math.sqrt(2)) / 2, 
		                    							 triangle.getSide() * Math.sqrt(3) * (i + 1) / 2 + (circle.getR() - circle.getR()/Math.sqrt(2)) / 2, 
		                    							 Color.YELLOW, triangle.getSide()); 
		                    this._area += temp.area();
		        			this._perimeter += temp.perimeter();
		                    graphics = temp.draw(graphics);
	                	}
	                    catch(ShapeException e) {
	                    		
	                    }
	                }
	          }
			}
			catch(ShapeException e) {
				System.out.println(e.what());
			}
		}
		else if((shapes[0] instanceof Circle) && (shapes[1] instanceof Circle)) {
			Circle cCircle = (Circle)shapes[0];
			Circle circle = (Circle)shapes[1];
			this._area += cCircle.area();
			this._perimeter += cCircle.perimeter();
			graphics = cCircle.draw(graphics);
			try {
	            Rectangle rectangle = new Rectangle((cCircle.getR() - cCircle.getR()/Math.sqrt(2)) / 2, 
	            									 (cCircle.getR() - cCircle.getR()/Math.sqrt(2)) / 2, 
	            									 cCircle.getR() / Math.sqrt(2), cCircle.getR() / Math.sqrt(2), Color.YELLOW);
	            int i, j;
		        rowNumber = (int)(rectangle.getHeight() / (circle.getR() * 2));
		        columnNumber = (int)(rectangle.getWidth() / (circle.getR() * 2));
		        
		        if(rectangle.getHeight() >= circle.getR() * 2 && rectangle.getWidth() >= circle.getR() * 2){
		            for(i = 0; i < circle.getR() * rowNumber * 2; i += circle.getR() * 2)
		                for(j = 0; j < circle.getR() * columnNumber * 2; j += circle.getR() * 2){
		                	try {
		                		Circle temp = new Circle(circle.getR() + j + (cCircle.getR() - cCircle.getR()/Math.sqrt(2)) / 2, 
		                								 circle.getR() + i + (cCircle.getR() - cCircle.getR()/Math.sqrt(2)) / 2, 
		                								 circle.getR(), Color.YELLOW);
		                		this._area += temp.area();
			        			this._perimeter += temp.perimeter();
		                		graphics = temp.draw(graphics);
		                	}
		                	catch(ShapeException e) {
		                		System.out.println(e.what());
		                	}
		                }
		        }
		        if((rectangle.getWidth() - (circle.getR() * 2 * columnNumber)) >= circle.getR() * Math.sqrt(3) &&
		            ((rectangle.getHeight() - (circle.getR() * 2 * rowNumber)) < circle.getR() * Math.sqrt(3))){
		            for(i = 1; i <= columnNumber; i++){
		            	try {
		            		Circle temp = new Circle(rectangle.getWidth() - circle.getR() + (cCircle.getR() - cCircle.getR()/Math.sqrt(2)) / 2, 
		            								 circle.getR() * i * 2, circle.getR() + (cCircle.getR() - cCircle.getR()/Math.sqrt(2)) / 2, 
		            								 Color.YELLOW);
		            		this._area += temp.area();
		        			this._perimeter += temp.perimeter();
		            		graphics = temp.draw(graphics);
		            	}
		            	catch(ShapeException e) {
		            		System.out.println(e.what());
		            	}
		            }
		        }
		        else if((rectangle.getHeight() - (circle.getR() * 2 * rowNumber)) >= circle.getR() * Math.sqrt(3) &&
		            ((rectangle.getWidth() - (circle.getR() * 2 * columnNumber)) < circle.getR() * Math.sqrt(3))){
		            for(i = 1; i <= rowNumber; i++){
		                try {
		                	Circle temp = new Circle(circle.getR() * i * 2 + (cCircle.getR() - cCircle.getR()/Math.sqrt(2)) / 2, 
		                							 circle.getR() - circle.getR() + (cCircle.getR() - cCircle.getR()/Math.sqrt(2)) / 2, 
		                							 circle.getR(), Color.YELLOW);
		                	this._area += temp.area();
		        			this._perimeter += temp.perimeter();
		            		graphics = temp.draw(graphics);
		                }
		                catch(ShapeException e) {
		                	System.out.println(e.what());
		                }
		            }
		        }
		        else if((rectangle.getHeight() - (circle.getR() * 2 * rowNumber)) >= circle.getR() * Math.sqrt(3) &&
		            ((rectangle.getWidth() - (circle.getR() * 2 * columnNumber)) >= circle.getR() * Math.sqrt(3))){
		            for(i = 1; i <= rowNumber; i++){
		            	try {
		            		Circle temp = new Circle(circle.getR() * i * 2 + (cCircle.getR() - cCircle.getR()/Math.sqrt(2)) / 2, 
		            								 rectangle.getHeight() - circle.getR() + (cCircle.getR() - cCircle.getR()/Math.sqrt(2)) / 2, 
		            								 circle.getR(), 
		            								 Color.YELLOW);
		            		this._area += temp.area();
		        			this._perimeter += temp.perimeter();
		            		graphics = temp.draw(graphics);
		            	}
		            	catch(ShapeException e) {
		            		System.out.println(e.what());
		            	}
		            }
		            for(i = 1; i < columnNumber; i++){
		            	try {
		            		Circle temp = new Circle(rectangle.getWidth() - circle.getR() + (cCircle.getR() - cCircle.getR()/Math.sqrt(2)) / 2, 
		            								 circle.getR() * i * 2 + (cCircle.getR() - cCircle.getR()/Math.sqrt(2)) / 2, 
		            								 circle.getR(), Color.YELLOW);
		            		this._area += temp.area();
		        			this._perimeter += temp.perimeter();
		            		graphics = temp.draw(graphics);
		            	}
		            	catch(ShapeException e) {
		            		System.out.println(e.what());
		            	}
		            }
		        }
			}
			catch(ShapeException e) {
				System.out.println(e.what());
			}
		}
		
		return graphics;
	}
}
