package Exe.EX3;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.Color;
import org.junit.jupiter.api.Test;

public class MyMap2DTest {

	// Creating the map object so we will be able to do the testing on it
	private static MyMap2D _map_test = null;

	// Colors for checking
	int black = Color.BLACK.getRGB();
	int blue = Color.BLUE.getRGB();
	int white = Color.WHITE.getRGB();
	int green = Color.GREEN.getRGB();
	int yellow = Color.YELLOW.getRGB();


	/**
	 * Most of the tests here will go like that:
	 * We will build the object of the map.
	 * Then we will call the functions/methods on it
	 * Then we will check that we've got the same value we have wanted.
	 * 
	 * After it we will try to combine test, like to draw rectangle and then to fill it, then to draw short path, etc...
	 * 
	 * Important!!! - In this test we are going according to optional 'mouse clicking points', so the input points are in the bounds
	 * For out of bound input!! points we are doing try&catch 
	 */

	@Test
	public void testSegment() {
		_map_test = new MyMap2D(20);

		try {							// If the input points are not in the map bound 						
			Point2D p1 = new Point2D(5,15);
			Point2D p2 = new Point2D(8,8);

			_map_test.drawSegment(p1, p2, blue); // Drawing the segment  to blue

			// In the same way the Function have worked we will go over the map here and see if e've got the same value

			int distX = (int)Math.abs(p1.ix() - p2.ix()); // Delta X
			int distY = (int)Math.abs(p1.iy() - p2.iy());

			// Checking if to go right or left, up or down
			int sx = p2.x() < p1.x() ? 1 : -1;  // X slope according to which point is higher
			int sy = p2.y() < p1.y() ? 1 : -1;	// Y slope according to which point is higher

			int x0 = p2.ix();
			int y0 = p2.iy();
			int x1 = p1.ix();
			int y1 = p1.iy();

			int err = distX - distY; 
			int e2 = 0;				 // Decision variable, based on 2*(DeltaX - DeltaY), that will fix the slope error

			while(true) {
				assertEquals(_map_test.getPixel(x0, y0) ,blue);	// Checking if we are got the same value				
				if(x0 == x1 && y0== y1) {  						// Means we've got to the end point.
					break;
				}

				e2 = 2*err;    //  
				if(e2 > -distY) {			// Going right or left
					err = err-distY;
					x0 = x0 + sx; 
				}
				if(e2 < distX) {			// Going up or down
					err = err + distX;
					y0 = y0 + sy;
				}
			}
		}catch(IndexOutOfBoundsException e) {} // Only for out of index input! points

	}

	@Test
	/**
	 * This test for checking the rectanlge_draw function.
	 * As was written on the top of the class, the way of the test 
	 */
	public void testRect() {
		_map_test = new MyMap2D(20); 	// Creating the object
		_map_test.fill(white); 			// Clearing the map from every thing

		try {							// If the input points are not in the map bound 
			Point2D p1 = new Point2D(1,2);
			Point2D p2 = new Point2D(4,10);
			int minX = Math.min(p1.ix(), p2.ix());
			int minY = Math.min(p1.iy(), p2.iy());

			int width = Math.abs((p1.ix() - p2.ix())); // The width of the
			int hight = Math.abs((p1.iy() - p2.iy()));
			_map_test.drawRect(p1, p2, 1);

			int[][] tmp = new int [_map_test.getWidth()][_map_test.getHeight()];
			for (int i = 0; i < _map_test.getHeight(); i++) {
				for (int j = 0; j < _map_test.getWidth(); j++)  {
					tmp[i][j] = _map_test.getPixel(i, j);  		// Deep copy for the color num
				}
			}
			for (int i = 0; i <= hight; i++) {
				for (int j = 0; j <= width; j++) {
					assertEquals(tmp[j + minX][i + minY] , 1);
				}
			}
		} catch(IndexOutOfBoundsException e) {} // Only for out of index input! points
	}

	@Test
	public void testCircle() {

		// Checking for regular circle 
		_map_test = new MyMap2D(40);
		_map_test.fill(white); 			// Clearing the map from every thing

		try {
			Point2D p1 = new Point2D(13,15);
			Point2D p2 = new Point2D(13,20);
			int rad = (int)p1.distance(p2);
			_map_test.drawCircle(p1,rad , 1);

			for (int i = 0; i < 40; i++) {
				for (int j = 0; j <40; j++)  {
					Point2D pm = new Point2D(i,j);
					if((p1.distance(pm)<rad)) {
						assertEquals(_map_test.getPixel(pm),1);
					}
				}
			}
		}catch (IndexOutOfBoundsException e) {} // Only for out of index input! points
	}

