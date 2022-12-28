package Exe.Ex4.geo;

import java.util.Comparator;

import Exe.Ex4.Ex4_Const;
import Exe.Ex4.GUI_Shapeable;

/**
 * This class represents a Comparator over GUI_Shapes - 
 * as a linear order over GUI_Shapes.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class ShapeComp implements Comparator<GUI_Shapeable>{
	//////////add your code below ///////////
	
	
	public static final Comparator<GUI_Shapeable> CompByToString = new ShapeComp(Ex4_Const.Sort_By_toString);
	
	private int _flag;
	public ShapeComp(int flag) {
		_flag = flag;
		
	}
	@Override
	public int compare(GUI_Shapeable o1, GUI_Shapeable o2) {
		if (o1 == null || o2== null) {return 0;}
		int ans=0;
		if(_flag == Ex4_Const.Sort_By_toString) {
			ans = o1.toString().compareTo(o2.toString());
		}	
		//////////add your code below ///////////

		// we are using the comperator of every class, Double, Integer, String
		
		else if(_flag == Ex4_Const.Sort_By_Anti_toString) {
			ans = o1.toString().compareTo(o2.toString()) *-1;
		}
	
		// According to ares
		else if(_flag == Ex4_Const.Sort_By_Area) {
			ans = Double.compare(o1.getShape().area(), o2.getShape().area()) ;
		}
		else if(_flag == Ex4_Const.Sort_By_Anti_Area) {
			
				ans = Double.compare(o1.getShape().area(), o2.getShape().area()) *-1;
		}
		
		// According to perimeters
		else if(_flag == Ex4_Const.Sort_By_Perimeter) {
			ans = Double.compare(o1.getShape().perimeter(), o2.getShape().perimeter());
		}
		else if(_flag == Ex4_Const.Sort_By_Anti_Perimeter) {
			ans = Double.compare(o1.getShape().perimeter(), o2.getShape().perimeter()) *-1;
		}
		
		// According to tags
		else if(_flag == Ex4_Const.Sort_By_Tag) {
			ans = Integer.compare(o1.getTag(), o2.getTag());
		}
		else if(_flag == Ex4_Const.Sort_By_Anti_Tag) {
			ans = Integer.compare(o1.getTag(), o2.getTag())*-1;
		}

		return ans;
	}

}

/**
 * double a1=-1, a2 = -1;
		GeoShape s1 = o1.getShape(), s2 = o2.getShape();
		int ans =0;
		if(_flag == Ex4_Const.Sort_By_Area) {
			a1 = s1.area();
			a2 = s2.area();
		}
		if(_flag == Ex4_Const.Sort_By_Anti_Area) {
			a2 = s1.area();
			a1 = s2.area();
		}
		if(_flag == Ex4_Const.Sort_By_Perimeter) {
			a1 = s1.perimeter();
			a2 = s2.perimeter();
		}
		if(_flag == Ex4_Const.Sort_By_Anti_Perimeter) {
			a2 = s1.perimeter();
			a1 = s2.perimeter();
		}
		if(_flag == Ex4_Const.Sort_By_Tag) {
			a1 = o1.getTag();
			a2 = o2.getTag();
		}
		if(_flag == Ex4_Const.Sort_By_Anti_Tag) {
			a2 = o1.getTag();
			a1 = o2.getTag();
		}
		if(a1>a2) {ans=1;}
		if(a1<a2) {ans=-1;
 */

