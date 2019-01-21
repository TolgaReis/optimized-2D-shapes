package shape;

/**
 * Main part of program.
 * @author Tolga Reis
 * @version 1.0
 */
import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Main class that executes program.
 * @author Tolga Reis
 * @version 1.0
 */
public class Mainapp {

	private JFrame frame;

	/**
	 * Launch the application.
	 * @param args takes argument for user initializing arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainapp window = new Mainapp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Mainapp() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 759, 524);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 11, 451, 463);
		panel.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(panel);
		
		JLabel lblInnerShape = new JLabel("Inner Shape");
		lblInnerShape.setBounds(481, 79, 99, 14);
		frame.getContentPane().add(lblInnerShape);
		
		JLabel lblContainer = new JLabel("Container Shape");
		lblContainer.setBounds(471, 33, 100, 14);
		frame.getContentPane().add(lblContainer);
		
		JComboBox<String> cbContainer = new JComboBox<String>();
		cbContainer.setBounds(461, 48, 100, 20);
		cbContainer.setBackground(Color.WHITE);
		cbContainer.setMaximumRowCount(3);
		cbContainer.addItem("Rectangle");
		cbContainer.addItem("Triangle");
		cbContainer.addItem("Circle");
		frame.getContentPane().add(cbContainer);
		
		JComboBox<String> cbInner = new JComboBox<String>();
		cbInner.setBounds(461, 97, 100, 20);
		cbInner.setBackground(Color.WHITE);
		cbInner.setSelectedIndex(-1);
		cbInner.setMaximumRowCount(3);
		cbInner.addItem("Rectangle");
		cbInner.addItem("Triangle");
		cbInner.addItem("Circle");
		frame.getContentPane().add(cbInner);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(617, 225, 99, 23);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Graphics g = panel.getGraphics(); 
				g.setColor(Color.GRAY); 
				g.fillRect(0, 0, panel.getWidth(), panel.getHeight()); 
				panel.paintComponents(g); 
			}
		});
		frame.getContentPane().add(btnClear);
		
		JButton btnDraw = new JButton("Draw");
		btnDraw.setBounds(617, 47, 99, 23);
		btnDraw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println(cbContainer.getSelectedItem());
				System.out.println(cbInner.getSelectedItem());
				Graphics g = panel.getGraphics();
				String containerSelect = (String)cbContainer.getSelectedItem();
				String innerSelect = (String)cbInner.getSelectedItem();
				if(containerSelect == "Rectangle" && innerSelect == "Rectangle") {
					try {
						Rectangle cRectangle = new Rectangle(0, 0, 200, 200, Color.RED);
						Rectangle iRectangle = new Rectangle(0, 0, 30, 30, Color.YELLOW);
						ComposedShape composed = new ComposedShape(cRectangle, iRectangle);
						g = composed.draw(g);
					}
					catch(ShapeException e) {
						System.out.println(e.what());
					}
				}
				else if(containerSelect == "Rectangle" && innerSelect == "Triangle") {
					try {
						Rectangle rectangle = new Rectangle(0, 0, 200, 200, Color.RED);
						Triangle triangle = new Triangle(10, 0 ,0, 17, 20, 17, Color.YELLOW, 10);
						ComposedShape composed = new ComposedShape(rectangle, triangle);
						g = composed.draw(g);
					}
					catch(ShapeException e) {
						System.out.println(e.what());
					}
				}
				else if(containerSelect == "Rectangle" && innerSelect == "Circle") {
					try {
						Rectangle rectangle = new Rectangle(0, 0, 200, 200, Color.RED);
						Circle circle = new Circle(10, 10, 10, Color.YELLOW);
						ComposedShape composed = new ComposedShape(rectangle, circle);
						g = composed.draw(g);
					}
					catch(ShapeException e) {
						System.out.println(e.what());
					}
				}
				else if(containerSelect == "Triangle" && innerSelect == "Rectangle") {
					try {
						Rectangle rectangle = new Rectangle(0, 0, 20, 20, Color.YELLOW);
						Triangle triangle = new Triangle(100, 0 ,0, 173, 200, 173, Color.RED, 200);
						ComposedShape composed = new ComposedShape(triangle, rectangle);
						g = composed.draw(g);
					}
					catch(ShapeException e) {
						System.out.println(e.what());
					}
				}
				else if(containerSelect == "Triangle" && innerSelect == "Triangle") {
					try {
						Triangle containerTriangle = new Triangle(100, 0 ,0, 173, 200, 173, Color.RED, 200);
						Triangle smallTriangle = new Triangle(10, 0 ,0, 17, 20, 17, Color.YELLOW, 20);
						ComposedShape composed = new ComposedShape(containerTriangle, smallTriangle);
						g = composed.draw(g);
					}
					catch(ShapeException e) {
						System.out.println(e.what());
					}
				}
				else if(containerSelect == "Triangle" && innerSelect == "Circle") {
					try {
						Triangle triangle = new Triangle(100, 0 ,0, 173, 200, 173, Color.RED, 200);
						Circle circle = new Circle(10, 10, 10, Color.YELLOW);
						ComposedShape composed = new ComposedShape(triangle, circle);
						g = composed.draw(g);
					}
					catch(ShapeException e) {
						System.out.println(e.what());
					}
				}
				else if(containerSelect == "Circle" && innerSelect == "Rectangle") {
					try {
						Circle circle = new Circle(0, 0, 200, Color.RED);
						Rectangle rectangle = new Rectangle(0, 0, 20, 20, Color.YELLOW);
						ComposedShape composed = new ComposedShape(circle, rectangle);
						g = composed.draw(g);
					}
					catch(ShapeException e) {
						System.out.println(e.what());
					}
				}
				else if(containerSelect == "Circle" && innerSelect == "Triangle") {
					try {
						Circle circle = new Circle(0, 0, 200, Color.RED);
						Triangle triangle = new Triangle(10, 0 ,0, 17, 20, 17, Color.YELLOW, 20);
						ComposedShape composed = new ComposedShape(circle, triangle);
						g = composed.draw(g);
					}
					catch(ShapeException e) {
						System.out.println(e.what());
					}
				}
				else if(containerSelect == "Circle" && innerSelect == "Circle") {
					try {
						Circle cCircle = new Circle(0, 0, 200, Color.RED);
						Circle sCircle = new Circle(0, 0, 10, Color.YELLOW);
						ComposedShape composed = new ComposedShape(cCircle, sCircle);
						g = composed.draw(g);
					}
					catch(ShapeException e) {
						System.out.println(e.what());
					}
				}
			}
		});
		btnDraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		frame.getContentPane().add(btnDraw);
		
		JLabel lblTestPart = new JLabel("Test Part");
		lblTestPart.setBounds(562, 151, 75, 14);
		frame.getContentPane().add(lblTestPart);
		
		JLabel lblWhichOne = new JLabel("Which One");
		lblWhichOne.setBounds(481, 176, 100, 14);
		frame.getContentPane().add(lblWhichOne);
		
		JComboBox<String> cbTest = new JComboBox<String>();
		cbTest.setSelectedIndex(-1);
		cbTest.setMaximumRowCount(5);
		cbTest.setBackground(Color.WHITE);
		cbTest.setBounds(461, 192, 100, 20);
		cbTest.addItem("Rectangle");
		cbTest.addItem("Triangle");
		cbTest.addItem("Circle");
		cbTest.addItem("PolygonDyn");
		cbTest.addItem("PolygonVect");
		cbTest.addItem("drawAll");
		cbTest.addItem("convertAll");
		cbTest.addItem("sortShapes");
		frame.getContentPane().add(cbTest);
		
		JButton btnTest = new JButton("Test");
		btnTest.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println(cbTest.getSelectedItem() + " is testing...");
				Graphics g = panel.getGraphics();
				String testSelect = (String)cbTest.getSelectedItem();
				if(testSelect == "Rectangle") {
					try {
						Rectangle cRectangle = new Rectangle(0, 0, 200, 200, Color.RED);
						Rectangle iRectangle = new Rectangle(0, 0, 30, 30, Color.YELLOW);
						g = cRectangle.draw(g);
						g = iRectangle.draw(g);
						System.out.println(cRectangle.toString());
						System.out.printf("Compare great and small rectangles: %d\n", cRectangle.compareTo(iRectangle));
						
					}
					catch(ShapeException e) {
						System.out.println(e.what());
					}
					
				}
				else if(testSelect == "Triangle") {
					try {
						Triangle containerTriangle = new Triangle(100, 0 ,0, 173, 200, 173, Color.RED, 200);
						Triangle smallTriangle = new Triangle(10, 0 ,0, 17, 20, 17, Color.YELLOW, 20);
						g = containerTriangle.draw(g);
						g = smallTriangle.draw(g);
						System.out.println(containerTriangle.toString());
						System.out.printf("Compare great and small rectangles: %d\n", containerTriangle.compareTo(smallTriangle));
						
					}
					catch(ShapeException e) {
						System.out.println(e.what());
					}
					
				}
				else if(testSelect == "Circle") {
					try {
						Circle cCircle = new Circle(0, 0, 200, Color.RED);
						Circle sCircle = new Circle(0, 0, 10, Color.YELLOW);
						g = cCircle.draw(g);
						g = sCircle.draw(g);
						System.out.println(cCircle.toString());
						System.out.printf("Compare great and small rectangles: %d\n", cCircle.compareTo(sCircle));
						
					}
					catch(ShapeException e) {
						System.out.println(e.what());
					}
					
				}
				else if(testSelect == "PolygonDyn") {
					try {
						PolygonDyn  polygonDyn = new PolygonDyn(new Rectangle(0, 0, 200, 200, Color.RED));
						System.out.printf("\nPolygonDyn rectangle is created.\nArea = %f, Perimeter = %f\n", polygonDyn.area(), polygonDyn.perimeter());
						g = polygonDyn.draw(g);
					}
					catch(ShapeException e) {
						System.out.println(e.what());
					}
				}
				else if(testSelect == "PolygonVect") {
					try {
						PolygonVect  polygonVect = new PolygonVect(new Triangle(100, 0 ,0, 173, 200, 173, Color.YELLOW, 200));
						System.out.printf("\nPolygonDyn rectangle is created.\nArea = %f, Perimeter = %f\n", polygonVect.area(), polygonVect.perimeter());
						g = polygonVect.draw(g);
					}
					catch(ShapeException e) {
						System.out.println(e.what());
					}
				}
				else if(testSelect == "drawAll") {
					try {
						Triangle smallTriangle = new Triangle(10, 0 ,0, 17, 20, 17, Color.YELLOW, 20);
						Circle cCircle = new Circle(0, 0, 200, Color.RED);
						Circle sCircle = new Circle(0, 0, 10, Color.YELLOW);
						Shape[] array = new Shape[3];
						array[0] = smallTriangle;
						array[1] = cCircle;
						array[2] = sCircle;
						g = Global.drawAll(array, g);
						System.out.println("All shapes are drawn.");
					}
					catch(ShapeException e) {
						System.out.println(e.what());
					}
				}
				else if(testSelect == "convertAll") {
					try {
						Triangle smallTriangle = new Triangle(10, 0 ,0, 17, 20, 17, Color.YELLOW, 20);
						Rectangle cRectangle = new Rectangle(0, 0, 200, 200, Color.RED);
						Rectangle iRectangle = new Rectangle(0, 0, 30, 30, Color.YELLOW);
						Shape[] array = new Shape[3];
						array[0] = smallTriangle;
						array[1] = cRectangle;
						array[2] = iRectangle;
						Polygon[] polygon = new Polygon[3];
						polygon = Global.convertAll(array);
						g = polygon[0].draw(g);
						g = polygon[1].draw(g);
						g = polygon[2].draw(g);
						System.out.println("All shapes are converted.");
					}
					catch(ShapeException e) {
						System.out.println(e.what());
					}
				}
				else if(testSelect == "sortShapes") {
					try {
						Triangle smallTriangle = new Triangle(10, 0 ,0, 17, 20, 17, Color.YELLOW, 20);
						Rectangle cRectangle = new Rectangle(0, 0, 200, 200, Color.RED);
						Rectangle iRectangle = new Rectangle(0, 0, 30, 30, Color.YELLOW);
						Shape[] array = new Shape[3];
						array[0] = smallTriangle;
						array[1] = cRectangle;
						array[2] = iRectangle;
						System.out.println("Before sorting: \n1; " + array[0].toString() +
											"\nc2; " + array[1].toString() + "\n3; " +
											array[2].toString());
						Global.sortShapes(array);
						System.out.println("\n\nAfter sorting: \n1; " + array[0].toString() +
								"\n2; " + array[1].toString() + "\n3; " +
								array[2].toString());
					}
					catch(ShapeException e) {
						System.out.println(e.what());
					}
				}
			}
		});
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnTest.setBounds(617, 191, 99, 23);
		frame.getContentPane().add(btnTest);
		
		JButton btnClearTest = new JButton("Clear");
		btnClearTest.setBounds(617, 96, 99, 23);
		btnClearTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Graphics g = panel.getGraphics(); 
				g.setColor(Color.GRAY); 
				g.fillRect(0, 0, panel.getWidth(), panel.getHeight()); 
				panel.paintComponents(g); 
			}
		});
		frame.getContentPane().add(btnClearTest);
	
		
	}
}