	//Fill test
	@Test
	public void testFill() {

		_map_test = new MyMap2D(160); // Creating new object, checking on a big map that it working
		_map_test.fill(white); 		 // Clearing the map from every thing

		try {						// If the input points are not in the map bound 
			_map_test.fill(0, 0, yellow);		

			int [][] temp = _map_test.getMap(); // Notice that we aren't changing anything
			for (int i = 0; i < 160; i++) {
				for (int j = 0; j <160; j++)  {
					temp[i][j] = _map_test.getPixel(i, j);  // Deep copy for the color num
				}
			}
			assertEquals(temp[1][1],yellow);

			// Drawing a circle and then use fill function to change its color, then we will use fill again to fill outside the circle
			_map_test.fill(white); // Clearing the map from every thing
			_map_test.init(40, 40);  			 // Magnify the map to get more accurate circle

			Point2D pc = new Point2D(17,21); 		// Point of the center of the circle
			Point2D pcr = new Point2D(25,21); 		// Point of the distance for the radius

			double radius = pc.distance(pcr);
			_map_test.drawCircle(pc,radius ,blue); //Drawing blue circle

			_map_test.fill(pc, green); // Changing the color to green
			_map_test.fill(3, 4, yellow); // Changing the rest of the map to yellow except from the circle  

			// Checking the the color was changed
			for (int i = 0; i < 40; i++) {
				for (int j = 0; j <40; j++)  {
					Point2D pm = new Point2D(i,j);
					if((pc.distance(pm)<radius)) {
						assertEquals(_map_test.getPixel(pm),green);
					}
					else {
						assertEquals(_map_test.getPixel(pm),yellow);
					}
				}
			}

		}catch (IndexOutOfBoundsException e) {
		}
	}

	/**
	 * This test will go like this:
	 * 1. First we will check a standard short path without any "obstacles"/
	 * 2. Then we will check case there no path (different colors or something is blocking the whole way).
	 * 3. After it we'll add all kind of "obstacles" such as: points, segments, rectangles, etc...
	 */

	@Test
	public void testShortestPath() {
		_map_test = new MyMap2D(20); // Creating new object
		_map_test.fill(white); 		// Clearing the map from every thing

		try {						// If the input points are not in the map bound 
			// Standard path
			Point2D p1 = new Point2D(2.078125,0.9453125);
			Point2D p2 = new Point2D(13.1328125,15.90625);

			Point2D[] path = _map_test.shortestPath(p1,p2);
			int dist = _map_test.shortestPathDist(p1, p2);

			for(int i = 0 ; i<dist; i++) { 			// Here we're checking with the by shortestPathDist function
				_map_test.setPixel(path[i], yellow);
			}

			for(int i = 0 ; i<path.length; i++) {	// Here we're checking with the by path's length function, to see if they are equal
				assertEquals(_map_test.getPixel(path[i]), yellow);	
			}
			assertEquals(path.length, dist);

			// Case there no any path
			_map_test.fill(white); // Clearing the map

			Point2D p3 = new Point2D(7.09765625,7.83984375);
			Point2D p4 = new Point2D(2.05859375,2.01953125);
			// Coloring the point in different colors
			_map_test.setPixel(p3, blue);
			_map_test.setPixel(p4, green);

			Point2D[] path2 = _map_test.shortestPath(p3,p4);
			assertNull(path2,"");

			_map_test.fill(white); // Clearing the map
			_map_test.drawSegment(new Point2D(-0.03125,9.9296875), new Point2D(18.8359375,10.0078125), green);

			Point2D[] path3 = _map_test.shortestPath(new Point2D(6.0625,5.046875),new Point2D(10.8671875,12.9375));
			assertNull(path3, "");

			// Case there are "obstacles"
			_map_test.fill(white); // Clearing the map so we can create obstacles

			_map_test.drawRect(new Point2D(3.0546875,16.9609375), new Point2D(11.1015625,11.0234375), blue); // Drawing blue rectangle
			// drawing yellow segment
			_map_test.drawSegment(new Point2D(14.0703125,17.078125), new Point2D(12.078125,6.0234375), yellow); 
			_map_test.drawSegment(new Point2D(1.1015625,7.1953125), new Point2D(9.1484375,9.03125), yellow); 
			_map_test.drawSegment(new Point2D(7.859375,6.921875), new Point2D(7.8984375,1.8828125), yellow);

			// Drawing green shortest path 
			Point2D p5 = new Point2D(4.96875,3.9921875); 
			Point2D p6 = new Point2D(12.078125,17.9765625);

			Point2D[] path4 = _map_test.shortestPath(p5,p6);
			// Coloring it in green
			int dist2 = _map_test.shortestPathDist(p5, p6);

			assertEquals(dist2, 22);
			for(int i = 0; i<dist2; i++) {
				_map_test.setPixel(path4[i], green);
			}
			// Now we will check that no changes in the obstacles colors happened, so we will know the path bypassed them  
			assertEquals(_map_test.getPixel(new Point2D(11.1015625,11.0234375)), blue); // Down right rectangle color
			assertEquals(_map_test.getPixel(new Point2D(12.078125,10.9453125)), green); // Our path 
			assertEquals(_map_test.getPixel(new Point2D(13.0546875,10.90625)), yellow); // One of the yellow segments
			assertEquals(_map_test.getPixel(new Point2D(9.109375,8.9140625)), yellow); //  One of the yellow segments
			assertEquals(_map_test.getPixel(new Point2D(10.0078125,8.9140625)), green); // Our path
		}
		catch (IndexOutOfBoundsException e) {} 	// Only for out of index input! points
	}		


