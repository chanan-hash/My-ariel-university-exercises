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
		int ans=0;
		if(_flag == Ex4_Const.Sort_By_toString) {
			ans = o1.toString().compareTo(o2.toString());
		}
		// Adding the Other sorts
		// Anti - means decending order		
		//////////add your code below ///////////

		else if(_flag == Ex4_Const.Sort_By_Anti_toString) {}
	
		// According to ares
		else if(_flag == Ex4_Const.Sort_By_Area) {}
		else if(_flag == Ex4_Const.Sort_By_Anti_Area) {}
		
		// According to perimeters
		else if(_flag == Ex4_Const.Sort_By_Perimeter) {}
		else if(_flag == Ex4_Const.Sort_By_Anti_Perimeter) {}
		
		// According to tags
		else if(_flag == Ex4_Const.Sort_By_Tag) {}
		else if(_flag == Ex4_Const.Sort_By_Anti_Tag) {}

		
		return ans;
	}

}
