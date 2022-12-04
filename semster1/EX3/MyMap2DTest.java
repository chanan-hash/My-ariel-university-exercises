package Exe.EX3;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MyMap2DTest {
	
	private static  Map2D _map_test = null;
	
	@Test
	/**
	 * This test for checking the rectanlge_draw function
	 */
	
	public void testRect() {
		Point2D p1 = new Point2D(1,2);
		Point2D p2 = new Point2D(4,10);
		int minX = Math.min(p1.ix(), p2.ix());
		int minY = Math.min(p1.iy(), p2.iy());
		
		int width = Math.abs((p1.ix() - p2.ix())); // the width of the
		int hight = Math.abs((p1.iy() - p2.iy()));
		_map_test.init(width, hight);
		_map_test.drawRect(p1, p2, 1);
		
		int[][] tmp = new int[_map_test.getHeight()][_map_test.getWidth()];
		for (int i = 0; i < _map_test.getHeight(); i++) {
			for (int j = 0; j < _map_test.getWidth(); j++)  {
				tmp[i][j] = _map_test.getPixel(i, j);  // deep copy for the color num
			}
		}
		for (int i = 0; i <= hight; i++) {
			for (int j = 0; j <= width; j++) {
				System.out.println(tmp[i][j]);
				assertEquals(tmp[j + minX][i + minY] , 1);
			
			}
		}
	
	
	}
	
	
	
	
}
