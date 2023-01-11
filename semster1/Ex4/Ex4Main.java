package Exe.Ex4;
import java.awt.Color;

import Exe.Ex4.geo.Circle2D;
import Exe.Ex4.geo.Point2D;
import Exe.Ex4.gui.Ex4;
/**
 * A very simple main class for basic code for Ex4
 * 
 * t2: output:
 * GUIShape,0,true,1,Circle2D,3.0,4.0, 2.0
 * GUIShape,255,false,2,Circle2D,6.0,8.0, 4.0
 * 
 * @author boaz.ben-moshe
 *
 * @author Michael Id - 206917908
 * @author Chanan Id -  209324102 
 *
 */
public class Ex4Main {

	public static void main(String[] args) {
		t1();
		t2();
		
		// I've put the file in the write place to check it you need to put the right directory. 
		// There function their that gives you it  
		// t3(); // won't work "out of the box" - requires editing the code (save, load..)
	}
	// Minimal empty frame (no shapes)
	public static void t1() {
		Ex4 ex4 = Ex4.getInstance();
		ex4.show();
	} 
	// Two simple circles
	public static void t2() {
		Ex4 ex4 = Ex4.getInstance();
		ShapeCollectionable shapes = ex4.getShape_Collection();
		Point2D p1 = new Point2D(3,4);
		Point2D p2 = new Point2D(6,8);
		Circle2D c1 = new Circle2D(p1,2);
		Circle2D c2 = new Circle2D(p2,4);
		GUI_Shapeable gs1 = new GUIShape(c1, true, Color.black, 1);
		GUI_Shapeable gs2 = new GUIShape(c2, false, Color.blue, 2);
		shapes.add(gs1);
		shapes.add(gs2);
		//ex4.init(shapes);
		ex4.show();
		System.out.print(ex4.getInfo());
	}
	
	// Loads a file from file a0.txt (Circles only).
	public static void t3() {
		Ex4 ex4 = Ex4.getInstance();
		ShapeCollectionable shapes = ex4.getShape_Collection();
		String str = System.getProperty("user.dir") + "\\\\a0.txt";
		System.out.println(str);
		System.out.println(System.getProperty("user.dir")); // will gives us were is the file to read --> I've put  also intos
		String file = "C:\\Users\\חנן\\Desktop\\אריאל אונ'\\מבוא לחישוב\\Intro2CS-main\\Intro2CS-main\\src\\Exe\\Ex4\\a0.txt"; //make sure the file is your working directory.
		shapes.load(file); // you can also do --> shapes.load(str);
		ex4.init(shapes);
		ex4.show();
	}

}