	/**
	 * Test for Game of life
	 * to create a an output of myself on a little map to know nextGen
	 * we will build a greed of 9X9 just to check some of the cases
	 */

	@Test
	public void testGenGol() {
		_map_test = new MyMap2D(10); // A grid 5X5;

		_map_test.fill(white); // Cleared the map from all another point form previous tests

		try {				// If the input points are not in the map bound 
			// We will draw some point for start
			Point2D p1 = new Point2D(1,0);
			Point2D p2 = new Point2D(1,1);
			Point2D p3 = new Point2D(1,2);
			Point2D p4 = new Point2D(0,1);
			Point2D p5 = new Point2D(2,1);


			// We will set them with blue color to check also that the next generation was changed to black;
			_map_test.setPixel(p1, blue);
			_map_test.setPixel(p2, blue);
			_map_test.setPixel(p3, blue);

			// Checking that the points where initialized right with blue color (-16776961)
			assertEquals(_map_test.getPixel(p1), blue);
			assertEquals(_map_test.getPixel(p2), blue);
			assertEquals(_map_test.getPixel(p3), blue);

			// Four point that won't supposed to change in that game
			Point2D p41 = new Point2D(4,5);
			Point2D p42 = new Point2D(4,6);
			Point2D p43 = new Point2D(3,5);
			Point2D p44 = new Point2D(3,6);

			_map_test.setPixel(p41, Color.YELLOW.getRGB());
			_map_test.setPixel(p42, Color.YELLOW.getRGB());
			_map_test.setPixel(p43, Color.YELLOW.getRGB());
			_map_test.setPixel(p44, Color.YELLOW.getRGB());

			_map_test.nextGenGol();	

			// Now we will check that p1 & p3 were changed to white, and p2 was changed to black
			// We will also check that the to neighbors from the side were changed to black  

			// Changed to white

			assertEquals(_map_test.getPixel(p1), white);
			assertEquals(_map_test.getPixel(p3), white);

			// Changed to black
			assertEquals(_map_test.getPixel(p2), black);
			assertEquals(_map_test.getPixel(p4), black);
			assertEquals(_map_test.getPixel(p5), black);

			// From the four points
			assertEquals(_map_test.getPixel(p41), black);
			assertEquals(_map_test.getPixel(p42), black);
			assertEquals(_map_test.getPixel(p43), black);
			assertEquals(_map_test.getPixel(p44), black);


			_map_test.nextGenGol();

			// Checking that they haven't changed
			assertEquals(_map_test.getPixel(p41), black);
			assertEquals(_map_test.getPixel(p42), black);
			assertEquals(_map_test.getPixel(p43), black);
			assertEquals(_map_test.getPixel(p44), black);

			// Changed to white

			assertEquals(_map_test.getPixel(p4), white);
			assertEquals(_map_test.getPixel(p5), white);

			// Changed to black
			assertEquals(_map_test.getPixel(p1), black);
			assertEquals(_map_test.getPixel(p2), black);
			assertEquals(_map_test.getPixel(p3), black);
		}catch (IndexOutOfBoundsException e) {} 		// Only for out of index input! points
	}

}
