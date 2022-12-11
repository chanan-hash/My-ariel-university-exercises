package Exe.EX3;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.Color;
import org.junit.jupiter.api.Test;

public class MyMap2DTest {

	private static MyMap2D _map_test = null;

	/**
	 * Most of the tests here will go like that:
	 * We will build the object of the map.
	 * Then we will call the functions/methods on it
	 * Then we will check that we've got the same value we have wanted 
	 */

	@Test
	public void testSegment() {
		_map_test = new MyMap2D(20);
		Point2D p1 = new Point2D(5,15);
		Point2D p2 = new Point2D(8,8);

		_map_test.drawSegment(p1, p2, 6); //drawing the segment according to number 6, just for checking

		// In the same way the Function have worked we will go over the map here and see if e've got the same value

		int distX = (int)Math.abs(p1.ix() - p2.ix());
		int distY = (int)Math.abs(p1.iy() - p2.iy());

		int sx = p2.x() < p1.x() ? 1 : -1;  // the stairs for going to the next point
		int sy = p2.y() < p1.y() ? 1 : -1;

		int x0 = p2.ix();
		int y0 = p2.iy();
		int x1 = p1.ix();
		int y1 = p1.iy();

		int err = distX - distY; // the substract between the height and width giving us the diagonal in like a vector
		int e2 = 0;				// fixing slop error

		while(true) {
			assertEquals(_map_test.getPixel(x0, y0) ,6);	// checking if we are got the same value				
			if(x0 == x1 && y0== y1) {  				// we got from one point to another
				break;
			}

			e2 = 2*err;    //  
			if(e2 > -distY) {
				err = err-distY;
				x0 = x0 + sx; 
			}
			if(e2 < distX) {
				err = err + distX;
				y0 = y0 + sy;
			}
		}

	}

	@Test
	/**
	 * This test for checking the rectanlge_draw function.
	 * As was written on the top of the class, the way of the test 
	 */
	public void testRect() {
		_map_test = new MyMap2D(20); //creating the object
		_map_test.fill(Color.WHITE.getRGB()); //clearing the map from every thing
		Point2D p1 = new Point2D(1,2);
		Point2D p2 = new Point2D(4,10);
		int minX = Math.min(p1.ix(), p2.ix());
		int minY = Math.min(p1.iy(), p2.iy());

		int width = Math.abs((p1.ix() - p2.ix())); // the width of the
		int hight = Math.abs((p1.iy() - p2.iy()));
		_map_test.drawRect(p1, p2, 1);

		int[][] tmp = new int [_map_test.getWidth()][_map_test.getHeight()];
		for (int i = 0; i < _map_test.getHeight(); i++) {
			for (int j = 0; j < _map_test.getWidth(); j++)  {
				tmp[i][j] = _map_test.getPixel(i, j);  // deep copy for the color num
			}
		}
		for (int i = 0; i <= hight; i++) {
			for (int j = 0; j <= width; j++) {
				assertEquals(tmp[j + minX][i + minY] , 1);

			}
		}

	}

	@Test
	public void testCircle() {
		// TODO deep copy of the map because it changes it in the heap
		// checking for regular circle 
		_map_test = new MyMap2D(40);
		_map_test.fill(Color.WHITE.getRGB()); //clearing the map from every thing
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
	}

	//fill test
	@Test
	public void testFill() {
		// creating new object
		_map_test = new MyMap2D(20);
		_map_test.fill(Color.WHITE.getRGB()); //clearing the map from every thing

		_map_test.fill(0, 0, 1);		
		//		int[][] temp = new int[20][20];
		int [][] temp = _map_test.getMap(); // notice that we aren't changing anything
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j <20; j++)  {
				temp[i][j] = _map_test.getPixel(i, j);  // deep copy for the color num
			}
		}
		assertEquals(temp[1][1],1);
	}

	//TODO a predictable answer to see
	/**
	 * Test for Game of life
	 * to create a an output of myself on a little map to know nextGen
	 * we will build a greed of 9X9 just to check some of the cases
	 */

	@Test
	public void testGenGol() {
		_map_test = new MyMap2D(10); // A grid 5X5;
		int black = Color.BLACK.getRGB();
		int blue = Color.BLUE.getRGB();
		int white = Color.WHITE.getRGB();
		_map_test.fill(white); //cleared the map from all another point form previous tests

		//we will draw some point for start
		Point2D p1 = new Point2D(1,0);
		Point2D p2 = new Point2D(1,1);
		Point2D p3 = new Point2D(1,2);
		Point2D p4 = new Point2D(0,1);
		Point2D p5 = new Point2D(2,1);


		// we will set them with blue color to check also that the next generation was changed to black;
		_map_test.setPixel(p1, blue);
		_map_test.setPixel(p2, blue);
		_map_test.setPixel(p3, blue);

		// checking that the points where initialized right with blue color (-16776961)
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

		// changed to white

		assertEquals(_map_test.getPixel(p1), white);
		assertEquals(_map_test.getPixel(p3), white);

		// changed to black
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

		// changed to white

		assertEquals(_map_test.getPixel(p4), white);
		assertEquals(_map_test.getPixel(p5), white);

		// changed to black
		assertEquals(_map_test.getPixel(p1), black);
		assertEquals(_map_test.getPixel(p2), black);
		assertEquals(_map_test.getPixel(p3), black);
	}

}
